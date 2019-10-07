package logica;

import java.util.Date;

public class Turista {

    private int ci;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private int telefono;
    private String calle;
    private short numero;
    private String localidad;

    public Turista(int ci, String nombre, String apellido, Date fechaNac, int telefono, String calle, short numero, String localidad) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Turista() {
        this.ci = 11111111;
        this.nombre = "Undefined name";
        this.apellido = "Undefined surname";
        this.fechaNac = new Date(1900,11,25);
        this.telefono = 24000000;
        this.calle = "Undefined street";
        this.numero = 0000;
        this.localidad = "Undefined city";
    }
}