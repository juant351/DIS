package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir almecenes que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Almacen {

    private int id;
    private int superficie;

    /**
     * Constructor de un almacen
     *
     * @param id
     * @param superficie en m2 del almacen
     */
    public Almacen(int id, int superficie) {
        setId(id);
        setSuperficie(superficie);
    }

    /**
     * Funcion para obtener el id identificador de un {@link Almacen}
     *
     * @return id del {@link Almacen}
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar un id identificador a un {@link Almacen}
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
     * Funcion para obtener la superficie (m2) de un {@link Almacen}
     *
     * @return superficie
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * Funcion para establecer la superficie de un {@link Almacen}
     *
     * @param superficie
     * @throws IllegalArgumentException si la superficie es nula
     */
    public void setSuperficie(int superficie) {
        if (superficie == 0) {
            throw new IllegalArgumentException("No permitido superficie nula");
        }
        this.superficie = superficie;
    }

}
