package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana principal del software.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 *
 */

public class Index extends javax.swing.JFrame {

    //Almacenará la vista actual
    String currentView;
    Herramientas Herramienta;
    DefaultComboBoxModel modeloDef;
    DefaultComboBoxModel modeloDefSort;
    private JLayeredPane layerHerramientasHistory = new JLayeredPane();
    private JLayeredPane layerTablaHistory = new JLayeredPane();
    
    JPanel contentHistory = new JPanel();

    public Index() {
        setCurrentView("CABANNAS");
    }
    
    public void buildIndex(){       
        initComponents();
        
        this.setSize(1200, 768);
        this.setLocationRelativeTo(null);
        
        paintPanel(new Panel_Cabanna(), layerIngresos);
        
        Herramienta = new Herramientas(currentView);
        modeloDef = Herramienta.camposComboB(currentView, modeloDef);
        modeloDefSort = Herramienta.camposSort(currentView, modeloDefSort);
        Herramienta.buildHerramientas(modeloDef, modeloDefSort);
        
        paintPanel(Herramienta, layerHerramientas);   
        Index.paintTabla(currentView);
    }

    public String getCurrentView() {
        return currentView;
    }

    public void setCurrentView(String currentView) {
        this.currentView = currentView;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        iconReserva = new javax.swing.JLabel();
        btnReservas = new javax.swing.JLabel();
        ui_btnReservas = new javax.swing.JLabel();
        iconCabanna = new javax.swing.JLabel();
        btnCabannas = new javax.swing.JLabel();
        ui_btnCabannas = new javax.swing.JLabel();
        btnCalendario = new javax.swing.JLabel();
        iconCalendario = new javax.swing.JLabel();
        ui_btnCalendario = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        UI_sideBar = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        ui_Dispose = new javax.swing.JLabel();
        ui_Exit = new javax.swing.JLabel();
        ui_topBar = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        layerIngresos = new javax.swing.JLayeredPane();
        layerHerramientas = new javax.swing.JLayeredPane();
        layerTabla = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3 Weeks");
        setName("frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        sideBar.setBackground(new java.awt.Color(204, 204, 204));
        sideBar.setPreferredSize(new java.awt.Dimension(300, 600));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_reserva.png"))); // NOI18N
        sideBar.add(iconReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 40, 40));

        btnReservas.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnReservas.setForeground(new java.awt.Color(255, 255, 255));
        btnReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReservas.setText("Reservas");
        btnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReservasMousePressed(evt);
            }
        });
        sideBar.add(btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 40));

        ui_btnReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, -1));

        iconCabanna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCabanna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_cabanna.png"))); // NOI18N
        sideBar.add(iconCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 40, 40));

        btnCabannas.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCabannas.setForeground(new java.awt.Color(255, 255, 255));
        btnCabannas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCabannas.setText("Cabañas");
        btnCabannas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCabannasMousePressed(evt);
            }
        });
        sideBar.add(btnCabannas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, 40));

        ui_btnCabannas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCabannas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, -1));

        btnCalendario.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCalendario.setText("Histórico");
        btnCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCalendarioMousePressed(evt);
            }
        });
        sideBar.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 40));

        iconCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_calendario.png"))); // NOI18N
        sideBar.add(iconCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 40, 40));

        ui_btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, -1));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("3 Weeks");
        sideBar.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 40));

        UI_sideBar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UI_sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_sideBar.png"))); // NOI18N
        UI_sideBar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sideBar.add(UI_sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 770));

        getContentPane().add(sideBar);
        sideBar.setBounds(0, 0, 240, 770);

        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ui_Dispose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_Dispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonDISPOSE.png"))); // NOI18N
        ui_Dispose.setToolTipText("");
        ui_Dispose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ui_DisposeMousePressed(evt);
            }
        });
        topBar.add(ui_Dispose, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, 30));

        ui_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonEXIT.png"))); // NOI18N
        ui_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ui_ExitMousePressed(evt);
            }
        });
        topBar.add(ui_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 30));

        ui_topBar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ui_topBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_topBar.png"))); // NOI18N
        ui_topBar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ui_topBar.setIconTextGap(0);
        ui_topBar.setPreferredSize(new java.awt.Dimension(610, 35));
        topBar.add(ui_topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 30));

        getContentPane().add(topBar);
        topBar.setBounds(240, 0, 960, 30);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, java.awt.Color.lightGray));
        content.setLayout(null);

        layerIngresos.setPreferredSize(new java.awt.Dimension(483, 402));
        layerIngresos.setLayout(new java.awt.CardLayout());
        content.add(layerIngresos);
        layerIngresos.setBounds(10, 0, 483, 402);

        layerHerramientas.setPreferredSize(new java.awt.Dimension(454, 145));
        layerHerramientas.setLayout(new java.awt.CardLayout());
        content.add(layerHerramientas);
        layerHerramientas.setBounds(500, 250, 454, 145);

        layerTabla.setPreferredSize(new java.awt.Dimension(936, 286));

        javax.swing.GroupLayout layerTablaLayout = new javax.swing.GroupLayout(layerTabla);
        layerTabla.setLayout(layerTablaLayout);
        layerTablaLayout.setHorizontalGroup(
            layerTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        layerTablaLayout.setVerticalGroup(
            layerTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        content.add(layerTabla);
        layerTabla.setBounds(6, 410, 950, 320);

        getContentPane().add(content);
        content.setBounds(240, 30, 960, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ui_ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ui_ExitMousePressed
        System.exit(0);
    }//GEN-LAST:event_ui_ExitMousePressed

    private void btnReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservasMousePressed
        setCurrentView("RESERVAS");
        resetView();
        
        paintPanel(new Panel_Reservar(), layerIngresos);
               
        Herramienta = new Herramientas(this.getCurrentView());
        modeloDef = Herramienta.camposComboB(currentView, modeloDef);
        modeloDefSort = Herramienta.camposSort(currentView, modeloDefSort);
        Herramienta.buildHerramientas(modeloDef, modeloDefSort);
        
        paintPanel(Herramienta, layerHerramientas);
        paintTabla("RESERVAS");
    }//GEN-LAST:event_btnReservasMousePressed

    private void btnCabannasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCabannasMousePressed
        setCurrentView("CABANNAS");
        resetView();
        
        paintPanel(new Panel_Cabanna(), layerIngresos);
        Index.paintTabla(getCurrentView());
                
        Herramienta = new Herramientas(this.getCurrentView());
        modeloDef = Herramienta.camposComboB(currentView, modeloDef);
        modeloDefSort = Herramienta.camposSort(currentView, modeloDefSort);
        Herramienta.buildHerramientas(modeloDef, modeloDefSort);
        
        paintPanel(Herramienta, layerHerramientas);
    }//GEN-LAST:event_btnCabannasMousePressed

    private void ui_DisposeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ui_DisposeMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_ui_DisposeMousePressed

    private void btnCalendarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalendarioMousePressed
        this.currentView = "HISTORICO";
        setupHistorico();
        
    }//GEN-LAST:event_btnCalendarioMousePressed

    public void setupHistorico(){
        layerHerramientas.setVisible(false);
        layerIngresos.setVisible(false);
        layerTabla.setVisible(false);
        layerTabla.setEnabled(false);
        
        content.add(contentHistory);
        
        contentHistory.setLayout(null);
        contentHistory.setBounds(0,0,content.getWidth(),content.getHeight());
        contentHistory.setVisible(true);
        contentHistory.setBackground(Color.WHITE);
        JLabel lblTituloHistory = new JLabel("Histórico");
        contentHistory.add(lblTituloHistory);
        lblTituloHistory.setSize(300,30);
        lblTituloHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloHistory.setLocation((contentHistory.getWidth()/2) - lblTituloHistory.getWidth(), 10);
        lblTituloHistory.setFont(new java.awt.Font("Segoe UI Bold", 0, 30));
        lblTituloHistory.setVisible(true);
        
        layerHerramientasHistory.setBounds(10, 50, 940, 85);
        Herramientas panel = new Herramientas();
        modeloDef = Herramienta.camposComboB(currentView, modeloDef);
        modeloDefSort = Herramienta.camposSort(currentView, modeloDefSort);
        panel.buildHerramientas(modeloDef, modeloDefSort);
        
        layerHerramientasHistory.add(panel);
        contentHistory.add(layerHerramientasHistory);
        panel.horizontalView();
        
        layerTablaHistory.setBounds(10, layerHerramientasHistory.getLocation().y + layerHerramientasHistory.getHeight() + 10, 940, contentHistory.getHeight() - layerHerramientasHistory.getHeight() - 50 -10);
        Tabla tabla = new Tabla("HISTORICO");
        tabla.setVisible(true);
        tabla.buildTable();
        
        tabla.changeSize(layerTablaHistory.getWidth(), layerTablaHistory.getHeight()-20);
        layerTablaHistory.add(tabla);
        contentHistory.add(layerTablaHistory);
        contentHistory.repaint();
    }
    
    public void resetView(){
        contentHistory.setVisible(false);
        contentHistory.removeAll();
        layerIngresos.setVisible(true);
        layerHerramientas.setVisible(true);
        layerTabla.setVisible(true);
    }
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

    public static void paintTabla(String view) {
        Tabla tabla = new Tabla(view);
        tabla.buildTable();
        paintPanel(tabla, layerTabla);
    }
    
    public static void paintTabla(DefaultTableModel modelo, String view) {
        Tabla tabla = new Tabla(view);
        tabla.buildTable(modelo);
        paintPanel(tabla, layerTabla);
    }
    
    public static void paintIngreso(Panel_Cabanna cabanna) {
        cabanna.setFields(cabanna.cabanna.getId());
        paintPanel(cabanna, layerIngresos);
        
    }
    public static void paintIngreso(Panel_Reservar res) {
        res.setFields(res.reserva.getCodigoReserva());
        paintPanel(res, layerIngresos);
        
    }
    

    public static void paintPanel(JPanel panel, JLayeredPane lyrPane) { //Coloca un el panel deseado en el JLayeredPane
        lyrPane.removeAll();
        lyrPane.add(panel);
        lyrPane.repaint();
        lyrPane.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Index main = new Index();
        main.buildIndex();
        main.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UI_sideBar;
    private javax.swing.JLabel btnCabannas;
    private javax.swing.JLabel btnCalendario;
    private javax.swing.JLabel btnReservas;
    private javax.swing.JPanel content;
    private javax.swing.JLabel iconCabanna;
    private javax.swing.JLabel iconCalendario;
    private javax.swing.JLabel iconReserva;
    private javax.swing.JLayeredPane layerHerramientas;
    private static javax.swing.JLayeredPane layerIngresos;
    private static javax.swing.JLayeredPane layerTabla;
    private javax.swing.JLabel lblTitle;
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
