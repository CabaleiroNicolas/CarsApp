/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

//import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.modelos.Reserva;

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
        this.setLocationRelativeTo(null);
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
        //Evento 8
        btnBuscarR.addActionListener(control);
        btnBuscarR.setActionCommand(BUSCAR_RESERVA);
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
    public void llenarTabla(List<Reserva> reservas) {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("FR");
        tabla.addColumn("FE");
        tabla.addColumn("Monto");
        tabla.addColumn("Estado");
        tabla.addColumn("Marca");
        tabla.addColumn("Modelo");
        tabla.addColumn("Versión");
        tabla.addColumn("Color");

        for (Reserva reserva : reservas) {
            Object[] fila = new Object[9];
            fila[0] = reserva.getID();
            fila[1] = new SimpleDateFormat("dd/MM/yyyy").format(reserva.getFechaReserva());
            fila[2]=  new SimpleDateFormat("dd/MM/yyyy").format(reserva.getVersion().getFechaEntrega());
            fila[3] = String.format("USD$ %.2f", reserva.getMontoTotal());
            fila[4] = reserva.getEstado().toString();
            fila[5] = reserva.getMarca().getNombre();
            fila[6] = reserva.getModelo().getNombre();
            fila[7] = reserva.getVersion().getNombre();
            fila[8] = reserva.getColor().getNombre();

            tabla.addRow(fila); 
        }
        jTable1.setModel(tabla);
    }
    public void limpiarTabla() {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("FR");
        tabla.addColumn("FE");
        tabla.addColumn("Monto");
        tabla.addColumn("Estado");
        tabla.addColumn("Marca");
        tabla.addColumn("Modelo");
        tabla.addColumn("Versión");
        tabla.addColumn("Color");
        jTable1.setModel(tabla);
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
        lblPrecio.setText("Precio: USD$ " + precio);
    }
    
    public void setFechaEntrega(String fecha) {
        lblFechaEntrega.setText("Fecha de entrega: " + fecha);
    }
    
    public void setFechaReserva(String fecha) {
        lblFechaReserva.setText("Fecha de reserva: " + fecha);
    }
    
    public void setTotal(Double precio){
        lblMontoTotal.setText("Monto total: USD$ " + precio);
    }
    
    public String getDNI() {
        return txtDNI.getText();
    }
    
    public String getDNIR() {
        return TXTdniR.getText();
    }
    
    public void setInfoBusqueda(String mensaje) {
        labelInfoBusqueda.setText(mensaje);
    }
    public void lblTablaReserva(String mensaje){
        lblTablaReserva.setText("Reservas del Cliente: "+mensaje);
    }
    public void setMontoPat(String mensaje) {
        lblMontoPat.setText("Monto Patentamiento: " + mensaje);
    }
    public void setMontoFlete(String mensaje) {
        lblMontoFlete.setText("Monto Flete: " + mensaje);
    }
    public void limpiarInformacion() {
        cmbMarca.setSelectedIndex(0);
        lblModelo.setVisible(false);
        lblVersion.setVisible(false);
        lblColor.setVisible(false);
        cmbModelo.setVisible(false); 
        cmbVersion.setVisible(false); 
        cmbColor.setVisible(false);
    }
    
    public void resetearRadioBotones(){
        rdAceptar.setSelected(false);
        rdRechazar.setSelected(false);
    }
    
    public void limpiarLabels() {
        lblDisponibilidad.setText("Disponibilidad:");
        lblPrecio.setText("Precio:");
        lblFechaEntrega.setText("Fecha de entrega:");
        lblMontoTotal.setText("Monto total:");
        lblFechaReserva.setText("Fecha de reserva:");
        lblMontoPat.setText("Monto Patentamiento:");
        lblMontoFlete.setText("Monto Flete:");
        lblTablaReserva.setText("Reservas del Cliente:");
        txtDNI.setText("");
        TXTdniR.setText("");
        labelInfoBusqueda.setText("");
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
        return (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        //return Integer.parseInt(txtReserva.getText());
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
        btnVerificar = new javax.swing.JButton();
        lblReserva = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelInfoBusqueda = new javax.swing.JLabel();
        lblTablaReserva = new javax.swing.JLabel();
        lblMontoPat = new javax.swing.JLabel();
        lblMontoFlete = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXTdniR = new javax.swing.JTextField();
        btnBuscarR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

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

        btnVerificar.setText("Verificar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FR", "FE", "Monto", "Estado", "Marca", "Modelo", "Version", "Color"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblTablaReserva.setText("Reservas del Cliente: ");

        lblMontoPat.setText("Monto Patentamiento:");

        lblMontoFlete.setText("Monto Flete:");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Buscar reservas del cliente");

        jLabel6.setText("DNI del cliente:");

        btnBuscarR.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo)
                    .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor)
                    .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReserva)
                    .addComponent(lblVersion))
                .addGap(56, 56, 56)
                .addComponent(lblBusqueda)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFechaEntrega)
                    .addComponent(lblPrecio)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDisponibilidad)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(btnRegistrar)
                    .addComponent(lblMontoTotal)
                    .addComponent(jLabel9)
                    .addComponent(lblFechaReserva)
                    .addComponent(lblMontoPat)
                    .addComponent(labelInfoBusqueda)
                    .addComponent(lblMontoFlete)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(rdRechazar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblTablaReserva)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTdniR, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarR))
                    .addComponent(btnVerificar))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblVersion)
                        .addGap(18, 18, 18)
                        .addComponent(cmbVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lblColor)
                        .addGap(18, 18, 18)
                        .addComponent(cmbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblDisponibilidad))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblPrecio)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblFechaEntrega)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblMontoPat)
                                            .addGap(7, 7, 7)
                                            .addComponent(lblMontoFlete)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblMontoTotal)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblFechaReserva)
                                            .addGap(25, 25, 25)
                                            .addComponent(labelInfoBusqueda))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6)
                                                .addComponent(TXTdniR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnBuscarR))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                    .addComponent(lblTablaReserva)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23)))
                            .addComponent(btnVerificar)
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(277, 277, 277)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblBusqueda)
                                    .addGap(91, 91, 91))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdAceptar)
                                        .addComponent(rdRechazar))
                                    .addGap(12, 12, 12))))))
                .addComponent(btnRegistrar)
                .addGap(71, 71, 71)
                .addComponent(lblReserva)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
     
    }//GEN-LAST:event_formComponentResized

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved

    }//GEN-LAST:event_formComponentMoved

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTdniR;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarR;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelInfoBusqueda;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaReserva;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblMontoFlete;
    private javax.swing.JLabel lblMontoPat;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblReserva;
    private javax.swing.JLabel lblTablaReserva;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JRadioButton rdAceptar;
    private javax.swing.JRadioButton rdRechazar;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}
