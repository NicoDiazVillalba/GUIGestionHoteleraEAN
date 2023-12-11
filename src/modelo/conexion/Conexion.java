
package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String base ="bdbreserva";
    private String user ="root";
    private String password ="juliana777";
    private String url ="jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
    
    public Connection realizarConexion(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Conectado");
            
        }catch(SQLException e){
            System.err.println(e);
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}

