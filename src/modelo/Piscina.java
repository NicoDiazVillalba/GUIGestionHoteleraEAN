package modelo;

import javax.swing.JOptionPane;
import vista.vistaPrincipal;

public class Piscina extends ServiciosAdicionales {

    public Piscina(int costo) {
        super(costo);
    }

    public int seleccionarServicio(vistaPrincipal vista ) {
        int costoPisicina;
        if (vista.getCheckboxPiscina().isSelected()) {
            costoPisicina = 65000;
        } else {
            costoPisicina = 0;
        }
        return costoPisicina;
    }

}
