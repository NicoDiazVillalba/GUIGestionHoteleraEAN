
package modelo.reserva;

import java.util.ArrayList;


public class ListaClientes {
    
    private ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();
    
    public void agregarCliente(Cliente objetoCliente){
        this.listaClientes.add(objetoCliente);
    }
    
    public ArrayList<Cliente> mostrarLista(){
        
    return this.listaClientes;
    }
    
}
