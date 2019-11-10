package grafica;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import logica.Usuario;

/**
 * Ventana principal del software.
 *
 * @author Matías Garibotti
 * @author Facundo Gallo
 *
 */

public class Index extends javax.swing.JFrame {
    public static Usuario user;
    //Almacenará la vista actual
    String currentView;
    Tools_Buscar searchPanel;
    Tools_visualizar viewPanel;
    Tools_Ocupacion viewOcupacion;
    DefaultComboBoxModel modeloDef;
    DefaultComboBoxModel modeloDefSort;
    private JLayeredPane layerHerramientasHistory = new JLayeredPane();
    private JLayeredPane layerTablaHistory = new JLayeredPane();
    
    JPanel contentHistory = new JPanel();

    public Index() {
        setCurrentView("CABANNAS");
        user = new Usuario();
    }

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Index.user = user;
    }
    
    public void build(){       
        initComponents();
        
        this.setSize(1200, 768);
        this.setLocationRelativeTo(null);
        
        paintPanel(new Panel_Cabanna(), layerIngresos);
        
        searchPanel = new Tools_Buscar(currentView);
        modeloDef = searchPanel.camposComboB(currentView, modeloDef);
        searchPanel.build(modeloDef);
        
        
        paintPanel(searchPanel, layerBuscar);   
        
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
        btnCheckOutWindow = new javax.swing.JLabel();
        ui_btnCheckOutWindow = new javax.swing.JLabel();
        btnCheckInWindow = new javax.swing.JLabel();
        ui_btnCheckInWindow = new javax.swing.JLabel();
        btnUser = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        ui_btnUser = new javax.swing.JLabel();
        btnCanceladas = new javax.swing.JLabel();
        iconCanceladas = new javax.swing.JLabel();
        ui_btnCanceladas = new javax.swing.JLabel();
        iconReserva = new javax.swing.JLabel();
        btnReservas = new javax.swing.JLabel();
        ui_btnReservas = new javax.swing.JLabel();
        iconCabanna = new javax.swing.JLabel();
        btnCabannas = new javax.swing.JLabel();
        ui_btnCabannas = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JLabel();
        iconHistorico = new javax.swing.JLabel();
        ui_btnCalendario = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        UI_sideBar = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        ui_Dispose = new javax.swing.JLabel();
        ui_Exit = new javax.swing.JLabel();
        ui_topBar = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        layerOcupación = new javax.swing.JLayeredPane();
        layerIngresos = new javax.swing.JLayeredPane();
        layerBuscar = new javax.swing.JLayeredPane();
        layerTabla = new javax.swing.JLayeredPane();
        layerVisualizar = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3 Weeks");
        setName("frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        sideBar.setBackground(new java.awt.Color(204, 204, 204));
        sideBar.setPreferredSize(new java.awt.Dimension(300, 600));
        sideBar.setLayout(null);

        btnCheckOutWindow.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCheckOutWindow.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckOutWindow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCheckOutWindow.setText("Check Out");
        btnCheckOutWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCheckOutWindowMousePressed(evt);
            }
        });
        sideBar.add(btnCheckOutWindow);
        btnCheckOutWindow.setBounds(0, 330, 240, 40);

        ui_btnCheckOutWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCheckOutWindow);
        ui_btnCheckOutWindow.setBounds(0, 330, 240, 40);

        btnCheckInWindow.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCheckInWindow.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckInWindow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCheckInWindow.setText("Check In");
        btnCheckInWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCheckInWindowMousePressed(evt);
            }
        });
        sideBar.add(btnCheckInWindow);
        btnCheckInWindow.setBounds(0, 280, 240, 40);

        ui_btnCheckInWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCheckInWindow);
        ui_btnCheckInWindow.setBounds(0, 280, 240, 40);

        btnUser.setFont(new java.awt.Font("Segoe UI Light", 1, 30)); // NOI18N
        btnUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUser.setText("Usuario");
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUserMousePressed(evt);
            }
        });
        sideBar.add(btnUser);
        btnUser.setBounds(0, 730, 240, 40);

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/iconUser.png"))); // NOI18N
        sideBar.add(iconUser);
        iconUser.setBounds(10, 730, 30, 40);

        ui_btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnUser);
        ui_btnUser.setBounds(0, 730, 240, 40);

        btnCanceladas.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCanceladas.setForeground(new java.awt.Color(255, 255, 255));
        btnCanceladas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCanceladas.setText("Canceladas");
        btnCanceladas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCanceladasMousePressed(evt);
            }
        });
        sideBar.add(btnCanceladas);
        btnCanceladas.setBounds(20, 230, 220, 40);

        iconCanceladas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_canceladas.png"))); // NOI18N
        sideBar.add(iconCanceladas);
        iconCanceladas.setBounds(10, 240, 26, 26);

        ui_btnCanceladas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCanceladas);
        ui_btnCanceladas.setBounds(0, 230, 240, 40);

        iconReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_reserva.png"))); // NOI18N
        sideBar.add(iconReserva);
        iconReserva.setBounds(0, 80, 40, 40);

        btnReservas.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnReservas.setForeground(new java.awt.Color(255, 255, 255));
        btnReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReservas.setText("Reservas");
        btnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReservasMousePressed(evt);
            }
        });
        sideBar.add(btnReservas);
        btnReservas.setBounds(0, 80, 240, 40);

        ui_btnReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnReservas);
        ui_btnReservas.setBounds(0, 80, 240, 40);

        iconCabanna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCabanna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ico_cabanna.png"))); // NOI18N
        sideBar.add(iconCabanna);
        iconCabanna.setBounds(0, 130, 40, 40);

        btnCabannas.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnCabannas.setForeground(new java.awt.Color(255, 255, 255));
        btnCabannas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCabannas.setText("Cabañas");
        btnCabannas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCabannasMousePressed(evt);
            }
        });
        sideBar.add(btnCabannas);
        btnCabannas.setBounds(0, 130, 240, 40);

        ui_btnCabannas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCabannas);
        ui_btnCabannas.setBounds(0, 130, 240, 40);

        btnHistorico.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnHistorico.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHistorico.setText("Histórico");
        btnHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHistoricoMousePressed(evt);
            }
        });
        sideBar.add(btnHistorico);
        btnHistorico.setBounds(0, 180, 240, 40);

        iconHistorico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/iconHistorico.png"))); // NOI18N
        sideBar.add(iconHistorico);
        iconHistorico.setBounds(0, 180, 40, 40);

        ui_btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_buttonSideBar.png"))); // NOI18N
        sideBar.add(ui_btnCalendario);
        ui_btnCalendario.setBounds(0, 180, 240, 40);

        lblTitle.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("T3W");
        sideBar.add(lblTitle);
        lblTitle.setBounds(40, 20, 150, 40);

        UI_sideBar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UI_sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_sideBar.png"))); // NOI18N
        UI_sideBar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sideBar.add(UI_sideBar);
        UI_sideBar.setBounds(0, 0, 250, 770);

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

        layerOcupación.setPreferredSize(new java.awt.Dimension(464, 89));
        layerOcupación.setLayout(new java.awt.CardLayout());
        content.add(layerOcupación);
        layerOcupación.setBounds(500, 180, 450, 60);

        layerIngresos.setPreferredSize(new java.awt.Dimension(483, 402));
        layerIngresos.setLayout(new java.awt.CardLayout());
        content.add(layerIngresos);
        layerIngresos.setBounds(10, 0, 483, 402);

        layerBuscar.setPreferredSize(new java.awt.Dimension(454, 145));
        layerBuscar.setLayout(new java.awt.CardLayout());
        content.add(layerBuscar);
        layerBuscar.setBounds(500, 315, 450, 90);

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

        layerVisualizar.setPreferredSize(new java.awt.Dimension(464, 89));
        layerVisualizar.setLayout(new java.awt.CardLayout());
        content.add(layerVisualizar);
        layerVisualizar.setBounds(500, 250, 450, 60);

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
        layerOcupación.removeAll();
        layerVisualizar.removeAll();
        Panel_Reservar p = new Panel_Reservar();
        p.build();
        paintPanel(p, layerIngresos);
               
        searchPanel = new Tools_Buscar(this.getCurrentView());
        modeloDef = searchPanel.camposComboB(currentView, modeloDef);
        searchPanel.build(modeloDef);
        viewOcupacion = new Tools_Ocupacion();
        viewOcupacion.build();
        viewPanel = new Tools_visualizar();
        viewPanel.build();
        paintPanel(viewPanel, layerVisualizar);
        paintPanel(viewOcupacion, layerOcupación);
        
        paintPanel(searchPanel, layerBuscar);
        paintTabla("RESERVAS");
    }//GEN-LAST:event_btnReservasMousePressed

    private void btnCabannasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCabannasMousePressed
        setCurrentView("CABANNAS");
        resetView();
        layerOcupación.removeAll();
        layerVisualizar.removeAll();
        layerVisualizar.repaint();
        layerOcupación.repaint();
        
        paintPanel(new Panel_Cabanna(), layerIngresos);
        Index.paintTabla(getCurrentView());
                
        searchPanel = new Tools_Buscar(this.getCurrentView());
        modeloDef = searchPanel.camposComboB(currentView, modeloDef);
        searchPanel.build(modeloDef);
        
        paintPanel(searchPanel, layerBuscar);
    }//GEN-LAST:event_btnCabannasMousePressed

    private void ui_DisposeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ui_DisposeMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_ui_DisposeMousePressed

    private void btnHistoricoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoricoMousePressed
        layerTablaHistory.removeAll();
        this.currentView = "HISTORICO";
        setupHistorico("Histórico");
        layerVisualizar.removeAll();
        layerVisualizar.repaint();
        layerOcupación.removeAll();
        layerOcupación.repaint();
        
    }//GEN-LAST:event_btnHistoricoMousePressed

    private void btnCanceladasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanceladasMousePressed
        layerTablaHistory.removeAll();
        this.currentView = "CANCELADAS";
        setupHistorico("Canceladas");
        layerVisualizar.removeAll();
        layerVisualizar.repaint();
        layerOcupación.removeAll();
        layerOcupación.repaint();
    }//GEN-LAST:event_btnCanceladasMousePressed

    private void btnUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMousePressed
        Login_Duenno login = new Login_Duenno();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnUserMousePressed

    private void btnCheckInWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckInWindowMousePressed
        Window_Checkin checkin = new Window_Checkin();
        user.setNombre("Turista");
        checkin.build();
        checkin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCheckInWindowMousePressed

    private void btnCheckOutWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckOutWindowMousePressed
        Window_Checkout checkout = new Window_Checkout();
        checkout.build();
        checkout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCheckOutWindowMousePressed

    public void setupHistorico(String title){
        layerBuscar.setVisible(false);
        layerIngresos.setVisible(false);
        layerTabla.setVisible(false);
        layerTabla.setEnabled(false);
        
        content.add(contentHistory);
        contentHistory.removeAll();
        
        
        contentHistory.setLayout(null);
        contentHistory.setBounds(0,0,content.getWidth(),content.getHeight());
        contentHistory.setVisible(true);
        contentHistory.setBackground(Color.WHITE);
        JLabel lblTituloHistory = new JLabel(title);
        contentHistory.add(lblTituloHistory);
        lblTituloHistory.setSize(300,30);
        lblTituloHistory.setVisible(false);
        
        layerTablaHistory.setBounds(10, layerHerramientasHistory.getLocation().y + layerHerramientasHistory.getHeight() + 10, 940, contentHistory.getHeight() - layerHerramientasHistory.getHeight() - 50 -10);
        Tabla tabla = new Tabla(this.getCurrentView());
        
        tabla.setVisible(true);
        tabla.buildTable();
        
        tabla.changeSize(layerTablaHistory.getWidth(), layerTablaHistory.getHeight()-20);
        layerTablaHistory.add(tabla);
        contentHistory.add(layerTablaHistory);
        layerTablaHistory.repaint();
        contentHistory.repaint();
    }
      
    public void resetView(){
        contentHistory.setVisible(false);
        contentHistory.removeAll();
        layerTablaHistory.removeAll();
        layerIngresos.setVisible(true);
        layerBuscar.setVisible(true);
        layerTabla.setVisible(true);
    }
    public static Color color_textHint = new Color(212, 212, 212);

    public void textHint(String txt, JTextField obj) { //Procedimiento para textHints
        if (obj.getText().equals(txt)) {
            obj.setText("");
            obj.setForeground(Color.BLACK);
        } else if (obj.getText().equals("")) {
            obj.setText(txt);
            obj.setForeground(color_textHint);
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
        Index.user=new Usuario();
        Index main = new Index();
        main.build();
        main.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UI_sideBar;
    private javax.swing.JLabel btnCabannas;
    private javax.swing.JLabel btnCanceladas;
    private javax.swing.JLabel btnCheckInWindow;
    private javax.swing.JLabel btnCheckOutWindow;
    private javax.swing.JLabel btnHistorico;
    private javax.swing.JLabel btnReservas;
    private javax.swing.JLabel btnUser;
    private javax.swing.JPanel content;
    private javax.swing.JLabel iconCabanna;
    private javax.swing.JLabel iconCanceladas;
    private javax.swing.JLabel iconHistorico;
    private javax.swing.JLabel iconReserva;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLayeredPane layerBuscar;
    private static javax.swing.JLayeredPane layerIngresos;
    private static javax.swing.JLayeredPane layerOcupación;
    private static javax.swing.JLayeredPane layerTabla;
    private static javax.swing.JLayeredPane layerVisualizar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel ui_Dispose;
    private javax.swing.JLabel ui_Exit;
    private javax.swing.JLabel ui_btnCabannas;
    private javax.swing.JLabel ui_btnCalendario;
    private javax.swing.JLabel ui_btnCanceladas;
    private javax.swing.JLabel ui_btnCheckInWindow;
    private javax.swing.JLabel ui_btnCheckOutWindow;
    private javax.swing.JLabel ui_btnReservas;
    private javax.swing.JLabel ui_btnUser;
    private javax.swing.JLabel ui_topBar;
    // End of variables declaration//GEN-END:variables
}