package es.uva.bluemanzana.basedatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla
 * {@link es.uva.blueManzanaG12.negocio.RolesEnEmpresa} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class RolEnEmpresaDAO {

    private static final boolean CLOSECONNECTION = true;
    private static final String INSERTA_ROL = "INSERT INTO ROLESENEMPRESA (COMIENZOENROL, EMPLEADO, ROL) VALUES (?, ?, ?)";
    public static final String OBTENER_ROL = "SELECT rol FROM Rolesenempresa WHERE empleado= ?";

    private RolEnEmpresaDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion encargada de crear un nuevo rol en empresa al registrar un nuevo
     * empleado.
     *
     * @param comienzo Comienzo en ese rol
     * @param nif Nif del empleado
     * @param rol Rol del empleado
     */
    public static void insert(Date comienzo, String nif, int rol) {

        DBConnection connection = DBConnection.getInstance();
        if (CLOSECONNECTION) {
            connection.openConnection();
        }

        try ( PreparedStatement emp = connection.getStatement(INSERTA_ROL);) {
            emp.setDate(1, comienzo);
            emp.setString(2, nif);
            emp.setInt(3, rol);
            emp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (CLOSECONNECTION) {
            connection.closeConnection();
        }

    }

    /**
     * Funcion para obtener el
     * {@link es.uva.blueManzanaG12.negocio.RolesEnEmpresa} de un
     * {@link es.uva.blueManzanaG12.negocio.Empleado} a partir de su nif/dni
     *
     * @param nif del {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @return rol {@link es.uva.blueManzanaG12.negocio.RolesEnEmpresa}
     */
    public static JsonObject obtenerRol(String nif) {
        JsonObject rol = null;
        DBConnection connection = DBConnection.getInstance();
        connection.openConnection();
        ResultSet rs = null;
        try (
                 PreparedStatement s = connection.getStatement(OBTENER_ROL);) {
            s.setString(1, nif);
            rs = s.executeQuery();
            int rolExt = -1;
            if (rs.next()) {
                rolExt = rs.getInt("rol");
                rol = (JsonObject) Json.createObjectBuilder().add("rol", rolExt).build();
            }
            connection.closeConnection();
            return rol;
        } catch (SQLException ex) {
            Logger.getLogger(RolEnEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RolEnEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
