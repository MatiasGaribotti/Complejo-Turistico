package logica.SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Turista;

/**
 * Esta clase contiene los métodos encargados de hacer las consultas a la base
 * de datos sobre la tabla cabannas.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 */
public class SQLTurista extends ConexionDB {

    String sSQL;
    public short NR; //Number of Records

    /**
     * Este método ingresa un nuevo turísta a la base de datos.
     *
     * @param tur Objeto que contiene los datos del turista a ingresar.
     * @return Retorna si se ejecutó con éxito la consulta o no.
     */
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
            JOptionPane.showMessageDialog(null, "Nombre de excepción:"+e.toString()+"\n"
                    + "Mensaje:"+e.getMessage()+"\n"
                            + "Código de error:"+e.getErrorCode()+"\n"
                                    + "Estado de la BD:"+e.getSQLState());
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);

            }
        }
    }

}
