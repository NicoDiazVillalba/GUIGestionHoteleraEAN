    
package modelo.reserva;

import java.util.ArrayList;


public class ListaReserva {
    
    private ArrayList <Reserva> ListaReserva = new ArrayList<Reserva>();
    
    public void agregarReserva(Reserva objetoReserva){
        this.ListaReserva.add(objetoReserva);
    }
    
    public ArrayList<Reserva>getLista(){
        return this.ListaReserva;
    }
}
