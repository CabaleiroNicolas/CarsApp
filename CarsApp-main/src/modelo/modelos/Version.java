
package modelo.modelos;

import java.util.ArrayList;

public class Version {
    
    private String nombre;
    private Segmento segmento;
    private double precio;
    private Fecha fechaEntrega;
    private ArrayList<Color> colores;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Version(String nombre) {
        this.nombre = nombre;
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
    
    public void setColores(ArrayList<Color> colores) {
        this.colores = colores;
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
    
    
    
    @Override
    public String toString() {
        return "\n" + nombre + ", segmento=" + segmento + "\ncolores: " + colores;
    }

    
    
}
