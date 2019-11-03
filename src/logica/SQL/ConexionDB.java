package logica.SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    public String dataBase="ProyectoProgramacion2"; //debe llamarse como el esquema en la base de datos al que queremos conectarnos
    public String url="jdbc:mysql://localhost:3306/" + dataBase; //la direción de phpmyadmin
    public String user="root"; //para el login en la DB
    public String pass=""; //contraseña 
    public Connection conectar(String usuario, String motDePasse){
        Connection enlace=null; 
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); //Se selecciona el Driver de la DB
            enlace=DriverManager.getConnection(this.url,this.user,this.pass); //Se conecta con la DB
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e); //Saca un diálogo a pantalla mostrando la excepción, el que venga después lo arregla
        } 
        return enlace;
    }
}