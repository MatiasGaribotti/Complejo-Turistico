
package logica.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Reserva;

public class SQLReserva extends ConexionDB  {
    Connection cn=conectar();
    String sSQL="";
    public boolean insertar(Reserva res){
        Connection con=conectar();
        sSQL="INSERT INTO Reservas (codigoReserva, fechaInicio, fechaFin, confirmada, cancelada, ci, idCabanna)"+
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst=con.prepareStatement(sSQL);
            pst.setInt(1, res.getCodigoReserva());
            pst.setDate(2, res.getFechaInicio());
            pst.setDate(3, res.getFechaFin());
            pst.setBoolean(4, res.getConfirmada());
            pst.setBoolean(5, res.getCancelada());
            pst.setInt(6, res.getCi());
            pst.setShort(7, res.getIdCabanna());
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
}
