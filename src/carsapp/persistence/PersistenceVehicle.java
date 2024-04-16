
package carsapp.persistence;

import carsapp.models.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceVehicle{

    
    private List<Color> colores = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<Segmento> segmentos = new ArrayList<>();
    private List<Version> versiones = new ArrayList<>();
    
    public PersistenceVehicle() {
        
        blanco.setEstado(Estados.DISPONIBLE);
        
        s10.getVersiones().add(x44);
        
        chevrolet.getModelos().add(s10);
        chevrolet.getModelos().add(cruze);
        fiat.getModelos().add(argo);
        fiat.getModelos().add(cronos);
        
    }
    
    private Marca chevrolet = new Marca();
    private Marca fiat = new Marca();
    
    private Modelo cronos = new Modelo();
    private Modelo argo = new Modelo();
    private Modelo cruze = new Modelo();
    private Modelo s10 = new Modelo();
    
    private Version x44 = new Version();
    
    private Color blanco = new Color();
    
    
    
    
}
