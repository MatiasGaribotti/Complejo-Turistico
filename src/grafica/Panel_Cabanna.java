package grafica;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import logica.Cabanna;
import logica.SQL.SQLCabanna;

/**
 * Clase que hereda de JPanel en la que tenemos toda la GUI para que el usuario
 * pueda ingresar nuevas Cabannas
 *
 * @version 13/10/2019/A
 * @author Matías Garibotti
 * @author Facundo Gallo
 */
public class Panel_Cabanna extends javax.swing.JPanel {

    private String accion;
    Cabanna cabanna;

    public Panel_Cabanna() {
        initComponents();
        accion = "INGRESAR";
    }

    public Panel_Cabanna(String accion) {
        initComponents();
        this.accion = accion;
    }

    public Panel_Cabanna(Cabanna cabanna, String accion) {
        initComponents();
        this.cabanna = cabanna;
        this.accion = accion;
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
        checkAireAcondicionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAireAcondicionadoActionPerformed(evt);
            }
        });
        add(checkAireAcondicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        checkParrillero.setBackground(new java.awt.Color(236, 235, 255));
        checkParrillero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        checkParrillero.setForeground(new java.awt.Color(43, 41, 41));
        checkParrillero.setText("Parrillero");
        checkParrillero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkParrilleroActionPerformed(evt);
            }
        });
        add(checkParrillero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 117, -1));

        lblCosto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(43, 41, 41));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCosto.setText("Costo por hora");
        add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, 20));

        fieldCostoHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCostoHourActionPerformed(evt);
            }
        });
        add(fieldCostoHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 88, 20));

        fieldCntHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCntHabitacionesActionPerformed(evt);
            }
        });
        add(fieldCntHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 88, 20));

        fieldCntBannos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCntBannosActionPerformed(evt);
            }
        });
        add(fieldCntBannos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 88, 20));

        fieldCntCamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCntCamasActionPerformed(evt);
            }
        });
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
        Cabanna cabanna = new Cabanna(
                Byte.parseByte(fieldCntHabitaciones.getText()),
                Byte.parseByte(fieldCntHabitaciones.getText()),
                Byte.parseByte(fieldCntCamas.getText()),
                Byte.parseByte(fieldCntBannos.getText()),
                (byte) 0,
                txtDescripcion.getText(),
                checkAireAcondicionado.isSelected(),
                checkParrillero.isSelected(),
                Short.parseShort(fieldCostoHour.getText())
        );

        SQLCabanna sCabanna = new SQLCabanna();

        if (accion.equals("MODIFICAR")) {
            boolean complete = sCabanna.modificar(cabanna);

            if (complete) {
                JOptionPane.showConfirmDialog(null, "Cabaña modificada correctamente");
                Index.paintTabla("CABANNAS");
                clearFields();
            } else {
                JOptionPane.showConfirmDialog(null, "Falla en la consulta, fue su culpa");
            }

        } else {
            boolean complete = sCabanna.insertar(cabanna);

            if (complete) {
                JOptionPane.showConfirmDialog(null, "Cabaña Ingresada correctamente");
                Index.paintTabla("CABANNAS");
                clearFields();
            } else {
                JOptionPane.showConfirmDialog(null, "Falla en la consulta, fue su culpa");
            }
        }

    }//GEN-LAST:event_btnIngresarMouseClicked

    private void fieldCntHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCntHabitacionesActionPerformed
        fieldCntHabitaciones.transferFocus();
    }//GEN-LAST:event_fieldCntHabitacionesActionPerformed

    private void fieldCntCamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCntCamasActionPerformed
        fieldCntCamas.transferFocus();
    }//GEN-LAST:event_fieldCntCamasActionPerformed

    private void fieldCntBannosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCntBannosActionPerformed
        fieldCntBannos.transferFocus();
    }//GEN-LAST:event_fieldCntBannosActionPerformed

    private void fieldCostoHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCostoHourActionPerformed
        fieldCostoHour.transferFocus();
    }//GEN-LAST:event_fieldCostoHourActionPerformed

    private void checkAireAcondicionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAireAcondicionadoActionPerformed
        checkAireAcondicionado.transferFocus();
    }//GEN-LAST:event_checkAireAcondicionadoActionPerformed

    private void checkParrilleroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkParrilleroActionPerformed
        checkParrillero.transferFocus();
    }//GEN-LAST:event_checkParrilleroActionPerformed

    public void clearFields() {
        this.fieldCntHabitaciones.setText("");
        this.fieldCntCamas.setText("");
        this.fieldCntBannos.setText("");
        this.fieldCostoHour.setText("");
        this.checkAireAcondicionado.setSelected(false);
        this.checkParrillero.setSelected(false);
        this.txtDescripcion.setText("");
    }

    public void setFields(short id) {
        SQLCabanna sql = new SQLCabanna();
        String[] datos = sql.select(Short.toString(id));

        fieldCntHabitaciones.setText(datos[1]);
        fieldCntCamas.setText(datos[2]);
        fieldCntBannos.setText(datos[3]);

        if (datos[4].equals("Sí")) {
            checkAireAcondicionado.setSelected(true);
        } else {
            checkAireAcondicionado.setSelected(false);
        }

        if (datos[5].equals("Sí")) {
            checkParrillero.setSelected(true);
        } else {
            checkParrillero.setSelected(false);
        }

        txtDescripcion.setText(datos[6]);
        fieldCostoHour.setText(datos[7]);

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
