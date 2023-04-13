package es.uva.bluemanzana.basedatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla
 * {@link es.uva.blueManzanaG12.negocio.Empleado} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class EmpleadoDAO {

    public static final String NUEVO_EMPLEADO = "INSERT INTO EMPLEADOS (NIF, NUMEROSEGURIDADSOCIAL, IBAN, FECHAINICIOENEMPRESA, DIRECCIONPOSTAL, DESTINADOEN) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_NIF = "SELECT * FROM EMPLEADOS WHERE NIF=?";
    private static final String GET_DESTINO = "SELECT DESTINADOEN FROM EMPLEADOS WHERE NIF = ?";

    private EmpleadoDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para añadir un nuevo
     * {@link es.uva.blueManzanaG12.negocio.Empleado} a la base de datos.
     *
     * @param nif dni/nif del {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @param numSegSoc numero de la seguridad social del
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @param iban numero de cuenta bancaria del
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @param direccion direccion del
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @param destinadoEn lugar en el que está destinado el
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     */
    public static void insert(String nif, String numSegSoc, String iban, int direccion, int destinadoEn) {

        Date moment = Date.valueOf(LocalDate.now());

        DBConnection connection = DBConnection.getInstance();

        connection.openConnection();

        try ( PreparedStatement emp = connection.getStatement(NUEVO_EMPLEADO);) {
            emp.setString(1, nif);
            emp.setString(2, numSegSoc);
            emp.setString(3, iban);
            emp.setDate(4, moment);
            emp.setInt(5, direccion);
            emp.setInt(6, destinadoEn);
            emp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.closeConnection();

    }

    /**
     * Funcion para comprobar si un
     * {@link es.uva.blueManzanaG12.negocio.Empleado} está registrado en la base
     * de datos, a partir de su nif/dni.
     *
     * @param nif del {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @return true/false dependiendo si está en la base de datos el
     * {@link es.uva.blueManzanaG12.negocio.Empleado}
     */
    public static JsonObject noExiteNIF(String nif) {
        JsonObject respuestaJson = null;
        DBConnection connection = DBConnection.getInstance();
        boolean value = false;
        ResultSet result = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(SELECT_BY_NIF);) {
            s.setString(1, nif);
            result = s.executeQuery();
            if (result.next()) {
                value = true;
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("existe", value).build();
            } else {
                respuestaJson = (JsonObject) Json.createObjectBuilder().add("existe", value).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Funcion para obtener el destino de un
     * {@link es.uva.blueManzanaG12.negocio.Empleado} en la base de datos a
     * partir de su nif/dni
     *
     * @param nif del {@link es.uva.blueManzanaG12.negocio.Empleado}
     * @return destino del {@link es.uva.blueManzanaG12.negocio.Empleado}
     */
    public static JsonObject getDestinoByNIF(String nif) {
        JsonObject dest = null;
        DBConnection connection = DBConnection.getInstance();
        ResultSet result = null;

        connection.openConnection();

        try ( PreparedStatement s = connection.getStatement(GET_DESTINO);) {
            s.setString(1, nif);
            result = s.executeQuery();
            if (result.next()) {
                int destino = result.getInt("DESTINADOEN");
                dest = (JsonObject) Json.createObjectBuilder().add("destino", destino).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return dest;
    }

}
