package es.uva.bluemanzana.negocio.modelo;

import java.sql.Date;

/**
 * Clase para definir las vinculaciones con la empresa que se guardan en la base
 * de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class VinculacionesConLaEmpresa {

    private Date inicio;
    private String empleado;
    private int vinculo;

    /**
     * Constructor de vinculaciones con la empresa de un {@link Empleado},
     * formada por una {@link Date} fecha de inicio de vinculacion, un
     * {@link Empleado} asociado y un identificador para el tipo de vínculo
     *
     * @param inicio
     * @param empleado
     * @param vinculo
     */
    public VinculacionesConLaEmpresa(Date inicio, String empleado, int vinculo) {
        setInicio(inicio);
        setEmpleado(empleado);
        setVinculo(vinculo);
    }

    /**
     * Funcion para obtener la {@link Date} de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @return inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * Funcion para asignar la {@link Date} de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @param inicio
     * @throws IllegalArgumentException si la fecha inicio es nula/vacía.
     */
    public void setInicio(Date inicio) {
        if (inicio == null) {
            throw new IllegalArgumentException("Fecha de comienzo vacia no admitida");
        }
        this.inicio = inicio;
    }

    /**
     * Funcion para obtener el {@link Empleado} de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @return empleado
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Funcion para asignar el {@link Empleado} de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @param empleado
     * @throws IllegalArgumentException si empleado es nulo.
     */
    public void setEmpleado(String empleado) {
        if (empleado.isEmpty()) {
            throw new IllegalArgumentException("No se permite nif empleado nulo");
        }
        this.empleado = empleado;
    }

    /**
     * Funcion para obtener el identificador del tipo de vinculo de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @return vinculo
     */
    public int getVinculo() {
        return vinculo;
    }

    /**
     * Funcion para asignar el identificador del tipo de vinculo de la
     * {@link VinculacionesConLaEmpresa}
     *
     * @param vinculo
     * @throws IllegalArgumentException si el identificador vinculo es nulo.
     */
    public void setVinculo(int vinculo) {
        if (vinculo == 0) {
            throw new IllegalArgumentException("No se permite identificador de vinculo nulo");
        }
        this.vinculo = vinculo;
    }
}
