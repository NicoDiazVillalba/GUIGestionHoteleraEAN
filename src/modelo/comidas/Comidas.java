package modelo.comidas;

import javax.swing.JOptionPane;

public abstract class Comidas {

    public String tipo;
    public int costo_final;

    public Comidas(String tipo) {
        this.tipo = tipo;

    }

    public int getCosto_final() {
        return costo_final;
    }

    public void setCosto_final(int costo_final) {
        this.costo_final = costo_final;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    }
