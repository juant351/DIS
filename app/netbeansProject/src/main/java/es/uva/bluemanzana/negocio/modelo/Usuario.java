package es.uva.bluemanzana.negocio.modelo;

/**
 * Clase para definir las usuarios de la empresa que se guardan en la base de
 * datos
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class Usuario {

    private String nif;
    private String nombre;
    private String apellidos;
    private String password;
    private String email;
    private String telefono;

    /**
     * Constructor vacío de un usuario. Todos los atributos se ponen a 0, o
     * vacíos.
     */
    public Usuario() {
        nif = "";
        nombre = "";
        apellidos = "";
        password = "";
        email = "";
        telefono = "";
    }

    /**
     * Constructor de un usuario, está definido por un nif/dni único, un nombre
     * y apellidos, una contraseña para su cuenta, un correo electrónico y un
     * teléfono.
     *
     * @param nif
     * @param nombre
     * @param apellidos
     * @param password
     * @param email
     * @param telefono
     */
    public Usuario(String nif, String nombre, String apellidos, String password, String email, String telefono) {
        setNif(nif);
        setNombre(nombre);
        setApellidos(apellidos);
        setPassword(password);
        setEmail(email);
        setTelefono(telefono);
    }

    /**
     * Función para obtener el nif/dni único del {@link Usuario}
     *
     * @return nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Función para asignar el nif/dni único del {@link Usuario}
     *
     * @param nif
     * @throws IllegalArgumentException si nif es nulo
     */
    public void setNif(String nif) {
        if (nif.isEmpty()) {
            throw new IllegalArgumentException("El nif/dni no puede ser nulo");
        }
        this.nif = nif;
    }

    /**
     * Función para obtener el nombre del {@link Usuario}
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Función para asignar el nombre del {@link Usuario}
     *
     * @param nombre
     * @throws IllegalArgumentException si nombre es nulo.
     */
    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.nombre = nombre;
    }

    /**
     * Función para obtener los apellidos del {@link Usuario}
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Función para asignar los apellidos del {@link Usuario}
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        if (apellidos.isEmpty()) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos");
        }
        this.apellidos = apellidos;
    }

    /**
     * Función para obtener la contraseña del {@link Usuario}
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Función para asignar la contraseña del {@link Usuario}
     *
     * @param password
     */
    public void setPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }
        this.password = password;
    }

    /**
     * Función para obtener el correo electronico del {@link Usuario}
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Función para asignar el correo electronico del {@link Usuario}
     *
     * @param email
     * @throws IllegalArgumentException si email es nulo.
     */
    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("El correo electronico no puede ser nulo");
        }
        this.email = email;
    }

    /**
     * Función para obtener el telefono del {@link Usuario}
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Función para asignar el telefono del {@link Usuario}
     *
     * @param telefono
     * @throws IllegalArgumentException si telefono es nulo.
     */
    public void setTelefono(String telefono) {
        if (telefono.isEmpty()) {
            throw new IllegalArgumentException("El telefono no puede ser nulo");
        }
        this.telefono = telefono;
    }

}
