package grafica;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.Cabanna;

public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        paintPanel(new Reservar(), lyrPaneTop);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        iconReserva = new javax.swing.JLabel();
        iconCabanna = new javax.swing.JLabel();
        inconCalendario = new javax.swing.JLabel();
        btnReservas = new javax.swing.JLabel();
        ui_btnReservas = new javax.swing.JLabel();
        btnCabannas = new javax.swing.JLabel();
        ui_btnCabannas = new javax.swing.JLabel();
        btnCalendario = new javax.swing.JLabel();
        ui_btnCalendario = new javax.swing.JLabel();
        UI_sideBar = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        lyrPaneTop = new javax.swing.JLayeredPane();
        lyrPaneTable = new javax.swing.JLayeredPane();
        topBar = new javax.swing.JPanel();
        ui_Dispose = new javax.swing.JLabel();
        ui_Exit = new javax.swing.JLabel();
        ui_topBar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3 Weeks");
        setName("frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBar.setBackground(new java.awt.Color(204, 204, 204));
        sideBar.setPreferredSize(new java.awt.Dimension(300, 600));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("3 Weeks");
        sideBar.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 40));

        iconReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/reserva.png"))); // NOI18N
        sideBar.add(iconReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 40, 40));

        iconCabanna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCabanna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/cabanna.png"))); // NOI18N
        sideBar.add(iconCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 40, 40));

        inconCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inconCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/calendario.png"))); // NOI18N
        sideBar.add(inconCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 40, 40));

        btnReservas.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        btnReservas.setForeground(new java.awt.Color(255, 255, 255));
        btnReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReservas.setText("Reservas");
        btnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReservasMousePressed(evt);
            }
        });
        sideBar.add(btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 40));

        ui_btnReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, -1));

        btnCabannas.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        btnCabannas.setForeground(new java.awt.Color(255, 255, 255));
        btnCabannas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCabannas.setText("Cabañas");
        btnCabannas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCabannasMousePressed(evt);
            }
        });
        sideBar.add(btnCabannas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 150, 40));

        ui_btnCabannas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCabannas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, -1));

        btnCalendario.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCalendario.setText("Calendario");
        sideBar.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, 40));

        ui_btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, -1));

        UI_sideBar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UI_sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/sideBar.png"))); // NOI18N
        UI_sideBar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        UI_sideBar.setPreferredSize(new java.awt.Dimension(150, 600));
        sideBar.add(UI_sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, -1));

        getContentPane().add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 610));

        content.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        content.setPreferredSize(new java.awt.Dimension(600, 600));

        lyrPaneTop.setBackground(new java.awt.Color(204, 204, 204));
        lyrPaneTop.setPreferredSize(new java.awt.Dimension(550, 300));
        lyrPaneTop.setLayout(new java.awt.CardLayout());

        lyrPaneTable.setBackground(new java.awt.Color(255, 255, 255));
        lyrPaneTable.setPreferredSize(new java.awt.Dimension(550, 290));
        lyrPaneTable.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyrPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(lyrPaneTop, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lyrPaneTop, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lyrPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 33, 760, 570));

        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ui_Dispose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_Dispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/buttonDISPOSE.png"))); // NOI18N
        ui_Dispose.setToolTipText("");
        ui_Dispose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ui_DisposeMousePressed(evt);
            }
        });
        topBar.add(ui_Dispose, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, 30));

        ui_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/buttonEXIT.png"))); // NOI18N
        ui_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ui_ExitMousePressed(evt);
            }
        });
        topBar.add(ui_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, 30));

        ui_topBar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ui_topBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/topBar.png"))); // NOI18N
        ui_topBar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ui_topBar.setIconTextGap(0);
        ui_topBar.setPreferredSize(new java.awt.Dimension(610, 35));
        topBar.add(ui_topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 30));

        getContentPane().add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 750, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ui_ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ui_ExitMousePressed
        System.exit(0);
    }//GEN-LAST:event_ui_ExitMousePressed

    private void btnReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservasMousePressed
        paintPanel(new Reservar(), lyrPaneTop);
    }//GEN-LAST:event_btnReservasMousePressed

    private void btnCabannasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCabannasMousePressed
        paintPanel(new ingCabanna(), lyrPaneTop);
        paintPanel(new Tabla("CABANNAS"), lyrPaneTable);
    }//GEN-LAST:event_btnCabannasMousePressed

    private void ui_DisposeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ui_DisposeMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_ui_DisposeMousePressed

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

    public void paintPanel(JPanel panel, JLayeredPane lyrPane) { //Coloca un el panel deseado en el JLayeredPane
        lyrPane.removeAll();
        lyrPane.add(panel);
        lyrPane.repaint();
        lyrPane.revalidate();
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
    private javax.swing.JLabel UI_sideBar;
    private javax.swing.JLabel btnCabannas;
    private javax.swing.JLabel btnCalendario;
    private javax.swing.JLabel btnReservas;
    private javax.swing.JPanel content;
    private javax.swing.JLabel iconCabanna;
    private javax.swing.JLabel iconReserva;
    private javax.swing.JLabel inconCalendario;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLayeredPane lyrPaneTable;
    private javax.swing.JLayeredPane lyrPaneTop;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel ui_Dispose;
    private javax.swing.JLabel ui_Exit;
    private javax.swing.JLabel ui_btnCabannas;
    private javax.swing.JLabel ui_btnCalendario;
    private javax.swing.JLabel ui_btnReservas;
    private javax.swing.JLabel ui_topBar;
    // End of variables declaration//GEN-END:variables
}
