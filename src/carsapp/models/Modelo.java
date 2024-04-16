
package carsapp.models;

import java.util.ArrayList;

public class Modelo {
    
    private String nombre;
    private ArrayList<Version> versiones;

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
    
    
}
