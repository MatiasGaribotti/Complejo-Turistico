package grafica;

import javax.swing.JOptionPane;
import logica.SQL.SQLQueries;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilidades.ManageCellsTable;
import utilidades.ManageHeaderTable;

public class Tabla extends javax.swing.JPanel {

    //Variable que define qué tipo de tabla va a ser
    private String view;

    SQLQueries sql = new SQLQueries();
    DefaultTableModel modelo = new DefaultTableModel();

    public Tabla() {
    }

    public Tabla(String currentView) {
        initComponents();
        this.setSize(936, 286);
        this.view = currentView;
        selectModel();
        table.setModel(modelo);
        styleTable();
    }
    public Tabla(DefaultTableModel mod, String currentView){
        initComponents();
        this.setSize(936, 286);
        this.modelo=mod;
        this.view = currentView;
        table.setModel(modelo);
        styleTable();
    }

    public void selectModel() {
        /*
            En base a el tipo de tabla
            se obtienen ciertos datos u otros.
            En este caso la consulta es para obtener
            todos los datos de la tabla que corresponda
         */

        switch (view) {
            case "CABANNAS":
                String[] atributos = {"id", "cantHabitaciones", "cantCamas", "cantBannos", "aireAcondicionado", "parrillero", "costHour"};
                String[] headers = {"ID", "Habitaciones", "Camas", "Baños", "Aire Acondicionado", "Parrillero", "Costo Hora"};
                modelo = sql.customSelectQuery(atributos, "cabannas", headers);
                break;

            case "RESERVAS":

                break;

            case "TURISTAS":

                break;

            case "HISTORICO":

                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo de tabla no encontrado - Consulta no realizada");

        }

    }

    public void styleTable() {

        //Header Personalizado default para todas las tablas
        JTableHeader jtableHeader = table.getTableHeader();
        jtableHeader.setDefaultRenderer(new ManageHeaderTable());
        table.setTableHeader(jtableHeader);
        table.getColumnModel().getColumn(0).setMaxWidth(35);

        switch (view) {
            case "CABANNAS":
                int size = table.getColumnCount();
                for(int i=0; i < size; i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(new ManageCellsTable("normal"));
                }
 
                break;

            case "RESERVAS":

                break;

            case "TURISTAS":

                break;

            case "HISTORICO":

                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo de tabla no encontrado - Estilos no aplicados");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setAutoCreateRowSorter(true);
        table.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));
        table.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(20);
        table.setRowMargin(2);
        jScrollPane1.setViewportView(table);
        table.setSize(600,300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
