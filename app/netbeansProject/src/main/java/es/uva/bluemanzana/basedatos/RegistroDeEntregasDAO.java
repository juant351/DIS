package es.uva.bluemanzana.basedatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla RegistroDeEntregas de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class RegistroDeEntregasDAO {

    public static final String NUEVO_REGISTRO = "INSERT INTO REGISTRODEENTREGAS (ID, FECHA, HORA, DNIQUIENFIRMA) VALUES (?, ?, ?, ?)";
    public static final String GET_ULTIMA_ID = "SELECT ID FROM REGISTRODEENTREGAS WHERE ID=(SELECT MAX(ID) FROM REGISTRODEENTREGAS)";

    private RegistroDeEntregasDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir un nuevo RegistroDeEntregas a la base de datos.
     *
     * @param id identificador del RegistroDeEntregas
     * @param fecha fecha en la que se crea el RegistroDeEntregas
     * @param hora hora en la que se crea el RegistroDeEntregas
     * @param nifFirmante dni/nif del empleado que recibe la entrega y confirma
     * el RegistroDeEntregas
     */
    public static void insert(int id, Date fecha, Time hora, String nifFirmante) {
        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        try ( PreparedStatement registro = connection.getStatement(NUEVO_REGISTRO);) {
            registro.setInt(1, id);
            registro.setDate(2, fecha);
            registro.setTime(3, hora);
            registro.setString(4, nifFirmante);
            registro.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDeEntregasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.closeConnection();

    }

    /**
     * Funcion para obtener el id identificador del ultimo RegistroDeEntregas
     * que se haya añadido a la base de datos. Para ello, se considera que el
     * ultimo RegistroDeEntregas es el que tiene el id con mayor valor, ya que
     * el id es de tipo {@link Integer}
     *
     * @return id del ultimo RegistroDeEntregas añadido a la base de datos
     */
    public static JsonObject getUltimaID() {
        JsonObject ult = null;
        DBConnection connection = DBConnection.getInstance();
        int id = -1;
        ResultSet result = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(GET_ULTIMA_ID);) {
            result = s.executeQuery();
            if (result.next()) {
                id = result.getInt("ID");
                ult = (JsonObject) Json.createObjectBuilder().add("id", id).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDeEntregasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistroDeEntregasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return ult;
    }

}
