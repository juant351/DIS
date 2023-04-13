package es.uva.bluemanzana.app;

import es.uva.bluemanzana.interfaz.BlueManzanaStateMachine;
import es.uva.bluemanzana.interfaz.paresvistacontrol.IdentificarseVista;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa principal de la aplicación.
 * 
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class BlueManzana {
    public static final BlueManzanaStateMachine stateMachine = new BlueManzanaStateMachine();
    /**
     * Main del programa, se inicia con la interfaz de iniciar sesión
     * 
     * @param args
     */
    public static void main(String[] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex){
            Logger.getLogger(IdentificarseVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario usuario = null;
        /* Create and display the form */
        Runnable r = () -> stateMachine.abrirVistaIdentificarse(usuario);
        java.awt.EventQueue.invokeLater(r);
    }   
    
    /**
     * Funcion para obtener el estado de la maquina.
     * 
     * @return stateMachine
     */
    
    public static BlueManzanaStateMachine getStateMachine(){
        return stateMachine;
    }
}
