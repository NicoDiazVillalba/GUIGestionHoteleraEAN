package modelo.consultareservas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.conexion.Conexion;
import modelo.reserva.Reserva;
import vista.vistaPrincipal;

public class ConsultasReservas extends Conexion {

    public void mostrarDatosTabla(vistaPrincipal vista) {

        String sql = "SELECT *FROM reservas";
        Statement st;
        Connection con = realizarConexion();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Cedula");
        model.addColumn("Acompañantes");
        model.addColumn("Noches");
        model.addColumn("Habitacion");
        model.addColumn("Comida");
        model.addColumn("Total");

        vista.getTablaReserva().setModel(model);

        String[] datos = new String[9];

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Funciona el MOSTRAR");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                model.addRow(datos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }

    }

    public boolean registrarDatosReserva(Reserva objetoReserva) {

        PreparedStatement ps;
        Connection con = realizarConexion();
        String sql = "insert into reservas (nombre,apellido,cedula,acompañantes,noches,habitacion,comida,total) values(?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            System.out.println("Funciona el INGRESAR");
            ps.setString(1, objetoReserva.getNombre());
            ps.setString(2, objetoReserva.getApellido());
            ps.setLong(3, objetoReserva.getCedula());
            ps.setInt(4, objetoReserva.getAcompañantes());
            ps.setInt(5, objetoReserva.getNoches());
            ps.setString(6, objetoReserva.getHabitacion());
            ps.setString(7, objetoReserva.getComida());
            ps.setInt(8, objetoReserva.getCostoTotal());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificarDatosReserva(Reserva objetoReserva) {

        PreparedStatement ps;
        Connection con = realizarConexion();
        String sql = "UPDATE reservas SET nombre=?,apellido=?,cedula=?,acompañantes=?,noches=?,habitacion=?,comida=?,total=? WHERE id =?";

        try {
            ps = con.prepareStatement(sql);
            System.out.println("Funciona el MODIFICAR");
            ps.setString(1, objetoReserva.getNombre());
            ps.setString(2, objetoReserva.getApellido());
            ps.setLong(3, objetoReserva.getCedula());
            ps.setInt(4, objetoReserva.getAcompañantes());
            ps.setInt(5, objetoReserva.getNoches());
            ps.setString(6, objetoReserva.getHabitacion());
            ps.setString(7, objetoReserva.getComida());
            ps.setInt(8, objetoReserva.getCostoTotal());
            ps.setInt(9, objetoReserva.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean eliminarReserva(Reserva objetoReserva) {

        PreparedStatement ps;
        Connection con = realizarConexion();
        String sql = "DELETE FROM reservas WHERE ID =?";

        try {
            ps = con.prepareStatement(sql);
            System.out.println("Funciona el ELIMINAR");
            ps.setInt(1, objetoReserva.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean buscarReserva(Reserva objetoReserva) {

        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = realizarConexion();
        String sql = "SELECT FROM* reservas WHERE id =?";

        try {
            ps = con.prepareStatement(sql);
            System.out.println("Funciona el ELIMINAR");
            ps.setLong(1, objetoReserva.getCedula());
            rs = ps.executeQuery();

            if (rs.next()) {
                objetoReserva.setId(Integer.parseInt(rs.getString("id")));
                objetoReserva.setNombre(rs.getString("nombre"));
                objetoReserva.setApellido(rs.getString("apellido"));
                objetoReserva.setCedula(Integer.parseInt(rs.getString("cedula")));
                objetoReserva.setAcompañantes(Integer.parseInt(rs.getString("acompañantes")));
                objetoReserva.setNoches(Integer.parseInt(rs.getString("noches")));
                objetoReserva.setHabitacion(rs.getString("habitacion"));
                objetoReserva.setComida(rs.getString("comida"));
                objetoReserva.setCostoTotal(Integer.parseInt(rs.getString("total")));
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

}
