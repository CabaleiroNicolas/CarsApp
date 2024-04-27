package modelo.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private int ID;
    private double montoTotal;
    private Date fechaReserva;
    private Cliente cliente;
    private EstadosReserva estado;
    private Modelo modelo;
    private Marca marca;
    private Version version;
    private Color color;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadosReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadosReserva estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "\nID de reserva: " + ID + "\n"
                + "Cliente: " + cliente.toString() + "\n"
                + "Fecha reserva: " + new SimpleDateFormat("dd/MM/yyyy").format(fechaReserva) + "\n"
                + "Monto total: USD$ " + montoTotal + "\n"
                + "Estado reserva: " + estado.toString()+ "\n"
                + "Marca: " + marca.getNombre()+"\n"
                + "Modelo: "+modelo.getNombre()+"\n"
                + "Version:"+version.getNombre()+"\n"
                + "Color:"+ color.getNombre();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
