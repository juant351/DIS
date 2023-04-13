package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir existencias que hay en las {@link Tienda} de un
 * {@link Producto}, que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class ExistenciaEnTienda {

    private int cantidad;
    private int tienda;
    private int producto;

    /**
     * Constructor, cuenta con la cantidad que hay de un {@link Producto}, el
     * identificador de la {@link Tienda} donde están esas existencias y el
     * identificador del {@link Producto} del que se tienen en cuenta las
     * existencias.
     *
     * @param cantidad
     * @param tienda
     * @param producto
     */
    public ExistenciaEnTienda(int cantidad, int tienda, int producto) {
        setCantidad(cantidad);
        setTienda(tienda);
        setProducto(producto);
    }

    /**
     * Funcion para obtener la cantidad de un {@link Producto} en
     * {@link ExistenciaEnTienda}
     *
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Funcion para obtener la cantidad de un {@link Producto} en
     * {@link ExistenciaEnTienda}
     *
     * @param cantidad
     * @throws IllegalArgumentException si la cantidad es nula
     */
    public void setCantidad(int cantidad) {
        if (cantidad == 0) {
            throw new IllegalArgumentException("La cantidad no puede ser nula");
        }
        this.cantidad = cantidad;
    }

    /**
     * Funcion para obtener el identificador de la {@link Tienda} de la
     * {@link ExistenciaEnTienda}
     *
     * @return tienda
     */
    public int getTienda() {
        return tienda;
    }

    /**
     * Funcion para asignar el identificador de la {@link Tienda} de la
     * {@link ExistenciaEnTienda}
     *
     * @param tienda
     * @throws IllegalArgumentException si el identificador es nulo
     */
    public void setTienda(int tienda) {
        if (tienda == 0) {
            throw new IllegalArgumentException("El identificador no puede ser nulo");
        }
        this.tienda = tienda;
    }

    /**
     * Funcion para obtener el identificador del {@link Producto} de
     * {@link ExistenciaEnTienda}
     *
     * @return producto
     */
    public int getProducto() {
        return producto;
    }

    /**
     * Funcion para asignar el identificador del {@link Producto} de
     * {@link ExistenciaEnTienda}
     *
     * @param producto
     * @throws IllegalArgumentException si el identificador es nulo
     */
    public void setProducto(int producto) {
        if (producto == 0) {
            throw new IllegalArgumentException("El identificador no puede ser nulo");
        }
        this.producto = producto;
    }

}
