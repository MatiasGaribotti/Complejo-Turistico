package logica;

public class Cabanna {

    short id;
    byte cantHabitaciones;
    byte cantCamas;
    byte cantBannos;
    byte cantHuespedes;
    String descripcion;
    boolean aireAcondicionado;
    boolean parrillero;
    short costHour;

    public void setId(short id) {
        this.id = id;
    }

    public void setCantHabitaciones(byte cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public void setCantCamas(byte cantCamas) {
        this.cantCamas = cantCamas;
    }

    public void setCantBannos(byte cantBannos) {
        this.cantBannos = cantBannos;
    }

    public void setCantHuespedes(byte cantHuespedes) {
        this.cantHuespedes = cantHuespedes;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public void setParrillero(boolean parrillero) {
        this.parrillero = parrillero;
    }

    public void setCostHour(short costHour) {
        this.costHour = costHour;
    }

    public short getId() {
        return id;
    }

    public byte getCantHabitaciones() {
        return cantHabitaciones;
    }

    public byte getCantCamas() {
        return cantCamas;
    }

    public byte getCantBannos() {
        return cantBannos;
    }

    public byte getCantHuespedes() {
        return cantHuespedes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public boolean getParrillero() {
        return parrillero;
    }

    public short getCostHour() {
        return costHour;
    }

    public Cabanna(short id, byte cantHabitaciones, byte cantCamas, byte cantBannos, byte cantHuespedes, String descripcion, boolean aireAcondicionado, boolean parrillero, short costHour) {
        this.id = -1;
        this.cantHabitaciones = -1;
        this.cantCamas = -1;
        this.cantBannos = -1;
        this.cantHuespedes = -1;
        this.descripcion = "None";
        this.aireAcondicionado = false;
        this.parrillero = false;
        this.costHour = -1;
    }

    
    
    public Cabanna(byte cantHabitaciones, byte cantCamas, byte cantBannos, byte cantHuespedes, String descripcion, boolean aireAcondicionado, boolean parrillero, short costHour) {
        this.id = -1;
        this.cantHabitaciones = cantHabitaciones;
        this.cantCamas = cantCamas;
        this.cantBannos = cantBannos;
        this.cantHuespedes = cantHuespedes;
        this.descripcion = descripcion;
        this.aireAcondicionado = aireAcondicionado;
        this.parrillero = parrillero;
        this.costHour = costHour;
    }

}