package modelo.modelos;

public class Cliente {
    private String DNI;
    private String nombreCompleto;
    private String direccion;
    private String mail;
    private String celular;
    private String telefono;
    
    public Cliente(String DNI, String nombreCompleto, String direccion,
            String mail, String celular, String telefono) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.mail = mail;
        this.celular = celular;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return nombreCompleto + " - " + celular + " - " + telefono;
    }
}
