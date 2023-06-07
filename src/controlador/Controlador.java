package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.comidas.AlmuerzoYRefrigerio;
import modelo.comidas.Desayuno;
import modelo.comidas.DesayunoYRefrigerio;
import modelo.serviciosAdicionales.Gimnasio;
import modelo.habitacion.HabitacionDuplex;
import modelo.habitacion.HabitacionJunior;
import modelo.habitacion.HabitacionSencilla;
import modelo.reserva.ListaClientes;
import modelo.reserva.ListaReserva;
import modelo.serviciosAdicionales.Piscina;
import modelo.reserva.Reserva;
import modelo.serviciosAdicionales.Spa;
import modelo.comidas.TresComidas;
import vista.vistaPrincipal;
import vista.vistaRegistroAcompañantes;
import vista.vistaRegistroComidas;
import vista.vistaRegistroEstadia;
import vista.vistaRegistroHabitacion;
import vista.vistaRegistroInicial;
import vista.vistaRegistroServiciosAdicionales;

public class Controlador {

    private vistaPrincipal mivista;
    private vistaRegistroInicial vistaRegistroInicial;
    private vistaRegistroAcompañantes vistaRegistroAcompañantes;
    private vistaRegistroEstadia vistaRegistroEstadia;
    private vistaRegistroHabitacion vistaRegistroHabitacion;
    private vistaRegistroComidas vistaRegistroComidas;
    private vistaRegistroServiciosAdicionales vistaRegistroServiciosAdicionales;
    private ListaClientes miLista = new ListaClientes();
    private ListaReserva miListaReserva = new ListaReserva();

    public Controlador(vistaPrincipal objetoGUI, vistaRegistroInicial objetoGUIRegistroInicial, vistaRegistroAcompañantes objetoGuiAcompañantes, vistaRegistroEstadia objetoGUIRegistroEstadia, vistaRegistroHabitacion objetoGUIRegistroHabitacion,vistaRegistroComidas objetoGUIRegistroComidas,vistaRegistroServiciosAdicionales objetoGUIRegistroServiciosAdicionales) {
        this.mivista = objetoGUI;
        this.vistaRegistroInicial = objetoGUIRegistroInicial;
        this.vistaRegistroAcompañantes = objetoGuiAcompañantes;
        this.vistaRegistroEstadia = objetoGUIRegistroEstadia;
        this.vistaRegistroHabitacion = objetoGUIRegistroHabitacion;
        this.vistaRegistroComidas = objetoGUIRegistroComidas;
        this.vistaRegistroServiciosAdicionales = objetoGUIRegistroServiciosAdicionales;
        this.mivista.setVisible(true);
        accionarBotones();

    }

    //Metodo donde escucha el boton
    private void accionarBotones() {

        this.mivista.getBotonVistaDatosPersonales().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerVisibleVistaRegistroInicial(evt);
            }

        });

        this.vistaRegistroInicial.getBotonGuardarDatosPersonales().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatosPersonales(evt);
            }

        });

        this.mivista.getBotonVistaRegistroAcompañantes().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerVisibleVistaRegistroAcompañantes(evt);
            }

        });

        this.vistaRegistroAcompañantes.getBotoningresarDatosAcompañantes().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraerdatosbotonacompañantes(evt);
            }

        });

        this.mivista.getBotonVistaRegistroEstadia().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerVisibleVistaRegistroEstadia(evt);
            }

        });
        
        this.mivista.getBotonVistaRegistroHabitacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerVisibleRegistroHabitacion(evt);
            }

        });

        this.vistaRegistroEstadia.getBotonIngresarEstadia().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extrarDatosBotonEstadia(evt);
            }

        });

        this.vistaRegistroHabitacion.getBotonElegirHabitacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraerDatosBotonHabitacion(evt);

            }

        });

        this.vistaRegistroHabitacion.getBotonConsultarHabitacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                consultarHabitacion(evt);
            }
        });

        this.mivista.getBotonVistaRegistroComidas().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                hacerVisibleRegistroComidas(evt);
            }
        });
        
        this.vistaRegistroComidas.getBotonIngresarComida().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirComida(evt);

            }

        });

        this.vistaRegistroComidas.getBotonConsultarComida().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarComida(evt);

            }

        });
        
        this.mivista.getBotonVistaServiciosAdicionales().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerVisibleServiciosAdicionales(evt);

            }

        });

        this.vistaRegistroServiciosAdicionales.getBotonElegirServiciosAdicionales().addActionListener(new java.awt.event.ActionListener() {
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

    private void hacerVisibleVistaRegistroInicial(java.awt.event.ActionEvent evt) {
        this.vistaRegistroInicial.setVisible(true);
    }

    private void hacerVisibleVistaRegistroAcompañantes(java.awt.event.ActionEvent evt) {
        this.vistaRegistroAcompañantes.setVisible(true);
    }

    private void hacerVisibleVistaRegistroEstadia(java.awt.event.ActionEvent evt) {
        this.vistaRegistroEstadia.setVisible(true);
    }
    
    private void hacerVisibleRegistroHabitacion (java.awt.event.ActionEvent evt){
        this.vistaRegistroHabitacion.setVisible(true);
    }
    
    private void hacerVisibleRegistroComidas (java.awt.event.ActionEvent evt){
        this.vistaRegistroComidas.setVisible(true);
    }
    
    private void hacerVisibleServiciosAdicionales (java.awt.event.ActionEvent evt){
        this.vistaRegistroServiciosAdicionales.setVisible(true);
    }
    
    private void guardarDatosPersonales(java.awt.event.ActionEvent evt) {

        String nombre = this.vistaRegistroInicial.getEntradaNombre().getText();
        String apellido = this.vistaRegistroInicial.getEntradaApellido().getText();
        int cedula = Integer.parseInt(this.vistaRegistroInicial.getEntradaCedula().getText());
        String correo = this.vistaRegistroInicial.getEntradaCorreo().getText();
        double celular = Double.parseDouble(this.vistaRegistroInicial.getEntradaCelular().getText());
        String direccion = this.vistaRegistroInicial.getEntradaDireccion().getText();

        this.vistaRegistroInicial.setVisible(false);

        JOptionPane.showMessageDialog(mivista, "Se guardaron los datos Correctamente!!");

        this.vistaRegistroInicial.getEntradaNombre().setEditable(false);
        this.vistaRegistroInicial.getEntradaApellido().setEditable(false);
        this.vistaRegistroInicial.getEntradaCedula().setEditable(false);
        this.vistaRegistroInicial.getEntradaCorreo().setEditable(false);
        this.vistaRegistroInicial.getEntradaCelular().setEditable(false);
        this.vistaRegistroInicial.getEntradaDireccion().setEditable(false);

        this.mivista.setVisible(true);
    }

    private void limpiarTabla(DefaultTableModel objetoModelo) {
        for (int i = 0; i < objetoModelo.getRowCount(); i++) {
            objetoModelo.removeRow(i);
        }

    }

    private void extraerdatosbotonacompañantes(java.awt.event.ActionEvent evt) {

        int numeroNiños = Integer.parseInt(this.vistaRegistroAcompañantes.getEntradaNumNiños().getText());
        int numeroAdultos = Integer.parseInt(this.vistaRegistroAcompañantes.getEntradaNnumAdultos().getText());
        int numeroTotalAcompañantes = numeroNiños + numeroAdultos;

        if (numeroNiños == 1) {
            int valorTotalNiños = 35000;
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else if (numeroNiños == 2) {
            int valorTotalNiños = 70000;
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Verifica los datos!!");
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText("");
            this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
            this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");

        }

        if (numeroAdultos == 1) {
            int valorTotalAdultos = 40000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numeroAdultos == 2) {
            int valorTotalAdultos = 80000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numeroAdultos == 3) {
            int valorTotalAdultos = 120000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numeroAdultos == 4) {
            int valorTotalAdultos = 160000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Verifica los datos!!");
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText("");
            this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
            this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");

        }

        if (numeroNiños <= 2 && numeroAdultos <= 4) {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Registrados correctamente!");


        } else {

            this.vistaRegistroAcompañantes.getEntradaNnumAdultos().setText("");
            this.vistaRegistroAcompañantes.getEntradaNumNiños().setText("");
            this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");
        }

        this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText(Integer.toString(numeroTotalAcompañantes));

        int valorTotalAcompañantes = (Integer.parseInt(this.vistaRegistroAcompañantes.getLabelvalorNiños().getText())) + Integer.parseInt(this.vistaRegistroAcompañantes.getLabelvalorAdultos().getText());
        this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText(Integer.toString(valorTotalAcompañantes));
    }

    private void extrarDatosBotonEstadia(java.awt.event.ActionEvent evt) {

        int ent_fechallegada = Integer.parseInt(this.vistaRegistroEstadia.getEntradaFechaLlegada().getText());
        int ent_fechasalida = Integer.parseInt(this.vistaRegistroEstadia.getEntradaFechaSalida().getText());

        int noches = ent_fechasalida - ent_fechallegada;
        if (noches <= 0) {
            JOptionPane.showMessageDialog(vistaRegistroEstadia, "Ingrese una fecha valida:");
        } else {
            this.vistaRegistroEstadia.getLabelNumeroNoches().setText(Integer.toString(noches));

            int valorTotalAcompañantes = noches * 60000;
            this.vistaRegistroEstadia.getLabelCostoTotalNoches().setText(Integer.toString(valorTotalAcompañantes));
            JOptionPane.showMessageDialog(vistaRegistroEstadia, "Noches registradas correctamente!");
        }

    }

    private void extraerDatosBotonHabitacion(java.awt.event.ActionEvent evt) {

        int camas = Integer.parseInt(this.vistaRegistroHabitacion.getLabelHabitacionCamas().getText());
        int capacidad = Integer.parseInt(this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().getText());
        int televisores = Integer.parseInt(this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().getText());
        int balcon = Integer.parseInt(this.vistaRegistroHabitacion.getLabelHabitacionBalcon().getText());
        int costo = Integer.parseInt(this.vistaRegistroHabitacion.getLabelCostoHabitacion().getText());

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
        String seleccion = this.vistaRegistroHabitacion.getComboboxHabitacion().getSelectedItem().toString();

        if (seleccion == "Duplex") {
            this.vistaRegistroHabitacion.getLabelHabitacionCamas().setText(Integer.toString(habitacionD.getCamas()));
            this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionD.getCapacidad()));
            this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionD.getTelevisores()));
            this.vistaRegistroHabitacion.getLabelHabitacionBalcon().setText(Integer.toString(1));
            this.vistaRegistroHabitacion.getLabelCostoHabitacion().setText(Integer.toString(habitacionD.getCosto()));

        } else if (seleccion == "Junior") {
            this.vistaRegistroHabitacion.getLabelHabitacionCamas().setText(Integer.toString(habitacionJ.getCamas()));
            this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionJ.getCapacidad()));
            this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionJ.getTelevisores()));
            this.vistaRegistroHabitacion.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelCostoHabitacion().setText(Integer.toString(habitacionJ.getCosto()));

        } else if (seleccion == "Sencilla") {
            this.vistaRegistroHabitacion.getLabelHabitacionCamas().setText(Integer.toString(habitacionS.getCamas()));
            this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().setText(Integer.toString(habitacionS.getCapacidad()));
            this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().setText(Integer.toString(habitacionS.getTelevisores()));
            this.vistaRegistroHabitacion.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelCostoHabitacion().setText(Integer.toString(habitacionS.getCosto()));

        } else {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
            this.vistaRegistroHabitacion.getLabelHabitacionCamas().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelHabitacionBalcon().setText(Integer.toString(0));
            this.vistaRegistroHabitacion.getLabelCostoHabitacion().setText(Integer.toString(0));
        }
    }

    private void elegirComida(java.awt.event.ActionEvent evt) {
        int numeroNochesComida = Integer.parseInt(this.vistaRegistroComidas.getLabelNochesComida().getText());
        int numeroAcompañantesComida = Integer.parseInt(this.vistaRegistroComidas.getLabelAcompañantesComida().getText());
        int costoTotal = Integer.parseInt(this.vistaRegistroComidas.getLabelCostoComida().getText());

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
        String seleccion = this.vistaRegistroComidas.getComboBoxComida().getSelectedItem().toString();
        int costoTotalComida = 0;

        int numeroNoches = Integer.parseInt(this.vistaRegistroEstadia.getLabelNumeroNoches().getText());
        int numeroAdultos = Integer.parseInt(this.vistaRegistroAcompañantes.getEntradaNnumAdultos().getText());
        int numeroNiños = Integer.parseInt(this.vistaRegistroAcompañantes.getEntradaNumNiños().getText());

        this.vistaRegistroComidas.getLabelNochesComida().setText(Integer.toString(numeroNoches));
        this.vistaRegistroComidas.getLabelAcompañantesComida().setText((this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().getText()));
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
            this.vistaRegistroComidas.getLabelAcompañantesComida().setText(Integer.toString(0));
            this.vistaRegistroComidas.getLabelNochesComida().setText(Integer.toString(0));
            this.vistaRegistroComidas.getLabelCostoComida().setText(Integer.toString(0));
        }

        this.vistaRegistroComidas.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
    }

    private void elegirServicioAdicional(java.awt.event.ActionEvent evt) {

        int costoGimansio = 0, costoSpa = 0, costoPiscina = 0;

        Gimnasio gimnasio = new Gimnasio(240000);
        Spa spa = new Spa(310000);
        Piscina piscina = new Piscina(65000);

        if ((this.vistaRegistroServiciosAdicionales.getCheckboxNinguno().isSelected() && this.vistaRegistroServiciosAdicionales.getCheckboxGimnasio().isSelected())
                || (this.vistaRegistroServiciosAdicionales.getCheckboxNinguno().isSelected() && this.vistaRegistroServiciosAdicionales.getCheckboxSpa().isSelected())
                || (this.vistaRegistroServiciosAdicionales.getCheckboxNinguno().isSelected() && this.vistaRegistroServiciosAdicionales.getCheckboxPiscina().isSelected())) {
            this.vistaRegistroServiciosAdicionales.getCheckboxGimnasio().setSelected(false);
            this.vistaRegistroServiciosAdicionales.getCheckboxSpa().setSelected(false);
            this.vistaRegistroServiciosAdicionales.getCheckboxPiscina().setSelected(false);
            this.vistaRegistroServiciosAdicionales.getCheckboxNinguno().setSelected(false);

            JOptionPane.showMessageDialog(mivista, "Error, selecciona una opcion correcta");

        } else {
            costoGimansio = gimnasio.seleccionarServicio(this.vistaRegistroServiciosAdicionales);
            costoSpa = spa.seleccionarServicio(this.vistaRegistroServiciosAdicionales);
            costoPiscina = piscina.seleccionarServicio(this.vistaRegistroServiciosAdicionales);
            JOptionPane.showMessageDialog(mivista, "Seleccionado con exito");
        }

        int totalServiciosAdicionales = costoGimansio + costoSpa + costoPiscina;
        this.vistaRegistroServiciosAdicionales.getLabelCostoTotalAdicionales().setText(Integer.toString(totalServiciosAdicionales));

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

        String nombre = this.vistaRegistroInicial.getEntradaNombre().getText();
        String apellido = this.vistaRegistroInicial.getEntradaApellido().getText();
        int cedula = Integer.parseInt(this.vistaRegistroInicial.getEntradaCedula().getText());
        int acompañantes = Integer.parseInt(this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().getText());
        int noches = Integer.parseInt(this.vistaRegistroEstadia.getLabelNumeroNoches().getText());
        String habitacion = this.vistaRegistroHabitacion.getComboboxHabitacion().getSelectedItem().toString();
        String comida = this.vistaRegistroComidas.getComboBoxComida().getSelectedItem().toString();

        int costoAcompañantes = Integer.parseInt(this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().getText());
        int costoHabitacion = Integer.parseInt(this.vistaRegistroHabitacion.getLabelCostoHabitacion().getText());
        int costoComida = Integer.parseInt(this.vistaRegistroComidas.getLabelCostoComida().getText());
        int costoNoches = Integer.parseInt(this.vistaRegistroEstadia.getLabelCostoTotalNoches().getText());
        int costoAdicionales = Integer.parseInt(this.vistaRegistroServiciosAdicionales.getLabelCostoTotalAdicionales().getText());

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

        this.vistaRegistroInicial.getEntradaNombre().setEditable(true);
        this.vistaRegistroInicial.getEntradaApellido().setEditable(true);
        this.vistaRegistroInicial.getEntradaCedula().setEditable(true);
        this.vistaRegistroInicial.getEntradaCorreo().setEditable(true);
        this.vistaRegistroInicial.getEntradaCelular().setEditable(true);
        this.vistaRegistroInicial.getEntradaDireccion().setEditable(true);
    }

    private void limpiarFormulario() {
        this.vistaRegistroInicial.getEntradaNombre().setText("");
        this.vistaRegistroInicial.getEntradaApellido().setText("");
        this.vistaRegistroInicial.getEntradaCedula().setText("");
        this.vistaRegistroInicial.getEntradaCorreo().setText("");
        this.vistaRegistroInicial.getEntradaCelular().setText("");
        this.vistaRegistroInicial.getEntradaDireccion().setText("");
        this.vistaRegistroAcompañantes.getEntradaNumNiños().setText("");
        this.vistaRegistroAcompañantes.getEntradaNnumAdultos().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorNiños().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
        this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");
        this.vistaRegistroServiciosAdicionales.getLabelCostoTotalAdicionales().setText("");
        this.vistaRegistroEstadia.getEntradaFechaLlegada().setText("");
        this.vistaRegistroEstadia.getEntradaFechaSalida().setText("");
        this.vistaRegistroEstadia.getLabelNumeroNoches().setText("");
        this.vistaRegistroEstadia.getLabelCostoTotalNoches().setText("");
        this.vistaRegistroComidas.getComboBoxComida().setSelectedItem(("Selecciona"));
        this.vistaRegistroComidas.getLabelAcompañantesComida().setText("");
        this.vistaRegistroComidas.getLabelNochesComida().setText("");
        this.vistaRegistroComidas.getLabelCostoComida().setText("");
        this.vistaRegistroHabitacion.getLabelHabitacionCamas().setText(Integer.toString(0));
        this.vistaRegistroHabitacion.getLabelHabitacionCapacidad().setText(Integer.toString(0));
        this.vistaRegistroHabitacion.getLabelHabitacionTelevisores().setText(Integer.toString(0));
        this.vistaRegistroHabitacion.getLabelHabitacionBalcon().setText(Integer.toString(0));
        this.vistaRegistroHabitacion.getLabelCostoHabitacion().setText(Integer.toString(0));
        this.vistaRegistroHabitacion.getComboboxHabitacion().setSelectedItem("Selecciona");
        this.vistaRegistroServiciosAdicionales.getCheckboxGimnasio().setSelected(false);
        this.vistaRegistroServiciosAdicionales.getCheckboxSpa().setSelected(false);
        this.vistaRegistroServiciosAdicionales.getCheckboxPiscina().setSelected(false);
        this.vistaRegistroServiciosAdicionales.getCheckboxNinguno().setSelected(false);
        this.vistaRegistroServiciosAdicionales.getLabelCostoTotalAdicionales().setText("");

    }
}
