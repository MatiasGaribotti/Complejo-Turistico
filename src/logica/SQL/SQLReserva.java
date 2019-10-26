package logica.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Reserva;

/**
 * Esta clase contiene los métodos encargados de hacer las consultas a la base
 * de datos sobre la tabla cabannas.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 */
public class SQLReserva extends ConexionDB {

    String sSQL;
    public short NR; //Number of Records

    
    /**
     * Este método ingresa una nueva reserva a la base de datos.
     *
     * @param res Objeto que contiene los datos de la reserva a ingresar.
     * @return Retorna si se ejecutó con éxito la consulta o no.
     */
    
    public boolean insertar(Reserva res) {
        Connection con = conectar();
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
        Connection con = conectar();
        
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

}
