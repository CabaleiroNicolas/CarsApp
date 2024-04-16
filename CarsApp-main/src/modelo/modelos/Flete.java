package modelo.modelos;

public class Flete {
    private String lugar;
    private double costo;

    public Flete(String lugar, double costo) {
        this.lugar = lugar;
        this.costo = costo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
