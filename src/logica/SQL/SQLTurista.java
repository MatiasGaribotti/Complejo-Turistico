
package logica.SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Turista;

public class SQLTurista extends ConexionDB {
    Connection cn=conectar();
    String sSQL="";
    
    public boolean insertar(Turista tur){
        Connection con=conectar();
        sSQL="INSERT INTO Turistas (ci, nombre, apellido, fechaNacimiento, telefonoMovil, calle, numero, localidad)"+
                "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst=con.prepareStatement(sSQL);
            pst.setInt(1, tur.getCi());
            pst.setString(2, tur.getNombre());
            pst.setString(3, tur.getApellido());
            pst.setDate(4, (Date) tur.getFechaNac());
            pst.setInt(5, tur.getTelefono());
            pst.setString(6, tur.getCalle());
            pst.setShort(7, tur.getNumero());
            pst.setString(8, tur.getLocalidad());
            pst.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        }
    }
    
    public java.sql.Date toSQLDate(Date date) {

        long milliseconds = date.getTime();
        java.sql.Date sqlDate = new java.sql.Date(milliseconds);
        return sqlDate;
    }
}
