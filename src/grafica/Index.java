package grafica;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        //this.setResizable(true);
        paintPanel(new Reservar());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        sideReservas = new javax.swing.JPanel();
        lblReservas = new javax.swing.JLabel();
        sideClear = new javax.swing.JPanel();
        lblClear = new javax.swing.JLabel();
        sideCabannas = new javax.swing.JPanel();
        lblCabannas = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        lyrPaneTop = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3 Weeks");
        setName("frame"); // NOI18N
        setResizable(false);

        sideBar.setBackground(new java.awt.Color(3, 91, 153));
        sideBar.setPreferredSize(new java.awt.Dimension(300, 600));

        name.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("3 Weeks");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });

        sideReservas.setBackground(new java.awt.Color(43, 131, 194));
        sideReservas.setPreferredSize(new java.awt.Dimension(300, 50));

        lblReservas.setBackground(new java.awt.Color(43, 131, 194));
        lblReservas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblReservas.setForeground(new java.awt.Color(255, 255, 255));
        lblReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReservas.setText("Reservas");
        lblReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblReservasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout sideReservasLayout = new javax.swing.GroupLayout(sideReservas);
        sideReservas.setLayout(sideReservasLayout);
        sideReservasLayout.setHorizontalGroup(
            sideReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideReservasLayout.createSequentialGroup()
                .addComponent(lblReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sideReservasLayout.setVerticalGroup(
            sideReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        sideClear.setBackground(new java.awt.Color(43, 131, 194));
        sideClear.setPreferredSize(new java.awt.Dimension(300, 50));

        lblClear.setBackground(new java.awt.Color(43, 131, 194));
        lblClear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblClear.setForeground(new java.awt.Color(255, 255, 255));
        lblClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClear.setText("Limpiar");
        lblClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblClearMousePressed(evt);
            }
        });

        javax.swing.GroupLayout sideClearLayout = new javax.swing.GroupLayout(sideClear);
        sideClear.setLayout(sideClearLayout);
        sideClearLayout.setHorizontalGroup(
            sideClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideClearLayout.createSequentialGroup()
                .addComponent(lblClear, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sideClearLayout.setVerticalGroup(
            sideClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideClearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sideCabannas.setBackground(new java.awt.Color(43, 131, 194));
        sideCabannas.setPreferredSize(new java.awt.Dimension(300, 50));

        lblCabannas.setBackground(new java.awt.Color(43, 131, 194));
        lblCabannas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCabannas.setForeground(new java.awt.Color(255, 255, 255));
        lblCabannas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCabannas.setText("Cabañas");
        lblCabannas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCabannasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout sideCabannasLayout = new javax.swing.GroupLayout(sideCabannas);
        sideCabannas.setLayout(sideCabannasLayout);
        sideCabannasLayout.setHorizontalGroup(
            sideCabannasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideCabannasLayout.createSequentialGroup()
                .addComponent(lblCabannas, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sideCabannasLayout.setVerticalGroup(
            sideCabannasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideCabannasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCabannas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideCabannas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sideReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sideClear, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideCabannas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideClear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        name.getAccessibleContext().setAccessibleName("name");

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(600, 600));

        lyrPaneTop.setBackground(new java.awt.Color(204, 204, 204));
        lyrPaneTop.setPreferredSize(new java.awt.Dimension(550, 300));
        lyrPaneTop.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lyrPaneTop, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addComponent(lyrPaneTop, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblClearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMousePressed

        lyrPaneTop.removeAll();
        lyrPaneTop.repaint();
        lyrPaneTop.revalidate();
    }//GEN-LAST:event_lblClearMousePressed

    private void lblReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReservasMousePressed
        paintPanel(new Reservar());

    }//GEN-LAST:event_lblReservasMousePressed

    private void lblCabannasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCabannasMousePressed
        paintPanel(new ingCabanna());
    }//GEN-LAST:event_lblCabannasMousePressed

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        // Ya vas a ver...
    }//GEN-LAST:event_nameMouseClicked

    public Color bgSidebar = new Color(94, 99, 184);
    public Color bgSidebar2 = new Color(19, 21, 128);
    public Color textHint = new Color(212, 212, 212);

    public void textHint(String txt, JTextField obj) { //Procedimiento para textHints
        if (obj.getText().equals(txt)) {
            obj.setText("");
            obj.setForeground(Color.BLACK);
        } else if (obj.getText().equals("")) {
            obj.setText(txt);
            obj.setForeground(textHint);
        }
    }

    public void paintPanel(JPanel panel) { //Coloca un el panel deseado en el JLayeredPane
        lyrPaneTop.removeAll();
        lyrPaneTop.add(panel);
        lyrPaneTop.repaint();
        lyrPaneTop.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JLabel lblCabannas;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblReservas;
    private javax.swing.JLayeredPane lyrPaneTop;
    private javax.swing.JLabel name;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel sideCabannas;
    private javax.swing.JPanel sideClear;
    private javax.swing.JPanel sideReservas;
    // End of variables declaration//GEN-END:variables
}
