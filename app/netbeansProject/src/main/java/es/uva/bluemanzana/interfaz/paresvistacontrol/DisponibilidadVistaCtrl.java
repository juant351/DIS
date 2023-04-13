package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.app.BlueManzana;
import es.uva.bluemanzana.negocio.modelo.Direccion;
import es.uva.bluemanzana.negocio.modelo.Producto;
import es.uva.bluemanzana.negocio.modelo.Tienda;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import es.uva.bluemanzana.negocio.controladores.DisponibilidadController;

/**
 * Clase que implementa el controlador de la interfaz del caso de uso Comprobar
 * disponibilidad de un producto.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DisponibilidadVistaCtrl {

    private Usuario usuario;
    private DisponibilidadVista vista;
    static final int NUMERO_PRODUCTOS_MINIMOS = 5;
    private DisponibilidadController useCaseDisponibilidad;

    /**
     * Constructor de la interfaz, a partir de la vista asociada y el usuario
     * que ha iniciado sesión.
     *
     * @param vista
     * @param usuario
     */
    public DisponibilidadVistaCtrl(DisponibilidadVista vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
        this.useCaseDisponibilidad = DisponibilidadController.getController();
    }

    /**
     * Funcion que cuando el usuario introduce un {@link Producto#id}, muestra
     * la informacion del {@link Producto}
     */
    public void procesarConsultaProducto() {
        boolean existe = false;
        try {
            int id = Integer.parseInt(vista.getIdProducto());
            existe = useCaseDisponibilidad.existeProducto(id);
            //Consulta producto en base de datos
            if (!existe) {
                vista.setMensajeError("El producto no se encuentra en la base de datos");

            } else {
                Producto producto = useCaseDisponibilidad.getProducto(id);
                String nombreCategoria = useCaseDisponibilidad.getCategoria(producto);
                String[] nombreTiendas = useCaseDisponibilidad.getNombreTiendas(id);
                //Mostrar en vista
                vista.setPanelPrincipalVisible(false);
                vista.setIdProducto(Integer.toString(producto.getId()));
                vista.setNombreProducto(producto.getNombre());
                vista.setCategoriaProducto(nombreCategoria);
                vista.setListaTiendas(nombreTiendas);
                vista.setPanelProductoVisible(true);
            }
        } catch (NumberFormatException e) {
            vista.setMensajeError("Debe introducir un id valido");
        }

    }

    /**
     * Funcion que cuando el usuario introduce un {@link Producto#id}, muestra
     * la informacion del {@link Producto}
     */
    public void procesarCancelarProducto() {
        vista.setPanelPrincipalVisible(true);
        vista.setPanelProductoVisible(false);
        vista.setPanelTiendasVisible(false);
    }

    /**
     * Funcion que cuando el usuario pulsa el boton de cancelar en el panel
     * principal, cambia la interfaz mostrada al usuario y muestra la de
     * identificarse
     */
    public void procesarCancelarTienda() {
        BlueManzana.getStateMachine().abrirVistaIdentificarse(usuario);
    }

    /**
     * Funcion que muestra la informacion de tienda que tengan disponible el
     * producto, o error en caso contrario.
     */
    public void procesarTienda() {
        String tiendaNombre = vista.getTiendaSelected();
        try {
            Tienda tienda = useCaseDisponibilidad.getTienda(tiendaNombre);
            int id = tienda.getId();
            int cantidad = useCaseDisponibilidad.getCantidad(id);
            if (cantidad < NUMERO_PRODUCTOS_MINIMOS) {
                vista.setMensajeError("Esta tienda no tiene la cantidas suficiente de productos");
            } else {
                Direccion direccion = useCaseDisponibilidad.getDireccion(id);
                String telefono = useCaseDisponibilidad.getTelefono(id);
                //Mostrar en vista
                vista.setNombreTienda(tiendaNombre);
                vista.setIdTienda(Integer.toString(id));
                vista.setDireccionTienda(direccion.toString());
                vista.setTelefonoTienda(telefono);
                vista.setPanelTiendasVisible(true);
            }
        } catch (Exception e) {
            vista.setMensajeError("No has seleccionado tienda");
        }

    }
}
