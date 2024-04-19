
package modelo.modelos;

import java.util.ArrayList;

public class Version {
    
    private String nombre;
    private Segmento segmento;
    private Double precio;
    private ArrayList<Color> colores;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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
    @Override
    public String toString() {
        return "\n" + nombre + ", segmento=" + segmento + "\ncolores: " + colores;
    }

    
    
}
