package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.ExistenciaEnTienda;
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
 * Clase para realizar consultas a la tabla {@link ExistenciaEnTienda} de la
 * base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class ExistenciasEnTiendasDAO {

    public static final String GET_EXISTENCIA_EN_TIENDA = "SELECT * FROM existenciasentiendas WHERE producto=?";
    public static final String NUEVA_CANTIDAD = "UPDATE existenciasentiendas SET cantidad = ? WHERE producto = ?";
    private static ArrayList<ExistenciaEnTienda> existencias = new ArrayList<>();
    private static final String CANTIDADLABEL = "cantidad";

    private ExistenciasEnTiendasDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener las {@link ExistenciaEnTienda} de un
     * {@link es.uva.blueManzana.negocio.modelo.Producto} de la base de datos,
     * se guardan en un {@link ArrayList}
     *
     * @param id del {@link es.uva.blueManzana.negocio.modelo.Producto}
     * @return existencias del
     * {@link es.uva.blueManzana.negocio.modelo.Producto}
     */
    public static List<ExistenciaEnTienda> getExistenciasTienda(int id) {

        DBConnection connection = DBConnection.getInstance();
        ResultSet result = null;
        connection.openConnection();
        try ( PreparedStatement s = connection.getStatement(GET_EXISTENCIA_EN_TIENDA);) {
            s.setInt(1, id);
            result = s.executeQuery();
            ExistenciaEnTienda existenciaTienda = null;
            existencias.clear();
            while (result.next()) {
                existenciaTienda = new ExistenciaEnTienda(result.getInt(CANTIDADLABEL), result.getInt("entienda"), result.getInt("producto"));
                existencias.add(existenciaTienda);
            }
        } catch (SQLException ex) {

            Logger.getLogger(ExistenciasEnTiendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExistenciasEnTiendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();
        return existencias;
    }

    /**
     * Funcion para obtener la cantidad de un
     * {@link es.uva.blueManzana.negocio.modelo.Producto} en una
     * {@link es.uva.blueManzana.negocio.modelo.Tienda} en la base de datos.
     *
     * @param id identificador del
     * {@link es.uva.blueManzana.negocio.modelo.Producto}
     * @return cantidad del {@link es.uva.blueManzana.negocio.modelo.Producto}
     */
    public static JsonObject getCantidad(int id) {
        JsonObject cant = null;
        DBConnection connection = DBConnection.getInstance();
        int cantidad = 0;
        ResultSet result = null;
        connection.openConnection();
        try ( PreparedStatement s = connection.getStatement(GET_EXISTENCIA_EN_TIENDA);) {
            s.setInt(1, id);
            result = s.executeQuery();
            if (result.next()) {
                cantidad = result.getInt(CANTIDADLABEL);
                cant = (JsonObject) Json.createObjectBuilder().add(CANTIDADLABEL, cantidad).build();
            }
        } catch (SQLException ex) {

            Logger.getLogger(ExistenciasEnTiendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExistenciasEnTiendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();
        return cant;
    }

    /**
     * Funcion para actualizar la cantidad de un
     * {@link es.uva.blueManzana.negocio.modelo.Producto} en una
     * {@link es.uva.blueManzana.negocio.modelo.Tienda} en la base de datos
     *
     * @param id identificador del
     * {@link es.uva.blueManzana.negocio.modelo.Producto}
     * @param cantidad del {@link es.uva.blueManzana.negocio.modelo.Producto}
     */
    public static void updateCantidad(int id, int cantidad) {
        DBConnection connection = DBConnection.getInstance();
        if (closeConnection) {
            connection.openConnection();
        }

        try ( PreparedStatement existencias = connection.getStatement(NUEVA_CANTIDAD);) {
            existencias.setInt(1, cantidad);
            existencias.setInt(2, id);
            existencias.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExistenciasEnTiendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (closeConnection) {
            connection.closeConnection();
        }

    }

    private static boolean closeConnection = true;
}
