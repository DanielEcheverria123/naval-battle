package com.example.navalbattle.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ship {
    private String name;
    private int size;
    private Color color;
    private int row;
    private int col;
    private boolean vertical;

    public Ship(String name, int size, Color color, boolean vertical) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.vertical = vertical;
    }

    public void deployShip(Canvas canvas, int row, int col, double cellWidth, double cellHeight) {
        this.row = row;
        this.col = col;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);

        if (name.equals("Portaaviones")) {
            if (vertical) {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight * 4);
                gc.setFill(Color.GRAY);
                gc.fillRect(col * cellWidth, row * cellHeight + (cellHeight * 1.5), cellWidth, cellHeight);
                gc.setFill(Color.RED);
                gc.fillRect(col * cellWidth + (cellWidth * 0.2), row * cellHeight + (cellHeight * 1.5), cellWidth * 0.6, cellHeight * 0.6);
            } else {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth * 4, cellHeight);
                gc.setFill(Color.GRAY);
                gc.fillRect(col * cellWidth + (cellWidth * 1.5), row * cellHeight, cellWidth, cellHeight);
                gc.setFill(Color.RED);
                gc.fillRect(col * cellWidth + (cellWidth * 1.5), row * cellHeight + (cellHeight * 0.2), cellWidth * 0.6, cellHeight * 0.6);
            }
        } else if (name.equals("Submarino")) {
            if (vertical) {
                gc.fillOval(col * cellWidth + (cellWidth * 0.2), row * cellHeight, cellWidth * 0.6, cellHeight * 3);
                gc.setFill(Color.DARKBLUE);
                gc.fillOval(col * cellWidth + (cellWidth * 0.2), row * cellHeight + (cellHeight * 0.5), cellWidth * 0.6, cellHeight * 2);
            } else {
                gc.fillOval(col * cellWidth, row * cellHeight + (cellHeight * 0.2), cellWidth * 3, cellHeight * 0.6);
                gc.setFill(Color.DARKBLUE);
                gc.fillOval(col * cellWidth + (cellWidth * 0.5), row * cellHeight + (cellHeight * 0.2), cellWidth * 2, cellHeight * 0.6);
            }
        } else if (name.equals("Destructor")) {
            if (vertical) {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight * 2);
                gc.setFill(Color.GREEN);
                gc.fillRect(col * cellWidth + (cellWidth * 0.2), row * cellHeight + (cellHeight * 0.2), cellWidth * 0.6, cellHeight * 1.6);
            } else {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth * 2, cellHeight);
                gc.setFill(Color.GREEN);
                gc.fillRect(col * cellWidth + (cellWidth * 0.2), row * cellHeight + (cellHeight * 0.2), cellWidth * 1.6, cellHeight * 0.6);
            }
        } else if (name.equals("Fragata")) {
            if (vertical) {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                gc.setFill(Color.YELLOW);
                gc.fillPolygon(new double[]{col * cellWidth + (cellWidth * 0.5), col * cellWidth + (cellWidth * 0.2), col * cellWidth + (cellWidth * 0.8)},
                        new double[]{row * cellHeight + (cellHeight * 0.2), row * cellHeight + (cellHeight * 0.8), row * cellHeight + (cellHeight * 0.8)},
                        3);
            } else {
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                gc.setFill(Color.YELLOW);
                gc.fillPolygon(new double[]{col * cellWidth + (cellWidth * 0.2), col * cellWidth + (cellWidth * 0.8), col * cellWidth + (cellWidth * 0.8)},
                        new double[]{row * cellHeight + (cellHeight * 0.5), row * cellHeight + (cellHeight * 0.2), row * cellHeight + (cellHeight * 0.8)},
                        3);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVertical() {
        return vertical;
    }
}
