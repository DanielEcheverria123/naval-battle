package com.example.navalbattle.view.alert;

import javafx.scene.control.Alert;

/**
 * La clase AlertBox implementa la interfaz lAlertBox y proporciona
 * funcionalidad para mostrar una ventana de alerta de error.
 *
 * @version 1.0
 * @since 1.0
 */

public class AlertBox implements lAlertBox {

    /**
     * Muestra una ventana de alerta de error con el título, encabezado y contenido
     * especificados.
     *
     * @param title   El título de la ventana de alerta.
     * @param header  El encabezado de la ventana de alerta.
     * @param content El contenido de la ventana de alerta.
     */
    @Override
    public void showMessage(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}