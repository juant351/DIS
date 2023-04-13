package es.uva.bluemanzana.interfaz;

import es.uva.bluemanzana.interfaz.paresvistacontrol.AtenderPedidoVista;
import es.uva.bluemanzana.interfaz.paresvistacontrol.DisponibilidadVista;
import es.uva.bluemanzana.interfaz.paresvistacontrol.IdentificarseVista;
import es.uva.bluemanzana.interfaz.paresvistacontrol.RegistrarseVista;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import javax.swing.JFrame;

/**
 * Clase que maneja los estados del sistema y las interfaces, para mostrar al
 * usuario cada interfaz dependiendo del estado del sistema y el caso de uso que
 * se esté realizando.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class BlueManzanaStateMachine {

    private JFrame currentState;

    /**
     * Crea una nueva maquina de estados BlueManzanaStateMachine
     */
    public BlueManzanaStateMachine() {
        //Constructor vacio de la maquina de estados
    }

    /**
     * Funcion para mostrar la interfaz asignada cuando se realiza el caso de
     * uso de Atender un Pedido.
     *
     * @param usuario
     */
    public void abrirVistaAtenderPedido(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.setVisible(false);
                currentState.dispose();
            }
            currentState = new AtenderPedidoVista(usuario);
            currentState.setVisible(true);
        });
    }

    /**
     * Funcion para mostrar la interfaz asignada cuando se realiza el caso de
     * uso de obtener la disponibilidad de un Producto.
     *
     * @param usuario
     */
    public void abrirVistaDisponibilidad(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.setVisible(false);
                currentState.dispose();
            }
            currentState = new DisponibilidadVista(usuario);
            currentState.setVisible(true);
        });
    }

    /**
     * Funcion para mostrar la interfaz asignada cuando se realiza el caso de
     * uso de Identificarse en el sistema.
     *
     * @param usuario
     */
    public void abrirVistaIdentificarse(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.setVisible(false);
                currentState.dispose();
            }
            currentState = new IdentificarseVista(usuario);
            currentState.setVisible(true);
        });
    }

    /**
     * Funcion para mostrar la interfaz asignada cuando se realiza el caso de
     * uso de Registrarse en el sistema.
     *
     * @param usuario
     */
    public void abrirVistaRegistrase(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.setVisible(false);
                currentState.dispose();
            }
            currentState = new RegistrarseVista(usuario);
            currentState.setVisible(true);
        });
    }
}
