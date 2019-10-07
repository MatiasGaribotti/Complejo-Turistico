package logica.SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Cabanna;
import logica.Reserva;
import logica.Turista;

public class SQLQueries extends ConexionDB {

    String sSQL;

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

    public boolean modificar(Cabanna cab) {
        Connection con = conectar();
        sSQL = "UPDATE Cabannas SET cantHabitaciones=?, cantCamas=?, cantBannos=?, descripcion=?, aireAcondicionado=?, parrillero=?, costHour=? WHERE id";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setByte(1, cab.getCantHabitaciones());
            pst.setByte(2, cab.getCantCamas());
            pst.setString(3, cab.getDescripcion());
            pst.setBoolean(4, cab.getAireAcondicionado());
            pst.setBoolean(5, cab.getParrillero());
            pst.setShort(6, cab.getCostHour());
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

    public boolean eliminar(Cabanna cab) {
        Connection con = conectar();
        sSQL = "DELETE FROM Cabannas WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setShort(1, cab.getId());
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

    public boolean insertar(Turista tur) {
        Connection con = conectar();
        sSQL = "INSERT INTO Turistas (ci, nombre, apellido, fechaNacimiento, telefonoMovil, calle, numero, localidad)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
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

    public java.sql.Date toSQLDate(Date date) {

        long milliseconds = date.getTime();
        java.sql.Date sqlDate = new java.sql.Date(milliseconds);
        return sqlDate;
    }
}
