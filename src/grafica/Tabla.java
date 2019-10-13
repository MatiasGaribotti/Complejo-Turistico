package grafica;

import logica.SQL.SQLQueries;
import javax.swing.table.DefaultTableModel;


public class Tabla extends javax.swing.JPanel {

    SQLQueries sql = new SQLQueries();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Tabla() {
        initComponents();
        this.setSize(900, 600);
        modelo = sql.seleccionarCabannas(7, "id,cantHabitaciones,cantCamas,CantBannos,aireAcondicionado,parrillero,costHour");
        table.setModel(modelo);
        
        
        
//        for (int i=1; i < table.getColumnCount(); i++){
//            table.getColumnModel().getColumn(i).setMaxWidth(90);
//        }
        table.getColumnModel().getColumn(0).setMaxWidth(35);
        table.setValueAt(new Integer(23), 1, 0);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setAutoCreateRowSorter(true);
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
        table.setGridColor(new java.awt.Color(102, 102, 255));
        table.setRowHeight(20);
        table.setRowMargin(2);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
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
