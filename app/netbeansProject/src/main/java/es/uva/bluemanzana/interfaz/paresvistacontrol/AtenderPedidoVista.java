package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.interfaz.paresvistacontrol.AtenderPedidoVistaCtrl;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import javax.json.JsonObject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que implementa la interfaz que se muestra a un usuario cuando realiza
 * el caso de uso de Atender un pedido en tienda.
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class AtenderPedidoVista extends javax.swing.JFrame {

    private AtenderPedidoVistaCtrl controladorAtenPed;
    private static Usuario usuario;

    /**
     * Constructor de la interfaz, utiliza el usuario con el que se ha iniciado
     * sesión en el sistema.
     *
     * @param usuario
     */
    public AtenderPedidoVista(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        controladorAtenPed = new AtenderPedidoVistaCtrl(this, usuario);
        error_NoEnTienda.setVisible(false);
        error_noEnReparto.setVisible(false);
        panel_Confirmar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recepcionPedidoTitulo = new javax.swing.JLabel();
        num_pedido_texto = new javax.swing.JTextField();
        num_pedido_label = new javax.swing.JLabel();
        error_NoEnTienda = new javax.swing.JLabel();
        error_noEnReparto = new javax.swing.JLabel();
        ok_boton = new javax.swing.JButton();
        panel_Confirmar = new javax.swing.JPanel();
        id_label = new javax.swing.JLabel();
        cantidad_label = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        estado_label = new javax.swing.JLabel();
        producto_label = new javax.swing.JLabel();
        solictadoEn_label = new javax.swing.JLabel();
        confirmar_boton = new javax.swing.JButton();
        cancelar_boton = new javax.swing.JButton();
        id_result = new javax.swing.JLabel();
        cantidad_result = new javax.swing.JLabel();
        fecha_result = new javax.swing.JLabel();
        estado_result = new javax.swing.JLabel();
        producto_result = new javax.swing.JLabel();
        solictadoEn_result = new javax.swing.JLabel();
        reclamacion_boton = new javax.swing.JButton();
        volver_boton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        recepcionPedidoTitulo.setText("RECEPCIÓN PEDIDO");

        num_pedido_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_pedido_textoActionPerformed(evt);
            }
        });

        num_pedido_label.setText("Nº Pedido:");

        error_NoEnTienda.setForeground(new java.awt.Color(255, 0, 0));
        error_NoEnTienda.setText("No existe el pedido para esta tienda");

        error_noEnReparto.setForeground(new java.awt.Color(255, 0, 0));
        error_noEnReparto.setText("El pedido no se encuentra \"En reparto\"");

        ok_boton.setText("OK");
        ok_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_botonActionPerformed(evt);
            }
        });

        panel_Confirmar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 0))); // NOI18N

        id_label.setText("Id:");

        cantidad_label.setText("Cantidad:");

        fecha_label.setText("Fecha:");

        estado_label.setText("Estado:");

        producto_label.setText("Producto:");

        solictadoEn_label.setText("Solicitado en:");

        confirmar_boton.setText("CONFIRMAR");
        confirmar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_botonActionPerformed(evt);
            }
        });

        cancelar_boton.setText("CANCELAR");
        cancelar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_botonActionPerformed(evt);
            }
        });

        reclamacion_boton.setText("Hacer reclamación");
        reclamacion_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reclamacion_botonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ConfirmarLayout = new javax.swing.GroupLayout(panel_Confirmar);
        panel_Confirmar.setLayout(panel_ConfirmarLayout);
        panel_ConfirmarLayout.setHorizontalGroup(
            panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConfirmarLayout.createSequentialGroup()
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ConfirmarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_label)
                            .addComponent(cantidad_label)
                            .addComponent(fecha_label)
                            .addComponent(estado_label)
                            .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(solictadoEn_label)
                                .addComponent(producto_label, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(30, 30, 30)
                        .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_result, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(cantidad_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estado_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(producto_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(solictadoEn_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_ConfirmarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(confirmar_boton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar_boton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ConfirmarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reclamacion_boton)
                .addGap(80, 80, 80))
        );
        panel_ConfirmarLayout.setVerticalGroup(
            panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConfirmarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(id_result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad_label)
                    .addComponent(cantidad_result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_label)
                    .addComponent(fecha_result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado_label)
                    .addComponent(estado_result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producto_label)
                    .addComponent(producto_result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(solictadoEn_label)
                    .addComponent(solictadoEn_result))
                .addGap(12, 12, 12)
                .addGroup(panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar_boton)
                    .addComponent(cancelar_boton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(reclamacion_boton)
                .addContainerGap())
        );

        volver_boton.setText("VOLVER");
        volver_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver_botonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(num_pedido_label, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(error_NoEnTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(error_noEnReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(num_pedido_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ok_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(recepcionPedidoTitulo)))
                        .addGap(16, 16, 16)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volver_boton)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recepcionPedidoTitulo)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_pedido_label)
                    .addComponent(num_pedido_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok_boton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_NoEnTienda)
                .addGap(3, 3, 3)
                .addComponent(error_noEnReparto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volver_boton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void num_pedido_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_pedido_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_pedido_textoActionPerformed

    private void confirmar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_botonActionPerformed
        controladorAtenPed.crearRegistroEntrega();
        controladorAtenPed.actualizarExistencias(producto_result.getText(), Integer.valueOf(cantidad_result.getText()));
        controladorAtenPed.pedidoEntregado(Integer.parseInt(id_result.getText()));
        panel_Confirmar.setVisible(false);
    }//GEN-LAST:event_confirmar_botonActionPerformed

    private void cancelar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_botonActionPerformed
        panel_Confirmar.setVisible(false);
    }//GEN-LAST:event_cancelar_botonActionPerformed

    private void ok_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_botonActionPerformed
        controladorAtenPed.procesaBotonOk();
        num_pedido_texto.setText("");
    }//GEN-LAST:event_ok_botonActionPerformed

    private void reclamacion_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reclamacion_botonActionPerformed
        JFrame frameAviso = new JFrame();
        JOptionPane.showMessageDialog(frameAviso, "Opción aún no implementada");
    }//GEN-LAST:event_reclamacion_botonActionPerformed

    private void volver_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_botonActionPerformed
        controladorAtenPed.procesaBotonVolver();
    }//GEN-LAST:event_volver_botonActionPerformed

    /**
     * Funcion para eliminar de la pantalla los diferentes mensajes de error.
     */
    public void ocultarMensaje() {
        error_NoEnTienda.setVisible(false);
        error_noEnReparto.setVisible(false);
    }

    /**
     * Funcion para obtener el {@link Pedido#id} que introduce el usuario.
     *
     * @return
     */
    public int getIdPedido() {
        return Integer.parseInt(num_pedido_texto.getText());
    }

    /**
     * Funcion que muestra el texto de error correspondiente.
     *
     * @param error error que ha sucedido, indica cual de los mensajes se debe
     * mostrar
     */
    public void muestraError(String error) {
        switch (error) {
            case "noTienda":
                error_NoEnTienda.setVisible(true);
                break;

            case "noEnReparto":
                error_noEnReparto.setVisible(true);
                break;
        }
    }

    /**
     * Funcion para mostrar por pantalla un panel con la informacion del
     * {@link Pedido} introducido por el usuario
     *
     * @param pedido {@link Pedido} para obtener sus datos.
     */
    public void muestraPanelPedido(JsonObject pedido) {
        panel_Confirmar.setVisible(true);
        id_result.setText(String.valueOf(pedido.getInt("id")));
        cantidad_result.setText(String.valueOf(pedido.getInt("cantidad")));
        fecha_result.setText(pedido.getString("fecha"));
        estado_result.setText("En reparto");
        String nombreProducto = controladorAtenPed.obtenerNombreProducto(pedido.getInt("producto"));
        producto_result.setText(nombreProducto);
        String nombreTiendaSolicitado = controladorAtenPed.obtenerNombreTienda(pedido.getInt("solicitadoEn"));
        solictadoEn_result.setText(nombreTiendaSolicitado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar_boton;
    private javax.swing.JLabel cantidad_label;
    private javax.swing.JLabel cantidad_result;
    private javax.swing.JButton confirmar_boton;
    private javax.swing.JLabel error_NoEnTienda;
    private javax.swing.JLabel error_noEnReparto;
    private javax.swing.JLabel estado_label;
    private javax.swing.JLabel estado_result;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel fecha_result;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel id_result;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel num_pedido_label;
    private javax.swing.JTextField num_pedido_texto;
    private javax.swing.JButton ok_boton;
    private javax.swing.JPanel panel_Confirmar;
    private javax.swing.JLabel producto_label;
    private javax.swing.JLabel producto_result;
    private javax.swing.JLabel recepcionPedidoTitulo;
    private javax.swing.JButton reclamacion_boton;
    private javax.swing.JLabel solictadoEn_label;
    private javax.swing.JLabel solictadoEn_result;
    private javax.swing.JButton volver_boton;
    // End of variables declaration//GEN-END:variables
}