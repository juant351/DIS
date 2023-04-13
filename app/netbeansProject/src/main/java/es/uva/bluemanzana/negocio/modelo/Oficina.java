package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir las oficinas que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Oficina {

    private int id;
    private String otrasIndicaciones;

    /**
     * Constructor de una oficina, cuenta con un identificador único y otras
     * indicaciones a tener en cuenta
     *
     * @param id
     * @param otrasIndicaciones
     */
    public Oficina(int id, String otrasIndicaciones) {
        setId(id);
        setOtrasIndicaciones(otrasIndicaciones);
    }

    /**
     * Funcion para obtener el identificador de una {@link Oficina}
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar el identificador de una {@link Oficina}
     *
     * @param id
     * @throws IllegalArgumentException si el id es nulo.
     */
    public void setId(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("No se permite id nulo");
        }
        this.id = id;
    }

    /**
     * Funcion para obtener una descripcion de otras indicaciones a tener en
     * cuenta de la {@link Oficina}
     *
     * @return otrasIndicaciones
     */
    public String getOtrasIndicaciones() {
        return otrasIndicaciones;
    }

    /**
     * Funcion para asignar una descripcion de otras indicaciones a tener en
     * cuenta de la {@link Oficina}
     *
     * @param otrasIndicaciones
     * @throws IllegalArgumentException si las indicaciones son nulas, es decir
     * están vacías.
     */
    public void setOtrasIndicaciones(String otrasIndicaciones) {
        if (otrasIndicaciones.isEmpty()) {
            throw new IllegalArgumentException("No se permite indicaciones nulas");
        }
        this.otrasIndicaciones = otrasIndicaciones;
    }

}
