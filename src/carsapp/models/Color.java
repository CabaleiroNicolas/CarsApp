
package carsapp.models;

public class Color {
    
    private String nombre;
    private Estados estado;

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados status) {
        this.estado = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

