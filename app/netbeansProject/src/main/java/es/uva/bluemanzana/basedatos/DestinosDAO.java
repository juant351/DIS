package es.uva.bluemanzana.basedatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla
 * {@link es.uva.blueManzanaG12.negocio.Destino} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DestinosDAO {

    public static final String GET_TELEFONO = "SELECT telefono FROM destinos WHERE id=?";

    private DestinosDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener el telefono de un
     * {@link es.uva.blueManzanaG12.negocio.Destino} a partir de su
     * identificador id
     *
     * @param id identificador del {@link es.uva.blueManzanaG12.negocio.Destino}
     * @return telefono del {@link es.uva.blueManzanaG12.negocio.Destino}
     */
    public static JsonObject getTelefono(int id) {
        JsonObject tlf = null;
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        ResultSet rs = null;
        try (PreparedStatement s = connection.getStatement(GET_TELEFONO)) {
            s.setInt(1, id);
            rs = s.executeQuery();
            if (rs.next()) {
                String telefono = rs.getString("Telefono");
                tlf = (JsonObject) Json.createObjectBuilder().add("telefono", telefono).build();
            }
        } catch (SQLException e) {
            Logger.getLogger(DestinosDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DestinosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        connection.closeConnection();
        return tlf;
    }
}
