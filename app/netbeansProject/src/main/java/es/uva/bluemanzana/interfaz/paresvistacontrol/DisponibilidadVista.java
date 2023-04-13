package es.uva.bluemanzana.interfaz.paresvistacontrol;

import es.uva.bluemanzana.interfaz.paresvistacontrol.DisponibilidadVistaCtrl;
import es.uva.bluemanzana.negocio.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 * Interfaz del caso de uso Consultar disponibilidad de un producto en tiendas
 * fisicas
 *
 * @author sergsan
 * @author juatorr
 * @author pabvare
 */
public class DisponibilidadVista extends javax.swing.JFrame {

    private DisponibilidadVistaCtrl controlador;

    /**
     * Crea la interfaz de DisponibilidadVista
     */
    public DisponibilidadVista(Usuario usuario) {
        initComponents();
        tiendaPanel.setVisible(false);
        productoPanel.setVisible(false);
        controlador = new DisponibilidadVistaCtrl(this, usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idProductoLabel = new javax.swing.JTextField();
        consultarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        productoPanel = new javax.swing.JPanel();
        tituloSecLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tiendasList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idMuestLabel = new javax.swing.JLabel();
        nombreMuestrLabel = new javax.swing.JLabel();
        catMuestrLabel = new javax.swing.JLabel();
        consultarTiendaBtn = new javax.swing.JButton();
        cancelarProductoBtn = new javax.swing.JButton();
        tiendaPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombreTiendaLabel = new javax.swing.JLabel();
        idTiendaLabel = new javax.swing.JLabel();
        direccionTiendaLabel = new javax.swing.JLabel();
        telefTiendaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloLabel.setText("Consultar disponibilidad de un producto");

        jLabel1.setText("Introduzca id:");

        consultarBtn.setText("Consultar Producto");
        consultarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultarBtnMouseClicked(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(tituloLabel))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idProductoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                                .addComponent(cancelarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(consultarBtn)
                                .addGap(9, 9, 9)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idProductoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(consultarBtn))
                .addContainerGap())
        );

        tituloSecLabel.setText("Detalles del producto");

        idLabel.setText("Id:");

        jLabel2.setText("Nombre:");

        tiendasList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(tiendasList);

        jLabel3.setText("Categoría:");

        jLabel4.setText("Tiendas:");

        idMuestLabel.setText("jLabel10");

        nombreMuestrLabel.setText("jLabel11");

        catMuestrLabel.setText("jLabel12");

        consultarTiendaBtn.setText("Consultar tienda");
        consultarTiendaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultarTiendaBtnMouseClicked(evt);
            }
        });

        cancelarProductoBtn.setText("Cancelar");
        cancelarProductoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarProductoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout productoPanelLayout = new javax.swing.GroupLayout(productoPanel);
        productoPanel.setLayout(productoPanelLayout);
        productoPanelLayout.setHorizontalGroup(
            productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoPanelLayout.createSequentialGroup()
                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(productoPanelLayout.createSequentialGroup()
                                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(productoPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(catMuestrLabel))
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(productoPanelLayout.createSequentialGroup()
                        .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productoPanelLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(tituloSecLabel))
                            .addGroup(productoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(idLabel)
                                .addGap(48, 48, 48)
                                .addComponent(idMuestLabel))
                            .addGroup(productoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nombreMuestrLabel))
                            .addGroup(productoPanelLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(cancelarProductoBtn)
                                .addGap(14, 14, 14)
                                .addComponent(consultarTiendaBtn)))
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productoPanelLayout.setVerticalGroup(
            productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloSecLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idMuestLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreMuestrLabel))
                .addGap(5, 5, 5)
                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(catMuestrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(productoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarTiendaBtn)
                    .addComponent(cancelarProductoBtn))
                .addContainerGap())
        );

        jLabel5.setText("Información de tienda");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Id:");

        jLabel8.setText("Dirección:");

        jLabel9.setText("Telefono:");

        nombreTiendaLabel.setText("jLabel14");

        idTiendaLabel.setText("jLabel15");

        direccionTiendaLabel.setText("jLabel16");

        telefTiendaLabel.setText("jLabel17");

        javax.swing.GroupLayout tiendaPanelLayout = new javax.swing.GroupLayout(tiendaPanel);
        tiendaPanel.setLayout(tiendaPanelLayout);
        tiendaPanelLayout.setHorizontalGroup(
            tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiendaPanelLayout.createSequentialGroup()
                .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tiendaPanelLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel5))
                    .addGroup(tiendaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(direccionTiendaLabel))
                    .addGroup(tiendaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefTiendaLabel))
                    .addGroup(tiendaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTiendaLabel)
                            .addComponent(nombreTiendaLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tiendaPanelLayout.setVerticalGroup(
            tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiendaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(nombreTiendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idTiendaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(direccionTiendaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tiendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(telefTiendaLabel))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tiendaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tiendaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Funcion que muestra el panel de las tiendas en las que se encuentra
     * disponible un {@link es.uva.blueManzanaG12.negocio.modelo.Producto}
     *
     * @param estado
     */
    public void setPanelTiendasVisible(boolean estado) {
        tiendaPanel.setVisible(estado);
    }

    /**
     * Funcion que muestra el panel de los
     * {@link es.uva.blueManzanaG12.negocio.modelo.Producto} disponibles
     *
     * @param estado
     */
    public void setPanelProductoVisible(boolean estado) {
        productoPanel.setVisible(estado);
    }

    /**
     * Funcion que muestra el panel principal de la interfaz.
     *
     * @param estado
     */
    public void setPanelPrincipalVisible(boolean estado) {
        principalPanel.setVisible(estado);
    }

    /**
     * Obtiene la id del producto introducida
     *
     * @return la id del producto
     */
    public String getIdProducto() {
        return idProductoLabel.getText();
    }

    /**
     * Introduce un mensaje de error
     *
     * @param error mensaje de error
     */
    public void setMensajeError(String error) {
        JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Establece el id del producto
     *
     * @param text id del producto
     */
    public void setIdProducto(String text) {
        idMuestLabel.setText(text);
    }

    /**
     * Establece el nombre del producto
     *
     * @param text nombre del producto
     */
    public void setNombreProducto(String text) {
        nombreMuestrLabel.setText(text);
    }

    /**
     * Establece la categoria del producto
     *
     * @param text categoria del producto
     */
    public void setCategoriaProducto(String text) {
        catMuestrLabel.setText(text);
    }

    /**
     * Muestra la lista de tiendas que tienen un producto
     *
     * @param tiendas lista de tiendas que tienen un producto
     */
    public void setListaTiendas(String[] tiendas) {
        tiendasList.setListData(tiendas);
    }

    /**
     * Obtiene el elemento seleccionado de las tiendas
     *
     * @return la tienda selecionada por el usuario
     */
    public String getTiendaSelected() {
        return tiendasList.getSelectedValue();
    }

    /**
     * Muestra el nombre de la tienda
     *
     * @param text nombre de la tienda
     */
    public void setNombreTienda(String text) {
        nombreTiendaLabel.setText(text);
    }

    /**
     * Muestra el id de la tienda
     *
     * @param text id de la tienda
     */
    public void setIdTienda(String text) {
        idTiendaLabel.setText(text);
    }

    /**
     * Muestra la direccion de la tienda
     *
     * @param text direccion de la tienda
     */
    public void setDireccionTienda(String text) {
        direccionTiendaLabel.setText(text);
    }

    /**
     * Muestra el telefono de la tienda
     *
     * @param text telefono de la tienda
     */
    public void setTelefonoTienda(String text) {
        telefTiendaLabel.setText(text);
    }

    /**
     * Controlador de eventos del botón consultar
     *
     * @param evt
     */
    private void consultarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarBtnMouseClicked
        controlador.procesarConsultaProducto();
    }//GEN-LAST:event_consultarBtnMouseClicked

    /**
     * Controlador de eventos del boton cancelar
     *
     * @param evt
     */
    private void cancelarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBtnMouseClicked
        controlador.procesarCancelarTienda();
    }//GEN-LAST:event_cancelarBtnMouseClicked

    /**
     * Controlador de eventos del boton consultar tienda
     *
     * @param evt
     */
    private void consultarTiendaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarTiendaBtnMouseClicked
        controlador.procesarTienda();
    }//GEN-LAST:event_consultarTiendaBtnMouseClicked

    private void cancelarProductoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarProductoBtnMouseClicked
        controlador.procesarCancelarProducto();
    }//GEN-LAST:event_cancelarProductoBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton cancelarProductoBtn;
    private javax.swing.JLabel catMuestrLabel;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JButton consultarTiendaBtn;
    private javax.swing.JLabel direccionTiendaLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idMuestLabel;
    private javax.swing.JTextField idProductoLabel;
    private javax.swing.JLabel idTiendaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreMuestrLabel;
    private javax.swing.JLabel nombreTiendaLabel;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JPanel productoPanel;
    private javax.swing.JLabel telefTiendaLabel;
    private javax.swing.JPanel tiendaPanel;
    private javax.swing.JList<String> tiendasList;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel tituloSecLabel;
    // End of variables declaration//GEN-END:variables
}
