package modelo.modelos;

public class Cliente {
    private String DNI;
    private String nombreCompleto;
    private String direccion;
    private String mail;
    private String celular;
    private String telefono;
    private String contraseña;
    
    public Cliente(String DNI, String nombreCompleto, String direccion, String mail, String celular, String telefono, String contraseña) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.mail = mail;
        this.celular = celular;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
