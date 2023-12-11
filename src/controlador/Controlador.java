package controlador;

import java.util.Date;
import java.util.concurrent.TimeUnit;
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
import modelo.consultareservas.ConsultasReservas;
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

    public Controlador(vistaPrincipal objetoGUI, vistaRegistroInicial objetoGUIRegistroInicial, vistaRegistroAcompañantes objetoGuiAcompañantes, vistaRegistroEstadia objetoGUIRegistroEstadia, vistaRegistroHabitacion objetoGUIRegistroHabitacion, vistaRegistroComidas objetoGUIRegistroComidas, vistaRegistroServiciosAdicionales objetoGUIRegistroServiciosAdicionales) {
        this.mivista = objetoGUI;
        this.vistaRegistroInicial = objetoGUIRegistroInicial;
        this.vistaRegistroAcompañantes = objetoGuiAcompañantes;
        this.vistaRegistroEstadia = objetoGUIRegistroEstadia;
        this.vistaRegistroHabitacion = objetoGUIRegistroHabitacion;
        this.vistaRegistroComidas = objetoGUIRegistroComidas;
        this.vistaRegistroServiciosAdicionales = objetoGUIRegistroServiciosAdicionales;
        this.mivista.setVisible(true);
        accionarBotones();
        ConsultasReservas consulta = new ConsultasReservas();
        consulta.mostrarDatosTabla(this.mivista);

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

        this.mivista.getBotonMostrar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarTabla(evt);

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

    private void hacerVisibleRegistroHabitacion(java.awt.event.ActionEvent evt) {
        this.vistaRegistroHabitacion.setVisible(true);
    }

    private void hacerVisibleRegistroComidas(java.awt.event.ActionEvent evt) {
        this.vistaRegistroComidas.setVisible(true);
    }

    private void hacerVisibleServiciosAdicionales(java.awt.event.ActionEvent evt) {
        this.vistaRegistroServiciosAdicionales.setVisible(true);
    }

    private void guardarDatosPersonales(java.awt.event.ActionEvent evt) {

        this.vistaRegistroInicial.setVisible(false);

        JOptionPane.showMessageDialog(mivista, "Se guardaron los datos Correctamente!!");

        this.mivista.setVisible(true);
    }

    private void extraerdatosbotonacompañantes(java.awt.event.ActionEvent evt) {

        int numerNiños = Integer.parseInt(this.vistaRegistroAcompañantes.getSpinnerNinos().getValue().toString());
        int numerAdultos = Integer.parseInt(this.vistaRegistroAcompañantes.getSpinnerAdultos().getValue().toString());
        int totalAcompañantes = numerNiños + numerAdultos;

        if (numerNiños == 0) {
            int valorTotalNiños = 0;
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else if (numerNiños == 1) {
            int valorTotalNiños = 35000;
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else if (numerNiños == 2) {
            int valorTotalNiños = 70000;
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText(Integer.toString(valorTotalNiños));

        } else {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Verifica los datos!!");
            this.vistaRegistroAcompañantes.getLabelvalorNiños().setText("");
            this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
            this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");

        }

        if (numerAdultos == 1) {
            int valorTotalAdultos = 40000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numerAdultos == 2) {
            int valorTotalAdultos = 80000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numerAdultos == 3) {
            int valorTotalAdultos = 120000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else if (numerAdultos == 4) {
            int valorTotalAdultos = 160000;
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText(Integer.toString(valorTotalAdultos));

        } else {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Verifica los datos!!");
            this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText("");
            this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
            this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");
        }

        if (numerNiños <= 2 && numerAdultos <= 4) {
            JOptionPane.showMessageDialog(this.vistaRegistroAcompañantes, "Registrados correctamente!");

        }

        this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText(Integer.toString(totalAcompañantes));

        int valorTotalAcompañantes = (Integer.parseInt(this.vistaRegistroAcompañantes.getLabelvalorNiños().getText())) + Integer.parseInt(this.vistaRegistroAcompañantes.getLabelvalorAdultos().getText());
        this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText(Integer.toString(valorTotalAcompañantes));
    }

    private void extrarDatosBotonEstadia(java.awt.event.ActionEvent evt) {

        Date fechaLlegada = this.vistaRegistroEstadia.getCalendarioLlegada().getDate();
        Date fechaSalida = this.vistaRegistroEstadia.getCalendarioSalida().getDate();

        long noches = fechaSalida.getTime() - fechaLlegada.getTime();
        long calculo = TimeUnit.DAYS.convert(noches, TimeUnit.MILLISECONDS);

        if (calculo <= 0) {
            JOptionPane.showMessageDialog(vistaRegistroEstadia, "Entrada invalida!!!");
        } else {

            this.vistaRegistroEstadia.getLabelNumeroNoches().setText(Long.toString(calculo));

            long valorTotalAcompañantes = calculo * 60000;
            this.vistaRegistroEstadia.getLabelCostoTotalNoches().setText(Long.toString(valorTotalAcompañantes));
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
        int numeroAdultos = Integer.parseInt(this.vistaRegistroAcompañantes.getSpinnerNinos().getValue().toString());
        int numeroNiños = Integer.parseInt(this.vistaRegistroAcompañantes.getSpinnerAdultos().getValue().toString());

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

    public void ActualizarTabla(java.awt.event.ActionEvent evt) {

        ConsultasReservas consulta = new ConsultasReservas();
        consulta.mostrarDatosTabla(this.mivista);
    }

    private void hacerReserva(java.awt.event.ActionEvent evt) {

        String nombre = this.vistaRegistroInicial.getEntradaNombre().getText();
        String apellido = this.vistaRegistroInicial.getEntradaApellido().getText();
        long cedula = Long.parseLong(this.vistaRegistroInicial.getEntradaCedula().getText());
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

        ConsultasReservas consulta = new ConsultasReservas();
        consulta.registrarDatosReserva(objetoReserva);

        limpiarFormulario();
        JOptionPane.showMessageDialog(mivista, "Datos registrados Correctamente!");
    }

    private void limpiarFormulario() {
        this.vistaRegistroInicial.getEntradaNombre().setText("");
        this.vistaRegistroInicial.getEntradaApellido().setText("");
        this.vistaRegistroInicial.getEntradaCedula().setText("");
        this.vistaRegistroInicial.getEntradaCorreo().setText("");
        this.vistaRegistroInicial.getEntradaCelular().setText("");
        this.vistaRegistroInicial.getEntradaDireccion().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorNiños().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorAdultos().setText("");
        this.vistaRegistroAcompañantes.getLabelvalorTotalAcompañantes().setText("");
        this.vistaRegistroAcompañantes.getLabelTotalAcompañantes().setText("");
        this.vistaRegistroServiciosAdicionales.getLabelCostoTotalAdicionales().setText("");
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
