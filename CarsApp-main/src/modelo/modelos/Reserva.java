package modelo.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private int ID;
    private double montoTotal;
    private Date fechaReserva;
    private Cliente cliente;
    private EstadosReserva estado;

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
                + "Estado reserva: " + estado.toString();
    }
}
