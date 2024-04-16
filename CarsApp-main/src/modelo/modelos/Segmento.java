
package modelo.modelos;

public class Segmento {
    
    private String nombre;
    private Flete flete;
    private Patentamiento patentado;

    

    public Segmento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Flete getFlete() {
        return flete;
    }

    public void setFlete(Flete flete) {
        this.flete = flete;
    }

    public Patentamiento getPatentado() {
        return patentado;
    }

    public void setPatentado(Patentamiento patentado) {
        this.patentado = patentado;
    }

    @Override
    public String toString() {
        return "Segmento: " + nombre + ", flete=" + flete + ", patentado=" + patentado;
    }
    
    
    
    
}
