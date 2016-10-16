package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    Connection con = null;

    public String agregarUsuario(Usuario usuario) {
        con = Conexion.conectarse();
        String retorno = null;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIO (usuario, pass) "
                    + " values (?, ?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
            retorno = "Usuario agregado";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
            retorno = null;
        } finally {
            if (con != null) {
                try {
                    if (!con.isClosed()) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    public static void main(String[] args) {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = new Usuario("Pegaso", "guaoguao");

        String r = udao.agregarUsuario(u);
        System.out.println(r);

    }

}
