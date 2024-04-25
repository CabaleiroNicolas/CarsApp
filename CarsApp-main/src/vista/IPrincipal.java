package vista;

import java.util.List;
import modelo.modelos.Reserva;

public interface IPrincipal {
    public static String CARGAR_MARCAS = "Cargar las marcas";
    public static String CARGAR_MODELOS = "Cargar los modelos";
    public static String CARGAR_VERSIONES = "Cargar las versiones";
    public static String CARGAR_COLORES = "Cargar los colores";
    public static String CARGAR_DISPONIBILIDAD = "Cargar la disponibilidad del color";
    public static String BUSCAR_CLIENTE = "Buscar el cliente por DNI";
    public static String REGISTRAR_RESERVA = "Registrar la reserva del vehiculo";
    public static String VERIFICAR_RESERVA = "Verificar la reserva del vehiculo";
    public static String BUSCAR_RESERVA = "Buscar las reservas del cliente";
    public void ejecutar();
    public void cargarMarcas(List marcas);
    public void cargarModelos(List modelos);
    public void cargarVersiones(List versiones);
    public void cargarColores(List colores);
    public String getMarcaSeleccionada();
    public String getModeloSeleccionado();
    public String getVersionSeleccionada();
    public String getColorSeleccionado();
    public void setControlador(controlador.Controlador control);
    public void setDisponibilidad(boolean flag);
    public void setPrecio(Double precio);
    public void setFechaEntrega(String fecha);
    public void setFechaReserva(String fecha);
    public void setTotal(Double precio);
    public void setMontoPat(String mensaje);
    public void setMontoFlete(String mensaje);
    public String getDNI();
    public String getDNIR();
    public void setInfoBusqueda(String mensaje);
    public void limpiarInformacion();
    public boolean getSeleccion();
    public int getID();
    public void setInfoReserva(String mensaje);
    public void mostrarMensaje(String mensaje);
    public void limpiarLabelCliente();
    public void limpiarTabla();
    public void llenarTabla(List<Reserva> reservas);
    public void lblTablaReserva(String mensaje);
    public void resetearRadioBotones();

}
