package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Tienda;
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
 * Clase para realizar consultas a la tabla {@link Tienda} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class TiendaDAO {

    public static final String GET_TIENDA = "SELECT * FROM TIENDAS WHERE ID= ?";
    public static final String GET_ALL_TIENDAS = "SELECT * FROM TIENDAS";
    public static final String GET_TIENDA_NOMBRE = "SELECT * FROM TIENDAS WHERE NOMBREIDENTIFICATIVO= ?";
    private static ArrayList<Tienda> tiendas = new ArrayList<>();

    private TiendaDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener una {@link Tienda} de la base de datos a partir de
     * su id identificador.
     *
     * @param id identificador de la {@link Tienda}
     * @param nombre de la {@link Tienda}
     * @return tienda {@link Tienda}
     */
    public static JsonObject getTienda(int id, String nombre) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        ResultSet result = null;
        try {
            PreparedStatement s;
            if (id == -1) {
                s = connection.getStatement(GET_TIENDA_NOMBRE);
                s.setString(1, nombre);
            } else {
                s = connection.getStatement(GET_TIENDA);
                s.setInt(1, id);
            }

            result = s.executeQuery();
            if (result.next()) {
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("id", result.getInt("ID"))
                        .add("nombre", result.getString("NOMBREIDENTIFICATIVO")).build();
            }
        } catch (SQLException ex) {

            Logger.getLogger(TiendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return respuestaJson;
    }

    /**
     * Funcion para obtener todas las {@link Tienda} de la base de datos, se
     * guardan en un {@link ArrayList}
     *
     * @return tiendas, {@link ArrayList} de {@link Tienda}
     */
    public static List<Tienda> getAllTiendas() {
        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        ResultSet result = null;
        try ( PreparedStatement s = connection.getStatement(GET_ALL_TIENDAS);) {
            result = s.executeQuery();
            Tienda tienda = null;
            tiendas.clear();
            while (result.next()) {
                tienda = new Tienda(result.getInt("ID"), result.getString("NOMBREIDENTIFICATIVO"));
                tiendas.add(tienda);
            }
        } catch (SQLException ex) {

            Logger.getLogger(TiendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TiendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return tiendas;
    }

}
