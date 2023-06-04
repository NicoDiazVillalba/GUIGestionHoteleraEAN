
package controlador;

import vista.vistaPrincipal;


public class main {
    
    public static void main(String[] args) {
        //1. Instanciar el objeto de la vista
        
        vistaPrincipal objetovista = new vistaPrincipal();
        
        //2. Instanciar el objeto del controlador
        
        Controlador objetocontrolador = new Controlador(objetovista);
    }
}
