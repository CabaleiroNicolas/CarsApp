package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.persistencia.PersistenceVehicle;
import vista.IPrincipal;
import vista.VistaPrincipal;

public class Controlador implements ActionListener{
    private IPrincipal vista = new VistaPrincipal();
    private PersistenceVehicle persistence = new PersistenceVehicle();;
    public void ejecutar(){
        vista.setControlador(this);
        vista.cargarMarcas(defaultmarcas());
        vista.ejecutar();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(vista.CARGAR_MODELOS)){
            vista.cargarModelos(modelosByMarca(vista.getMarcaSeleccionada()));
        }else if(event.getActionCommand().equals(vista.CARGAR_VERSIONES)){
            vista.cargarVersiones(versionByModelo(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado()));
        }else if(event.getActionCommand().equals(vista.CARGAR_COLORES)){
            vista.cargarColores(coloresByVersion(vista.getMarcaSeleccionada(), vista.getModeloSeleccionado(), vista.getVersionSeleccionada()));
        }
    }
    
    public List<String> defaultmarcas(){
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresMarcas();
        list.add("Seleccione una marca");
        list.addAll(aux);
        return list;
    }
    
    public List<String> modelosByMarca(String marca){
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresModelos(marca);
        list.add("Seleccione un modelo");
        list.addAll(aux);
        return list;
    }
    
    public List<String> versionByModelo(String marca, String modelo){
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresVersiones(marca, modelo);
        list.add("Seleccione una version");
        list.addAll(aux);
        return list;
    }
    
    public List<String> coloresByVersion(String marca, String modelo,String version){
        List<String> list = new ArrayList<>();
        List<String> aux = persistence.getNombresColores(marca, modelo, version);
        list.add("Seleccione un color");
        list.addAll(aux);
        return list;
    }
    
}
