package modelo.reserva;


public abstract class Persona {
 
    private String nombre;
    private String apellido;
    private int cedula;
    private String correo;
    private double celular;
    private String direccion;
    private String genero;

    public Persona(String ent_nombre, String ent_apellido, int ent_cedula, String ent_correo, double ent_celular, String ent_direccion, String ent_genero) {
        this.nombre = ent_nombre;
        this.apellido = ent_apellido;
        this.cedula = ent_cedula;
        this.correo = ent_correo;
        this.celular = ent_celular;
        this.direccion = ent_direccion;
        this.genero = ent_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public double getCelular() {
        return celular;
    }

    public void setCelular(double celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
}
