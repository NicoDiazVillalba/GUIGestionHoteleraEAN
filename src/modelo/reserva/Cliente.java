
package modelo.reserva;

import javax.swing.JOptionPane;

public class Cliente extends Persona {
    
    public int costo_niños;
    public int numero_niños;
    public int costo_adultos;
    public int numero_adultos;
    public int costo_habitacion;
    public String tipo_habitacion;
    public int numero_noches;
    public int costo_noches;
    public int costo_comida;
    public String tipo_comida;
    public int costo_total;
    

    public Cliente(String ent_nombre, String ent_apellido, int ent_cedula, String ent_correo, double ent_celular, String ent_direccion) {
        super(ent_nombre, ent_apellido, ent_cedula, ent_correo, ent_celular, ent_direccion);
    }
    
     
    public void costoTotalAcompañantes(){
        int costo_total = costo_niños+costo_adultos;
        JOptionPane.showMessageDialog(null, "Costo Total Acompañantes: "+costo_total);
    }
    
    public int numeroNoches(int ent_fecha_llegada,int ent_fecha_salida){
        int noches =0;
        noches = ent_fecha_salida-ent_fecha_llegada;
        numero_noches = noches;
        return numero_noches;
    }

    public int getNumero_noches() {
        return numero_noches;
    }

    public void costoNumeroNoches(int ent_noches){
        int costo_total = 0;
        costo_total = ent_noches*60000;
        costo_noches =costo_total;
        JOptionPane.showMessageDialog(null, "- Numero de noches: "+ent_noches+"\n- Costo por noche: $60.000\n- Costo Total: $"+costo_noches);
    }
   
    public int getCosto_niños() {
        return costo_niños;
    }

    public int getNumero_niños() {
        return numero_niños;
    }

    public int getCosto_adultos() {
        return costo_adultos;
    }

    public int getNumero_adultos() {
        return numero_adultos;
    }

    public int getCosto_habitacion() {
        return costo_habitacion;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public int getCosto_noches() {
        return costo_noches;
    }

    public int getCosto_comida() {
        return costo_comida;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public int getCosto_total() {
        return costo_total;
    }
    
  
    
}
    

    

    
    
    
    
    
    
    
    
    

