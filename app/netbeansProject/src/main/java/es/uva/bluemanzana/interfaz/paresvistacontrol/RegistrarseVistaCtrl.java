/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.interfaz.paresvistacontrol.RegistrarseVista;
import es.uva.bluemanzana.negocio.controladores.RegistrarEmpleadoController;


/**
 * Clase que implementa el controlador para la vista registrar nuevo empleado.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class RegistrarseVistaCtrl {

    private final RegistrarseVista vistaReg;
    private final RegistrarEmpleadoController useCaseRegistrarController;
    private int contPulsComp = 0; //Contador pulsaciones en comprobar

    /**
     * Constructor de vista registrar empleado
     *
     * @param v vista
     */
    public RegistrarseVistaCtrl(RegistrarseVista v) {
        vistaReg = v;
        useCaseRegistrarController = RegistrarEmpleadoController.getController();
    }

    /**
     * Cuando el usuario introsduce los datos y pulsa el boton comprobar se realiza
     * una comprobacion del dni y de todos los parametros introducidos. Si todo es correcto se muestran
     * los paneles correspondientes en la vista.
     */
    public void procesaBotonComprobar() {
        if (contPulsComp == 0) {
            switch (RegistrarEmpleadoController.compruebaDNI(vistaReg.getNIF())) {
                case 1:
                    vistaReg.muestraErrorDNI(1);
                    break;
                case 2:
                    vistaReg.muestraErrorDNI(2);
                    break;
                default:
                    vistaReg.muestraPanelComprueba();
                    contPulsComp++;
                    break;
            }
        } else{

            if (vistaReg.getNombre().length() < 1 || vistaReg.getNombre().length() > 30) {
                vistaReg.muestraError("nombre");
            } else if (vistaReg.getApellidos().length() < 1 || vistaReg.getApellidos().length() > 30) {
                vistaReg.muestraError("apellido");
            } else if (vistaReg.getTelefono().length() < 4 || vistaReg.getTelefono().length() > 12) {
                vistaReg.muestraError("telefono");
            } else if (vistaReg.getEmail().length() > 100 || !RegistrarEmpleadoController.compruebaEmail(vistaReg.getEmail())) {
                vistaReg.muestraError("email");
            } else if (vistaReg.getIban().length() != 24) {
                vistaReg.muestraError("iban");
            } else if (vistaReg.getNumSegSoc().length() != 12) {
                vistaReg.muestraError("ss");
            } else {
                String[] lista = RegistrarEmpleadoController.getLista();
                vistaReg.muestraPanelRolDest();
                vistaReg.setListaDestinos(lista);
            }
        }

    }
    
    /**
     * Funcion encargada de comprobrar el rol y el destino introducidos por el usuario tras
     * presionar el boton registrar. Si es correcto se asigna una contrasena temporal que 
     * se muestra al usuario.
     */
    public void procesaBotonRegistrar() {
        if (RegistrarEmpleadoController.esRolEmpresa(vistaReg.getRol())) {
            vistaReg.muestraError("roles");
        } else if (!RegistrarEmpleadoController.compruebaRol(vistaReg.getRol(), vistaReg.getDestinoSelected())) {
            vistaReg.muestraError("roles");
        } else if (vistaReg.isEnabledBotonDireccion()) {
            vistaReg.muestraError("botDireccion");
        } else if (vistaReg.getDestinoSelectedIndex() == -1) {
            vistaReg.muestraError("destino");

        } else {
            String passTemp = "12345";
            useCaseRegistrarController.addNewUsuario(passTemp, vistaReg.getNIF(), vistaReg.getNombre(), vistaReg.getApellidos(), vistaReg.getEmail(), vistaReg.getTelefono());
            useCaseRegistrarController.addNewEmpleado(vistaReg.getNIF(), vistaReg.getNumSegSoc(), vistaReg.getIban(), vistaReg.getDestinoSelectedIndex(), vistaReg.getRol());
            vistaReg.registroCorrecto(passTemp);
        }
    }
    
    /**
     * Funcion que procesa la pulsacion del boton cancelar y cambia de vista.
     */
    public void procesaBotonCancelar() {
        vistaReg.cambiarAVistaIdentificarse();
    }

    /**
     * Funcion que procesa la pulsacion del boton para anadir una nueva direccion y mostrar
     * el panel correspondiente.
     */
    public void procesaBotonDireccion() {
        vistaReg.muestraPanelDireccion();
    }

    /**
     * Funcion que procesa la pulsacion del boton guardar direccion y reliza una llamada al 
     * controlador de caso de uso.
     */
    public void procesaBotonGuardar() {
        useCaseRegistrarController.addNewDireccion(vistaReg.getCalle(), vistaReg.getNumeroDir(), vistaReg.getOtros(), vistaReg.getCodPos(), vistaReg.getLocalidad(), vistaReg.getProvincia());
        vistaReg.ocultaPanelDireccion();
    }

}
