/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class VistaPrincipal extends javax.swing.JFrame implements IPrincipal {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    public void ejecutar(){
        this.setVisible(true);
        lblModelo.setVisible(false);
        cmbModelo.setVisible(false);
        lblVersion.setVisible(false);
        cmbVersion.setVisible(false);
        lblColor.setVisible(false);
        cmbColor.setVisible(false);
    }
    
    public void setControlador(controlador.Controlador control) {
        // Evento 1
        cmbMarca.addActionListener(control);
        cmbMarca.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try{
                    lblModelo.setVisible(false);
                    cmbModelo.setVisible(false);
                    lblVersion.setVisible(false);
                    cmbVersion.setVisible(false);
                    lblColor.setVisible(false);
                    cmbColor.setVisible(false);
                    limpiarLabels();
                    ActionEvent actionEvent = new ActionEvent(cmbMarca, ActionEvent.ACTION_PERFORMED, CARGAR_MODELOS);
                    control.actionPerformed(actionEvent);
                    lblModelo.setVisible(true);
                    cmbModelo.setVisible(true);
                }catch(NullPointerException ex){
                    System.out.print("");
                }
                
                
            }
        });
        // Evento 2
        cmbModelo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try{
                    lblVersion.setVisible(false);
                    cmbVersion.setVisible(false);
                    lblColor.setVisible(false);
                    cmbColor.setVisible(false);
                    limpiarLabels();
                    ActionEvent actionEvent = new ActionEvent(cmbMarca, ActionEvent.ACTION_PERFORMED, CARGAR_VERSIONES);
                    control.actionPerformed(actionEvent);
                    lblVersion.setVisible(true);
                    cmbVersion.setVisible(true);
                }catch(NullPointerException ex){
                    System.out.println("No hay modelo seleccionado");
                }
               
            }
        });
        // Evento 3
        cmbVersion.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try{
                    lblColor.setVisible(false);
                    cmbColor.setVisible(false);
                    limpiarLabels();
                    ActionEvent actionEvent = new ActionEvent(cmbMarca, ActionEvent.ACTION_PERFORMED, CARGAR_COLORES);
                    control.actionPerformed(actionEvent);
                    lblColor.setVisible(true);
                    cmbColor.setVisible(true);
                }catch(NullPointerException ex){
                    System.out.println("No hay version seleccionada");
                }
            }
        });
        // Evento 4
        cmbColor.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try{
                    ActionEvent actionEvent = new ActionEvent(cmbMarca, ActionEvent.ACTION_PERFORMED, CARGAR_DISPONIBILIDAD);
                    control.actionPerformed(actionEvent);
                }
                catch(NullPointerException ex){
                    System.out.println("No hay color seleccionado");
                }
            }
        });
        // Evento 5
        btnBuscar.addActionListener(control);
        btnBuscar.setActionCommand(BUSCAR_CLIENTE);
        // Evento 6
        btnRegistrar.addActionListener(control);
        btnRegistrar.setActionCommand(REGISTRAR_RESERVA);
        // Evento 7
        btnVerificar.addActionListener(control);
        btnVerificar.setActionCommand(VERIFICAR_RESERVA);
    }
    
    public void cargarMarcas(List marcas){
        cmbMarca.removeAllItems();
        // Desactivamos temporalmente los ItemListeners
        ItemListener[] listeners = cmbMarca.getItemListeners();
        for (ItemListener listener : listeners) {
            cmbMarca.removeItemListener(listener);
        }
        for(int i=0; i<marcas.size();i++){
            String item = (String) marcas.get(i);
            cmbMarca.addItem(item);
        }
        // Reactivamos los ItemListeners
        for (ItemListener listener : listeners) {
            cmbMarca.addItemListener(listener);
        }
    }
    
    public String getMarcaSeleccionada(){
        return (String)cmbMarca.getSelectedItem();
    }
    
    public String getModeloSeleccionado(){
        return (String)cmbModelo.getSelectedItem();
    }
    
    public String getVersionSeleccionada(){
        return (String)cmbVersion.getSelectedItem();
    }
    
    public String getColorSeleccionado(){
        return (String)cmbColor.getSelectedItem();
    }
    
    public void cargarModelos(List marcas){
        cmbModelo.removeAllItems();
        //Obtenemos todos los ItemListener 
        ItemListener[] listeners = cmbModelo.getItemListeners();
        //Desactivamos uno por uno para prevenir la deteccion en la carga
        for (ItemListener listener : listeners) {
            cmbModelo.removeItemListener(listener);
        }
        //Cargamos los items
        for(int i=0; i<marcas.size();i++){
            String item = (String) marcas.get(i);
            cmbModelo.addItem(item);
        }
        // Reactivamos los ItemListeners
        for (ItemListener listener : listeners) {
            cmbModelo.addItemListener(listener);
        }
    }
    
    public void cargarVersiones(List marcas){
        cmbVersion.removeAllItems();
        //Obtenemos todos los ItemListener 
        ItemListener[] listeners = cmbVersion.getItemListeners();
        //Desactivamos uno por uno para prevenir la deteccion en la carga
        for (ItemListener listener : listeners) {
            cmbVersion.removeItemListener(listener);
        }
        for(int i=0; i<marcas.size();i++){
            String item = (String) marcas.get(i);
            cmbVersion.addItem(item);
        }
        // Reactivamos los ItemListeners
        for (ItemListener listener : listeners) {
            cmbVersion.addItemListener(listener);
        }
    }
    
    public void cargarColores(List colores){
        cmbColor.removeAllItems();
        ItemListener[] listeners = cmbColor.getItemListeners();
        
        for (ItemListener listener : listeners) {
            cmbColor.removeItemListener(listener);
        }
        
        for(int i=0; i<colores.size();i++){
            String item = (String) colores.get(i);
            cmbColor.addItem(item);
        }
        
        for (ItemListener listener : listeners) {
            cmbColor.addItemListener(listener);
        }
    }
    
    public void setDisponibilidad(boolean flag){
        if(flag) {
            jLabel3.setText("DISPONIBLE");
            jLabel3.setForeground(Color.GREEN);
        } else {
            jLabel3.setText("NO DISPONIBLE");
            jLabel3.setForeground(Color.RED);
        }
    }
    
    public void setPrecio(Double precio){
        lblPrecio.setText("Precio: $" + precio);
    }
    
    public void setFechaEntrega(String fecha) {
        lblFechaEntrega.setText("Fecha de entrega: " + fecha);
    }
    
    public void setFechaReserva(String fecha) {
        lblFechaReserva.setText("Fecha de reserva: " + fecha);
    }
    
    public void setTotal(Double precio){
        lblMontoTotal.setText("Monto total: $" + precio);
    }
    
    public String getDNI() {
        return txtDNI.getText();
    }
    
    public void setInfoBusqueda(String mensaje) {
        lblBusqueda.setText(mensaje);
    }
    
    public void limpiarInformacion() {
        cmbMarca.setSelectedIndex(0);
        lblModelo.setVisible(false);
        lblVersion.setVisible(false);
        lblColor.setVisible(false);
        cmbModelo.setVisible(false); 
        cmbVersion.setVisible(false); 
        cmbColor.setVisible(false);
        rdAceptar.setSelected(false);
        rdRechazar.setSelected(false);
    }
    
    public void limpiarLabels() {
        lblDisponibilidad.setText("Disponibilidad:");
        lblPrecio.setText("Precio:");
        lblFechaEntrega.setText("Fecha de entrega:");
        lblMontoTotal.setText("Monto total:");
        lblFechaReserva.setText("Fecha de reserva:");
        txtDNI.setText("");
        lblBusqueda.setText("");
        jLabel3.setText("");
    }
    
    public void limpiarLabelCliente(){
        lblBusqueda.setText("");
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,"Aviso",JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public boolean getSeleccion() {
        return rdAceptar.isSelected() ? true : false;
    }
    
    public int getID() {
        return Integer.parseInt(txtReserva.getText());
    }
    
    public void setInfoReserva(String mensaje) {
        lblReserva.setText(mensaje);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel();
        cmbModelo = new javax.swing.JComboBox<>();
        lblVersion = new javax.swing.JLabel();
        cmbVersion = new javax.swing.JComboBox<>();
        lblColor = new javax.swing.JLabel();
        cmbColor = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblDisponibilidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblFechaEntrega = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        lblFechaReserva = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        lblBusqueda = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        rdAceptar = new javax.swing.JRadioButton();
        rdRechazar = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtReserva = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        lblReserva = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Marca");

        lblModelo.setText("Modelo");

        lblVersion.setText("Version");

        lblColor.setText("Color");

        btnRegistrar.setText("Registrar reserva");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Información del vehículo:");

        lblDisponibilidad.setText("Disponibilidad:");

        lblPrecio.setText("Precio:");

        lblFechaEntrega.setText("Fecha de entrega:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Información de la reserva:");

        lblMontoTotal.setText("Monto total:");

        lblFechaReserva.setText("Fecha de reserva:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("DNI del cliente:");

        btnBuscar.setText("Buscar");

        buttonGroup1.add(rdAceptar);
        rdAceptar.setText("Aceptar");

        buttonGroup1.add(rdRechazar);
        rdRechazar.setText("Rechazar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Buscar reserva:");

        btnVerificar.setText("Verificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVersion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModelo)
                            .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor)
                            .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVerificar))
                            .addComponent(lblReserva))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaEntrega)
                            .addComponent(lblPrecio)
                            .addComponent(lblFechaReserva)
                            .addComponent(lblMontoTotal)
                            .addComponent(lblBusqueda)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistrar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(rdRechazar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDisponibilidad)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDisponibilidad)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFechaEntrega)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMontoTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechaReserva)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBusqueda))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblModelo)
                        .addGap(18, 18, 18)
                        .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lblVersion)
                        .addGap(18, 18, 18)
                        .addComponent(cmbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblColor)
                        .addGap(18, 18, 18)
                        .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdAceptar)
                            .addComponent(rdRechazar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReserva)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbModelo;
    private javax.swing.JComboBox<String> cmbVersion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaReserva;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblReserva;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JRadioButton rdAceptar;
    private javax.swing.JRadioButton rdRechazar;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtReserva;
    // End of variables declaration//GEN-END:variables
}
