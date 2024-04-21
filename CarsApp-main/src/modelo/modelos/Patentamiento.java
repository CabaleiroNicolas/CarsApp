package modelo.modelos;

public class Patentamiento {
    
    private double costo;
    
    private final float porcentaje = 2;
    
    public float getPorcentaje() {
        return porcentaje;
    }

    public double getCosto() {
        return costo;
    }
    
    public void setCosto(double monto){
        this.costo = monto*0.02;
    }
}
