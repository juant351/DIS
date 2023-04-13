package es.uva.bluemanzana.negocio.modelo;

import java.time.LocalDate;

/**
 * Clase para definir empleados que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Empleado {

    private String nif;
    private String numeroSeguridadSocial;
    private String iban;
    private LocalDate fechaInicioEnEmpresa;
    private Direccion direccionPostal;
    private Destino destinadoEn;

    /**
     * Constructor de empleados, cuenta con un nif, numero de la seguridad
     * social, numero de cuenta bancaria, fecha de inicio en la empresa, la
     * direccion postal (donde reside) y el destino asignado que tiene.
     *
     * @param nif
     * @param numeroSeguridadSocial
     * @param iban
     * @param fechaInicioEnEmpresa
     * @param direccionPostal
     * @param destinadoEn
     */
    public Empleado(String nif, String numeroSeguridadSocial, String iban, LocalDate fechaInicioEnEmpresa, Direccion direccionPostal, Destino destinadoEn) {
        setNif(nif);
        setNumeroSeguridadSocial(numeroSeguridadSocial);
        setIban(iban);
        setFechaInicioEnEmpresa(fechaInicioEnEmpresa);
        setDireccionPostal(direccionPostal);
        setDestinadoEn(destinadoEn);
    }

    /**
     * Funcion para obtener el nif/dni de un {@link Empleado}
     *
     * @return nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Funcion para establecer el dni/nif de {@link Empleado}
     *
     * @param nif
     * @throws IllegalArgumentException si el nif es nulo
     */
    public void setNif(String nif) {
        if (nif.isEmpty()) {
            throw new IllegalArgumentException("No permitido dni vacio.");
        }
        this.nif = nif;
    }

    /**
     * Funcion para obtener el numero de la seguridad social de un
     * {@link Empleado}
     *
     * @return numeroSeguridadSocial
     */
    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    /**
     * Funcion para asignar el numero de la seguridad social de un
     * {@link Empleado}
     *
     * @param numeroSeguridadSocial
     * @throws IllegalArgumentException si el numeroSeguridadSocial es nulo
     */
    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        if (numeroSeguridadSocial.isEmpty()) {
            throw new IllegalArgumentException("Numero de seguridad social vacio no permitido");
        }
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    /**
     * Funcion para obtener el numero de cuenta bancaria de un {@link Empleado}
     *
     * @return iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * Funcion para asignar el numero de cuenta bancaria de un {@link Empleado}
     *
     * @param iban
     * @throws IllegalArgumentException si el iban es nulo.
     */
    public void setIban(String iban) {
        if (iban.isEmpty()) {
            throw new IllegalArgumentException("Iban vacio no permitido");
        }
        this.iban = iban;
    }

    /**
     * Funcion para obtener la fecha de inicio en la empresa de un
     * {@link Empleado}
     *
     * @return fechaInicioEnEmpresa
     */
    public LocalDate getFechaInicioEnEmpresa() {
        return fechaInicioEnEmpresa;
    }

    /**
     * Funcion para asignar la fecha de inicio en la empresa de un
     * {@link Empleado}
     *
     * @param fechaInicioEnEmpresa
     * @throws IllegalArgumentException si la fechaInicioEnEmpresa es nula
     */
    public void setFechaInicioEnEmpresa(LocalDate fechaInicioEnEmpresa) {
        if (fechaInicioEnEmpresa == null) {
            throw new IllegalArgumentException("Fecha vacia no permitida");
        }
        this.fechaInicioEnEmpresa = fechaInicioEnEmpresa;
    }

    /**
     * Funcion para obtener la direccion postal de un {@link Empleado}
     *
     * @return direccionPostal
     */
    public Direccion getDireccionPostal() {
        return direccionPostal;
    }

    /**
     * Funcion para asignar la direccion postal de un {@link Empleado}
     *
     * @param direccionPostal
     * @throws IllegalArgumentException si la direccionPostal es nula.
     */
    public void setDireccionPostal(Direccion direccionPostal) {
        if (direccionPostal == null) {
            throw new IllegalArgumentException("Direccion vacia no permitida");
        }
        this.direccionPostal = direccionPostal;
    }

    /**
     * Funcion para obtener el {@link Destino} de un {@link Empleado}
     *
     * @return destinadoEn
     */
    public Destino getDestinadoEn() {
        return destinadoEn;
    }

    /**
     * Funcion para asignar el {@link Destino} de un {@link Empleado}
     *
     * @param destinadoEn
     * @throws IllegalArgumentException si el destinadoEn es nulo
     */
    public void setDestinadoEn(Destino destinadoEn) {
        if (destinadoEn == null) {
            throw new IllegalArgumentException("Destino vacio no permitido");
        }
        this.destinadoEn = destinadoEn;
    }

}
