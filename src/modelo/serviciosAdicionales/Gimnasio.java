package modelo.serviciosAdicionales;

import vista.vistaPrincipal;
import vista.vistaRegistroServiciosAdicionales;

public class Gimnasio extends ServiciosAdicionales {

    public Gimnasio(int costo) {
        super(costo);
    }
   
    public int seleccionarServicio(vistaRegistroServiciosAdicionales vista) {
        int costoGimansio;
        if (vista.getCheckboxGimnasio().isSelected()) {
            costoGimansio = 240000;
        } else {
            costoGimansio = 0;
        }
        return costoGimansio;
    }
    

}
