package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir direcciones que se guardan en la base de datos.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Direccion {

    private int identificador;
    private String calle;
    private int numero;
    private String otros;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    public Direccion(int identificador, String calle, int numero, String otros, int codigoPostal, String localidad, String provincia) {
        setIdentificador(identificador);
        setCalle(calle);
        setNumero(numero);
        setOtros(otros);
        setCodigoPostal(codigoPostal);
        setLocalidad(localidad);
        setProvincia(provincia);
    }

    /**
     * Funcion para obtener el identificador de una {@link Direccion}
     *
     * @return identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Funcion para asignar un id identificador a una {@link Direccion}
     *
     * @param identificador
     * @throws IllegalArgumentException si el identificador es nulo
     */
    public void setIdentificador(int identificador) {
        if (identificador == 0) {
            throw new IllegalArgumentException("El identificador no puede ser 0");
        }
        this.identificador = identificador;
    }

    /**
     * Funcion para obtener la calle de una {@link Direccion}
     *
     * @return calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Funcion para asignar la calle de una {@link Direccion}
     *
     * @param calle
     * @throws IllegalArgumentException si la calle es nula.
     */
    public void setCalle(String calle) {
        if (calle == null) {
            throw new IllegalArgumentException("La calle no puede ser nula");
        }
        this.calle = calle;
    }

    /**
     * Funcion para obtener el numero de una {@link Direccion}, es decir numero
     * del edificio.
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Funcion para establecer el numero de edificio, de la {@link Direccion}
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Funcion para obtener una descripcion de otros aspectos a tener en cuenta
     * de la {@link Direccion}
     *
     * @return otros
     */
    public String getOtros() {
        return otros;
    }

    /**
     * Funcion para establecer una descripcion de otros aspectos a tener en
     * cuenta de la {@link Direccion}
     *
     * @param otros
     */
    public void setOtros(String otros) {
        this.otros = otros;
    }

    /**
     * Funcion para obtener el codigo postal de una {@link Direccion}
     *
     * @return codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Funcion para establecer el codigo postal de una {@link Direccion}
     *
     * @param codigoPostal
     * @throws IllegalArgumentException si el codigo postal es nulo.
     */
    public void setCodigoPostal(int codigoPostal) {
        if (codigoPostal == 0) {
            throw new IllegalArgumentException("El codigo postal no puede ser 0");
        }
        this.codigoPostal = codigoPostal;
    }

    /**
     * Funcion para obtener la localidad de una {@link Direccion}
     *
     * @return localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Funcion para establecer la localidad de una {@link Direccion}
     *
     * @param localidad
     * @throws IllegalArgumentException si la localidad es nula.
     */
    public void setLocalidad(String localidad) {
        if (localidad == null) {
            throw new IllegalArgumentException("La localidad no puede ser nula");
        }
        this.localidad = localidad;
    }

    /**
     * Funcion para obtener la provincia en la que se encuentra una
     * {@link Direccion}
     *
     * @return provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Funcion para establecer la provincia en la que se encuentra una
     * {@link Direccion}
     *
     * @param provincia
     * @throws IllegalArgumentException si la provincia es nula.
     */
    public void setProvincia(String provincia) {
        if (provincia == null) {
            throw new IllegalArgumentException("La provincia no puede ser nula");
        }
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        if (otros == null) {
            return calle + " " + numero + " " + codigoPostal + " " + localidad + " " + provincia;
        } else {
            return calle + " " + numero + " " + otros + " " + codigoPostal + " " + localidad + " " + provincia;
        }
    }

}
