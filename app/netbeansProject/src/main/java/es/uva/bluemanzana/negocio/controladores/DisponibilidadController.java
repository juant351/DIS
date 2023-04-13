package es.uva.bluemanzana.negocio.controladores;

import es.uva.bluemanzana.basedatos.CategoriaDAO;
import es.uva.bluemanzana.basedatos.DestinosDAO;
import es.uva.bluemanzana.basedatos.DireccionDAO;
import es.uva.bluemanzana.basedatos.ExistenciasEnTiendasDAO;
import es.uva.bluemanzana.basedatos.ProductoDAO;
import es.uva.bluemanzana.basedatos.TiendaDAO;
import es.uva.bluemanzana.negocio.modelo.Direccion;
import es.uva.bluemanzana.negocio.modelo.ExistenciaEnTienda;
import es.uva.bluemanzana.negocio.modelo.Producto;
import es.uva.bluemanzana.negocio.modelo.Tienda;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;

/**
 * Clase que implementa el controlador que maneja la interfaz cuando el usuario
 * realiza el caso de uso de obtener la disponibilidad de un producto..
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DisponibilidadController {

    static final int NUMERO_PRODUCTOS_MINIMOS = 5;
    private static final String NOMBRELABEL = "nombre";

    /**
     * Funcion para obtener un nuevo {@link DisponibilidadController}
     *
     * @return DisponibilidadController
     */
    public static DisponibilidadController getController() {
        return new DisponibilidadController();
    }

    /**
     * Funcion para saber si un {@link Producto} se encuentra en la base de
     * datos, para ello se le pasa a la funcion {@link ProductoDAO#existeProducto(int)
     * } el {@link Producto#id}
     *
     * @param id
     * @return true/false dependiendo
     */
    public boolean existeProducto(int id) {
        return ProductoDAO.existeProducto(id).getBoolean("existe");
    }

    /**
     * Funcion para obtener un {@link Producto} a partir de su
     * {@link Producto#id}
     *
     * @param id del Producto
     * @return producto
     */
    public Producto getProducto(int id) {
        JsonObject productoJson = ProductoDAO.getProductoById(id);
        return new Producto(productoJson.getInt("id"), productoJson.getString(NOMBRELABEL), productoJson.getInt("precio"), parseFecha(productoJson.getString("fecha")), productoJson.getInt("categoria"));
    }

    /**
     * Funcion para obtener la
     * {@link es.uva.bluemanzana.negocio.modelo.Categoria} de un
     * {@link Producto}
     *
     * @param producto
     * @return categoria
     */
    public String getCategoria(Producto producto) {
        return CategoriaDAO.getNombreCategoria(producto.getCategoria()).getString(NOMBRELABEL);
    }

    /**
     * Funcion para obtener los {@link Tienda#nombreIdentificativo}
     *
     * @param id
     * @return un {@link ArrayList} con los {@link Tienda#nombreIdentificativo}
     */
    public String[] getNombreTiendas(int id) {
        List<ExistenciaEnTienda> existencia = ExistenciasEnTiendasDAO.getExistenciasTienda(id);
        String[] nombreTiendas = new String[existencia.size()];
        for (int i = 0; i < existencia.size(); i++) {
            nombreTiendas[i] = TiendaDAO.getTienda(existencia.get(i).getTienda(), null).getString(NOMBRELABEL);
        }
        return nombreTiendas;
    }

    /**
     * Funcion para obtener una {@link Tienda} a partir de su
     * {@link Tienda#nombreIdentificativo} Llama a {@link TiendaDAO#getTienda(int, java.lang.String)
     * }
     *
     * @param tiendaNombre
     * @return tienda
     */
    public Tienda getTienda(String tiendaNombre) {
        JsonObject tiendaJson = TiendaDAO.getTienda(-1, tiendaNombre);
        return new Tienda(tiendaJson.getInt("id"), tiendaJson.getString(NOMBRELABEL));
    }

    /**
     * Funcion para obtener la cantidad de un {@link Producto} en una
     * {@link Tienda}
     *
     * @param id {@link Producto}
     * @return cantidad de existencias
     */
    public int getCantidad(int id) {
        return ExistenciasEnTiendasDAO.getCantidad(id).getInt("cantidad");
    }

    /**
     * Funcion para obtener la {@link Direccion} de {@link Tienda} a partir de
     * su {@link Tienda#id}
     *
     * @param id de la Tienda
     * @return Direccion de la Tienda
     */
    public Direccion getDireccion(int id) {
        JsonObject dirJson = DireccionDAO.getDireccion(id);
        return (new Direccion(dirJson.getInt("id"), dirJson.getString("calle"),
                dirJson.getInt("numero"), dirJson.getString("otros"), dirJson.getInt("codPos"),
                dirJson.getString("localidad"), dirJson.getString("provincia")));
    }

    /**
     * Funcion para obtener el
     * {@link es.uva.bluemanzana.negocio.modelo.Destino#telefono} de la
     * {@link Tienda}
     *
     * @param id de la Tienda
     * @return telefono del Destino asociado a la Tienda
     */
    public String getTelefono(int id) {
        return DestinosDAO.getTelefono(id).getString("telefono");
    }

    /**
     * Permite convertir un String en fecha (Date).
     *
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    private static Date parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        java.sql.Date fechaSql = null;
        try {
            java.util.Date fechaDate = formato.parse(fecha);
            fechaSql = new java.sql.Date(fechaDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DisponibilidadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaSql;
    }
}
