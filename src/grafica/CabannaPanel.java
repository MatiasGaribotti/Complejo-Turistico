package grafica;

import javax.swing.JOptionPane;
import logica.Cabanna;
import logica.SQL.SQLQueries;

public class CabannaPanel extends javax.swing.JPanel {

    private byte cntHabitaciones;
    private byte cntCamas;
    private byte cntBannos;
    private String descripcion;
    private boolean aireAcondicionado;
    private boolean parrillero;
    private short costoHour;

    public byte getCntHabitaciones() {
        return cntHabitaciones;
    }

    public void setCntHabitaciones(byte cntHabitaciones) {
        this.cntHabitaciones = cntHabitaciones;
    }

    public byte getCntCamas() {
        return cntCamas;
    }

    public void setCntCamas(byte cntCamas) {
        this.cntCamas = cntCamas;
    }

    public byte getCntBannos() {
        return cntBannos;
    }

    public void setCntBannos(byte cntBannos) {
        this.cntBannos = cntBannos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean getParrillero() {
        return parrillero;
    }

    public void setParrillero(boolean parrillero) {
        this.parrillero = parrillero;
    }

    public short getCostoHour() {
        return costoHour;
    }

    public void setCostoHour(short costoHour) {
        this.costoHour = costoHour;
    }

    public CabannaPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCntCamas = new javax.swing.JLabel();
        lblCntHabitaciones = new javax.swing.JLabel();
        lblCntBannos = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        scrollDescripcion = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        checkAireAcondicionado = new javax.swing.JCheckBox();
        checkParrillero = new javax.swing.JCheckBox();
        lblCosto = new javax.swing.JLabel();
        fieldCostoHour = new javax.swing.JTextField();
        fieldCntHabitaciones = new javax.swing.JTextField();
        fieldCntBannos = new javax.swing.JTextField();
        fieldCntCamas = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 235, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Cabaña", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(43, 41, 41))); // NOI18N
        setPreferredSize(new java.awt.Dimension(483, 402));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCntCamas.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCntCamas.setForeground(new java.awt.Color(43, 41, 41));
        lblCntCamas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCntCamas.setText("Camas");
        add(lblCntCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 50, 20));

        lblCntHabitaciones.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCntHabitaciones.setForeground(new java.awt.Color(43, 41, 41));
        lblCntHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCntHabitaciones.setText("Habitaciones");
        add(lblCntHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));

        lblCntBannos.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCntBannos.setForeground(new java.awt.Color(43, 41, 41));
        lblCntBannos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCntBannos.setText("Cantidad de Baños");
        add(lblCntBannos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 20));

        lblDescripcion.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(43, 41, 41));
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescripcion.setText("Descripción");
        add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, 20));

        scrollDescripcion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        scrollDescripcion.setViewportView(txtDescripcion);

        add(scrollDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 280, 60));

        checkAireAcondicionado.setBackground(new java.awt.Color(236, 235, 255));
        checkAireAcondicionado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        checkAireAcondicionado.setForeground(new java.awt.Color(43, 41, 41));
        checkAireAcondicionado.setText("Aire Acondicionado");
        add(checkAireAcondicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        checkParrillero.setBackground(new java.awt.Color(236, 235, 255));
        checkParrillero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        checkParrillero.setForeground(new java.awt.Color(43, 41, 41));
        checkParrillero.setText("Parrillero");
        add(checkParrillero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 117, -1));

        lblCosto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(43, 41, 41));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCosto.setText("Costo por hora");
        add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, 20));
        add(fieldCostoHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 88, 20));
        add(fieldCntHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 88, 20));
        add(fieldCntBannos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 88, 20));
        add(fieldCntCamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 88, 20));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_btnIngresar.png"))); // NOI18N
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        getInput();
        Cabanna cabanna = new Cabanna(cntHabitaciones, cntCamas, cntBannos, (byte) 0, descripcion, aireAcondicionado, parrillero, costoHour);
        SQLQueries test = new SQLQueries();
        boolean complete=test.insertar(cabanna);
        if(complete)
            JOptionPane.showConfirmDialog(null, "Consulta realizada");
        else
            JOptionPane.showConfirmDialog(null, "Falla en la consulta, fue su culpa");
    }//GEN-LAST:event_btnIngresarMouseClicked

    public void getInput() {
        this.cntHabitaciones = Byte.parseByte(fieldCntHabitaciones.getText());
        this.cntCamas = Byte.parseByte(fieldCntCamas.getText());
        this.cntBannos = Byte.parseByte(fieldCntBannos.getText());
        this.descripcion = txtDescripcion.getText();
        this.aireAcondicionado = checkAireAcondicionado.isSelected();
        this.parrillero = checkParrillero.isSelected();
        this.costoHour = Short.parseShort(fieldCostoHour.getText());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnIngresar;
    public javax.swing.JCheckBox checkAireAcondicionado;
    public javax.swing.JCheckBox checkParrillero;
    private javax.swing.JTextField fieldCntBannos;
    private javax.swing.JTextField fieldCntCamas;
    private javax.swing.JTextField fieldCntHabitaciones;
    private javax.swing.JTextField fieldCostoHour;
    private javax.swing.JLabel lblCntBannos;
    private javax.swing.JLabel lblCntCamas;
    private javax.swing.JLabel lblCntHabitaciones;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JScrollPane scrollDescripcion;
    public javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
