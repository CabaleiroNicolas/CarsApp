
package modelo.modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Version {
    
    private String nombre;
    private Segmento segmento;
    private double precio;
    private Fecha fechaEntrega;
    private ArrayList<Color> colores = new ArrayList<>();
    
    
    public Version(String nombre, Segmento segmento, double precio) {
        this.nombre = nombre;
        this.segmento = segmento;
        this.precio = precio;
        this.fechaEntrega= fechaDinamica();
        rellenarColores();
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Segmento getSegmento() {
        return segmento;
    }
    
    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }
    
    public ArrayList<Color> getColores() {
        return colores;
    }
    
//    public void setColores(ArrayList<Color> colores) {
//        this.colores = colores;
//    }
    
    public void rellenarColores() {
        colores.add(new Color("Blanco"));
        colores.add(new Color("Negro"));
        colores.add(new Color("Azul"));
        colores.add(new Color("Rojo"));
        
        for(Color color : colores) color.setEstado(Estados.DISPONIBLE);
    }
    
    public Color getColorByIndex(int index) {
        return colores.get(index);
    }

    public Fecha getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Fecha fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    private Fecha fechaDinamica() {
        LocalDate fechaActual = LocalDate.now();
        // Sumar dias aleatorios aa la fecha actual para que no tengan todos la misma fecha de entrega
        LocalDate fechaFutura = fechaActual.plusDays(10 + (int)(Math.random() * ((15 - 10) + 1)));
        // Crear un objeto Fecha usando LocalDate p/devolver 
        return new Fecha(fechaFutura.getDayOfMonth(), fechaFutura.getMonthValue(), fechaFutura.getYear());
    }

    @Override
    public String toString() {
        return "\n" + nombre + ", segmento=" + segmento + "\ncolores: " + colores;
    }

    
    
}
