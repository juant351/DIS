package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir los tipos de rol que hay en la empresa que se guardan en
 * la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class TiposDeRol {

    private int idTipo;
    private String nombreTipo;

    /**
     * Constructor para los tipos de rol, definidos por un identificador único y
     * un nombre.
     *
     * @param idTipo
     * @param nombreTipo
     */
    public TiposDeRol(int idTipo, String nombreTipo) {
        setIdTipo(idTipo);
        setNombreTipo(nombreTipo);
    }

    /**
     * Funcion para obtener el identifcador unico del {@link TiposDeRol}
     *
     * @return idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * Funcion para asignar el identifcador unico del {@link TiposDeRol}
     *
     * @param idTipo
     * @throws IllegalArgumentException si idTipo es nulo
     */
    public void setIdTipo(int idTipo) {
        if (idTipo == 0) {
            throw new IllegalArgumentException("No se permite id nulo");
        }
        this.idTipo = idTipo;
    }

    /**
     * Funcion para obtener el nombre del {@link TiposDeRol}
     *
     * @return nombreTipo
     */
    public String getNombreTipo() {
        return nombreTipo;
    }

    /**
     * Funcion para asignar el nombre del {@link TiposDeRol}
     *
     * @param nombreTipo
     * @throws IllegalArgumentException si nombreTipo es nulo/vacío.
     */
    public void setNombreTipo(String nombreTipo) {
        if (nombreTipo.isEmpty()) {
            throw new IllegalArgumentException("No se permite nombre nulo");
        }
        this.nombreTipo = nombreTipo;
    }

}
