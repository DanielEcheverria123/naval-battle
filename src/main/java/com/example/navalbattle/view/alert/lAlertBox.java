package com.example.navalbattle.view.alert;

/**
 * La interfaz lAlertBox define un método para mostrar una ventana de alerta.
 *
 * @version 1.0
 * @since 1.0
 */
public interface lAlertBox {

    /**
     * Muestra una ventana de alerta con el título, encabezado y contenido
     * especificados.
     *
     * @param title   El título de la ventana de alerta.
     * @param header  El encabezado de la ventana de alerta.
     * @param content El contenido de la ventana de alerta.
     */
    void showMessage(String title, String header, String content);
}
