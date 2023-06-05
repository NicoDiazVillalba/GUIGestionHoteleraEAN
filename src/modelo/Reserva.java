
package modelo;


public class Reserva {
    
    public String nombre;
    public String apellido;
    public int cedula;
    public int acompañantes;
    public int noches;
    public String habitacion;
    public String comida;
    public int costoTotal;
    

    public Reserva(String entradaNombre, String entradaApellido, int entradaCedula, int entradaAcompañantes, int entradaNoches, String entradaHabitacion, String entradaComida) {
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

    public int getCedula() {
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
    
    
    public int definirCosto(int  entradaCostoAcompañantes, int entradaCostoHabitacion, int entradaCostoComida,int entradaCostoNoches,int entradaCostoAdicionales){
        this.costoTotal = entradaCostoAcompañantes+entradaCostoHabitacion+entradaCostoComida+entradaCostoNoches+entradaCostoAdicionales;
        return this.costoTotal;
    }

    public int getCostoTotal() {
        return costoTotal;
    }
    
    
    
    
}
