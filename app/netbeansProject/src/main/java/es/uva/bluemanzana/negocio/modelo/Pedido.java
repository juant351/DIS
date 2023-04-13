package es.uva.bluemanzana.negocio.modelo;

import java.sql.Date;

/**
 * Clase para definir los pedidos que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Pedido {

    private int id;
    private int cantidad;
    private Date fecha;
    private int idEstado;
    private int idProducto;
    private int idTienda;
    private int idPrepPedido;

    /**
     * Constructor de un pedido, cuenta con un identificador unico, una cantidad
     * del {@link Producto}, la fecha de en la que se ha realizado, un
     * identificador del estado del pedido, un identificador del
     * {@link Producto}, un identificador de la {@link Tienda} y un
     * identificador de la preparacion del pedido asignada.
     *
     * @param id
     * @param cantidad
     * @param fecha
     * @param idEstado
     * @param idProducto
     * @param idTienda
     * @param idPrepPedido
     */
    public Pedido(int id, int cantidad, Date fecha, int idEstado, int idProducto, int idTienda, int idPrepPedido) {
        setId(id);
        setCantidad(cantidad);
        setFecha(fecha);
        setIdEstado(idEstado);
        setIdProducto(idProducto);
        setIdTienda(idTienda);
        setIdPrepPedido(idPrepPedido);
    }

    /**
     * Funcion para obtener el identificador de un {@link Pedido}
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar el identificador de un {@link Pedido}, que debe ser
     * único
     *
     * @param id
     * @throws IllegalArgumentException si el id es nulo.
     */
    public void setId(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("No permitido id nulo.");
        }
        this.id = id;
    }

    /**
     * Funcion para obtener la cantidad del {@link Producto} asignada para el
     * {@link Pedido}
     *
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Funcion para asignar la cantidad del {@link Producto} asignada para el
     * {@link Pedido}
     *
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Funcion para obtener la fecha en la que se realiza el {@link Pedido}
     *
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Funcion para asignar la fecha en la que se realiza el {@link Pedido}
     *
     * @param fecha
     * @throws IllegalArgumentException si la fecha es nula/vacía.
     */
    public void setFecha(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha vacia no permitida");
        }
        this.fecha = fecha;
    }

    /**
     * Funcion para obtener el identificador del estado del {@link Pedido}
     *
     * @return idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Funcion para asignar el identificador id_estado del estado del
     * {@link Pedido}
     *
     * @param idEstado
     * @throws IllegalArgumentException si el id_estado es nulo
     */
    public void setIdEstado(int idEstado) {
        if (idEstado == 0) {
            throw new IllegalArgumentException("No permitido id del estado nulo.");
        }
        this.idEstado = idEstado;
    }

    /**
     * Funcion para obtener el identificador del {@link Producto} del
     * {@link Pedido}
     *
     * @return id_producto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Funcion para asignar el identificador del {@link Producto} del
     * {@link Pedido}
     *
     * @param idProducto
     * @throws IllegalArgumentException si el id_producto es nulo
     */
    public void setIdProducto(int idProducto) {
        if (idProducto == 0) {
            throw new IllegalArgumentException("No permitido id del producto nulo.");
        }
        this.idProducto = idProducto;
    }

    /**
     * Funcion para obtener el identificador de la {@link Tienda} del
     * {@link Pedido}
     *
     * @return idTienda
     */
    public int getIdTienda() {
        return idTienda;
    }

    /**
     * Funcion para asignar el identificador de la {@link Tienda} del
     * {@link Pedido}
     *
     * @param idTienda
     * @throws IllegalArgumentException si id_tienda es nulo
     */
    public void setIdTienda(int idTienda) {
        if (idTienda == 0) {
            throw new IllegalArgumentException("No permitido id de la tienda nulo.");
        }
        this.idTienda = idTienda;
    }

    /**
     * Funcion para obtener el identificador de la preparacion del
     * {@link Pedido}
     *
     * @return id_prepPedido
     */
    public int getIdPrepPedido() {
        return idPrepPedido;
    }

    /**
     * Funcion para asignar el identificador de la preparacion del
     * {@link Pedido}
     *
     * @param idPrepPedido
     * @throws IllegalArgumentException si id_prepPedido es nulo.
     */
    public void setIdPrepPedido(int idPrepPedido) {
        if (idPrepPedido == 0) {
            throw new IllegalArgumentException("No permitido id del pedido nulo.");
        }
        this.idPrepPedido = idPrepPedido;
    }

}
