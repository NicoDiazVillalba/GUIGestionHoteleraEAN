
package modelo.reserva;


public class Reserva {
    
    public int id;
    public String nombre;
    public String apellido;
    public long cedula;
    public int acompañantes;
    public int noches;
    public String habitacion;
    public String comida;
    public int costoTotal;
    

    public Reserva(String entradaNombre, String entradaApellido, long entradaCedula, int entradaAcompañantes, int entradaNoches, String entradaHabitacion, String entradaComida) {
        this.nombre = entradaNombre;
        this.apellido = entradaApellido;
        this.cedula = entradaCedula;
        this.acompañantes = entradaAcompañantes;
        this.noches = entradaNoches;
        this.habitacion = entradaHabitacion;
        this.comida = entradaComida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public int getAcompañantes() {
        return acompañantes;
    }

    public int getNoches() {
        return noches;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public String getComida() {
        return comida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    
    

    public int definirCosto(int  entradaCostoAcompañantes, int entradaCostoHabitacion, int entradaCostoComida,int entradaCostoNoches,int entradaCostoAdicionales){
        this.costoTotal = entradaCostoAcompañantes+entradaCostoHabitacion+entradaCostoComida+entradaCostoNoches+entradaCostoAdicionales;
        return this.costoTotal;
    }

    public int getCostoTotal() {
        return costoTotal;
    }
    
    
    
    
}
