package grafica;

import java.sql.Date;
import javax.swing.JTextField;
import logica.SQL.SQLReserva;
import logica.SQL.SQLTurista;
import logica.Reserva;
import logica.Turista;

public class Reservar extends javax.swing.JPanel {

    public Reservar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCI = new javax.swing.JLabel();
        fieldCI = new javax.swing.JFormattedTextField();
        lblNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        fieldApellido = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        fieldFechaNac = new javax.swing.JFormattedTextField();
        lblTel = new javax.swing.JLabel();
        fieldTelefono = new javax.swing.JFormattedTextField();
        lblDireccion = new javax.swing.JLabel();
        fieldCalle = new javax.swing.JTextField();
        fieldNumero = new javax.swing.JTextField();
        fieldLocalidad = new javax.swing.JTextField();
        lblCabanna = new javax.swing.JLabel();
        fieldCabanna = new javax.swing.JFormattedTextField();
        lblFechaInicio = new javax.swing.JLabel();
        fieldFechaInicio = new javax.swing.JFormattedTextField();
        lblFechaFin = new javax.swing.JLabel();
        fieldFechaFin = new javax.swing.JFormattedTextField();
        btnReservar = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 131, 194));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reservar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCI.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCI.setForeground(new java.awt.Color(255, 255, 255));
        lblCI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCI.setText("Cédula de Identidad*:");
        add(lblCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 29, -1, 23));

        try {
            fieldCI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(fieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 33, 112, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre*");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 59, 140, 23));

        fieldNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldNombre.setPreferredSize(new java.awt.Dimension(60, 25));
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });
        add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 57, -1, -1));

        lblApellido.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("Apellido*");
        add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 88, 140, 23));

        fieldApellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldApellido.setPreferredSize(new java.awt.Dimension(60, 25));
        fieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldApellidoActionPerformed(evt);
            }
        });
        add(fieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 90, -1, -1));

        lblFechaNac.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaNac.setText("Fecha de Nacimiento*");
        add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 116, -1, 23));

        try {
            fieldFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaNac.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaNacActionPerformed(evt);
            }
        });
        add(fieldFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 120, 69, -1));

        lblTel.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblTel.setForeground(new java.awt.Color(255, 255, 255));
        lblTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTel.setText("Teléfono*");
        add(lblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 146, 140, 23));

        try {
            fieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 150, 156, -1));

        lblDireccion.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("Dirección*");
        add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 176, 144, 23));

        fieldCalle.setForeground(new java.awt.Color(173, 173, 173));
        fieldCalle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldCalle.setText("Calle");
        fieldCalle.setToolTipText("");
        fieldCalle.setPreferredSize(new java.awt.Dimension(60, 25));
        fieldCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCalleFocusLost(evt);
            }
        });
        fieldCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCalleActionPerformed(evt);
            }
        });
        add(fieldCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 178, 94, 24));

        fieldNumero.setForeground(new java.awt.Color(173, 173, 173));
        fieldNumero.setText("Numero");
        fieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNumeroFocusLost(evt);
            }
        });
        add(fieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 177, 69, 26));

        fieldLocalidad.setForeground(new java.awt.Color(173, 173, 173));
        fieldLocalidad.setText("Localidad");
        fieldLocalidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldLocalidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldLocalidadFocusLost(evt);
            }
        });
        add(fieldLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 177, 94, 27));

        lblCabanna.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCabanna.setForeground(new java.awt.Color(255, 255, 255));
        lblCabanna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCabanna.setText("ID Cabaña*");
        add(lblCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 210, 144, 23));

        fieldCabanna.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####"))));
        add(fieldCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 214, 94, -1));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaInicio.setText("Fecha de Inicio*");
        add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 240, 144, 23));

        try {
            fieldFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaInicio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaInicioActionPerformed(evt);
            }
        });
        add(fieldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 244, 69, -1));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaFin.setText("Fecha Finalización*");
        add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 270, 144, 23));

        try {
            fieldFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaFin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaFinActionPerformed(evt);
            }
        });
        add(fieldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 274, 69, -1));

        btnReservar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 271, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed

    }//GEN-LAST:event_fieldNombreActionPerformed

    private void fieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldApellidoActionPerformed

    }//GEN-LAST:event_fieldApellidoActionPerformed

    private void fieldFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaNacActionPerformed

    }//GEN-LAST:event_fieldFechaNacActionPerformed

    private void fieldCalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCalleFocusGained

        Index idx = new Index();
        idx.textHint("Calle", fieldCalle);
    }//GEN-LAST:event_fieldCalleFocusGained

    private void fieldCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCalleFocusLost
        Index idx = new Index();
        idx.textHint("Calle", fieldCalle);
    }//GEN-LAST:event_fieldCalleFocusLost

    private void fieldCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCalleActionPerformed

    }//GEN-LAST:event_fieldCalleActionPerformed

    private void fieldNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNumeroFocusGained
        Index idx = new Index();
        idx.textHint("Numero", fieldNumero);
    }//GEN-LAST:event_fieldNumeroFocusGained

    private void fieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNumeroFocusLost
        Index idx = new Index();
        idx.textHint("Numero", fieldNumero);
    }//GEN-LAST:event_fieldNumeroFocusLost

    private void fieldLocalidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldLocalidadFocusGained
        Index idx = new Index();
        idx.textHint("Localidad", fieldLocalidad);
    }//GEN-LAST:event_fieldLocalidadFocusGained

    private void fieldLocalidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldLocalidadFocusLost
        Index idx = new Index();
        idx.textHint("Localidad", fieldLocalidad);
    }//GEN-LAST:event_fieldLocalidadFocusLost

    private void fieldFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaInicioActionPerformed

    }//GEN-LAST:event_fieldFechaInicioActionPerformed

    private void fieldFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaFinActionPerformed

    }//GEN-LAST:event_fieldFechaFinActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        getInput(); //Obtengo todos los datos de los campos

        Turista turista = new Turista(ci, nombre, apellido, fechaNac, telefono, calle, numero, localidad); //Se crea el turista

        SQLTurista test = new SQLTurista();
        test.insertar(turista);

        int codigoReserva = (int) (Math.random() * 320000); //Genera un numero de reserva (puede estar duplicado)
        Reserva reserva = new Reserva(codigoReserva, fechaInicio, fechaFin, false, false, ci, idCabanna);

        SQLReserva testR = new SQLReserva();
        testR.insertar(reserva);

    }//GEN-LAST:event_btnReservarActionPerformed

    private int ci;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private int telefono;
    private String calle;
    private short numero;
    private String localidad;
    private short idCabanna; //FK
    private Date fechaInicio;
    private Date fechaFin;

    public void getInput() {
        ci = Integer.parseInt(fieldCI.getText());
        nombre = fieldNombre.getText();
        apellido = fieldApellido.getText();
        fechaNac = toDate(fieldFechaNac);
        telefono = Integer.parseInt(fieldTelefono.getText());
        calle = fieldCalle.getText();
        numero = Short.parseShort(fieldNumero.getText());
        localidad = fieldLocalidad.getText();
        idCabanna = Short.parseShort(fieldCabanna.getText());
        fechaInicio = toDate(fieldFechaInicio);
        fechaFin = toDate(fieldFechaFin);

    }

    public Date toDate(JTextField field) {  //A partir de un JTextField obtengo la fecha que contiene
        Reservar reservar = new Reservar();
        int day = reservar.getDay(field.getText());
        int month = reservar.getMonth(field.getText());
        int year = reservar.getYear(field.getText());

        Date result = new Date(year - 1900, month-1, day);
        return result;
    }

    public int getDay(String date) {
        int day = Integer.parseInt(date.substring(0, 2));
        return day;
    }

    public int getMonth(String date) {
        int month = Integer.parseInt(date.substring(3, 5));
        return month;
    }

    public int getYear(String date) {
        int year = (Integer.parseInt(date.substring(6, 10)));
        return year;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    public javax.swing.JTextField fieldApellido;
    public javax.swing.JFormattedTextField fieldCI;
    public javax.swing.JFormattedTextField fieldCabanna;
    public javax.swing.JTextField fieldCalle;
    public javax.swing.JFormattedTextField fieldFechaFin;
    public javax.swing.JFormattedTextField fieldFechaInicio;
    public javax.swing.JFormattedTextField fieldFechaNac;
    public javax.swing.JTextField fieldLocalidad;
    public javax.swing.JTextField fieldNombre;
    public javax.swing.JTextField fieldNumero;
    public javax.swing.JFormattedTextField fieldTelefono;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCI;
    private javax.swing.JLabel lblCabanna;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    // End of variables declaration//GEN-END:variables

}
