package modelo;

import vista.vistaPrincipal;

public class Gimnasio extends ServiciosAdicionales {

    public Gimnasio(int costo) {
        super(costo);
    }
   
    public int seleccionarServicio(vistaPrincipal vista) {
        int costoGimansio;
        if (vista.getCheckboxGimnasio().isSelected()) {
            costoGimansio = 240000;
        } else {
            costoGimansio = 0;
        }
        return costoGimansio;
    }
    

}
