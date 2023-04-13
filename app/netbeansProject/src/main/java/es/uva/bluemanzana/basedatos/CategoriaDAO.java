package es.uva.bluemanzana.basedatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla de
 * {@link es.uva.blueManzanaG12.negocio.Categoria} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class CategoriaDAO {

    public static final String OBTENER_NOMBRE_CATEGORIA = "SELECT nombre FROM Categorias WHERE id=?";

    private CategoriaDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener el nombre de una categoria partiendo de un
     * identificador asociado a dicha categoria.
     *
     * @param id de la categoria
     * @return nombre de la categoria
     */
    public static JsonObject getNombreCategoria(int id) {
        JsonObject nomb = null;
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        ResultSet rs = null;
        try (PreparedStatement s = connection.getStatement(OBTENER_NOMBRE_CATEGORIA);) {
            s.setInt(1, id);
            rs = s.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                nomb = (JsonObject) Json.createObjectBuilder().add("nombre", nombre).build();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();
        return nomb;
    }
}
