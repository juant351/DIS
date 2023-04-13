package es.uva.bluemanzana.negocio.modelo;

import java.sql.Date;

/**
 * Clase para definir disponibilidades que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Disponibilidades {

    private Date comienzo;
    private Date finalPrevisto;
    private String empleado;
    private int disponibilidad;

    /**
     * Constructor de disponibilidades, cuenta con una fecha de comienzo, una
     * fecha de final previsto, un empleado asociado y un identificador de tipo
     * de disponibilidad
     *
     * @param comienzo
     * @param finalPrevisto
     * @param empleado
     * @param disponibilidad
     */
    public Disponibilidades(Date comienzo, Date finalPrevisto, String empleado, int disponibilidad) {
        setComienzo(comienzo);
        setFinalPrevisto(finalPrevisto);
        setEmpleado(empleado);
        setDisponibilidad(disponibilidad);
    }

    /**
     * Funcion para obtener la fecha de comienzo de una {@link Disponibilidades}
     *
     * @return comienzo
     */
    public Date getComienzo() {
        return comienzo;
    }

    /**
     * Funcion para establecer una fecha de comienzo a un
     * {@link Disponibilidades}
     *
     * @param comienzo
     * @throws IllegalArgumentException si la fecha es nula
     */
    public void setComienzo(Date comienzo) {
        if (comienzo.toString().isEmpty()) {
            throw new IllegalArgumentException("No se permite comiezo nulo");
        }
        this.comienzo = comienzo;
    }

    /**
     * Funcion para obtener la fecha de final previsto de la
     * {@link Disponibilidades}
     *
     * @return finalPrevisto
     */
    public Date getFinalPrevisto() {
        return finalPrevisto;
    }

    /**
     * Funcion para establecer la fecha del final previsto para una
     * {@link Disponibilidades}
     *
     * @param finalPrevisto
     */
    public void setFinalPrevisto(Date finalPrevisto) {
        this.finalPrevisto = finalPrevisto;
    }

    /**
     * Funcion para obtener el {@link Empleado} asociado a la
     * {@link Disponibilidades}
     *
     * @return empleado
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Funcion para establacer el {@link Empleado} de una
     * {@link Disponibilidades} a partir de su nif/dni.
     *
     * @param empleado
     * @throws IllegalArgumentException si el nif/dni del {@link Empleado} es
     * nulo.
     */
    public void setEmpleado(String empleado) {
        if (empleado.isEmpty()) {
            throw new IllegalArgumentException("No se permite nif empleado nulo");
        }
        this.empleado = empleado;
    }

    /**
     * Funcion para obtener el identificador del tipo de disponibilidad de
     * {@link Disponibilidades}
     *
     * @return disponibilidad
     */
    public int getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Funcion para establecer el identificador de tipo de disponibilidad de
     * {@link Disponibilidades}
     *
     * @param disponibilidad
     * @throws IllegalArgumentException si el identificador es nulo
     */
    public void setDisponibilidad(int disponibilidad) {
        if (disponibilidad == 0) {
            throw new IllegalArgumentException("No se permite disponibilidad nula");
        }
        this.disponibilidad = disponibilidad;
    }

}
