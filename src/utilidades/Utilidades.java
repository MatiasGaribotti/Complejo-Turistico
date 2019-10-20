package utilidades;

/**
 * Contiene las variables estáticas que referencian a 
 * los números de columna de las tablas.
 *
 * @author Matías Garibotti
 */
public class Utilidades {

    //Tabla Turista
    public static final int CI=0;
    public static final int NOMBRE = 1;
    public static final int APELLIDO = 2;
    public static final int FECHA_NAC = 3;
    public static final int TELEFONO = 4;
    public static final int CALLE = 5;
    public static final int NUMERO = 6;
    public static final int LOCALIDAD = 7;
    public static final int MODIFICAR_TURISTA = 8;
    public static final int ELIMINAR_TURISTA = 9;
    
    //Tabla Cabañas
    public static final int ID_CABANNA = 0;
    public static final int HABITACIONES = 1;
    public static final int CAMAS = 2;
    public static final int BANNOS = 3;
    public static final int AIRE_ACONDICIONADO = 4;
    public static final int PARRILLERO = 5;
    public static final int COSTO_HORA = 6;
    public static final int MODIFICAR_CABANNA = 7;
    public static final int ELIMINAR_CABANNA = 8;
        public static final int INFO = 9;

    //Tabla Reservas
    public static final int CODIGO_RESERVA = 0;
    public static final int CI_RESERVA = 1;
    public static final int ID_CABANNA_RESERVA = 2;
    public static final int FECHA_INICIO = 3;
    public static final int FECHA_FIN = 4;
    public static final int MODIFICAR_RESERVA = 5;
    public static final int ELIMINAR_RESERVA = 6;
    
    //Revisar
//    public static final int CHECKIN = 5;
//    public static final int CHECKOUT = 6;
}
