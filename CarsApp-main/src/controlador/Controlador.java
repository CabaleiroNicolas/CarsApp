package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.modelos.Cliente;
import modelo.persistencia.Persistence;
import modelo.modelos.Color;
import modelo.modelos.Estados;
import modelo.modelos.EstadosReserva;
import modelo.modelos.Reserva;
import modelo.modelos.Version;
import vista.IPrincipal;
import vista.VistaPrincipal;

public class Controlador implements ActionListener {

    private IPrincipal vista = new VistaPrincipal();
    private Persistence persistence = new Persistence();
    private Reserva reserva = new Reserva();

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
            Color aux = persistence.buscarColor(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada(), vista.getColorSeleccionado());
            boolean auxBool = persistence.isDisponible(aux);
            vista.setDisponibilidad(auxBool);

            if (auxBool) {
                Version auxVer = persistence.buscarVersion(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada());
                vista.setPrecio(auxVer.getPrecio());

                // La fecha de entrega fue asignada en la creación del objeto Fecha del objeto Version en Persistence()
                String fechaEntrega = auxVer.getFechaEntrega().getDia() + "/" + auxVer.getFechaEntrega().getMes() + "/" + auxVer.getFechaEntrega().getAnio();
                vista.setFechaEntrega(fechaEntrega);

                // Para la fecha de reserva obtengo la fecha actual y la formateo según el patrón indicado
                DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaReserva = new Date();
                vista.setFechaReserva(formatoFecha.format(fechaReserva));
                reserva.setFechaReserva(fechaReserva);

                double total = auxVer.getPrecio() + auxVer.getSegmento().getFlete().getCosto() + auxVer.getSegmento().getPatentado().getCosto();
                vista.setTotal(total);
                reserva.setMontoTotal(total);

//                if(auxVer.getSegmento()!= null){
//                    System.out.println(auxVer.getSegmento().getNombre());
//                }
            }
        } // Ejecución del evento al hacer click en el botón Buscar (Evento 5)
        else if (event.getActionCommand().equals(vista.BUSCAR_CLIENTE)) {
            List<Cliente> clientes = persistence.getClientes();
            String DNIbuscado = vista.getDNI();
            boolean encontrado = false;

            for (Cliente cliente : clientes) {
                if (cliente.getDNI().equals(DNIbuscado)) {
                    vista.setInfoBusqueda(cliente.toString());
                    reserva.setCliente(cliente);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                vista.setInfoBusqueda("No se encontró el cliente");
            }
        } // Ejecución del evento al hacer click en el botón Registrar (Evento 6)
        else if (event.getActionCommand().equals(vista.REGISTRAR_RESERVA)) {

            String marcaSel = vista.getMarcaSeleccionada(),
                    modeloSel = vista.getModeloSeleccionado(),
                    versionSel = vista.getVersionSeleccionada(),
                    colorSel = vista.getColorSeleccionado();
            Color color;
            
            if(!marcaSel.equals("Seleccione una marca") && modeloSel != null
                    && versionSel != null && colorSel != null) {
                color = persistence.buscarColor(marcaSel,
                    modeloSel, versionSel,
                    colorSel);
            } else {
                color = null;
            }

            if (color == null || reserva.getCliente() == null
                    || reserva.getFechaReserva() == null) {
                System.out.println("ERROR! Hay algun dato incompleto en la reserva");
            } else {
                if (vista.getSeleccion()) {
                    color.setEstado(Estados.NO_DISPONIBLE);

                    reserva.setEstado(EstadosReserva.PENDIENTE);
                } else {
                    reserva.setEstado(EstadosReserva.NULO);
                }

                reserva.setID(persistence.getReservas().size() + 1);
                persistence.getReservas().add(reserva);
                vista.limpiarInformacion();
                System.out.println(reserva);
            }
        } // Ejecución del evento al hacer click en el botón Verificar (Evento 7)
        else if (event.getActionCommand().equals(vista.VERIFICAR_RESERVA)) {
            List<Reserva> reservas = persistence.getReservas();
            int IDbuscado = vista.getID();
            boolean verificado = false;

            for (Reserva res : reservas) {
                if (res.getID() == IDbuscado) {
                    res.setEstado(EstadosReserva.VERIFICADO);
                    vista.setInfoReserva("La reserva se verificó con éxito!");
                    System.out.println(res);
                    verificado = true;
                }
            }

            if (!verificado) {
                vista.setInfoReserva("No se encontró la reserva");
            }
        }
    }

    public List<String> defaultmarcas() {
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresMarcas();
        list.add("Seleccione una marca");
        list.addAll(aux);
        return list;
    }

    public List<String> modelosByMarca(String marca) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresModelos(marca);
        list.add("Seleccione un modelo");
        list.addAll(aux);
        return list;
    }

    public List<String> versionByModelo(String marca, String modelo) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresVersiones(marca, modelo);
        list.add("Seleccione una version");
        list.addAll(aux);
        return list;
    }

    public List<String> coloresByVersion(String marca, String modelo, String version) {
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresColores(marca, modelo, version);
        list.add("Seleccione un color");
        list.addAll(aux);
        return list;
    }

}
