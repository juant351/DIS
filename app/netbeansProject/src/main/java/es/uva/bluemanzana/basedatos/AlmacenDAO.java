package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Almacen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para realizar consultas a la tabla de {@link Almacen} de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class AlmacenDAO {

    public static final String GET_ALL_ALMACENES = "SELECT * FROM ALMACENES";
    private static ArrayList<Almacen> almacenes = new ArrayList<>();

    private AlmacenDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener todos los {@link Almacen} de la base de datos en un
     * {@link ArrayList}.
     *
     * @return almacenes
     */
    public static List<Almacen> getAllAlmacenes() {
        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();
        ResultSet result = null;
        try ( PreparedStatement s = connection.getStatement(GET_ALL_ALMACENES);) {

            result = s.executeQuery();
            Almacen almacen = null;
            almacenes.clear();
            while (result.next()) {
                almacen = new Almacen(result.getInt("ID"), result.getInt("SUPERFICIE"));
                almacenes.add(almacen);

            }

        } catch (SQLException ex) {

            Logger.getLogger(AlmacenDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlmacenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        connection.closeConnection();

        return almacenes;
    }
}
