    
package modelo.habitacion;


public class HabitacionDuplex extends Habitacion{
    
    private boolean balcon;
    private int televisores;
    
    public HabitacionDuplex(String ent_tipo,int ent_camas, int ent_capacidad,int ent_televisores, int ent_costo, boolean ent_balcon) {
        super(ent_tipo, ent_camas, ent_capacidad, ent_costo);
        
        this.balcon = ent_balcon;
        this.televisores = ent_televisores;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public int getTelevisores() {
        return televisores;
    }

    public void setTelevisores(int televisores) {
        this.televisores = televisores;
    }
    
    
    
    
    

    

    

    


    
    
}
