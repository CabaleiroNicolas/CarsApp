
package modelo.modelos;

import java.util.ArrayList;

public class Modelo {
    
    private String nombre;
    private ArrayList<Version> versiones = new ArrayList<>();

    

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(ArrayList<Version> versiones) {
        this.versiones = versiones;
    }

    @Override
    public String toString() {
        return "\n" + nombre + "'\nversiones:" + versiones;
    }
    
    
    
}
