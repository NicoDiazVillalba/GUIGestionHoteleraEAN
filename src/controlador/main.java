
package controlador;

import vista.vistaPrincipal;
import vista.vistaRegistroAcompañantes;
import vista.vistaRegistroComidas;
import vista.vistaRegistroEstadia;
import vista.vistaRegistroHabitacion;
import vista.vistaRegistroInicial;
import vista.vistaRegistroServiciosAdicionales;


public class main {
    
    public static void main(String[] args) {
        //1. Instanciar el objeto de la vista
        
        vistaPrincipal objetovista = new vistaPrincipal();
        vistaRegistroInicial objetovistaRegistroInicial = new vistaRegistroInicial();
        vistaRegistroAcompañantes objetovistaRegistroAcompañantes = new vistaRegistroAcompañantes();
        vistaRegistroEstadia objetovistaRgistroEstadia = new vistaRegistroEstadia();
        vistaRegistroHabitacion objetovistaRegistroHabitacion = new vistaRegistroHabitacion();
        vistaRegistroComidas objetoRegistroComidas = new vistaRegistroComidas();
        vistaRegistroServiciosAdicionales objetoServiciosAdicionales = new vistaRegistroServiciosAdicionales();
        
        //2. Instanciar el objeto del controlador
        
        Controlador objetocontrolador = new Controlador(objetovista,objetovistaRegistroInicial,objetovistaRegistroAcompañantes,objetovistaRgistroEstadia,objetovistaRegistroHabitacion,objetoRegistroComidas,objetoServiciosAdicionales);
    }
}
