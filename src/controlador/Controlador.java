package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AlmuerzoYRefrigerio;
import modelo.Cliente;
import modelo.Desayuno;
import modelo.DesayunoYRefrigerio;
import modelo.Gimnasio;
import modelo.HabitacionDuplex;
import modelo.HabitacionJunior;
import modelo.HabitacionSencilla;
import modelo.ListaClientes;
import modelo.ListaReserva;
import modelo.Piscina;
import modelo.Reserva;
import modelo.Spa;
import modelo.TresComidas;
import vista.vistaPrincipal;

public class Controlador {

    private vistaPrincipal mivista;
    private ListaClientes miLista = new ListaClientes();
    private ListaReserva miListaReserva = new ListaReserva();

    public Controlador(vistaPrincipal objetoGUI) {
        this.mivista = objetoGUI;
        this.mivista.setVisible(true);
        accionarBotones();

    }

    //Metodo donde escucha el boton
    private void accionarBotones() {

        this.mivista.getBotonGuardarDatosPersonales().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatosPersonales(evt);
            }

        });

        this.mivista.getBotoningresarDatosAcompañantes().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraerdatosbotonacompañantes(evt);
            }

        });

        this.mivista.getBotonIngresarEstadia().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extrarDatosBotonEstadia(evt);
            }

        });

        this.mivista.getBotonElegirHabitacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraerDatosBotonHabitacion(evt);

            }

        });

        this.mivista.getBotonConsultarHabitacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                consultarHabitacion(evt);
            }
        });

        this.mivista.getBotonIngresarComida().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirComida(evt);

            }

        });

        this.mivista.getBotonConsultarComida().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarComida(evt);

            }

        });

        this.mivista.getBotonElegirServiciosAdicionales().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirServicioAdicional(evt);

            }

        });

        this.mivista.getBotonHacerReserva().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerReserva(evt);

            }

        });
    }

    //Medodo donde se realiza la accion luego de oprimir el boton
    private void guardarDatosPersonales(java.awt.event.ActionEvent evt) {
        //Crear y extraer la infromacion del formulario 
        String nombre = this.mivista.getEntradaNombre().getText();
        String apellido = this.mivista.getEntradaApellido().getText();
        int cedula = Integer.parseInt(this.mivista.getEntradaCedula().getText());
        String correo = this.mivista.getEntradaCorreo().getText();
        double celular = Double.parseDouble(this.mivista.getEntradaCelular().getText());
        String direccion = this.mivista.getEntradaDireccion().getText();

        JOptionPane.showMessageDialog(mivista, "Se guardaron los datos Correctamente!!");

        this.mivista.getEntradaNombre().setEditable(false);
        this.mivista.getEntradaApellido().setEditable(false);
        this.mivista.getEntradaCedula().setEditable(false);
        this.mivista.getEntradaCorreo().setEditable(false);
        this.mivista.getEntradaCelular().setEditable(false);
        this.mivista.getEntradaDireccion().setEditable(false);

    }

    private void limpiarTabla(DefaultTableModel objetoModelo) {
        for (int i = 0; i < objetoModelo.getRowCount(); i++) {
            objetoModelo.removeRow(i);
        }

    }

    private void extraerdatosbotonacompañantes(java.awt.event.ActionEvent evt) {

        int numeroNiños = Integer.parseInt(this.mivista.getEntradaNumNiños().getText());
        int numeroAdultos = Integer.parseInt(this.mivista.getEntradaNnumAdultos().getText());
        int numeroTotalAcompañantes = numeroNiños + numeroAdultos;

        if (numeroNiños == 1) {
            int valorTotalNiños = 35000;
            this.mivista.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else if (numeroNiños == 2) {
            int valorTotalNiños = 70000;
            this.mivista.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida de niños");
            this.mivista.getEntradaNumNiños().setText("");

        }

        if (numeroAdultos == 1) {
            int valorTotalAdultos = 40000;
            this.mivista.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));
        } else if (numeroAdultos == 2) {
            int valorTotalAdultos = 80000;
            this.mivista.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));
        } else if (numeroAdultos == 3) {
            int valorTotalAdultos = 120000;
            this.mivista.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));
        } else if (numeroAdultos == 4) {
            int valorTotalAdultos = 160000;
            this.mivista.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida de adultos");
            this.mivista.getEntradaNnumAdultos().setText("");

        }

        this.mivista.getLabelTotalAcompañantes().setText(Integer.toString(numeroTotalAcompañantes));

        int valorTotalAcompañantes = (Integer.parseInt(this.mivista.getLabelvalorNiños().getText())) + Integer.parseInt(this.mivista.getLabelvalorAdultos().getText());
        this.mivista.getLabelvalorTotalAcompañantes().setText(Integer.toString(valorTotalAcompañantes));
    }

    private void extrarDatosBotonEstadia(java.awt.event.ActionEvent evt) {

        int ent_fechallegada = Integer.parseInt(this.mivista.getEntradaFechaLlegada().getText());
        int ent_fechasalida = Integer.parseInt(this.mivista.getEntradaFechaSalida().getText());

        int noches = ent_fechasalida - ent_fechallegada;
        if (noches <= 0) {
            JOptionPane.showMessageDialog(mivista, "Ingrese una fecha valida:");
        } else {
            this.mivista.getLabelNumeroNoches().setText(Integer.toString(noches));

            int valorTotalAcompañantes = noches * 60000;
            this.mivista.getLabelCostoTotalNoches().setText(Integer.toString(valorTotalAcompañantes));
            JOptionPane.showMessageDialog(mivista, "Noches registradas correctamente!");
        }

    }

    private void extraerDatosBotonHabitacion(java.awt.event.ActionEvent evt) {

        int camas = Integer.parseInt(this.mivista.getLabelHabitacionCamas().getText());
        int capacidad = Integer.parseInt(this.mivista.getLabelHabitacionCapacidad().getText());
        int televisores = Integer.parseInt(this.mivista.getLabelHabitacionTelevisores().getText());
        int balcon = Integer.parseInt(this.mivista.getLabelHabitacionBalcon().getText());
        int costo = Integer.parseInt(this.mivista.getLabelCostoHabitacion().getText());

        if (camas == 0 || capacidad == 0) {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
        } else {
            JOptionPane.showMessageDialog(mivista, "Se registró la habitación correctamente!!");
        }

    }

    private void consultarHabitacion(java.awt.event.ActionEvent evt) {

        HabitacionDuplex habitacionD = new HabitacionDuplex("Duplex", 4, 8, 4, 1200000, true);
        HabitacionJunior habitacionJ = new HabitacionJunior("Junior", 2, 4, 2, 800000, false);
        HabitacionSencilla habitacionS = new HabitacionSencilla("Sencilla", 1, 1, 0, 500000, false);
        String seleccion = this.mivista.getComboboxHabitacion().getSelectedItem().toString();

        if (seleccion == "Duplex") {
            this.mivista.getLabelHabitacionCamas().setText(Integer.toString(habitacionD.getCamas()));
            this.mivista.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionD.getCapacidad()));
            this.mivista.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionD.getTelevisores()));
            this.mivista.getLabelHabitacionBalcon().setText(Integer.toString(1));
            this.mivista.getLabelCostoHabitacion().setText(Integer.toString(habitacionD.getCosto()));

        } else if (seleccion == "Junior") {
            this.mivista.getLabelHabitacionCamas().setText(Integer.toString(habitacionJ.getCamas()));
            this.mivista.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionJ.getCapacidad()));
            this.mivista.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionJ.getTelevisores()));
            this.mivista.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.mivista.getLabelCostoHabitacion().setText(Integer.toString(habitacionJ.getCosto()));

        } else if (seleccion == "Sencilla") {
            this.mivista.getLabelHabitacionCamas().setText(Integer.toString(habitacionS.getCamas()));
            this.mivista.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionS.getCapacidad()));
            this.mivista.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionS.getTelevisores()));
            this.mivista.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.mivista.getLabelCostoHabitacion().setText(Integer.toString(habitacionS.getCosto()));

        } else {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
            this.mivista.getLabelHabitacionCamas().setText(Integer.toString(0));
            this.mivista.getLabelHabitacionCapacidad().setText(Integer.toString(0));
            this.mivista.getLabelHabitacionTelevisores().setText(Integer.toString(0));
            this.mivista.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.mivista.getLabelCostoHabitacion().setText(Integer.toString(0));
        }
    }

    private void elegirComida(java.awt.event.ActionEvent evt) {
        int numeroNochesComida = Integer.parseInt(this.mivista.getLabelNochesComida().getText());
        int numeroAcompañantesComida = Integer.parseInt(this.mivista.getLabelAcompañantesComida().getText());
        int costoTotal = Integer.parseInt(this.mivista.getLabelCostoComida().getText());

        if (numeroNochesComida == 0 || numeroAcompañantesComida == 0 || costoTotal == 0) {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
        } else {
            JOptionPane.showMessageDialog(mivista, "Comida seleccionada correctamente!");
        }

    }

    private void consultarComida(java.awt.event.ActionEvent evt) {
        //Objetos
        Desayuno comida1 = new Desayuno("Desayuno");
        DesayunoYRefrigerio comida2 = new DesayunoYRefrigerio("Desayuno y Refrigerio");
        AlmuerzoYRefrigerio comida3 = new AlmuerzoYRefrigerio("Almuerzo y Refrigerio");
        TresComidas comida4 = new TresComidas("Desayuno Almuerzo y Cena");
        //COmbo box y variables
        String seleccion = this.mivista.getComboBoxComida().getSelectedItem().toString();
        int costoTotalComida = 0;

        int numeroNoches = Integer.parseInt(this.mivista.getLabelNumeroNoches().getText());
        int numeroAdultos = Integer.parseInt(this.mivista.getEntradaNnumAdultos().getText());
        int numeroNiños = Integer.parseInt(this.mivista.getEntradaNumNiños().getText());

        this.mivista.getLabelNochesComida().setText(Integer.toString(numeroNoches));
        this.mivista.getLabelAcompañantesComida().setText((this.mivista.getLabelTotalAcompañantes().getText()));
        if (seleccion == "Desayuno - $15.000") {
            costoTotalComida = comida1.definirCosto(numeroNiños, numeroAdultos, numeroNoches);

        } else if (seleccion == "Desayuno y Refrigerio - $20.000") {
            costoTotalComida = comida2.definirCosto(numeroNiños, numeroAdultos, numeroNoches);

        } else if (seleccion == "Almuerzo y Refrigerio - $35.000") {
            costoTotalComida = comida3.definirCosto(numeroNiños, numeroAdultos, numeroNoches);

        } else if (seleccion == "Desayuno, Almuerzo y Cena - $50.000") {
            costoTotalComida = comida4.definirCosto(numeroNiños, numeroAdultos, numeroNoches);

        } else {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
            this.mivista.getLabelAcompañantesComida().setText(Integer.toString(0));
            this.mivista.getLabelNochesComida().setText(Integer.toString(0));
            this.mivista.getLabelCostoComida().setText(Integer.toString(0));
        }

        this.mivista.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
    }

    private void elegirServicioAdicional(java.awt.event.ActionEvent evt) {

        int costoGimansio = 0, costoSpa = 0, costoPiscina = 0;

        Gimnasio gimnasio = new Gimnasio(240000);
        Spa spa = new Spa(310000);
        Piscina piscina = new Piscina(65000);

        if ((this.mivista.getCheckboxNinguno().isSelected() && this.mivista.getCheckboxGimnasio().isSelected())
                || (this.mivista.getCheckboxNinguno().isSelected() && this.mivista.getCheckboxSpa().isSelected())
                || (this.mivista.getCheckboxNinguno().isSelected() && this.mivista.getCheckboxPiscina().isSelected())) {
            this.mivista.getCheckboxGimnasio().setSelected(false);
            this.mivista.getCheckboxSpa().setSelected(false);
            this.mivista.getCheckboxPiscina().setSelected(false);
            this.mivista.getCheckboxNinguno().setSelected(false);

            JOptionPane.showMessageDialog(mivista, "Error, selecciona una opcion correcta");

        } else {
            costoGimansio = gimnasio.seleccionarServicio(this.mivista);
            costoSpa = spa.seleccionarServicio(this.mivista);
            costoPiscina = piscina.seleccionarServicio(this.mivista);
            JOptionPane.showMessageDialog(mivista, "Seleccionado con exito");
        }

        int totalServiciosAdicionales = costoGimansio + costoSpa + costoPiscina;
        this.mivista.getLabelCostoTotalAdicionales().setText(Integer.toString(totalServiciosAdicionales));

    }

    /*private int gimansioSeleccionado(vistaPrincipal vista, Gimnasio objetoGimansio) {
        int costoGimansio;
        if (vista.getCheckboxGimnasio().isSelected()) {
            costoGimansio = objetoGimansio.getCosto();
        } else {
            costoGimansio = 0;
        }
        return costoGimansio;
    }

    private int spaSeleccionado(vistaPrincipal vista, Spa objetoSpa) {
        int costoSpa;
        if (vista.getCheckboxSpa().isSelected()) {
            costoSpa = objetoSpa.getCosto();
        } else {
            costoSpa = 0;
        }
        return costoSpa;
    }

    private int piscinaSeleccionado(vistaPrincipal vista, Piscina objetoPiscina) {
        int costoPisicina;
        if (vista.getCheckboxPiscina().isSelected()) {
            costoPisicina = objetoPiscina.getCosto();
        } else {
            costoPisicina = 0;
        }
        return costoPisicina;
    }*/
    private void hacerReserva(java.awt.event.ActionEvent evt) {

        String nombre = this.mivista.getEntradaNombre().getText();
        String apellido = this.mivista.getEntradaApellido().getText();
        int cedula = Integer.parseInt(this.mivista.getEntradaCedula().getText());
        int acompañantes = Integer.parseInt(this.mivista.getLabelTotalAcompañantes().getText());
        int noches = Integer.parseInt(this.mivista.getLabelNumeroNoches().getText());
        String habitacion = this.mivista.getComboboxHabitacion().getSelectedItem().toString();
        String comida = this.mivista.getComboBoxComida().getSelectedItem().toString();

        int costoAcompañantes = Integer.parseInt(this.mivista.getLabelvalorTotalAcompañantes().getText());
        int costoHabitacion = Integer.parseInt(this.mivista.getLabelCostoHabitacion().getText());
        int costoComida = Integer.parseInt(this.mivista.getLabelCostoComida().getText());
        int costoNoches = Integer.parseInt(this.mivista.getLabelCostoTotalNoches().getText());
        int costoAdicionales = Integer.parseInt(this.mivista.getLabelCostoTotalAdicionales().getText());

        Reserva objetoReserva = new Reserva(nombre, apellido, cedula, acompañantes, noches, habitacion, comida);
        objetoReserva.definirCosto(costoAcompañantes, costoHabitacion, costoComida, costoNoches, costoAdicionales);

        this.miListaReserva.agregarReserva(objetoReserva);
        DefaultTableModel mapeo2 = (DefaultTableModel) this.mivista.getTablaReserva().getModel();

        limpiarTabla(mapeo2);

        for (Reserva elemento : this.miListaReserva.getLista()) {
            mapeo2.addRow(new Object[]{elemento.getNombre(), elemento.getApellido(), elemento.getCedula(), elemento.getAcompañantes(), elemento.getNoches(), elemento.getHabitacion(), elemento.getComida(), elemento.getCostoTotal()});
            System.out.println(elemento.getNombre());
        }
        limpiarFormulario();
        JOptionPane.showMessageDialog(mivista, "Datos registrados Correctamente!");

        this.mivista.getEntradaNombre().setEditable(true);
        this.mivista.getEntradaApellido().setEditable(true);
        this.mivista.getEntradaCedula().setEditable(true);
        this.mivista.getEntradaCorreo().setEditable(true);
        this.mivista.getEntradaCelular().setEditable(true);
        this.mivista.getEntradaDireccion().setEditable(true);
    }

    private void limpiarFormulario() {
        this.mivista.getEntradaNombre().setText("");
        this.mivista.getEntradaApellido().setText("");
        this.mivista.getEntradaCedula().setText("");
        this.mivista.getEntradaCorreo().setText("");
        this.mivista.getEntradaCelular().setText("");
        this.mivista.getEntradaDireccion().setText("");
        this.mivista.getEntradaNumNiños().setText("");
        this.mivista.getEntradaNnumAdultos().setText("");
        this.mivista.getLabelvalorNiños().setText("");
        this.mivista.getLabelvalorAdultos().setText("");
        this.mivista.getLabelvalorTotalAcompañantes().setText("");
        this.mivista.getLabelTotalAcompañantes().setText("");
        this.mivista.getLabelCostoTotalAdicionales().setText("");
        this.mivista.getEntradaFechaLlegada().setText("");
        this.mivista.getEntradaFechaSalida().setText("");
        this.mivista.getLabelNumeroNoches().setText("");
        this.mivista.getLabelCostoTotalNoches().setText("");
        this.mivista.getComboBoxComida().setSelectedItem(("Selecciona"));
        this.mivista.getLabelAcompañantesComida().setText("");
        this.mivista.getLabelNochesComida().setText("");
        this.mivista.getLabelCostoComida().setText("");
        this.mivista.getLabelHabitacionCamas().setText(Integer.toString(0));
        this.mivista.getLabelHabitacionCapacidad().setText(Integer.toString(0));
        this.mivista.getLabelHabitacionTelevisores().setText(Integer.toString(0));
        this.mivista.getLabelHabitacionBalcon().setText(Integer.toString(0));
        this.mivista.getLabelCostoHabitacion().setText(Integer.toString(0));
        this.mivista.getComboboxHabitacion().setSelectedItem("Selecciona");
        this.mivista.getCheckboxGimnasio().setSelected(false);
        this.mivista.getCheckboxSpa().setSelected(false);
        this.mivista.getCheckboxPiscina().setSelected(false);
        this.mivista.getCheckboxNinguno().setSelected(false);
        this.mivista.getLabelCostoTotalAdicionales().setText("");

    }
}
