package grafica;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Reserva;
import logica.SQL.SQLReserva;
import logica.SQL.SQLTurista;
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
        btnReservar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 235, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reservar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        setPreferredSize(new java.awt.Dimension(483, 402));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCI.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCI.setForeground(new java.awt.Color(43, 41, 41));
        lblCI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCI.setText("CI*");
        add(lblCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 23));

        try {
            fieldCI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCI.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCIActionPerformed(evt);
            }
        });
        add(fieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 111, 22));

        lblNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(43, 41, 41));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Nombre*");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 20));

        fieldNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldNombre.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldNombre.setPreferredSize(new java.awt.Dimension(60, 25));
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });
        add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 111, 22));

        lblApellido.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(43, 41, 41));
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblApellido.setText("Apellido*");
        add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 20));

        fieldApellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldApellido.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldApellido.setPreferredSize(new java.awt.Dimension(60, 25));
        fieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldApellidoActionPerformed(evt);
            }
        });
        add(fieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 111, 22));

        lblFechaNac.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(43, 41, 41));
        lblFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFechaNac.setText("Nacimiento*");
        add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 20));

        try {
            fieldFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaNac.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaNac.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaNacActionPerformed(evt);
            }
        });
        add(fieldFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 69, 22));

        lblTel.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblTel.setForeground(new java.awt.Color(43, 41, 41));
        lblTel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTel.setText("Teléfono*");
        add(lblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 23));

        try {
            fieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldTelefono.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTelefonoActionPerformed(evt);
            }
        });
        add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 156, 22));

        lblDireccion.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(43, 41, 41));
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDireccion.setText("Dirección*");
        add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, 23));

        fieldCalle.setForeground(new java.awt.Color(173, 173, 173));
        fieldCalle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldCalle.setText("Calle");
        fieldCalle.setToolTipText("");
        fieldCalle.setCaretColor(new java.awt.Color(43, 41, 41));
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
        add(fieldCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 120, 22));

        fieldNumero.setForeground(new java.awt.Color(173, 173, 173));
        fieldNumero.setText("Numero");
        fieldNumero.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNumeroFocusLost(evt);
            }
        });
        fieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNumeroActionPerformed(evt);
            }
        });
        add(fieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 69, 22));

        fieldLocalidad.setForeground(new java.awt.Color(173, 173, 173));
        fieldLocalidad.setText("Localidad");
        fieldLocalidad.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldLocalidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldLocalidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldLocalidadFocusLost(evt);
            }
        });
        fieldLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldLocalidadActionPerformed(evt);
            }
        });
        add(fieldLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 110, 22));

        lblCabanna.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCabanna.setForeground(new java.awt.Color(43, 41, 41));
        lblCabanna.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCabanna.setText("ID Cabaña*");
        add(lblCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 23));

        fieldCabanna.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####"))));
        fieldCabanna.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldCabanna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCabannaActionPerformed(evt);
            }
        });
        add(fieldCabanna, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 70, 22));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(43, 41, 41));
        lblFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFechaInicio.setText("Fecha Inicio*");
        add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 20));

        try {
            fieldFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaInicio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaInicio.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaInicioActionPerformed(evt);
            }
        });
        add(fieldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 69, 22));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(43, 41, 41));
        lblFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFechaFin.setText("Fecha Fin*");
        add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 80, 23));

        try {
            fieldFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFechaFin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldFechaFin.setCaretColor(new java.awt.Color(43, 41, 41));
        fieldFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaFinActionPerformed(evt);
            }
        });
        add(fieldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 69, 22));

        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ui/ui_btnReservar.png"))); // NOI18N
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservarMouseClicked(evt);
            }
        });
        add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        fieldNombre.transferFocus();
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void fieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldApellidoActionPerformed
        fieldApellido.transferFocus();
    }//GEN-LAST:event_fieldApellidoActionPerformed

    private void fieldFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaNacActionPerformed
        fieldFechaNac.transferFocus();
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
        fieldCalle.transferFocus();
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
        fieldFechaInicio.transferFocus();
    }//GEN-LAST:event_fieldFechaInicioActionPerformed

    private void fieldFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaFinActionPerformed
        fieldFechaFin.transferFocus();
    }//GEN-LAST:event_fieldFechaFinActionPerformed

    private void btnReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseClicked
        boolean correcto=getInput(); //Obtengo todos los datos de los campos
        Turista turista = new Turista(ci, nombre, apellido, fechaNac, telefono, calle, numero, localidad); //Se crea el turista

        SQLTurista sTurista = new SQLTurista();
        boolean consultaTur=sTurista.insertar(turista);

        SQLReserva sReserva = new SQLReserva();
        
        int codigoReserva = (int) (Math.random() * 320000); //Genera un numero de reserva (puede estar duplicado)
        Reserva reserva = new Reserva(codigoReserva, fechaInicio, fechaFin, false, false, ci, idCabanna);
        
        boolean consultaRes=sReserva.insertar(reserva);
        
        /*
            Testing
        */
        if(correcto)
            JOptionPane.showConfirmDialog(null, "Cédula válida");
        else
            JOptionPane.showConfirmDialog(null, "Cédula inválida");
        if(consultaTur&&consultaRes)
            JOptionPane.showConfirmDialog(null, "Consulta realizada");
        else if(!consultaRes)
            JOptionPane.showConfirmDialog(null, "Consulta no mucho muy bien realizada para la reserva");
        else if(!consultaTur)
            JOptionPane.showConfirmDialog(null, "Consulta no mucho muy bien realizada para el turista");
        else
            JOptionPane.showConfirmDialog(null, "Consulta no realizada directamente, sino indirectamente en su mente.");
       
    }//GEN-LAST:event_btnReservarMouseClicked

    private void fieldCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCIActionPerformed
        fieldCI.transferFocus();
    }//GEN-LAST:event_fieldCIActionPerformed

    private void fieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTelefonoActionPerformed
        fieldTelefono.transferFocus();
    }//GEN-LAST:event_fieldTelefonoActionPerformed

    private void fieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNumeroActionPerformed
        fieldNumero.transferFocus();
    }//GEN-LAST:event_fieldNumeroActionPerformed

    private void fieldLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldLocalidadActionPerformed
        fieldLocalidad.transferFocus();
    }//GEN-LAST:event_fieldLocalidadActionPerformed

    private void fieldCabannaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCabannaActionPerformed
        fieldCabanna.transferFocus();
    }//GEN-LAST:event_fieldCabannaActionPerformed

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

    public boolean getInput() {
        boolean valido=true; //Creo una variable booleana como bandera para informar si están los campos válidos
        int [] Ced=new int[8];
        String Aux=fieldCI.getText();
        for(int i=0;i<Ced.length;i++){
            Ced[i]=Integer.parseInt(Aux.substring(i, i+1)); //Relleno el array con cada uno de los dígitos de la cédula
            if(i==7){
                //Matriz 2 9 8 7 6 3 4
                int Suma=Ced[0]*2+Ced[1]*9+Ced[2]*8+Ced[3]*7+Ced[4]*6+Ced[5]*3+Ced[6]*4;
                int M=(Suma%10);
                int verificador=((10-M)%10);
                if(Ced[i]!=verificador)
                    valido=false;
            }
        }
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
        return valido;
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
    private javax.swing.JLabel btnReservar;
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
