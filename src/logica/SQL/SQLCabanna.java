package logica.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Cabanna;

/**
 * Esta clase contiene los métodos encargados de hacer las consultas a la base de datos sobre la tabla cabannas
 * @version 13/10/2019/A
 * @author Matías Garibotti
 */


public class SQLCabanna extends ConexionDB {

    String sSQL;
    public short NR; //Number of Records

    public DefaultTableModel select() {

        String[] headers = {"ID", "Habitaciones", "Camas", "Baños", "Huespedes", "Aire A.", "Parrillero", "Costo Hora", "Descripción"};
        String[] registro = new String[8];
        NR = 0;
        DefaultTableModel modelo = new DefaultTableModel(null, headers);
        Connection con = conectar();
        sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,cantHuespedes,aireAcondicionado,parrillero,costHour,descripcion FROM Cabannas ORDER BY id";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                registro[0] = rs.getString("id");
                registro[1] = rs.getString("cantHabitaciones");
                registro[2] = rs.getString("cantCamas");
                registro[3] = rs.getString("cantBannos");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("aireAcondicionado");
                registro[6] = rs.getString("parrillero");
                registro[7] = rs.getString("costHour");
                
                NR++;
                
                modelo.addRow(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        } finally {
            
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
                
            }
        }
        return modelo;
    }
    
    /**
    * Esta función hace una consula a la base de datos aplicando un filtro.
    * @param patron filtra utilizando este patrón
    * @param campo el filtro se aplica sobre este campo
    * @return Retorna el modelo con las cabeceras y datos obtenidos de la consulta.
    * 
    */
    
    public  DefaultTableModel select(String patron, String campo) {

        String[] headers = {"ID", "Habitaciones", "Camas", "Baños", "Aire A.", "Parrillero", "Costo Hora","",""};
        String[] Registro = new String[headers.length+2];
        NR = 0;

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers);

        Connection con = conectar();

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
        */
        sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,aireAcondicionado,parrillero,costHour "
                + "FROM cabannas WHERE " + campo + " LIKE '%" + patron + "%' ORDER BY id";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("id");
                Registro[1] = rs.getString("cantHabitaciones");
                Registro[2] = rs.getString("cantCamas");
                Registro[3] = rs.getString("cantBannos");
                Registro[4] = rs.getString("aireAcondicionado");
                Registro[5] = rs.getString("parrillero");
                Registro[6] = rs.getString("costHour");
                Registro[7] = "MODIFICAR";
                Registro[8] = "ELIMINAR";
                //Agrego los datos obtenidos al modelo
                
                if(Registro[4].equals("1"))
                    Registro[4] = "Sí";
                else
                    Registro[4] = "No";
                
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
    
    public  String[] select(String id) {
        String[] Registro = new String[8];
        NR = 0;

        Connection con = conectar();

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
        */
        sSQL = "SELECT id,cantHabitaciones,cantCamas,cantBannos,aireAcondicionado,parrillero,descripcion, costHour "
                + "FROM cabannas WHERE id=" + id + "";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("id");
                Registro[1] = rs.getString("cantHabitaciones");
                Registro[2] = rs.getString("cantCamas");
                Registro[3] = rs.getString("cantBannos");
                Registro[4] = rs.getString("aireAcondicionado");
                Registro[5] = rs.getString("parrillero");
                Registro[6] = rs.getString("descripcion");
                Registro[7] = rs.getString("costHour");
                
                if(Registro[4].equals("1"))
                    Registro[4] = "Sí";
                else
                    Registro[4] = "No";
                
                if(Registro[5].equals("1"))
                    Registro[5] = "Sí";
                else
                    Registro[5] = "No";

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
    
    /**
     * Este es el método a través del que se ingresan las cabañas.
     * @param cab Objeto que contiene los datos de la cabaña a ingresar
     * @return Retorna si se ejecutó con exito o no.
     */
    public boolean insertar(Cabanna cab) {
        Connection con = conectar();
        sSQL = "INSERT INTO Cabannas (cantHabitaciones,cantCamas,cantBannos,descripcion,aireAcondicionado,parrillero,costHour)"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setByte(1, cab.getCantHabitaciones());
            pst.setByte(2, cab.getCantCamas());
            pst.setByte(3, cab.getCantBannos());
            pst.setString(4, cab.getDescripcion());
            pst.setBoolean(5, cab.getAireAcondicionado());
            pst.setBoolean(6, cab.getParrillero());
            pst.setShort(7, cab.getCostHour());
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
    
    /**
     * Este es el método a través del que se modifican las cabañas.
     * @param cab Objeto que contiene los nuevos datos de la cabaña.
     * @return Devuelve si se ejecutó con éxito o no.
     */
    public boolean modificar(Cabanna cab) {
        //Nueva conexión
        Connection con = conectar();
        
        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ?  
        */
        sSQL = "UPDATE Cabannas SET cantHabitaciones=?, cantCamas=?, cantBannos=?, descripcion=?, aireAcondicionado=?, parrillero=?, costHour=? WHERE id=?";
        
        
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            
            pst.setByte(1, cab.getCantHabitaciones());
            pst.setByte(2, cab.getCantCamas());
            pst.setByte(3, cab.getCantBannos());
            pst.setString(4, cab.getDescripcion());
            pst.setBoolean(5, cab.getAireAcondicionado());
            pst.setBoolean(6, cab.getParrillero());
            pst.setShort(7, cab.getCostHour());
            pst.setShort(8,cab.getId());
            
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
    
    /**
     * Método a través del que se eliminan las cabañas.
     * @param id Id de la cabaña
     * @return Devuelve si se ejecutó con éxito o no.
     */
    
    public boolean eliminar(short id) {
        Connection con = conectar();
        sSQL = "DELETE FROM Cabannas WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setShort(1, id);
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
