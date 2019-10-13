package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Se controla todo lo que pasa en la tabla (es un driver).
 *
 * @author Matías Garibotti
 */
public class ManageCellsTable extends DefaultTableCellRenderer {

    private String tipo;

    private Font normal = new Font("Segoe UI", Font.PLAIN, 12);
    private Font bold = new Font("Segoe UI", Font.PLAIN, 12);

    //Label para el Icono
    private JLabel label = new JLabel();

    /*
    * Los iconos que incluiran las tablas.
    * A través de estos íconos el usuario podrá realizar
    * acciones como: ver la descripción de una cabaña, eliminar
    * una fila (cabaña, reserva, turista;
     */
    private final ImageIcon iconoInfo = new ImageIcon(getClass().getResource("/assets.ui/"));
    private final ImageIcon iconoModificar = new ImageIcon(getClass().getResource("/assets.ui/"));
    private final ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/assets.ui/"));

    public ManageCellsTable() {
        this.tipo = "normal";
    }

    /*
     * Contructor común para el tipo de celda.
    * @param tipo
     */
    public ManageCellsTable(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        /*
            * Este método controla toda la tabla, contiene los valores
            * de si está seleciconada o no, tiene el foco o no, entre otros.
            *
            * Cada evento sobre la tabla invoca a este método.
         */
        //Algunos colores por defecto
        Color bgColor = null;
        Color bgColorDefault = new Color(192, 192, 192);
        Color bgCOlorSelected = new Color(140, 140, 140);

        /*
            * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección.
         */
        if (selected) {
            this.setBackground(bgColorDefault);

        } else {

            this.setBackground(Color.white);
        }

        /*
         * Se definen los tipos posibles de celdas para
         * definir así sus estilos correspondientes.
         */
        if (tipo.equals("normal")) {

            if (focused) {
                bgColor = bgCOlorSelected;
            } else {
                bgColor = bgColorDefault;
            }
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);

            this.setBackground((selected) ? bgColor : Color.WHITE);
            this.setFont(normal);
            return this;

        }

        if (tipo.equals("icono")) {

            if (String.valueOf(value).equals("INFO_CABANNA")) {
                label.setIcon(iconoInfo);

            }else if (String.valueOf(value).equals("MODIFICAR")) {
                label.setIcon(iconoModificar);
                
            }else if (String.valueOf(value).equals("ELIMINAR")) {
                label.setIcon(iconoEliminar);
            
            }
            
            label.setHorizontalAlignment( JLabel.LEFT );
            
            //Le agrego un borde
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            
            return label;

        }

        return this;

    }

}
