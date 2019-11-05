package logica;

import java.sql.Date;

public class Reserva {

    int codigoReserva; //PK
    Date fechaInicio;
    Date fechaFin;
    boolean confirmada;
    boolean cancelada;
    int ci; //FK
    short idCabanna; //FK

    public Reserva() {
    }

    public Reserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Reserva(Date fechaInicio, Date fechaFin, boolean confirmada, boolean cancelada, int ci, short idCabanna) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.confirmada = confirmada;
        this.cancelada = cancelada;
        this.ci = ci;
        this.idCabanna = idCabanna;
    }

    
    
    public Reserva(int codigoReserva, Date fechaInicio, Date fechaFin, boolean confirmada, boolean cancelada, int ci, short idCabanna) {
        this.codigoReserva = codigoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.confirmada = confirmada;
        this.cancelada = cancelada;
        this.ci = ci;
        this.idCabanna = idCabanna;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public boolean getConfirmada() {
        return confirmada;
    }

    public boolean getCancelada() {
        return cancelada;
    }

    public int getCi() {
        return ci;
    }

    public short getIdCabanna() {
        return idCabanna;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public void setIdCabanna(short idCabanna) {
        this.idCabanna = idCabanna;
    }

}
