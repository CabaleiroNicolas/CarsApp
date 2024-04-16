package modelo.modelos;

public class Reserva {
    private double montoTotal;
    private Fecha fechaReserva;
    private Cliente cliente;
    private EstadosReserva estado;

    public Reserva(double montoTotal, Fecha fechaReserva, Cliente cliente, EstadosReserva estado) {
        this.montoTotal = montoTotal;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.estado = estado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Fecha getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Fecha fechaReserva) {
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
}
