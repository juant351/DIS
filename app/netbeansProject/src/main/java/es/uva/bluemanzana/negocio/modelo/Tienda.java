package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir las tiendas de la empresa que se guardan en la base de
 * datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Tienda {

    private int id;
    private String nombreIdentificativo;

    /**
     * Constructor para una tienda, la cual está formada por un identificador
     * único y un nombre identificativo.
     *
     * @param id
     * @param nombreIdentificativo
     */
    public Tienda(int id, String nombreIdentificativo) {
        setId(id);
        setNombreIdentificativo(nombreIdentificativo);
    }

    /**
     * Funcion para obtener el identificador de la {@link Tienda}
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion para asignar el identificador de la {@link Tienda}
     *
     * @param id
     * @throws IllegalArgumentException si id es nulo
     */
    public void setId(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("No permitido id nulo.");
        }
        this.id = id;
    }

    /**
     * Funcion para obtener el nombre identificativo de la {@link Tienda}
     *
     * @return nombreIdentificativo
     */
    public String getNombreIdentificativo() {
        return nombreIdentificativo;
    }

    /**
     * Funcion para asignar el nombre identificativo de la {@link Tienda}
     *
     * @param nombreIdentificativo
     * @throws IllegalArgumentException si el nombre_identificativo es
     * nulo/vacío.
     */
    public void setNombreIdentificativo(String nombreIdentificativo) {
        if (nombreIdentificativo.isEmpty()) {
            throw new IllegalArgumentException("No permitido nombre vacío.");
        }
        this.nombreIdentificativo = nombreIdentificativo;
    }

}
