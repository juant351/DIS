package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Oficina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para realizar consultas a la tabla {@link Oficina} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class OficinaDAO {

    public static final String GET_ALL_OFICINAS = "SELECT * FROM OFICINAS";
    private static ArrayList<Oficina> oficinas = new ArrayList<>();

    private OficinaDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener todas las {@link Oficina} de la base de datos,
     * guardandose en un {@link ArrayList}
     *
     * @return oficinas {@link Oficina} de la base de datos.
     */
    public static List<Oficina> getAllOficinas() {
        DBConnection connection = DBConnection.getInstance();

        if (closeConnection) {
            connection.openConnection();
        }
        ResultSet result = null;
        try ( PreparedStatement s = connection.getStatement(GET_ALL_OFICINAS);) {

            result = s.executeQuery();
            Oficina oficina = null;
            oficinas.clear();
            while (result.next()) {
                oficina = new Oficina(result.getInt("ID"), result.getString("OTRASINDICACIONESDEZONA"));
                oficinas.add(oficina);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (closeConnection) {
            connection.closeConnection();
        }
        return oficinas;
    }

    private static boolean closeConnection = true;
}
