package es.uva.bluemanzana.negocio.controladores;

import es.uva.bluemanzana.basedatos.EmpleadoDAO;
import es.uva.bluemanzana.basedatos.ExistenciasEnTiendasDAO;
import es.uva.bluemanzana.basedatos.PedidoDAO;
import es.uva.bluemanzana.basedatos.ProductoDAO;
import es.uva.bluemanzana.basedatos.RegistroDeEntregasDAO;
import es.uva.bluemanzana.basedatos.TiendaDAO;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase controlador para el caso de uso Recepcion en tienda fisica de un pedido
 * de suministro de producto
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class AtenderPedidoController {

    /**
     * Funcion para obtener un nuevo {@link AtenderPedidoController}
     *
     * @return AtenderPedidoController
     */
    public static AtenderPedidoController getController() {
        return new AtenderPedidoController();
    }

    /**
     * Funcion para obtener el
     * {@link es.uva.bluemanzana.negocio.modelo.Producto#nombre} a partir de su
     * {@link es.uva.bluemanzana.negocio.modelo.Producto#id} para ello se usa {@link ProductoDAO#getProductoById(int)
     * }
     *
     * @param idProducto identificador del
     * {@link es.uva.bluemanzana.negocio.modelo.Producto}
     * @return nombre del {@link es.uva.bluemanzana.negocio.modelo.Producto}
     */
    public String obtenerNombreProducto(int idProducto) {
        return ProductoDAO.getProductoById(idProducto).getString("nombre");
    }

    /**
     * Funcion para obtener el
     * {@link es.uva.bluemanzana.negocio.modelo.Tienda#nombreIdentificativo} a
     * partir de su {@link es.uva.bluemanzana.negocio.modelo.Tienda#id} para
     * ello se usa {@link TiendaDAO#getTienda(int, java.lang.String) }
     *
     * @param idTienda identificador de la
     * {@link es.uva.bluemanzana.negocio.modelo.Tienda}
     * @return nombre de la {@link es.uva.bluemanzana.negocio.modelo.Tienda}
     */
    public String obtenerNombreTienda(int idTienda) {
        return TiendaDAO.getTienda(idTienda, null).getString("nombre");
    }

    /**
     * Funcion para crear un nuevo registro de entrega de pedido, para ello se
     * usa el {@link Usuario} que ha inicado sesion y se llama a {@link RegistroDeEntregasDAO#insert(int, java.sql.Date, java.sql.Time, java.lang.String)
     * }
     *
     * @param usuario
     */
    public void crearRegistroEntrega(Usuario usuario) {
        int id = RegistroDeEntregasDAO.getUltimaID().getInt("id") + 1;
        Date fecha = Date.valueOf(LocalDate.now());
        Time hora = Time.valueOf(LocalTime.now());
        RegistroDeEntregasDAO.insert(id, fecha, hora, usuario.getNif());
    }

    /**
     * Funcion para actualizar
     * {@link es.uva.bluemanzana.negocio.modelo.ExistenciaEnTienda}, para ello
     * se tiene en cuenta el
     * {@link es.uva.bluemanzana.negocio.modelo.Producto#nombre} y la cantidad
     * que se va a añadir. La funcion usa {@link ExistenciasEnTiendasDAO#updateCantidad(int, int)
     * } para actualizar las existencias.
     *
     * @param nombreProducto
     * @param cantidad
     */
    public void actualizarExistencias(String nombreProducto, int cantidad) {
        int idProducto = ProductoDAO.getProductoByName(nombreProducto).getInt("id");
        int cantidadActu = ExistenciasEnTiendasDAO.getCantidad(idProducto).getInt("cantidad");
        ExistenciasEnTiendasDAO.updateCantidad(idProducto, cantidadActu + cantidad);
    }

    /**
     * Funcion para actualizar el
     * {@link es.uva.bluemanzana.negocio.modelo.Pedido#idEstado} del
     * {@link es.uva.bluemanzana.negocio.modelo.Pedido} a partir de su
     * {@link es.uva.bluemanzana.negocio.modelo.Pedido#id} Para ello se llama a {@link PedidoDAO#updateEstado(int, int)
     * }
     *
     * @param idPedido
     */
    public void pedidoEntregado(int idPedido) {
        PedidoDAO.updateEstado(idPedido, 6);
    }

    /**
     * Funcion para obtener el nif del firmante del pedido.
     *
     * @param idPedido
     * @return nif
     */
    public int getNIFPedido(int idPedido) {
        return PedidoDAO.getPedido(idPedido).getInt("id");
    }

    /**
     * Funcion para obtener el
     * {@link es.uva.bluemanzana.negocio.modelo.Empleado#destinadoEn} a partir
     * de su {@link es.uva.bluemanzana.negocio.modelo.Empleado#nif} La funcion
     * llama a {@link EmpleadoDAO#get_destino_byNIF(java.lang.String) }
     *
     * @param id
     * @return destino del empleado
     */
    public int getDestinoEmpleado(String id) {
        return EmpleadoDAO.getDestinoByNIF(id).getInt("destino");
    }

    /**
     * Funcion para obtener
     * {@link es.uva.bluemanzana.negocio.modelo.Pedido#idEstado} a partir de su
     * {@link es.uva.bluemanzana.negocio.modelo.Pedido#id} La funcion llama a {@link PedidoDAO#getPedido(int)
     * }
     *
     * @param idPedido
     * @return el estado del pedido
     */
    public int getEstadoPedido(int idPedido) {
        return PedidoDAO.getPedido(idPedido).getInt("estado");
    }
}
