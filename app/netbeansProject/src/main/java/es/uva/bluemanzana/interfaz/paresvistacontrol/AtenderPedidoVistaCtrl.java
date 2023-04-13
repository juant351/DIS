package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.app.BlueManzana;
import es.uva.bluemanzana.basedatos.PedidoDAO;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import es.uva.bluemanzana.negocio.controladores.AtenderPedidoController;

/**
 * Clase que implementa el controlador que maneja la interfaz cuando el usuario
 * realiza el caso de uso de Atender un pedido en tienda.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class AtenderPedidoVistaCtrl {

    private AtenderPedidoVista vista;
    private Usuario usuario;
    private AtenderPedidoController useCaseAtenderPedido;

    /**
     * Constructor del controlador, se crea con una interfaz asociada y el
     * {@link Usuario} que inició sesión.
     *
     * @param vista
     * @param usuario
     */
    public AtenderPedidoVistaCtrl(AtenderPedidoVista vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
        useCaseAtenderPedido = AtenderPedidoController.getController();
    }

    /**
     * Cuando el {@link Usuario} introduce un
     * id{@link es.uva.blueManzanaG12.negocio.modelo.Pedido#id} se comprueba si
     * ese id esta asociado a un {@link Pedido} en {@link Tienda} o si esta en
     * estado de reparto. Segun el caso, se muestra mensaje de error o se invoca
     * a la interfaz.
     */
    public void procesaBotonOk() {

        int idPedido = vista.getIdPedido();
        vista.ocultarMensaje();

        if (useCaseAtenderPedido.getNIFPedido(idPedido) != useCaseAtenderPedido.getDestinoEmpleado(usuario.getNif())) {
            vista.muestraError("noTienda");
        } else if (useCaseAtenderPedido.getEstadoPedido(idPedido) != 5) {
            vista.muestraError("noEnReparto");
        } else {
            vista.muestraPanelPedido(PedidoDAO.getPedido(idPedido));
        }
    }

    /**
     * Si el usuario ha pulsado el boton de volver, se invoca a la interfaz de
     * identificarse.
     */
    public void procesaBotonVolver() {
        BlueManzana.getStateMachine().abrirVistaIdentificarse(usuario);
    }

    /**
     * Funcion para obtener el nombre de un
     * {@link es.uva.blueManzanaG12.negocio.modelo.Producto} a partir de su
     * identificador.
     *
     * @param idProducto
     * @return llamada a un metodo que devuelve el nombre del
     * {@link es.uva.blueManzanaG12.negocio.modelo.Producto}
     */
    public String obtenerNombreProducto(int idProducto) {
        return useCaseAtenderPedido.obtenerNombreProducto(idProducto);
    }

    /**
     * Funcion para obtener el nombre de un
     * {@link es.uva.blueManzanaG12.negocio.modelo.Tienda} a partir de su
     * identificador.
     *
     * @param idTienda
     * @return llamada a un metodo que devuelve el nombre del
     * {@link es.uva.blueManzanaG12.negocio.modelo.Tienda}
     */
    public String obtenerNombreTienda(int idTienda) {
        return useCaseAtenderPedido.obtenerNombreTienda(idTienda);
    }

    /**
     * Funcion que llama al controlador para crear uno nuevo registro de entrega
     * del pedido.
     */
    public void crearRegistroEntrega() {
        useCaseAtenderPedido.crearRegistroEntrega(usuario);
    }

    /**
     * Funcion que llama al controlador para actualizar las existencias del
     * Producto en la Tienda.
     */
    public void actualizarExistencias(String nombreProducto, int cantidad) {
        useCaseAtenderPedido.actualizarExistencias(nombreProducto, cantidad);
    }

    /**
     * Funcion que llama al controlador para actualizar el estado del Pedido.
     */
    public void pedidoEntregado(int idPedido) {
        useCaseAtenderPedido.pedidoEntregado(idPedido);
    }

}
