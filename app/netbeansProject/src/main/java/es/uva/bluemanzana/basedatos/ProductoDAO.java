package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla {@link Producto} de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class ProductoDAO {

    public static final String GET_PRODUCTO_BY_ID = "SELECT * FROM PRODUCTOS WHERE ID= ?";
    public static final String GET_PRODUCTO_BY_NAME = "SELECT * FROM PRODUCTOS WHERE NOMBRE= ?";

    private ProductoDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para comprobar si un {@link Producto} está presente en la base de
     * datos a partir de su id identificador
     *
     * @param id del {@link Producto}
     * @return true/false dependiendo de si está o no almacenado en objeto Json.
     */
    public static JsonObject existeProducto(int id) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();
        boolean existe = false;
        connection.openConnection();
        ResultSet rs = null;
        try ( PreparedStatement s = connection.getStatement(GET_PRODUCTO_BY_ID);) {
            s.setInt(1, id);
            rs = s.executeQuery();
            existe = rs.next();
            respuestaJson = (JsonObject) Json.createObjectBuilder().add("existe", existe).build();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            respuestaJson = (JsonObject) Json.createObjectBuilder().add("existe", existe).build();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();
        return respuestaJson;
    }

    /**
     * Funcion para obtener un {@link Producto} de la base de datos a partir de
     * su id identificador.
     *
     * @param id del {@link Producto}
     * @return respuestaJson que contiene {@link Producto}
     */
    public static JsonObject getProductoById(int id) {
        JsonObject resJson = null;
        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        ResultSet rslt = null;
        try ( PreparedStatement s = connection.getStatement(GET_PRODUCTO_BY_ID);) {
            s.setInt(1, id);
            rslt = s.executeQuery();
            if (rslt.next()) {
                resJson = (JsonObject) Json.createObjectBuilder().add("id", rslt.getInt("ID"))
                        .add("nombre", rslt.getString("NOMBRE")).add("precio", rslt.getDouble("PRECIO"))
                        .add("fecha", rslt.getDate("FECHADECREACION").toString()).add("categoria", rslt.getInt("CATEGORIA")).build();
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rslt != null) {
                    rslt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return resJson;
    }

    /**
     * Funcion para obtener un {@link Producto} de la base de datos a partir de
     * su nombre.
     *
     * @param nombre del {@link Producto}
     * @return producto {@link Producto}
     */
    public static JsonObject getProductoByName(String nombre) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();
        ResultSet result = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(GET_PRODUCTO_BY_NAME);) {
            s.setString(1, nombre);
            result = s.executeQuery();
            if (result.next()) {
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("id", result.getInt("ID"))
                        .add("nombre", result.getString("NOMBRE")).add("precio", result.getDouble("PRECIO"))
                        .add("fecha", result.getDate("FECHADECREACION").toString()).add("categoria", result.getInt("CATEGORIA")).build();

            }
        } catch (SQLException ex) {

            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return respuestaJson;
    }

}
