package modelo.serviciosAdicionales;

import javax.swing.JOptionPane;
import vista.vistaPrincipal;
import vista.vistaRegistroServiciosAdicionales;

public class Piscina extends ServiciosAdicionales {

    public Piscina(int costo) {
        super(costo);
    }

    public int seleccionarServicio(vistaRegistroServiciosAdicionales vista ) {
        int costoPisicina;
        if (vista.getCheckboxPiscina().isSelected()) {
            costoPisicina = 65000;
        } else {
            costoPisicina = 0;
        }
        return costoPisicina;
    }

}
