package logica.SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Cabanna;
import logica.Reserva;
import logica.Turista;

public class SQLQueries extends ConexionDB {

    String sSQL;
    public short NR; //Number of Records

    public DefaultTableModel seleccionar(String patron, String atributo) { //Esta función retornará una tabla filtrada por el patrón de búsqueda
        String[] Cabeceras = {"ID", "NºHabitaciones", "NºCamas", "NºBaños", "Aire Acondicionado", "Parrillero", "Costo por hora"}; //Es el array de las cabeceras de la tabla
        String[] Registro = new String[8]; //Es el array que almacenará todo un registro de una consulta 
        NR = 0; //Lo inicializo en cero para luego, en caso de que la búsqueda no haya arrojado resultado y otras cosas, evaluarlo
        DefaultTableModel modelo = new DefaultTableModel(null, Cabeceras); //Se hace la instancia del modelo en tabla y se inicializa con las cabeceras, el primer parámetro tengo que investigarlo
        Connection con = conectar();
        sSQL = "SELECT * FROM Cabannas WHERE " + atributo + " LIKE '%" + patron + "%' ORDER BY id";
        /*La instrucción seleccionará TODO registro de la relación Cabannas 
        donde el atributo pasado por parámetro es igual al patron pasado por parámetro, y estarán los registros ordenados por el atributo id*/

        try {
            Statement st = con.createStatement();//Se inctancia una Instrucción y es asignada con la creación de una Declaración del objecto Connection ya creado
            ResultSet rs = st.executeQuery(sSQL); //Se ejecuta la consulta con la instrucción anteriormente declarada
            while (rs.next()) {
                //Asigno cada índice del registro con cada atributo de la relación, en el mismo orden y con el mismo nombre que en la DB
                Registro[0] = rs.getString("id");
                Registro[1] = rs.getString("cantHabitaciones");
                Registro[2] = rs.getString("cantCamas");
                Registro[3] = rs.getString("cantBannos");
                Registro[4] = rs.getString("descripcion");
                Registro[5] = rs.getString("aireAcondicionado");
                Registro[6] = rs.getString("parrillero");
                Registro[7] = rs.getString("costHour");
                NR++; //Para contar el total de registros, re útil,¿viste?
                modelo.addRow(Registro);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); //Showea la excepción en caso de excepción en la DB, si nos hackearon los rusos por ejemplo
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        }
        return modelo;
    }

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
