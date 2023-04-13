package es.uva.bluemanzana.negocio.modelo;

import java.sql.Date;

/**
 * Clase para definir los productos que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private Date fechaDeCreacion;
    private int categoria;

    /**
     * Constructor de un producto, el cual cuenta con un identificador unico, un
     * nombre, un precio asignado, fecha en la que se crea y un identifcador de
     * {@link Categoria}.
     *
     * @param id
     * @param nombre
     * @param precio
     * @param fechaDeCreacion
     * @param categoria
     */
    public Producto(int id, String nombre, double precio, Date fechaDeCreacion, int categoria) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        setFechaDeCreacion(fechaDeCreacion);
        setCategoria(categoria);
    }

    /**
     * Funcion para obtener el identificador unico del {@link Producto}
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar el identificador unico del {@link Producto}
     *
     * @param id
     * @throws IllegalArgumentException si el id es nulo
     */
    public void setId(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("No permitido id nulo");
        }
        this.id = id;
    }

    /**
     * Funcion para obtener el nombre del {@link Producto}
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Funcion para asignar el nombre del {@link Producto}
     *
     * @param nombre
     * @throws IllegalArgumentException si el nombre es nulo/vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("No permitido nombre nulo");
        }
        this.nombre = nombre;
    }

    /**
     * Funcion para obtener el precio del {@link Producto}
     *
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Funcion para asignar el precio del {@link Producto}
     *
     * @param precio
     * @throws IllegalArgumentException si el precio es nulo
     */
    public void setPrecio(double precio) {
        if (precio == 0) {
            throw new IllegalArgumentException("No permitido precio nulo");
        }
        this.precio = precio;
    }

    /**
     * Funcion para obtener la {@link Date} fecha de creacion del
     * {@link Producto}
     *
     * @return fechaDeCreacion
     */
    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    /**
     * Funcion para asignar la {@link Date} fecha de creacion del
     * {@link Producto}
     *
     * @param fechaDeCreacion
     * @throws IllegalArgumentException si fechaDeCreacion es nula/vacía
     */
    public void setFechaDeCreacion(Date fechaDeCreacion) {
        if (fechaDeCreacion == null) {
            throw new IllegalArgumentException("No permitido fecha de creacion nula");
        }
        this.fechaDeCreacion = fechaDeCreacion;
    }

    /**
     * Función para obtener el identificador de la {@link Categoria} del
     * {@link Producto}
     *
     * @return categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Función para asignar el identificador de la {@link Categoria} del
     * {@link Producto}
     *
     * @param categoria
     * @throws IllegalArgumentException si categoria es nula
     */
    public void setCategoria(int categoria) {
        if (categoria == 0) {
            throw new IllegalArgumentException("No permitido id de categoria nulo");
        }
        this.categoria = categoria;
    }

}
