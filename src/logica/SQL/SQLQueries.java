package logica.SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se encuentran las consultas SQL personalizadas.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 */
public class SQLQueries extends ConexionDB {

    String sSQL;
    public short NR; //Number of Records

    /**
     * Esta función ejecutará una consulta de selección personalizada a la base
     * de datos
     *
     * @param atributos = atributos a seleccionar(IMPORTANTE: RESPETAR NOMBRES
     * DE LA BD).
     * @param dbTable = relación de donde seleccionar los datos.
     * @param headers = Cabeceras de las columnas.
     * @return Devuelve un modelo con las cabeceras que se pasaron por parámetro
     * y los datos obtenidos
     */
    public DefaultTableModel customSelectQuery(String[] atributos, String dbTable, String[] headers) {

        sSQL = "SELECT ";
        String[] Registro = new String[atributos.length+2];
        NR = 0;

        //Creo el modelo sin datos y le paso las cabeceras.
        DefaultTableModel modelo = new DefaultTableModel(null, headers);
        

        Connection con = conectar("root", "");

        for (int i = 0; i < atributos.length; i++) {
            sSQL = sSQL.concat(atributos[i]);
            if (!(i == (atributos.length - 1))) {
                sSQL = sSQL.concat(",");
            } else {
                sSQL = sSQL.concat(" ");
            }
        }

        /*
            Completo la consulta.
            La tabla resultado va a estar ordenada por el
            campo/atributo 0.
         */
        sSQL = sSQL.concat("FROM " + dbTable + " ORDER BY " + atributos[0]);

        try {

            //Se crea el statement a partir de el objeto de la conección.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /*
            * Agrego al modelo los datos obtenidos
            * a partir de la consulta a la base de datos.
             */
            while (rs.next()) {

                for (int i = 0; i < Registro.length-2; i++) {

                    /*
                    * Asigno a cada posición del registro los datos que le corresponden.
                     */
                    if(i>3&&i<6){
                        if(rs.getString(atributos[i]).equalsIgnoreCase("1"))
                            Registro[i]="Sí";
                        else
                            Registro[i]="No";
                    }else
                        Registro[i] = rs.getString(atributos[i]);
                    NR++;
                }
                Registro[Registro.length-2]="MODIFICAR";
                Registro[Registro.length-1]="ELIMINAR";

                //Agrego los datos obtenidos al modelo
                modelo.addRow(Registro);
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

        return modelo;

    }
}
