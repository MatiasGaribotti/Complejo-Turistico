package logica.SQL;

import grafica.Index;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

    /**
     * Este método ingresa un nuevo turísta a la base de datos.
     *
     * @param tur Objeto que contiene los datos del turista a ingresar.
     * @return Retorna si se ejecutó con éxito la consulta o no.
     */
    public boolean insertar(Turista tur) {
        Connection con = conectar(Index.user.getNombre());

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
            if(e.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "El turista ya está en la base de datos");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Nombre de excepción:"+e.toString()+"\n"
                        + "Mensaje:"+e.getMessage()+"\n"
                                + "Código de error:"+e.getErrorCode()+"\n"
                                        + "Estado de la BD:"+e.getSQLState());
                return false;
            }

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);

            }
        }
    }
    
    public  String[] select(int ci) {
        String[] Registro = new String[8];

        Connection con = conectar(Index.user.getNombre());

        /*
            Establezco la sentencia SQL a ejecutar ya aplicando el filtro
        */
        sSQL = "SELECT ci,nombre,apellido,fechaNacimiento,telefonoMovil,calle,numero,localidad "
                + "FROM turistas WHERE ci=" + ci + "";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("ci");
                Registro[1] = rs.getString("nombre");
                Registro[2] = rs.getString("apellido");
                Registro[3] = rs.getString("fechaNacimiento");
                Registro[4] = rs.getString("telefonoMovil");
                Registro[5] = rs.getString("calle");
                Registro[6] = rs.getString("numero");
                Registro[7] = rs.getString("localidad");          

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
    
    public  DefaultTableModel selectHistory() {

        String[] headers = {"CI", "Código","ID", "Fecha Inicio", "Fecha Fin"};
        String[] Registro = new String[5];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        
        }};

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT T.ci,R.codigoReserva,R.idCabanna,R.fechaInicio,R.fechaFin "
                + "FROM Turistas AS T,Reservas AS R WHERE T.ci=R.ci AND R.cancelada=0 AND R.checkIn=1 ORDER BY fechaInicio";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("ci");
                Registro[1] = rs.getString("codigoReserva");
                Registro[2] = rs.getString("idCabanna");
                Registro[3] = rs.getString("fechaInicio");
                Registro[4] = rs.getString("fechaFin");

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
    public  DefaultTableModel selectCheckIn(int codigo) {

        String[] headers = {"CI", "Código","Nombre Completo","ID", "Fecha Inicio", "Fecha Fin"};
        String[] Registro = new String[headers.length];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        
        }};

        Connection con = conectar(Index.user.getNombre());

        sSQL = "SELECT DISTINCT T.ci,R.codigoReserva,T.nombre,T.apellido,R.idCabanna,R.fechaInicio,R.fechaFin "
                + "FROM Turistas AS T,Reservas AS R,Reservas_Acompannantes AS RA WHERE (T.ci=R.ci OR (T.ci=RA.ci AND R.codigoReserva=RA.codigoReserva)) AND R.cancelada=0 AND R.codigoReserva="+codigo+" ORDER BY fechaInicio";

        try {

            //Se crea el statement a partir de el objeto de la conexión.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                Registro[0] = rs.getString("ci");
                Registro[1] = rs.getString("codigoReserva");
                Registro[2] = rs.getString("nombre")+rs.getString("apellido");
                Registro[3] = rs.getString("idCabanna");
                Registro[4] = rs.getString("fechaInicio");
                Registro[5] = rs.getString("fechaFin");

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
    
    public boolean modificar(Turista tur) {
        //Nueva conexión
        Connection con = conectar(Index.user.getNombre());
        
        /*
          Sentencia SQL. Por temas de seguridad se utilizan los ?  
        */
        sSQL = "UPDATE Turistas SET nombre=?, apellido=?, fechaNacimiento=?, telefonoMovil=?, calle=?, numero=?, localidad=?  WHERE ci=?";
        
        
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            
            pst.setString(1, tur.getNombre());
            pst.setString(2, tur.getApellido());
            pst.setDate(3, (Date) tur.getFechaNac());
            pst.setInt(4, tur.getTelefono());
            pst.setString(5, tur.getCalle());
            pst.setShort(6, tur.getNumero());
            pst.setString(7, tur.getLocalidad());
            pst.setInt(8, tur.getCi());
            
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
