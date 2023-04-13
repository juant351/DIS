package es.uva.bluemanzana.basedatos;

import es.uva.bluemanzana.negocio.modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * Clase para realizar consultas a la tabla {@link Pedido} de la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class PedidoDAO {

    public static final String GET_PEDIDO = "SELECT * FROM PEDIDOSDESUMINISTRODEPRODUCTO WHERE ID= ?";
    public static final String NUEVO_ESTADO = "UPDATE pedidosdesuministrodeproducto SET estado = ? WHERE id = ?";

    private PedidoDAO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Funcion para obtener un {@link Pedido} de la base de datos a partir de su
     * id identificador
     *
     * @param id identificador del {@link Pedido}
     * @return pedido {@link Pedido}
     */
    public static JsonObject getPedido(int id) {
        JsonObject ped = null;
        DBConnection connection = DBConnection.getInstance();

        if (closeConnection) {
            connection.openConnection();
        }
        ResultSet result = null;
        try (PreparedStatement s = connection.getStatement(GET_PEDIDO);) {
            s.setInt(1, id);
            result = s.executeQuery();
            if (result.next()) {
                ped = (JsonObject) Json.createObjectBuilder().add("id", result.getInt("ID")).add("cantidad", result.getInt("CANTIDAD"))
                        .add("fecha", result.getDate("FECHA").toString()).add("estado", result.getInt("ESTADO")).add("producto", result.getInt("PRODUCTO"))
                        .add("solicitadoEn", result.getInt("SOLICITADOEN")).add("preparacion", result.getInt("PREPARACION")).build();

            }
        } catch (SQLException ex) {

            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (closeConnection) {
            connection.closeConnection();
        }
        return ped;
    }

    /**
     * Funcion para actualizar el estado de un {@link Pedido} a partir de su
     * idPedido identificador
     *
     * @param idPedido identificador del {@link Pedido}
     * @param estado estado nuevo que se le asigna al {@link Pedido}
     */
    public static void updateEstado(int idPedido, int estado) {
        DBConnection connection = DBConnection.getInstance();
        if (closeConnection) {
            connection.openConnection();
        }

        try (PreparedStatement pedido = connection.getStatement(NUEVO_ESTADO);) {
            pedido.setInt(2, idPedido);
            pedido.setInt(1, estado);
            pedido.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (closeConnection) {
            connection.closeConnection();
        }

    }

    private static boolean closeConnection = true;
}
