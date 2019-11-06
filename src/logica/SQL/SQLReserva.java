package logica.SQL;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
    public boolean aviseConTiempo(Date fechaAModificar){

        long days = (sysDate.getTime()-fechaAModificar.getTime())/86400000;
        
        return days >= 2; //Si faltan 2 o más días retorna true;
    }
    
    /**
     * Este método ingresa una nueva reserva a la base de datos.
     *
     * @param res Objeto que contiene los datos de la reserva a ingresar.
     * @return Retorna si se ejecutó con éxito la consulta o no.
     */
    
    public boolean insertar(Reserva res) {
        Connection con = conectar("root", "");
        sSQL = "INSERT INTO Reservas (codigoReserva, fechaInicio, fechaFin, confirmada, cancelada, ci, idCabanna)"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setInt(1, res.getCodigoReserva());
            pst.setDate(2, res.getFechaInicio());
            pst.setDate(3, res.getFechaFin());
            pst.setBoolean(4, res.getConfirmada());
            pst.setBoolean(5, res.getCancelada());
            pst.setInt(6, res.getCi());
            pst.setShort(7, res.getIdCabanna());
            
            pst.execute();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        } finally {
            try {
                con.close();
                
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
                
            }
        }
    }
    
    public boolean cancelar(Reserva res) {
        //Nueva conexión
        Connection con = conectar("root", "");
        
        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ? 
        */
        sSQL = "UPDATE Reservas SET confirmada=? WHERE id=?";
        
        
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            
            pst.setBoolean(1, true);
            pst.setInt(2,res.getCodigoReserva());
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
        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin","CheckIn", "", ""}; //Dos columnas vacías para botones
        String[] Registro = new String[headers.length];
        DefaultTableModel modelo = new DefaultTableModel(null, headers);
        
        Connection con = conectar("root", "");
        
        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,confirmada "
                + "FROM reservas WHERE cancelada=0 ORDER BY fechaInicio";
        
        try {
            
            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            
            while(rs.next()){
                
                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("ci");
                Registro[2] = rs.getString("idCabanna");
                Registro[3] = rs.getString("fechaInicio");
                Registro[4] = rs.getString("fechaFin");
                Registro[5] = rs.getString("confirmada");
                
                Registro[Registro.length-2] = "MODIFICAR";
                Registro[Registro.length-1] = "ELIMINAR";
                
                //Agrego los datos obtenidos al modelo
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
    
    public  DefaultTableModel selectCanceladas() {

        String[] headers = {"Código", "ID", "Fecha Inicio", "Fecha Fin", "CI"};
        String[] Registro = new String[5];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers);

        Connection con = conectar("root", "");

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
            
        }finally {
            
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                
            }
        }

        return modelo;

    }
    public  String[] select(String codigo) {
        String[] Registro = new String[6];

        Connection con = conectar("root", "");

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
        */
        sSQL = "SELECT codigoReserva,idCabanna,fechaInicio,fechaFin,confirmada,ci "
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
                Registro[4] = rs.getString("confirmada");
                Registro[5] = rs.getString("ci");
                
                if(Registro[4].equals("1"))
                    Registro[4] = "Sí";
                else
                    Registro[4] = "No";

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

        return Registro;

    }
    
    public DefaultTableModel selectVisualizar(String periodo) {
        String[] headers = {"Código", "C.I", "Cabaña", "Fecha Inicio", "Fecha Fin","CheckIn", "", ""}; //Dos columnas vacías para botones
        String[] Registro = new String[headers.length];
        DefaultTableModel modelo = new DefaultTableModel(null, headers);
        LocalDate maximo;
        switch(periodo){
            case "MES":
                maximo=LocalDate.now().plusMonths(1);
                break;
            default:    
                maximo=LocalDate.now().plusWeeks(1);   
        }
        
        Connection con = conectar("root", "");
        
        sSQL = "SELECT codigoReserva,ci,idCabanna,fechaInicio,fechaFin,confirmada "
                + "FROM reservas WHERE cancelada=0 AND fechaFin<"+maximo.toString()+" ORDER BY fechaInicio";
        
        try {
            
            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            
            while(rs.next()){
                
                Registro[0] = rs.getString("codigoReserva");
                Registro[1] = rs.getString("ci");
                Registro[2] = rs.getString("idCabanna");
                Registro[3] = rs.getString("fechaInicio");
                Registro[4] = rs.getString("fechaFin");
                Registro[5] = rs.getString("confirmada");
                
                Registro[Registro.length-2] = "MODIFICAR";
                Registro[Registro.length-1] = "ELIMINAR";
                
                //Agrego los datos obtenidos al modelo
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

}
