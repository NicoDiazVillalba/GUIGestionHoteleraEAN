package controlador;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AlmuerzoYRefrigerio;
import modelo.Cliente;
import modelo.Desayuno;
import modelo.DesayunoYRefrigerio;
import modelo.HabitacionDuplex;
import modelo.HabitacionJunior;
import modelo.HabitacionSencilla;
import modelo.ListaClientes;
import modelo.Persona;
import modelo.TresComidas;
import vista.vistaPrincipal;

public class Controlador {

    private vistaPrincipal mivista;
    private ListaClientes miLista = new ListaClientes();

    public Controlador(vistaPrincipal objetoGUI) {
        this.mivista = objetoGUI;
        this.mivista.setVisible(true);
        accionarBotones();

    }

    //Metodo donde escucha el boton
    private void accionarBotones() {
        this.mivista.getBotonIngresardatos().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraerdatosboton(evt);
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
    }

    //Medodo donde se realiza la accion luego de oprimir el boton
    private void extraerdatosboton(java.awt.event.ActionEvent evt) {
        //Crear y extraer la infromacion del formulario 
        String nombre = this.mivista.getEntradaNombre().getText();
        String apellido = this.mivista.getEntradaApellido().getText();
        int cedula = Integer.parseInt(this.mivista.getEntradaCedula().getText());
        String correo = this.mivista.getEntradaCorreo().getText();
        double celular = Double.parseDouble(this.mivista.getEntradaCelular().getText());
        String direccion = this.mivista.getEntradaDireccion().getText();

        //Instanciar el objeto persona
        Cliente objetoCliente = new Cliente(nombre, apellido, cedula, correo, celular, direccion);
        //Agregar el objeto a una lista
        this.miLista.agregarCliente(objetoCliente);
        //Mostrar datos 

        DefaultTableModel mapeo = (DefaultTableModel) this.mivista.getTablaReserva().getModel();

        limpiarTabla(mapeo);

        for (Cliente elemento : this.miLista.mostrarLista()) {
            mapeo.addRow(new Object[]{elemento.getNombre(), elemento.getApellido(), elemento.getCedula(), elemento.getCelular()});
            System.out.println(elemento.getNombre());
        }

        limpiarFormulario();
        JOptionPane.showMessageDialog(mivista, "Datos registrados Correctamente!");

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

        HabitacionDuplex habitacionD = new HabitacionDuplex("Duplex", 4, 2, 4, 1200000, true);
        HabitacionJunior habitacionJ = new HabitacionJunior("Junior", 2, 1, 2, 800000, false);
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
    
    private void elegirComida(java.awt.event.ActionEvent evt){
        int numeroNochesComida = Integer.parseInt(this.mivista.getLabelNochesComida().getText());
        int numeroAcompañantesComida = Integer.parseInt(this.mivista.getLabelAcompañantesComida().getText());
        int costoTotal = Integer.parseInt(this.mivista.getLabelCostoComida().getText());
        
        if (numeroNochesComida ==0||numeroAcompañantesComida==0||costoTotal==0){
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
        }else{
            JOptionPane.showMessageDialog(mivista, "Comida seleccionada correctamente!");
        }
        
        System.out.println("niches"+numeroNochesComida);
        System.out.println("personas: "+numeroAcompañantesComida);    
        System.out.println("Costo"+costoTotal);
    }

    private void consultarComida(java.awt.event.ActionEvent evt) {
        //Objetos
        Desayuno comida1 = new Desayuno("Desayuno");
        DesayunoYRefrigerio comida2 = new DesayunoYRefrigerio("Desayuno y Refrigerio");
        AlmuerzoYRefrigerio comida3 = new AlmuerzoYRefrigerio("Almuerzo y Refrigerio");
        TresComidas comida4 = new TresComidas("Desayuno Almuerzo y Cena");
        //COmbo box y variables
        String seleccion = this.mivista.getComboBoxComida().getSelectedItem().toString();
        int costoTotalComida;

        int numeroNoches = Integer.parseInt(this.mivista.getLabelNumeroNoches().getText());
        int numeroAdultos = Integer.parseInt(this.mivista.getEntradaNnumAdultos().getText());
        int numeroNiños = Integer.parseInt(this.mivista.getEntradaNumNiños().getText());

        this.mivista.getLabelNochesComida().setText(Integer.toString(numeroNoches));
        this.mivista.getLabelAcompañantesComida().setText((this.mivista.getLabelTotalAcompañantes().getText()));
        if (seleccion == "Desayuno - $15.000") {
            costoTotalComida = comida1.definirCosto(numeroNiños, numeroAdultos, numeroNoches);
            this.mivista.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
        } else if (seleccion == "Desayuno y Refrigerio - $20.000") {
            costoTotalComida = comida2.definirCosto(numeroNiños, numeroAdultos, numeroNoches);
            this.mivista.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
        } else if (seleccion == "Almuerzo y Refrigerio - $35.000") {
            costoTotalComida = comida3.definirCosto(numeroNiños, numeroAdultos, numeroNoches);
            this.mivista.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
        } else if (seleccion == "Desayuno, Almuerzo y Cena - $50.000") {
            costoTotalComida = comida4.definirCosto(numeroNiños, numeroAdultos, numeroNoches);
            this.mivista.getLabelCostoComida().setText(Integer.toString(costoTotalComida));
        } else {
            JOptionPane.showMessageDialog(mivista, "Por favor, selecciona una opción!");
            this.mivista.getLabelAcompañantesComida().setText(Integer.toString(0));
            this.mivista.getLabelNochesComida().setText(Integer.toString(0));
            this.mivista.getLabelCostoComida().setText(Integer.toString(0));
        }

    }

    private void limpiarFormulario() {
        this.mivista.getEntradaNombre().setText("");
        this.mivista.getEntradaApellido().setText("");
        this.mivista.getEntradaCedula().setText("");
        this.mivista.getEntradaCorreo().setText("");
        this.mivista.getEntradaCelular().setText("");
        this.mivista.getEntradaDireccion().setText("");
    }
}
