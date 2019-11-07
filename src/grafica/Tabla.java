package grafica;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import logica.Cabanna;
import logica.Reserva;
import logica.SQL.SQLCabanna;
import logica.SQL.SQLReserva;
import logica.SQL.SQLTurista;
import utilidades.ManageCellsTable;
import utilidades.ManageHeaderTable;

public class Tabla extends javax.swing.JPanel {

    //Variable que define qué tipo de tabla va a ser
    private String view;
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        
        }};
    

    public Tabla() {
        this.view = "CABANNAS";
    }

    public Tabla(String currentView) {
        this.view = currentView;
    }

    public void buildTable() {
        initComponents();
        this.setSize(936, 286); //Check if this works
        modelo = buildModel();
        table.setModel(modelo);
    
        styleTable();

    }

    public void buildTable(DefaultTableModel modelo) {
        initComponents();
        this.setSize(936, 286);
        this.modelo = modelo;
        table.setModel(modelo);
        styleTable();

    }

    public void changeSize(int width, int height) {
        this.setSize(width, height);

    }
    
    public DefaultTableModel buildModel() {
        /*
            En base a el tipo de tabla
            se obtienen ciertos datos u otros.
            En este caso la consulta es para obtener
            todos los datos de la tabla que corresponda
         */
        
        switch (view) {
            case "CABANNAS":
                SQLCabanna sqlCabanna = new SQLCabanna();
                modelo = sqlCabanna.select("", "id");
                break;

            case "RESERVAS":
                SQLReserva sqlReserva = new SQLReserva();
                modelo = sqlReserva.select();
                break;

            case "TURISTAS":

                break;

            case "HISTORICO":
                SQLTurista sqlTurista = new SQLTurista();
                modelo = sqlTurista.selectHistory();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo de tabla no encontrado - Consulta no realizada");

        }
        return modelo;

    }

    public void styleTable() {

        //Header Personalizado default para todas las tablas
        JTableHeader jtableHeader = table.getTableHeader();
        jtableHeader.setDefaultRenderer(new ManageHeaderTable());
        table.setTableHeader(jtableHeader);

        table.setRowHeight(25);

        int size = table.getColumnCount();

        switch (view) {
            case "CABANNAS":
                table.getColumnModel().getColumn(0).setMaxWidth(35);

                for (int i = 0; i < size - 2; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(new ManageCellsTable("normal"));
                }

                table.getColumnModel().getColumn(size - 2).setCellRenderer(new ManageCellsTable("ICONO"));
                table.getColumnModel().getColumn(size - 1).setCellRenderer(new ManageCellsTable("ICONO"));
                table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 2).setMaxWidth(40);
                table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setMaxWidth(40);

                break;

            case "RESERVAS":
                for (int i = 0; i < size - 2; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(new ManageCellsTable("normal"));
                }

                table.getColumnModel().getColumn(size - 2).setCellRenderer(new ManageCellsTable("ICONO"));
                table.getColumnModel().getColumn(size - 1).setCellRenderer(new ManageCellsTable("ICONO"));
                table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 2).setMaxWidth(40);
                table.getColumnModel().getColumn(table.getColumnModel().getColumnCount() - 1).setMaxWidth(40);

                break;

            case "RESERVAS_CANCELADAS":
                table.getColumnModel().getColumn(0).setMaxWidth(35);

                for (int i = 0; i < size; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(new ManageCellsTable("normal"));
                }

                break;

            case "TURISTAS":

                break;

            case "HISTORICO":
                for (int i = 0; i < size; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(new ManageCellsTable("normal"));
                }

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
        ){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column){return false;}
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(20);
        table.setRowMargin(2);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int fila = table.rowAtPoint(evt.getPoint());
        int columna = table.columnAtPoint(evt.getPoint());

        if (columna == table.getColumnModel().getColumnCount() - 2) {

            if (view.equals("CABANNAS")) {
                Short id = Short.parseShort(table.getModel().getValueAt(fila, 0).toString());
                Index.paintIngreso(new Panel_Cabanna(new Cabanna(id), "MODIFICAR"));

            } else if (view.equals("RESERVAS")) {
                int codigo = Integer.parseInt(table.getModel().getValueAt(fila, 0).toString());
                
                Index.paintIngreso(new Panel_Reservar(new Reserva(codigo), "MODIFICAR"));
            }

        } else if (columna == table.getColumnModel().getColumnCount() - 1) {//se valida que sea la columna del otro evento
            if (view.equals("CABANNAS")) {
                int op = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if(op == JOptionPane.YES_OPTION)
                    eliminarRegistro(fila);
                else
                    JOptionPane.showMessageDialog(null, "Eliminación cancelada");

            } else if (view.equals("RESERVAS")) {
                int op = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la reserva?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(op == 0){ //Yes
                    
                }else{
                    
                }
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    public void eliminarRegistro(int fila) {
        Short id = Short.parseShort(table.getModel().getValueAt(fila, 0).toString());

        System.out.println(id);
        SQLCabanna sqlCabannas = new SQLCabanna();
        boolean eliminar = sqlCabannas.eliminar(id);
        DefaultTableModel modelo = sqlCabannas.select("", "id");

        Index.paintTabla(modelo, view);
        if (eliminar) {
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal.");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
