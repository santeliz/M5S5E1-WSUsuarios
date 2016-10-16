/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author JAVA
 */
@WebService(serviceName = "WSAgregarUsuarios")
public class WSAgregarUsuarios {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarUser")
    public String agregarUser(@WebParam(name = "usuario") String usuario, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        Usuario user = new Usuario(usuario, pass);
        UsuarioDAO userDAO = new UsuarioDAO();

        return userDAO.agregarUsuario(user);
    }
}
