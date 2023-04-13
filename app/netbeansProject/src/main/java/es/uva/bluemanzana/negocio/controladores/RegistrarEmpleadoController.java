/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.bluemanzana.negocio.controladores;

import es.uva.bluemanzana.basedatos.AlmacenDAO;
import es.uva.bluemanzana.basedatos.DireccionDAO;
import es.uva.bluemanzana.basedatos.DisponibilidadesDAO;
import es.uva.bluemanzana.basedatos.EmpleadoDAO;
import es.uva.bluemanzana.basedatos.OficinaDAO;
import es.uva.bluemanzana.basedatos.RolEnEmpresaDAO;
import es.uva.bluemanzana.basedatos.TiendaDAO;
import es.uva.bluemanzana.basedatos.TiposDeRolDAO;
import es.uva.bluemanzana.basedatos.UsuarioDAO;
import es.uva.bluemanzana.basedatos.VinculacionesConLaEmpresaDAO;
import es.uva.bluemanzana.negocio.modelo.Almacen;
import es.uva.bluemanzana.negocio.modelo.Oficina;
import es.uva.bluemanzana.negocio.modelo.Tienda;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase controlador para el caso de uso Registrar nuevo empleado.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class RegistrarEmpleadoController {

    private static int[] listaIds;

    /**
     * Consulta que devuelve un nuevo controlador del caso de uso de registrar
     * nuevo empleado y que se usa como constructor.
     *
     * @return controlador del caso de uso registrar nuevo {@link Empleado}.
     */
    public static RegistrarEmpleadoController getController() {
        return new RegistrarEmpleadoController();
    }

    /**
     * Consulta que devuelve una lista con todos los {@link Destino} posibles
     * que hay en la base de datos.
     *
     * @return lista de {@link Destino} disponibles.
     */
    public static String[] getLista() {
        int i = 0;
        List<Tienda> tiendas = TiendaDAO.getAllTiendas();
        List<Almacen> almacenes = AlmacenDAO.getAllAlmacenes();
        List<Oficina> oficinas = OficinaDAO.getAllOficinas();
        int tam = (tiendas.size() + almacenes.size() + oficinas.size());
        String[] lista = new String[tam];
        listaIds = new int[tam];
        for (Tienda tienda : tiendas) {
            lista[i] = "Tienda: " + tienda.getId() + ". Nombre: " + tienda.getNombreIdentificativo();
            listaIds[i] = tienda.getId();
            i++;
        }
        for (Almacen almacen : almacenes) {
            lista[i] = "Almacen: " + almacen.getId() + ". Superficie: " + almacen.getSuperficie();
            listaIds[i] = almacen.getId();
            i++;
        }
        for (Oficina oficina : oficinas) {
            lista[i] = "Oficina: " + oficina.getId() + ". Indicaciones: " + oficina.getOtrasIndicaciones();
            listaIds[i] = oficina.getId();
            i++;
        }

        return lista;
    }

    /**
     * Consulta que devuelve una lista con los ids de todos los {@link Destino}
     * disponibles en la base de datos.
     *
     * @return lista de ids de los {@link Destino}.
     */
    public int[] getListaIds() {
        return listaIds;
    }

    /**
     * Funcion encargada de comunicarse con el {@link UsuarioDAO} para anadir un
     * nuevo usuario a la base de datos.
     *
     * @param passTemp Contrasena temporal
     * @param nif Dni del {@link Usuario}
     * @param nombre Nombre del {@link Usuario}
     * @param apellidos Apellidos del {@link Usuario}
     * @param email Email del {@link Usuario}
     * @param telefono Telefono del {@link Usuario}
     */
    public void addNewUsuario(String passTemp, String nif, String nombre, String apellidos, String email, String telefono) {
        UsuarioDAO.insert(nif, nombre, apellidos, passTemp, email, telefono);
    }

    /**
     * Funcion encargada de comunicarse con el {@link EmpleadoDAO} para anadir
     * un nuevo empleado a la base de datos.
     *
     * @param nif Dni del {@link Empleado}
     * @param numSeg Numero de la seguridad social del {@link Empleado}
     * @param iban Iban del {@link Empleado}
     * @param destino Destino del {@link Empleado}
     */
    public void addNewEmpleado(String nif, String numSeg, String iban, int destino, String rol) {
        int id = DireccionDAO.getUltimaID().getInt("id");
        EmpleadoDAO.insert(nif, numSeg, iban, id, listaIds[destino]);
        VinculacionesConLaEmpresaDAO.insert(Date.valueOf(LocalDate.now()), nif, 1);
        DisponibilidadesDAO.insert(Date.valueOf(LocalDate.now()), null, nif, 3);
        RolEnEmpresaDAO.insert(Date.valueOf(LocalDate.now()), nif, getRolByNombre(rol));

    }

    /**
     * Funcion encargada de comunicarse con el {@link DireccionDAO} para anadir
     * una nueva direccion a la base de datos.
     *
     * @param calle Calle de la {@link Direccion}
     * @param num Numero de la {@link Direccion}
     * @param otros Otras indicaciones para la {@link Direccion}
     * @param codpos Codigo postal de la {@link Direccion}
     * @param localidad Localidad de la {@link Direccion}
     * @param provincia Provincia de la {@link Direccion}
     */
    public void addNewDireccion(String calle, int num, String otros, int codpos, String localidad, String provincia) {
        int id = DireccionDAO.getUltimaID().getInt("id") + 1;
        DireccionDAO.insert(id, calle, num, otros, codpos, localidad, provincia);
    }

    /**
     * Consulta para comprobar si el email introducio es correcto
     *
     * @param email Email del {@link Usuario}
     * @return true/false en funcion de si el email es correcto
     */
    public static boolean compruebaEmail(String email) {
        //Con pattern nos permite crear una exp regular o patron
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);

        return mather.find();
    }

    /**
     * Consulta para comprobar si el dni introducido es correcto y si se
     * encuentra en la base de datos.
     *
     * @param dni Dni del {@link Usuario}
     * @return codigo Entero en funcion del error o dni correcta.
     */
    public static int compruebaDNI(String dni) {
        String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (dni.length() != 9) {
            return 1;
        } else if (Character.isDigit(dni.charAt(8))) {
            return 1;
        } else {
            int resto = Integer.parseInt(dni.substring(0, 7)) % 23;
            if (letrasValidas.substring(resto).equalsIgnoreCase(dni.substring(8))) {
                return 1;
            }
        }

        if (EmpleadoDAO.noExiteNIF(dni.toUpperCase()).getBoolean("existe")) {
            return 2;
        }
        return 0;
    }

    /**
     * Consulta encarda de comprobar si el par rol/destino es correcto.
     *
     * @param rol Rol introducido por el {@link Usuario}
     * @param destinoSelect {@link Usuario} introducido por el {@link Usuario}
     * @return true/false en funcion de si el par es correcto o no
     */
    public static boolean compruebaRol(String rol, String destinoSelect) {
        rol = rol.toUpperCase();
        String[] destinoPart = destinoSelect.split(":");
        String destino = destinoPart[0].toUpperCase();
        return !((rol.equals("EMPLEADOTIENDA") || rol.equals("ENCARGADOTIENDA")) && !destino.equals("TIENDA") || (rol.equals("EMPLEADOALMACEN") || rol.equals("ENCARGADOALMACEN")) && !destino.equals("ALMACEN") || rol.equals("GESTORMARCA") || rol.equals("RECURSOSHUMANOS") || (rol.equals("ENCARGADOLOGISTICA")) && !destino.equals("OFICINA"));
    }

    /**
     * Consulta encargada de comunicarse con {@link TiposDeRolDAO} para
     * comprobar que el rol es uno de los disponibles en la base de datos
     *
     * @param rol Rol del {@link Usuario}
     * @return true/false en funcion de si el rol esta en la base de datos
     */
    public static boolean esRolEmpresa(String rol) {
        rol = rol.toUpperCase();
        return TiposDeRolDAO.esRolEmpresa(rol).getBoolean("esRol");
    }

    /**
     * Consulta encargada de devoler la id del rol a partir de su nombre.
     *
     * @param rol Nombre del rol
     * @return id Id del tipo de rol
     */
    public static int getRolByNombre(String rol) {
        return TiposDeRolDAO.getIdRolByName(rol).getInt("IDTIPO");
    }
}
