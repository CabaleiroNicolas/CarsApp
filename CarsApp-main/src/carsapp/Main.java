package carsapp;

import java.util.List;

import modelo.modelos.Marca;
import modelo.persistencia.PersistenceVehicle;
import controlador.Controlador;

public class Main {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.ejecutar();
    }
    
}
