package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.TiposDeRol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla {@link TiposDeRol} de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class TiposDeRolDAO {

    private static final String SELECT_ALL_ROL = "SELECT * FROM TIPOSDEROL";
    private static final String SELECT_ROL_BY_NOMBRE = "SELECT * FROM TIPOSDEROL WHERE NOMBRETIPO= ?";
    private static final String IDTIPOLABEL = "IDTIPO";

    private TiposDeRolDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener todos los {@link TiposDeRol} de la base de datos,
     * para ello se almacenan en un {@link ArrayList}
     *
     * @return roles, {@link ArrayList} de {@link TiposDeRol}
     */
    public static List<TiposDeRol> getAllRol() {
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        TiposDeRol rol = new TiposDeRol(0, " ");
        int id;
        String nombre;
        ArrayList<TiposDeRol> roles = new ArrayList<>();
        ResultSet result = null;
        try ( PreparedStatement s = connection.getStatement(SELECT_ALL_ROL);) {
            result = s.executeQuery();
            while (result.next()) {
                nombre = result.getString("NOMBRETIPO");
                id = result.getInt(IDTIPOLABEL);
                rol.setIdTipo(id);
                rol.setNombreTipo(nombre);
                roles.add(rol);
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return roles;
    }

    /**
     * Consulta que obtiene id del rol a partir de su nombre.
     *
     * @param rol Nombre del rol
     * @return id Id del tipo de rol
     */
    public static JsonObject getIdRolByName(String rol) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();
        ResultSet res = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(SELECT_ROL_BY_NOMBRE);) {
            s.setString(1, rol);
            res = s.executeQuery();
            if (res.next()) {
                int val = res.getInt(IDTIPOLABEL);
                respuestaJson = (JsonObject) Json.createObjectBuilder().add(IDTIPOLABEL, val).build();
            }
        } catch (SQLException e) {
            Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        connection.closeConnection();

        return respuestaJson;
    }

    /**
     * Funcion para comprobar que rol introducido pertenece a {@link TiposDeRol}
     * de la base de datos.
     *
     * @param rol {@link TiposDeRol}
     * @return true/false dependiendo de si pertenece o no.
     */
    public static JsonObject esRolEmpresa(String rol) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();
        boolean value = false;
        ResultSet result = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(SELECT_ROL_BY_NOMBRE);) {
            s.setString(1, rol);
            result = s.executeQuery();
            if (result.next()) {
                value = true;
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("esRol", value).build();
            } else {
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("esRol", value).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiposDeRolDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return respuestaJson;
    }

}
