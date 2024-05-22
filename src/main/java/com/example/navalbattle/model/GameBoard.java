package com.example.navalbattle.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameBoard {
    private Canvas canvas;
    private int rows;
    private int cols;

    public GameBoard(Canvas canvas, int rows, int cols) {
        this.canvas = canvas;
        this.rows = rows;
        this.cols = cols;
        drawBoard();
    }

    private void drawBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double cellWidth = canvas.getWidth() / cols;
        double cellHeight = canvas.getHeight() / rows;

        gc.setStroke(Color.BLACK);

        // Dibujar las líneas horizontales
        double y = 0;
        for (int i = 0; i <= rows; i++) {
            gc.strokeLine(0, y, canvas.getWidth(), y);
            y += cellHeight;
        }

        // Dibujar las líneas verticales
        double x = 0;
        for (int i = 0; i <= cols; i++) {
            gc.strokeLine(x, 0, x, canvas.getHeight());
            x += cellWidth;
        }
    }

    public void setDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        drawBoard();
    }
}
