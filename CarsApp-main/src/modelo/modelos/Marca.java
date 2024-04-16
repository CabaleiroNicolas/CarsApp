/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.modelos;

import java.util.ArrayList;

/**
 *
 * @author nicoc
 */
public class Marca {
    
    private String nombre;
    private ArrayList<Modelo> modelos = new ArrayList<>();

    

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "Marca: " + nombre + "\nmodelos:" + modelos;
    }
 
}
