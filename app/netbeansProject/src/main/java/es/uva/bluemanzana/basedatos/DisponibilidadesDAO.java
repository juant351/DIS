package es.uva.bluemanzana.basedatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para realizar consultas a la tabla
 * {@link es.uva.blueManzanaG12.negocio.Disponibilidades} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DisponibilidadesDAO {

    public static final String NUEVA_DISPONIBILIDAD = "INSERT INTO DISPONIBILIDADES (COMIENZO, FINALPREVISTO, EMPLEADO, DISPONIBILIDAD) VALUES (?, ?, ?, ?)";

    private DisponibilidadesDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir una nueva
     * {@link es.uva.blueManzanaG12.negocio.Disponibilidades} a la base de
     * datos.
     *
     * @param inicio tipo {@link Date}, periodo que comienza su disponibilidad.
     * @param finalPrevisto tipo {@link Date}, periodo en el que finaliza su
     * disponibilidad.
     * @param nif {@link String}, dni/nif del
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @param disponibilidad int, tipo de
     * {@link es.uva.blueManzanaG12.negocio.Disponibilidades}
     */
    public static void insert(Date inicio, Date finalPrevisto, String nif, int disponibilidad) {

        DBConnection connection = DBConnection.getInstance();
        if (closeConnection) {
            connection.openConnection();
        }

        try (PreparedStatement s = connection.getStatement(NUEVA_DISPONIBILIDAD);) {
            s.setDate(1, inicio);
            s.setDate(2, finalPrevisto);
            s.setString(3, nif);
            s.setInt(4, disponibilidad);
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
