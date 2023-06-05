package modelo;

import javax.swing.JOptionPane;
import vista.vistaPrincipal;

public class Spa extends ServiciosAdicionales {

    public Spa(int costo) {
        super(costo);
    }

    public int seleccionarServicio(vistaPrincipal vista) {
        int costoSpa;
        if (vista.getCheckboxSpa().isSelected()) {
            costoSpa = 310000;
        } else {
            costoSpa = 0;
        }
        return costoSpa;
    }

}
