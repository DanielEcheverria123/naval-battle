package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Carrier {
    private Group shipGroup;
    private Color color;
    private int size;
    private int row;
    private int col;

    public Carrier(int size, int row, int col) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.shipGroup = new Group();
        Ellipse carrier = new Ellipse(size, size / 4);
        carrier.setFill(Color.YELLOW);
        carrier.setStroke(Color.RED);
        shipGroup.getChildren().add(carrier);

    }

    public Group getShipGroup() {
        return shipGroup;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSize() {
        return size;
    }
}
