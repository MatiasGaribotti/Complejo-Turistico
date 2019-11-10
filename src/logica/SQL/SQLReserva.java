package logica.SQL;

import grafica.Index;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Reserva;

/**
 * Esta clase contiene los métodos encargados de hacer las consultas a la base
 * de datos sobre la tabla cabannas.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 */
public class SQLReserva extends ConexionDB {

    Calendar calendar = Calendar.getInstance();
    Date sysDate = calendar.getTime();
    String sSQL;

    /**
     * Este método ingresa una nueva reserva a la base de datos.
     *
     * @param res Objeto que contiene los datos de la reserva a ingresar.
     * @return Retorna si se ejecutó con éxito la consulta o no.
     */
    public boolean insertar(Reserva res) {
        Object[] proximosAux = selectCuenta(res.getIdCabanna()).toArray();
        LocalDate[] proximos = new LocalDate[proximosAux.length];
        boolean noDisponible = false;

        for (int i = 0; i < proximosAux.length; i++) {
            proximos[i] = (LocalDate) proximosAux[i];
        }
        for (int i = 0; i < proximos.length; i += 2) {
            //Fecha de inicio dentro del período de una reserva
            if ((LocalDate.parse(res.getFechaInicio().toString()).isAfter(proximos[i]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i]))
                    && (LocalDate.parse(res.getFechaInicio().toString()).isBefore(proximos[i + 1]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i + 1]))) {
                noDisponible = true;
            } //Fecha de finalización dentro del período de una reserva
            else if ((LocalDate.parse(res.getFechaFin().toString()).isAfter(proximos[i]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i]))
                    && (LocalDate.parse(res.getFechaFin().toString()).isBefore(proximos[i + 1]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i + 1]))) {
                noDisponible = true;
            } //La nueva reserva abarca un período reservado
            else if ((LocalDate.parse(res.getFechaInicio().toString()).isBefore(proximos[i]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i]))
                    && (LocalDate.parse(res.getFechaFin().toString()).isAfter(proximos[i + 1]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i + 1]))) {
                noDisponible = true;
            }

        }

        if (!noDisponible) {
            Connection con = conectar(Index.user.getNombre());
            sSQL = "INSERT INTO Reservas (codigoReserva, fechaInicio, fechaFin, checkIn, cancelada, ci, idCabanna)"
                    + "VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = con.prepareStatement(sSQL);

                pst.setInt(1, res.getCodigoReserva());
                pst.setDate(2, res.getFechaInicio());
                pst.setDate(3, res.getFechaFin());
                pst.setBoolean(4, res.getCheckIn());
                pst.setBoolean(5, res.getCancelada());
                pst.setInt(6, res.getCi());
                pst.setShort(7, res.getIdCabanna());

                pst.execute();

                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                return false;

            } finally {
                try {
                    con.close();

                } catch (SQLException e) {
                    JOptionPane.showConfirmDialog(null, e);

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cabaña reservada para el período seleccionado");
            return false;
        }
    }

    public boolean cancelar(int codigoReserva) {
        //Nueva conexión
        Connection con = conectar(Index.user.getNombre());

        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ? 
         */
        sSQL = "UPDATE Reservas SET cancelada=? WHERE codigoReserva=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setBoolean(1, true);
            pst.setInt(2, codigoReserva);
            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public boolean confirmar(int codigo, int ci) {
        //Nueva conexión
//        System.out.println(Index.user.getNombre());
        Connection con = conectar(Index.user.getNombre());

        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ? 
         */
        sSQL = "UPDATE Reservas SET checkIn=? WHERE codigoReserva=? AND ci=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setBoolean(1, true);
            pst.setInt(2, codigo);
            pst.setInt(3, ci);
            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public boolean checkout(int codigo, int ci) {
        //Nueva conexión
//        System.out.println(Index.user.getNombre());
        Connection con = conectar(Index.user.getNombre());

        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ? 
         */
        sSQL = "UPDATE Reservas SET checkOut=? WHERE codigoReserva=? AND ci=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setBoolean(1, true);
            pst.setInt(2, codigo);
            pst.setInt(3, ci);
            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public DefaultTableModel select() {
        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin", "Confirmada", "", ""}; //Dos columnas vacías para botones
        String[] Registro = new String[headers.length];

        DefaultTableModel modelo = new DefaultTableModel(null, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,checkIn "
                + "FROM reservas WHERE cancelada=0 AND checkOut=0 ORDER BY fechaInicio";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("ci");
                Registro[2] = rs.getString("idCabanna");
                Registro[3] = rs.getString("fechaInicio");
                Registro[4] = rs.getString("fechaFin");
                Registro[5] = rs.getString("checkIn");

                Registro[Registro.length - 2] = "MODIFICAR";
                Registro[Registro.length - 1] = "ELIMINAR";

                //Agrego los datos obtenidos al modelo
                modelo.addRow(Registro);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        return modelo;
    }
    
    public  DefaultTableModel select(String patron, String campo) {

        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin", "Confirmada", "", ""}; //Dos columnas vacías para botones
        String[] Registro = new String[headers.length+2];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        
        }};

        Connection con = conectar("root");

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
        */
        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,checkIn "
                + "FROM reservas WHERE " + campo + " LIKE '%" + patron + "%'";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("ci");
                Registro[2] = rs.getString("idCabanna");
                Registro[3] = rs.getString("fechaInicio");
                Registro[4] = rs.getString("fechaFin");
                Registro[5] = rs.getString("checkIn");
                Registro[6] = "MODIFICAR";
                Registro[7] = "ELIMINAR";
                //Agrego los datos obtenidos al modelo
                
                
                if(Registro[5].equals("1"))
                    Registro[5] = "Sí";
                else
                    Registro[5] = "No";
                
                modelo.addRow(Registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }finally {
            
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                
            }
        }

        return modelo;

    }
    

    public ArrayList<LocalDate> selectCuenta(short id) {
        int cont = 0;
        ArrayList<LocalDate> Fechas = new ArrayList<>();

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT fechaInicio,fechaFin "
                + "FROM reservas WHERE cancelada=0 AND fechaInicio>" + LocalDate.now().toString() + " AND idCabanna='" + id + "' ORDER BY fechaInicio";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                Fechas.add(cont, LocalDate.parse(rs.getString("fechaInicio")));
                Fechas.add(cont + 1, LocalDate.parse(rs.getString("fechaFin")));
                cont++;

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        return Fechas;
    }

    public DefaultTableModel selectCanceladas() {

        String[] headers = {"Código", "ID", "Fecha Inicio", "Fecha Fin", "CI"};
        String[] Registro = new String[5];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin "
                + "FROM `reservas` WHERE `cancelada`=1 ORDER BY fechaInicio";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("idCabanna");
                Registro[2] = rs.getString("fechaInicio");
                Registro[3] = rs.getString("fechaFin");
                Registro[4] = rs.getString("ci");

                //Agrego los datos obtenidos al modelo
                modelo.addRow(Registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        return modelo;

    }

    public String[] select(String codigo) {
        String[] Registro = new String[6];

        Connection con = conectar(Index.user.getNombre());

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
         */
        sSQL = "SELECT codigoReserva,idCabanna,fechaInicio,fechaFin,checkIn,ci "
                + "FROM reservas WHERE codigoReserva=" + codigo + "";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("idCabanna");
                Registro[2] = rs.getString("fechaInicio");
                Registro[3] = rs.getString("fechaFin");
                Registro[4] = rs.getString("checkIn");
                Registro[5] = rs.getString("ci");

                if (Registro[4].equals("1")) {
                    Registro[4] = "Sí";
                } else {
                    Registro[4] = "No";
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        return Registro;

    }

    public boolean addHost(int codigo, int ci) {
        //Nueva conexión
        System.out.println(Index.user.getNombre());
        Connection con = conectar("Turista");
        boolean reservaValida = true;
        byte cantHosts = 0;

        sSQL = "SELECT R.checkIn,R.cancelada FROM Reservas AS R WHERE R.codigoReserva='" + codigo + "';";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery(sSQL);
            boolean cancel = true, check = false;
            while (rs.next()) {
                check = rs.getBoolean("checkIn");
                cancel = rs.getBoolean("cancelada");
            }
            if (check == false || cancel == true) {
                reservaValida = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (reservaValida) {
            con = conectar("Duenno");
            sSQL = "INSERT INTO Reservas_Acompannantes(codigoReserva,ci) VALUES(?,?)";
            try {
                PreparedStatement pst1 = con.prepareStatement(sSQL);
                pst1.setInt(1, codigo);
                pst1.setInt(2, ci);
                pst1.execute();
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else {
            return false;
        }
    }

    @SuppressWarnings("empty-statement")
    public DefaultTableModel selectVisualizarDisponibilidad(String periodo) {
        boolean continuar = true;
        ArrayList<String> Result = new ArrayList<>();
        String[] headers = new String[8];
        headers[0] = "ID";
        headers[1] = "Habitaciones";
        headers[2] = "Camas";
        headers[3] = "Baños";
        headers[4] = "Descripción";
        headers[5] = "Aire Acondicionado";
        headers[6] = "Parrillero";
        headers[7] = "Costo hora";

        String[] Registro = new String[headers.length];
        DefaultTableModel modelo = new DefaultTableModel(null, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        LocalDate maximo;
        switch (periodo) {
            case "MES":
                maximo = LocalDate.now().plusMonths(1);
                break;
            case "DÍA":
                maximo = LocalDate.now().plusDays(1);
                break;
            default:
                maximo = LocalDate.now().plusWeeks(1);
        }

        Connection con = conectar(Index.user.getNombre());
//        System.out.println(maximo.toString());

        sSQL = "SELECT R.codigoReserva,R.ci,R.idCabanna,R.fechaInicio,R.fechaFin,R.checkIn,R.checkOut "
                + "FROM reservas AS R, cabannas AS C WHERE R.cancelada=0 AND (NOT(R.`fechaInicio`>'" + maximo.toString() + "' "
                + "OR R.fechaFin<" + LocalDate.now().toString() + ")) GROUP BY idCabanna ORDER BY fechaInicio";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                Result.add(rs.getString("idCabanna"));
            }
            if (Result.isEmpty()) {
                continuar = false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pasó algo, en algún lugar y fue por algo."); //Código de errores requeterrecontra intelegible
        }
        Object[] cabannas = Result.toArray();

        if (continuar) {
            sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,descripcion,aireAcondicionado,parrillero,costHour "
                    + "FROM reservas AS R, cabannas AS C WHERE R.cancelada=0 AND (NOT(";
            for (int i = 0; i < cabannas.length; i++) {
                if (i == cabannas.length - 1) {
                    sSQL += "C.id='" + cabannas[i].toString() + "')) GROUP BY id";
                } else {
                    sSQL += "C.id='" + cabannas[i].toString() + "' OR ";
                }
            }
        } else {
            sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,descripcion,aireAcondicionado,parrillero,costHour "
                    + "FROM cabannas";
        }

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs1.next()) {
                Registro[0] = rs1.getString("id");
                Registro[1] = rs1.getString("cantHabitaciones");
                Registro[2] = rs1.getString("cantCamas");
                Registro[3] = rs1.getString("cantBannos");
                Registro[4] = rs1.getString("descripcion");
                Registro[5] = rs1.getString("aireAcondicionado");
                Registro[6] = rs1.getString("parrillero");
                Registro[7] = rs1.getString("costHour");

                //Agrego los datos obtenidos al modelo
                modelo.addRow(Registro);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        return modelo;
    }

    public DefaultTableModel selectVisualizarOcupacion(String periodo) {
        boolean continuar = true;
        ArrayList<String> Result = new ArrayList<>();
        String[] headers = new String[8];
        headers[0] = "ID";
        headers[1] = "Habitaciones";
        headers[2] = "Camas";
        headers[3] = "Baños";
        headers[4] = "Descripción";
        headers[5] = "Aire Acondicionado";
        headers[6] = "Parrillero";
        headers[7] = "Costo hora";

        String[] Registro = new String[headers.length];
        DefaultTableModel modelo = new DefaultTableModel(null, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        LocalDate maximo;
        switch (periodo) {
            case "MES":
                maximo = LocalDate.now().plusMonths(1);
                break;
            case "DÍA":
                maximo = LocalDate.now().plusDays(1);
                break;
            default:
                maximo = LocalDate.now().plusWeeks(1);
        }

        Connection con = conectar(Index.user.getNombre());
//        System.out.println(maximo.toString());

        sSQL = "SELECT R.codigoReserva,R.ci,R.idCabanna,R.fechaInicio,R.fechaFin,R.checkIn,R.checkOut "
                + "FROM reservas AS R, cabannas AS C WHERE R.cancelada=0 AND (NOT(R.`fechaInicio`>'" + maximo.toString() + "' "
                + "OR R.fechaFin<" + LocalDate.now().toString() + ")) GROUP BY idCabanna ORDER BY fechaInicio";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                Result.add(rs.getString("idCabanna"));
            }
            if (Result.isEmpty()) {
                continuar = false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pasó algo, en algún lugar y fue por algo."); //Código de errores requeterrecontra intelegible
        }
        Object[] cabannas = Result.toArray();

        if (continuar) {
            sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,descripcion,aireAcondicionado,parrillero,costHour "
                    + "FROM reservas AS R, cabannas AS C WHERE R.cancelada=0 AND (";
            for (int i = 0; i < cabannas.length; i++) {
                if (i == cabannas.length - 1) {
                    sSQL += "C.id='" + cabannas[i].toString() + "') GROUP BY C.id";
                } else {
                    sSQL += "C.id='" + cabannas[i].toString() + "' OR ";
                }
            }
        } else {
            sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,descripcion,aireAcondicionado,parrillero,costHour "
                    + "FROM cabannas WHERE id=0";
        }

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs1.next()) {
                Registro[0] = rs1.getString("id");
                Registro[1] = rs1.getString("cantHabitaciones");
                Registro[2] = rs1.getString("cantCamas");
                Registro[3] = rs1.getString("cantBannos");
                Registro[4] = rs1.getString("descripcion");
                Registro[5] = rs1.getString("aireAcondicionado");
                Registro[6] = rs1.getString("parrillero");
                Registro[7] = rs1.getString("costHour");

                //Agrego los datos obtenidos al modelo
                modelo.addRow(Registro);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        return modelo;
    }

    public boolean modificar(Reserva res) {
        //Nueva conexión
        Connection con = conectar(Index.user.getNombre());

        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ?  
         */
        sSQL = "UPDATE Reservas SET fechaInicio=?, fechaFin=?, idCabanna=? WHERE codigoReserva=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setDate(1, res.getFechaInicio());
            pst.setDate(2, res.getFechaFin());
            pst.setShort(3, res.getIdCabanna());
            pst.setInt(4, res.getCodigoReserva());

            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

    }

}
