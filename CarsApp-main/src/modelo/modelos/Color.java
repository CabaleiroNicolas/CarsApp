
package modelo.modelos;

public class Color {
    
    private String nombre;
    private Estados estado;

    

    public Color(String nombre) {
        this.nombre = nombre;
    }

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

    @Override
    public String toString() {
        return "\nColor: " + nombre ;
    }

    
    
}

