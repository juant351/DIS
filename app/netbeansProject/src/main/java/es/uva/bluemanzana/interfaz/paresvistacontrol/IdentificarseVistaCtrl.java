package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.app.BlueManzana;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import es.uva.bluemanzana.negocio.controladores.IdentificarseController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa el controlador de la interfaz del caso de uso
 * Identificarse en el sistema.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class IdentificarseVistaCtrl {

    private Usuario usuario;
    private IdentificarseVista vista;
    

    /**
     * Contructor del controlador, se crea a partir de la interfaz asociada y
     * del usurio que ingresa en el sistema.
     *
     * @param usuario
     * @param vista
     */
    public IdentificarseVistaCtrl(Usuario usuario, IdentificarseVista vista) {
        this.usuario = usuario;
        this.vista = vista;
        
    }

    /**
     * Funcion que procesa el inicio de sesion de un usuario, primero obtiene la
     * contraseña introducida en el sistema y a partir del valor de misma se
     * produce uno de los tres casos posibles: La contraseña es incorrecta y se
     * muestra el mensaje de error. El usuario no está registrado en la base de
     * datos y se muestra el mensaje de error. Contraseña correcta y se pasa a
     * procesar el rol del usuario.
     */
    public void procesarInicioSesion() {

        char[] contrasenaChar = vista.getContrasena();
        String contrasena = "";
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < contrasenaChar.length; i++) {
            bld.append(contrasenaChar[i]);
        }
        contrasena = bld.toString();
        try {
            usuario = IdentificarseController.getUsuario(vista.getDni());
            String contrasenaObt = usuario.getPassword();
            if (!contrasena.equals(contrasenaObt)) {
                String mens = "Contraseña Incorrecta";
                vista.setMensajeError(mens);
            } else {
                procesarRol(usuario);
            }

        } catch (Exception e) {
            Logger.getLogger(IdentificarseVistaCtrl.class.getName()).log(Level.SEVERE, null, e);
            String mens = "Usuario no encontrado";
            vista.setMensajeError(mens);
        }

    }

    /**
     * Funcion que obtiene el rol del usuario (empleado) que ha inicado sesion
     * en el sistema. Dependiendo del valor del rol obtenido, se muestran en la
     * interfaz los botones para realizar los diferentes casos de uso asignados.
     *
     * @param user usuario que ha iniciado sesion.
     */
    public void procesarRol(Usuario user) {
        vista.setOpcionPanelVisible();
        int rol = IdentificarseController.getRol(user.getNif());
        switch (rol) {
            case 2:
                //Empleado de recursos humanos
                vista.rolDos();
                break;
            case 3:
                //Encargado de logistica
                vista.rolTres();
                break;
            case 5:
                //Encargado de tienda
                vista.rolCinco();
                break;
            default:

                break;
        }
    }

    /**
     * Funcion que llama a la maquina de estados {@link BlueManzanaStateMachine}
     * para cambiar a {@link RegistrarseVista}
     */
    public void procesarNuevoEmpleado() {
        BlueManzana.getStateMachine().abrirVistaRegistrase(usuario);
    }

    /**
     * Funcion que llama a la maquina de estados {@link BlueManzanaStateMachine}
     * para cambiar a {@link AtenderPedidoVista}
     */
    public void procesarPedidoTienda() {
        BlueManzana.getStateMachine().abrirVistaAtenderPedido(usuario);
    }

    /**
     * Funcion que llama a la maquina de estados {@link BlueManzanaStateMachine}
     * para cambiar a {@link DisponibilidadVista}
     */
    public void procesarDisponibilidadProducto() {
        BlueManzana.getStateMachine().abrirVistaDisponibilidad(usuario);
    }

    /**
     * Funcion para mostrar en la interfaz el mensaje de error si una opcion no
     * esta implementada.
     */
    public void noImplementado() {
        vista.setMensajeError("Opcion aun no implementada");
    }
}
