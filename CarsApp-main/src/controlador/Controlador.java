package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.modelos.Cliente;
import modelo.persistencia.Persistencia;
import modelo.modelos.Color;
import modelo.modelos.Estados;
import modelo.modelos.EstadosReserva;
import modelo.modelos.Marca;
import modelo.modelos.Modelo;
import modelo.modelos.Patentamiento;
import modelo.modelos.Reserva;
import modelo.modelos.Version;
import vista.IPrincipal;
import vista.VistaPrincipal;

public class Controlador implements ActionListener {

    private IPrincipal vista = new VistaPrincipal();
    private Persistencia persistencia = new Persistencia();
    
    private int ID;
    private Date fechaReserva;
    private Cliente cliente;
    private EstadosReserva estado;
    private double montoTotal;

    public void ejecutar() {
        vista.setControlador(this);
        vista.cargarMarcas(defaultmarcas());
        vista.ejecutar();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        // Ejecución del evento al hacer click en un item del comboBox Marcas (Evento 1)
        if (event.getActionCommand().equals(vista.CARGAR_MODELOS)) {
            vista.cargarModelos(modelosByMarca(vista.getMarcaSeleccionada()));
        } // Ejecución del evento al hacer click en un item del comboBox Modelos (Evento 2)
        else if (event.getActionCommand().equals(vista.CARGAR_VERSIONES)) {
            vista.cargarVersiones(versionByModelo(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado()));
        } // Ejecución del evento al hacer click en un item del comboBox Versiones (Evento 3)
        else if (event.getActionCommand().equals(vista.CARGAR_COLORES)) {
            vista.cargarColores(coloresByVersion(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada()));
        } // Ejecución del evento al hacer click en un item del comboBox Colores (Evento 4)
        else if (event.getActionCommand().equals(vista.CARGAR_DISPONIBILIDAD)) {
            Color aux = persistencia.buscarColor(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada(), vista.getColorSeleccionado());
            boolean auxBool = persistencia.isDisponible(aux);
            vista.setDisponibilidad(auxBool);

            if (auxBool) {
                Patentamiento patentamiento = new Patentamiento();
                Version auxVer = persistencia.buscarVersion(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada());
                vista.setPrecio(auxVer.getPrecio());

                // La fecha de entrega fue asignada en la creación del objeto Fecha del objeto Version en Persistence()
                String fechaEntrega = auxVer.getFechaEntrega().getDia() + "/" + auxVer.getFechaEntrega().getMes() + "/" + auxVer.getFechaEntrega().getAnio();
                vista.setFechaEntrega(fechaEntrega);

                // Para la fecha de reserva obtengo la fecha actual y la formateo según el patrón indicado
                DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                fechaReserva = new Date();
                vista.setFechaReserva(formatoFecha.format(fechaReserva));

                patentamiento.setCosto(auxVer.getPrecio());
                
                double total = auxVer.getPrecio() + auxVer.getSegmento().getFlete().getCosto() + patentamiento.getCosto();
                vista.setMontoPat(Double.toString(patentamiento.getCosto()));
                vista.setMontoFlete(Double.toString(auxVer.getSegmento().getFlete().getCosto()));
                vista.setTotal(total);
                montoTotal = total;
            }
        } // Ejecución del evento al hacer click en el botón Buscar (Evento 5) y el boton Biscar de Reservas (Evento 8)
        else if (event.getActionCommand().equals(vista.BUSCAR_CLIENTE)) {
            List<Cliente> clientes = persistencia.getClientes();
            String DNIbuscado = vista.getDNI();
            String constraseñaBuscada = vista.getContraseña();
            
            boolean encontrado = false;

            for (Cliente cl : clientes) {
                if (cl.getDNI().equals(DNIbuscado) && cl.getContraseña().equals(constraseñaBuscada)) {  
                    vista.setInfoBusqueda(cl.toString());
                    cliente = cl;
                    encontrado = true;
                }
            }

            if (!encontrado) {
                vista.limpiarLabelCliente();
                vista.mostrarMensaje("Cliente no encontrado!");
                cliente = null;
            }else{
                llenarTablaReservas(DNIbuscado,cliente.getNombreCompleto());
            }
        } // Ejecución del evento al hacer click en el botón Registrar (Evento 6)
        else if (event.getActionCommand().equals(vista.REGISTRAR_RESERVA)) {
            Reserva reserva = new Reserva();
            boolean faltanDatos = false;

            String marcaSel = vista.getMarcaSeleccionada(),
                    modeloSel = vista.getModeloSeleccionado(),
                    versionSel = vista.getVersionSeleccionada(),
                    colorSel = vista.getColorSeleccionado();
            Color color;
            if(!marcaSel.equals("Seleccione una marca") && modeloSel != null
                    && versionSel != null && colorSel != null) {
                color = persistencia.buscarColor(marcaSel,
                    modeloSel, versionSel,
                    colorSel);
            } else {
                color = null;
            }
            if(cliente !=null){
                llenarTablaReservas(cliente.getDNI(),cliente.getNombreCompleto());
            }
            
            if(color == null || fechaReserva == null || cliente == null)
                faltanDatos = true;
            
            if (faltanDatos) {
                if (color == null || fechaReserva == null)
                    vista.mostrarMensaje("ERROR! Faltan datos de vehiculo o no esta disponible");
                else
                    vista.mostrarMensaje("ERROR! Cliente no seleccionado");
            } else {
                Marca marca = persistencia.buscarMarca(marcaSel);
                Modelo modelo = persistencia.buscarModelo(marca, modeloSel);
                Version version = persistencia.buscarVersion(marcaSel, modeloSel, versionSel);
                if (vista.getSeleccion()) {
                    color.setEstado(Estados.NO_DISPONIBLE);

                    estado = EstadosReserva.PENDIENTE;
                } else {
                    estado = EstadosReserva.NULO;
                }

                ID = persistencia.getReservas().size() + 1;
                
                reserva.setID(ID);
                reserva.setCliente(cliente);
                reserva.setEstado(estado);
                reserva.setFechaReserva(fechaReserva);
                reserva.setMontoTotal(montoTotal);
                reserva.setMarca(marca);
                reserva.setModelo(modelo);
                reserva.setVersion(version);
                reserva.setColor(color);
                
                if(estado == EstadosReserva.NULO){
                    vista.mostrarMensaje("Reserva almacenada con estado 'NULO'");
                }
                else{
                    vista.mostrarMensaje("La reserva de "+cliente.getNombreCompleto()+" fue exitosa!");
                }
                
                persistencia.getReservas().add(reserva);
                vista.mostrarMensaje(reserva.toString());
                llenarTablaReservas(cliente.getDNI(),cliente.getNombreCompleto());
                vista.limpiarInformacion();
                //vista.limpiarTabla();
                vista.resetearRadioBotones();
                cliente = null;
                fechaReserva = null;
            }
        } // Ejecución del evento al hacer click en el botón Verificar (Evento 7)
//        else if (event.getActionCommand().equals(vista.VERIFICAR_RESERVA)) {
//            List<Reserva> reservas = persistencia.getReservas();
//            int IDbuscado = vista.getID();
//            boolean encontrado = false;
//
//            for (Reserva res : reservas) {
//                if (res.getID() == IDbuscado && res.getEstado() == EstadosReserva.PENDIENTE) {
//                    res.setEstado(EstadosReserva.VERIFICADO);
//                    vista.mostrarMensaje("La reserva de "+res.getCliente().getNombreCompleto()+" se verificó con éxito!");
//                    vista.mostrarMensaje(res.toString());
//                    llenarTablaReservas(vista.getDNIR(),cliente.getNombreCompleto());
//                    encontrado = true;
//                } else if(res.getID() == IDbuscado && res.getEstado() == EstadosReserva.NULO){
//                    vista.mostrarMensaje("La reserva no fue aceptada (estado NULO)");
//                    encontrado = true;
//                }
//            }
//            
//            if (!encontrado) {
//                vista.mostrarMensaje("No se encontró la reserva");            
//            }
//        }
    }

    public List<String> defaultmarcas() {
        List<String> list = new ArrayList<>();
        List<String> aux = persistencia.getNombresMarcas();
        list.add("Seleccione una marca");
        list.addAll(aux);
        return list;
    }

    public List<String> modelosByMarca(String marca) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistencia.getNombresModelos(marca);
        list.add("Seleccione un modelo");
        list.addAll(aux);
        return list;
    }

    public List<String> versionByModelo(String marca, String modelo) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistencia.getNombresVersiones(marca, modelo);
        list.add("Seleccione una version");
        list.addAll(aux);
        return list;
    }

    public List<String> coloresByVersion(String marca, String modelo, String version) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistencia.getNombresColores(marca, modelo, version);
        list.add("Seleccione un color");
        list.addAll(aux);
        return list;
    }
    public void llenarTablaReservas(String dni,String nombre){
        vista.lblTablaReserva(nombre);
        vista.llenarTabla(persistencia.obtenerReservasCliente(dni));
    }

}
