package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla {@link Direccion} de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DireccionDAO {

    public static final String NUEVA_DIRECCION = "INSERT INTO DIRECCIONES (ID, CALLE, NUMERO, OTROS, CODIGOPOSTAL, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?, ?, ?,?)";
    public static final String GET_ULTIMA_ID = "SELECT ID FROM DIRECCIONES WHERE ID=(SELECT MAX(ID) FROM DIRECCIONES)";
    public static final String GET_DIRECCION = "SELECT * FROM direcciones WHERE id=?";
    private static final String LOGGER_CLASE = DireccionDAO.class.getName();
    private DireccionDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir una nueva {@link Direccion} a la base de datos
     *
     * @param id identificador de la {@link Direccion}
     * @param calle calle de la {@link Direccion}
     * @param numero numero del edificio de la {@link Direccion}
     * @param otros consideraciones a tener en cuenta de la {@link Direccion}
     * @param codpos codigo postal de la {@link Direccion}
     * @param localidad localidad en la que se encuentra la {@link Direccion}
     * @param provincia provincia en la que se encuentra la {@link Direccion}
     */
    public static void insert(int id, String calle, int numero, String otros, int codpos, String localidad, String provincia) {

        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        try ( PreparedStatement emp = connection.getStatement(NUEVA_DIRECCION);) {
            emp.setInt(1, id);
            emp.setString(2, calle);
            emp.setInt(3, numero);
            emp.setString(4, otros);
            emp.setInt(5, codpos);
            emp.setString(6, localidad);
            emp.setString(7, provincia);
            emp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LOGGER_CLASE).log(Level.SEVERE, null, ex);
        }

        connection.closeConnection();

    }

    /**
     * Consulta con la que obtener la id del ultimo elemento {@link Direccion} que se
     * encuentra en la base de datos.Para ello se ha tenido en cuenta que el ultimo elemento es
     * el que tiene la id más alta, al ser de tipo {@link Integer}
     *
     * @return ultimaId identificador
     */
    public static JsonObject getUltimaID() {
        DBConnection connection = DBConnection.getInstance();
        JsonObject ultimaId = null;
        ResultSet result = null;
        int idNueva = -1;
        connection.openConnection();
        try ( PreparedStatement sUltId = connection.getStatement(GET_ULTIMA_ID);) {
            result = sUltId.executeQuery();
            if (result.next()) {
                idNueva = result.getInt("ID");
                ultimaId = (JsonObject) Json.createObjectBuilder().add("id", idNueva).build();
            }
        } catch (SQLException ex) {
             Logger.getLogger(LOGGER_CLASE).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LOGGER_CLASE).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();

        return ultimaId;
    }

    /**
     * Funcion para obtener una {@link Direccion} de la base de datos a partir
     * de su identificador id.
     *
     * @param id identificador de una {@link Direccion}
     * @return direccion {@link Direccion}
     */
    public static JsonObject getDireccion(int id) {
        JsonObject dir = null;
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        ResultSet rs = null;
        String calleLabel = "calle";
        String numeroLabel = "numero";
        String otrosLabel = "otros";
        String localidadLabel = "localidad";
        String provinciaLabel = "provincia";
        try ( PreparedStatement s = connection.getStatement(GET_DIRECCION)) {
            s.setInt(1, id);
            rs = s.executeQuery();
            if (rs.next()) {
                String calle = rs.getString(calleLabel);
                int numero = rs.getInt(numeroLabel);
                String otros = rs.getString(otrosLabel);
                int codPos = rs.getInt("codigopostal");
                String localidad = rs.getString(localidadLabel);
                String provincia = rs.getString("provincia");
                if (otros != null) {
                    dir = (JsonObject) Json.createObjectBuilder().add("id", id).add(calleLabel, calle).add(numeroLabel, numero)
                            .add(otrosLabel, otros).add("codPos", codPos).add(localidadLabel, localidad)
                            .add(provinciaLabel, provincia).build();
                } else {
                    dir = (JsonObject) Json.createObjectBuilder().add("id", id).add(calleLabel, calle).add(numeroLabel, numero)
                            .add(otrosLabel, " ").add("codPos", codPos).add(localidadLabel, localidad)
                            .add(provinciaLabel, provincia).build();
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(LOGGER_CLASE).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LOGGER_CLASE).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();
        return dir;

    }

}
