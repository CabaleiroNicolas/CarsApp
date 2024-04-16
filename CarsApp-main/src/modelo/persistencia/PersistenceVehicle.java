package modelo.persistencia;

import modelo.modelos.Estados;
import modelo.modelos.Segmento;
import modelo.modelos.Modelo;
import modelo.modelos.Version;
import modelo.modelos.Marca;
import modelo.modelos.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.Segment;

public class PersistenceVehicle {

    
    private List<Color> colores = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<Segmento> segmentos = new ArrayList<>();
    private List<Version> versiones = new ArrayList<>();
    
    //Marcas
    private Marca chevrolet = new Marca("Chevrolet");
    private Marca fiat = new Marca("Fiat");
    private Marca honda = new Marca("Honda");
    //Modelos
    private Modelo cronos = new Modelo("Cronos");
    private Modelo argo = new Modelo("Argo");
    private Modelo cruze = new Modelo("Cruze");
    private Modelo s10 = new Modelo("S10"); 
    private Modelo fit = new Modelo("Fit");
    private Modelo cr_v = new Modelo("CR-V");
    //Versiones
    private Version x44 = new Version("4x4");
    private Version lx = new Version("LX");
    private Version ex = new Version("EX");
    private Version exs = new Version("EXS");
    //Colores
    private Color blanco = new Color("Blanco");
    private Color negro = new Color("Negro");
    private Color azul = new Color("Azul");
    //Segmentos
    private Segmento segmentoA = new Segmento("Segmento A");
    private Segmento segmentoB = new Segmento("Segmento B");
    private Segmento segmentoC = new Segmento("Segmento C");

    
    public PersistenceVehicle() {
        
        blanco.setEstado(Estados.DISPONIBLE);
        negro.setEstado(Estados.DISPONIBLE);
        azul.setEstado(Estados.DISPONIBLE);
        ArrayList colores = new ArrayList();
        colores.add(blanco);
        colores.add(negro);
        colores.add(azul);
        lx.setColores(colores);
        lx.setSegmento(segmentoB);
        ex.setColores(colores);
        ex.setSegmento(segmentoB);
        exs.setColores(colores);
        exs.setSegmento(segmentoB);
        fit.getVersiones().add(lx);
        fit.getVersiones().add(ex);
        fit.getVersiones().add(exs);
        ex.setSegmento(segmentoC);
        exs.setSegmento(segmentoC);
        cr_v.getVersiones().add(ex);
        cr_v.getVersiones().add(exs);

        s10.getVersiones().add(x44);
        honda.getModelos().add(fit);
        honda.getModelos().add(cr_v);
       
        chevrolet.getModelos().add(s10);
        chevrolet.getModelos().add(cruze);
        
        fiat.getModelos().add(argo);
        fiat.getModelos().add(cronos);
       

        marcas.addAll(Arrays.asList(chevrolet, honda, fiat));
        
    }

    public List<String> getNombresMarcas(){
        return  marcas.stream().map(m -> m.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresModelos(String marca){
        Marca marc = buscarMarca(marca);
        return marc.getModelos().stream().map(mod -> mod.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresVersiones(String marca, String modelo){
        Modelo mod = buscarModelo(buscarMarca(marca), modelo);
        return mod.getVersiones().stream().map(m -> m.getNombre()).collect(Collectors.toList());
    }
    
    public List<String> getNombresColores(String marca, String modelo, String version){
        System.out.println(marca + modelo + version);
        Version ver = buscarVersion(marca, modelo, version);
        if(ver == null){
            System.out.println("NULO");
        }
        return ver.getColores().stream().map(c -> c.getNombre()).collect(Collectors.toList());
    }
    
    public Marca buscarMarca(String nombre){
        return marcas.stream().filter(m -> m.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);
    }
    public Modelo buscarModelo(Marca marca, String modelo){
        return marca.getModelos().stream().filter(m -> m.getNombre().equals(modelo))
                    .findFirst()
                    .orElse(null);
    }
    public Version buscarVersion(String marca, String modelo, String version){
        Modelo mod = buscarModelo(buscarMarca(marca), modelo);
        return mod.getVersiones().stream().filter(m -> m.getNombre().equals(version))
                    .findFirst()
                    .orElse(null);
    }

    public List<Color> getColores() {
        return colores;
    }


    public void setColores(List<Color> colores) {
        this.colores = colores;
    }


    public List<Marca> getMarcas() {
        return marcas;
    }


    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }


    public List<Modelo> getModelos() {
        return modelos;
    }


    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }


    public List<Segmento> getSegmentos() {
        return segmentos;
    }


    public void setSegmentos(List<Segmento> segmentos) {
        this.segmentos = segmentos;
    }


    public List<Version> getVersiones() {
        return versiones;
    }


    public void setVersiones(List<Version> versiones) {
        this.versiones = versiones;
    }

    
    
   
    
    
    
    
}
