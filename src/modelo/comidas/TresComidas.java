
package modelo.comidas;

import javax.swing.JOptionPane;


public class TresComidas extends Comidas{

    public TresComidas(String tipo) {
        super(tipo);
    }
   
    public int definirCosto(int ent_numero_niños, int ent_numero_adultos, int ent_numero_noches){
        int costo_total = ((50000*ent_numero_niños)+(50000*ent_numero_adultos))*ent_numero_noches;
        costo_final = costo_total;
        return costo_final;
    }
    
}
