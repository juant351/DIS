package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir categorias que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Categoria {

    private String id;
    private String nombre;

    /**
     * Constructor de {@link Categorias}, definido por un id identificador y un
     * nombre.
     *
     * @param id
     * @param nombre
     */
    public Categoria(String id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    /**
     * Funcion para obtener el id identificador de {@link Categorias}
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Funcion para establecer el id de {@link Categorias}
     *
     * @param id
     * @throws IllegalArgumentException si la id es nula/vacia
     */
    public void setId(String id) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Id vacia no admitida");
        }
        this.id = id;
    }

    /**
     * Funcion para obtener el nombre de {@link Categorias}
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Funcion para asignar un nombre a {@link Categorias}
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
