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

    //Función a la que llamaremos cuando se intente modificar o cancelar alguna reserva
    public boolean aviseConTiempo(Date fechaAModificar) {

        long days = (sysDate.getTime() - fechaAModificar.getTime()) / 86400000;

        return days >= 2; //Si faltan 2 o más días retorna true;
    }

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
            if (
                    (LocalDate.parse(res.getFechaInicio().toString()).isAfter(proximos[i]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i])) 
                    && (LocalDate.parse(res.getFechaInicio().toString()).isBefore(proximos[i + 1]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i + 1]))
                    ){
                noDisponible = true;
            }
            //Fecha de finalización dentro del período de una reserva
            else if (
                    (LocalDate.parse(res.getFechaFin().toString()).isAfter(proximos[i]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i])) 
                    && (LocalDate.parse(res.getFechaFin().toString()).isBefore(proximos[i + 1]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i + 1]))
                    ){
                noDisponible = true;
            }
            //La nueva reserva abarca un período reservado
            else if (
                    (LocalDate.parse(res.getFechaInicio().toString()).isBefore(proximos[i]) || LocalDate.parse(res.getFechaInicio().toString()).isEqual(proximos[i]))
                    && (LocalDate.parse(res.getFechaFin().toString()).isAfter(proximos[i + 1]) || LocalDate.parse(res.getFechaFin().toString()).isEqual(proximos[i + 1]))
                    ){
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

    public boolean confirmar(Reserva res) {
        //Nueva conexión
        Connection con = conectar(Index.user.getNombre());

        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ? 
         */
        sSQL = "UPDATE Reservas SET checkIn=? WHERE id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setBoolean(1, true);
            pst.setInt(2, res.getCodigoReserva());
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
        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin", "CheckIn", "", ""}; //Dos columnas vacías para botones
        String[] Registro = new String[headers.length];

        DefaultTableModel modelo = new DefaultTableModel(null, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,checkIn "
                + "FROM reservas WHERE cancelada=0 ORDER BY fechaInicio";

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

    public DefaultTableModel selectVisualizar(String periodo) {
        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin", "CheckIn", "", ""}; //Dos columnas vacías para botones
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
            default:
                maximo = LocalDate.now().plusWeeks(1);
        }

        Connection con = conectar(Index.user.getNombre());
        System.out.println(maximo.toString());
        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,checkIn "
                + "FROM reservas WHERE cancelada=0 AND `fechaInicio`>'" + maximo.toString() + "' ORDER BY fechaInicio";

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
            System.out.println("INICIO:" + res.getFechaInicio());
            pst.setDate(2, res.getFechaFin());
            System.out.println("FIN: " + res.getFechaFin());
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
