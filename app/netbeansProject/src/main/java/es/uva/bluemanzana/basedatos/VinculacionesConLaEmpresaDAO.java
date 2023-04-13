package es.uva.bluemanzana.basedatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para realizar consultas a la tabla
 * {@link es.uva.blueManzanaG12.negocio.VinculacionesConLaEmpresa} de la base de
 * datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class VinculacionesConLaEmpresaDAO {

    public static final String NUEVA_VINCULACION = "INSERT INTO VINCULACIONESCONLAEMPRESA (INICIO, EMPLEADO, VINCULO) VALUES (?, ?, ?)";

    private VinculacionesConLaEmpresaDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir una
     * {@link es.uva.blueManzanaG12.negocio.VinculacionesConLaEmpresa} a la base
     * de datos.
     *
     * @param inicio de la
     * {@link es.uva.blueManzanaG12.negocio.VinculacionesConLaEmpresa}, tipo
     * {@link Date}
     * @param nif nif/dni del {@link es.uva.blueManzanaG12.negocio.Empleado} de
     * la {@link es.uva.blueManzanaG12.negocio.VinculacionesConLaEmpresa}
     * @param vinculo tipo de vinculo del
     * {@link es.uva.blueManzanaG12.negocio.Empleado} con la empresa
     */
    public static void insert(Date inicio, String nif, int vinculo) {

        DBConnection connection = DBConnection.getInstance();
        if (closeConnection) {
            connection.openConnection();
        }

        try (PreparedStatement s = connection.getStatement(NUEVA_VINCULACION);) {
            s.setDate(1, inicio);
            s.setString(2, nif);
            s.setInt(3, vinculo);
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VinculacionesConLaEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (closeConnection) {
            connection.closeConnection();
        }
    }
    private static boolean closeConnection = true;
}
