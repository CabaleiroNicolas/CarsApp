package modelo.modelos;

public class Patentamiento {
    
    private Double costo;

    public Patentamiento() {
    }
    
    private final float porcentaje = 2;
    
    public float getPorcentaje() {
        return porcentaje;
    }

    public Double getCosto() {
        return costo;
    }
    
    
    
    public void setCosto(Double monto){
        this.costo = monto*0.02;
    }
}
