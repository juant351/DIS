package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir destinos que se guardan en la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Destino {

    private int id;
    private String telefono;
    private Direccion direccion;

    /**
     * Constructor de {@link Destino}, cuenta con un id identificador, un
     * telefono y una direccion
     *
     * @param id
     * @param telefono
     * @param direccion
     */
    public Destino(int id, String telefono, Direccion direccion) {
        setId(id);
        setTelefono(telefono);
        setDireccion(direccion);
    }

    /**
     * Funcion para obtener el id identificador de {@link Destino}
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar un id identificador a un {@link Destino}
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
     * Funcion para obtener el telefono de un {@link Destino}
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Funcion para asignar un telefono a un {@link Destino}
     *
     * @param telefono
     * @throws IllegalArgumentException si el telefono es nulo
     */
    public void setTelefono(String telefono) {
        if (telefono == null) {
            throw new IllegalArgumentException("No permitido telefono nulo");
        }
        this.telefono = telefono;
    }

    /**
     * Funcion para obtener la {@link Direccion} de un {@link Destino}
     *
     * @return direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Funcion para asignar una {@link Direccion} a un {@link Destino}
     *
     * @param direccion
     * @throws IllegalArgumentException si la {@link Direccion} es nula
     */
    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException("No permitido direccion nula");
        }
        this.direccion = direccion;
    }

}
