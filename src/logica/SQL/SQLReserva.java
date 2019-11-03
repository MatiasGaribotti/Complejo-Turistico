package logica.SQL;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    String sSQL;
    
    //Función a la que llamaremos cuando se intente modificar o cancelar alguna reserva
    public boolean aviseConTiempo(Date fechaAModificar){
        boolean aviso=true;
        Date fecAct;
        fecAct=new Date();
        if(fechaAModificar.getMonth()==fecAct.getMonth()&&(fechaAModificar.getDay()==(fecAct.getDay()-2)))
            aviso=false;
        return aviso;
    }
    
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
    public  DefaultTableModel selectCanceladas() {

        String[] headers = {"Código", "ID", "Fecha Inicio", "Fecha Fin", "CI"};
        String[] Registro = new String[5];

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers);

        Connection con = conectar();

        sSQL = "SELECT codigoReserva,idCabanna,fechaInicio,fechaFin,ci "
                + "FROM `reservas` WHERE `Cancelada`=1  ORDER BY idCabanna";

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

}
