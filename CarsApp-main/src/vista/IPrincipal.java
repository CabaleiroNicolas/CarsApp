package vista;

import java.util.List;

public interface IPrincipal {
    public static String CARGAR_MARCAS = "Cargar las marcas";
    public static String CARGAR_MODELOS = "Cargar los modelos";
    public static String CARGAR_VERSIONES = "Cargar las versiones";
    public static String CARGAR_COLORES = "Cargar los colores";
    public static String CARGAR_DISPONIBILIDAD = "Cargar la disponibilidad del color";
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
    public void setTotal(Double precio);
    
}
