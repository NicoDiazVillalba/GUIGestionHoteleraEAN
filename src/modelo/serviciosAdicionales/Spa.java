package modelo.serviciosAdicionales;

import javax.swing.JOptionPane;
import vista.vistaPrincipal;
import vista.vistaRegistroServiciosAdicionales;

public class Spa extends ServiciosAdicionales {

    public Spa(int costo) {
        super(costo);
    }

    public int seleccionarServicio(vistaRegistroServiciosAdicionales vista) {
        int costoSpa;
        if (vista.getCheckboxSpa().isSelected()) {
            costoSpa = 310000;
        } else {
            costoSpa = 0;
        }
        return costoSpa;
    }

}
