/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.bluemanzana.negocio.controladores;

import es.uva.bluemanzana.basedatos.RolEnEmpresaDAO;
import es.uva.bluemanzana.basedatos.UsuarioDAO;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import javax.json.JsonObject;

/**
 * Clase controlador para el caso de uso Identificarse.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class IdentificarseController {
    
    /**
     * Constructor privado
     */
    private IdentificarseController() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Consulta que devuelve un nuevo controlador.
     * @return Controlador identificarse
     */
    public static IdentificarseController getController() {
        return new IdentificarseController();
    }

    /**
     * Consulta encargada de obtener un {@link Usuario} de la base de datos a
     * partir de su dni.
     *
     * @param dni Dni del {@link Usuario}
     * @return {@link Usuario}
     */
    public static Usuario getUsuario(String dni) {
        JsonObject usuario = UsuarioDAO.getUsuario(dni);
        return new Usuario(usuario.getString("nif"), usuario.getString("nombre"), usuario.getString("apellidos"), usuario.getString("password"),
                 usuario.getString("email"), usuario.getString("telefono"));
    }

    /**
     * Consulta encargada de devolver el rol del {@link Usuario} a partir de su
     * dni
     *
     * @param dni Dni del {@link Usuario}
     * @return rol Rol del usuario
     */
    public static int getRol(String dni) {
        JsonObject rol = RolEnEmpresaDAO.obtenerRol(dni);
        return rol.getInt("rol");
    }
}
