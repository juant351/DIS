package es.uva.bluemanzana.basedatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla {@link Usuario} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class UsuarioDAO {

    public static final String NUEVO_USUARIO = "INSERT INTO USUARIOS (NIF, NOMBRE, APELLIDOS, PASSWORD, EMAIL, TELEFONO) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String CONSULTAR_USUARIO = "SELECT * FROM Usuarios WHERE nif= ?";

    private UsuarioDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir un {@link Usuario} a la base de datos.
     *
     * @param nif nif/dni del {@link Usuario}
     * @param nombre del {@link Usuario}
     * @param apellidos del {@link Usuario}
     * @param pass contraseña del {@link Usuario}
     * @param email correo electronico del {@link Usuario}
     * @param telefono telefono/movil del {@link Usuario}
     */
    public static void insert(String nif, String nombre, String apellidos, String pass, String email, String telefono) {
        DBConnection connection = DBConnection.getInstance();
        if (closeConnection) {
            connection.openConnection();
        }

        try (PreparedStatement usu = connection.getStatement(NUEVO_USUARIO);) {
            usu.setString(1, nif);
            usu.setString(2, nombre);
            usu.setString(3, apellidos);
            usu.setString(4, pass);
            usu.setString(5, email);
            usu.setString(6, telefono);
            usu.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (closeConnection) {
            connection.closeConnection();
        }
    }

    /**
     * Funcion para obtener un {@link Usuario} de la base de datos a partir de
     * su nif/dni
     *
     * @param nif del {@link Usuario}
     * @return usuario {@link Usuario}SS
     */
    public static JsonObject getUsuario(String nif) {
        JsonObject usuario = null;
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        ResultSet rs = null;
        try (PreparedStatement s = connection.getStatement(CONSULTAR_USUARIO);) {
            s.setString(1, nif);
            rs = s.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                usuario = (JsonObject) Json.createObjectBuilder().add("nif", nif)
                        .add("nombre", nombre)
                        .add("apellidos", apellidos)
                        .add("password", password)
                        .add("email", email)
                        .add("telefono", telefono)
                        .build();

            }
            connection.closeConnection();
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static boolean closeConnection = true;
}
