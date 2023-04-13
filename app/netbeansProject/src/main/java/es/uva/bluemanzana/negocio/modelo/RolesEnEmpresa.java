package es.uva.bluemanzana.negocio.modelo;

import java.sql.Date;

/**
 * Clase para definir los roles en la empresa que se guardan en la base de datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class RolesEnEmpresa {

    private Date fechaDeComienzo;
    private String dni;
    private int rol;

    /**
     * Constructor de roles en la empresa, formado por la fecha en la que se
     * comenzó con ese rol, el dni/nif del {@link Empleado} asignado a ese rol,
     * y un identificador del {@link TiposDeRol}
     *
     * @param fechaDeComienzo
     * @param dni
     * @param rol
     */
    public RolesEnEmpresa(Date fechaDeComienzo, String dni, int rol) {
        setFechaDeComienzo(fechaDeComienzo);
        setDni(dni);
        setRol(rol);
    }

    /**
     * Funcion para obtener la {@link Date} fecha de comienzo del
     * {@link RolesEnEmpresa}
     *
     * @return fechaDeComienzo
     */
    public Date getFechaDeComienzo() {
        return fechaDeComienzo;
    }

    /**
     * Funcion para asignar la {@link Date} fecha de comienzo del
     * {@link RolesEnEmpresa}
     *
     * @param fechaDeComienzo
     * @throws IllegalArgumentException si fechaDeComienzo es nula/vacía
     */
    public void setFechaDeComienzo(Date fechaDeComienzo) {
        if (fechaDeComienzo == null) {
            throw new IllegalArgumentException("Fecha de comienzo vacia no admitida");
        }
        this.fechaDeComienzo = fechaDeComienzo;
    }

    /**
     * Funcion para obtener el dni/nif del {@link Empleado} del
     * {@link RolesEnEmpresa}
     *
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Funcion para asignar el dni/nif del {@link Empleado} del
     * {@link RolesEnEmpresa}
     *
     * @param dni
     * @throws IllegalArgumentException si dni es nulo.
     */
    public void setDni(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("El dni vacio no puede ser nulo");
        }
        this.dni = dni;
    }

    /**
     * Funcion para obtener el identificador del {@link TiposDeRol} del
     * {@link RolesEnEmpresa}
     *
     * @return rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * Funcion para asignar el identificador del {@link TiposDeRol} del
     * {@link RolesEnEmpresa}
     *
     * @param rol
     * @throws IllegalArgumentException si el identificador rol es nulo.
     */
    public void setRol(int rol) {
        if (rol == 0) {
            throw new IllegalArgumentException("El rol 0 no esta admitido");
        }
        this.rol = rol;
    }

}
