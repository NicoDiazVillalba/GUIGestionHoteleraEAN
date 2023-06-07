
package modelo.habitacion;

import javax.swing.JOptionPane;


public abstract class Habitacion  {
    
    private String tipo;
    private int camas;
    private int capacidad;
    private int costo;
    

    public Habitacion(String ent_tipo,int ent_camas, int ent_capacidad, int ent_costo ) {
        this.tipo = ent_tipo;
        this.camas = ent_camas;
        this.capacidad = ent_capacidad;
        this.costo = ent_costo;
        
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

 
}

    

    
      
    

