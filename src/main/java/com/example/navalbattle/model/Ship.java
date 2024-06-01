package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ship {
    private Group shipGroup;
    private Color color;
    private int size;

    public Ship(Color color, int size) {
        this.color = color;
        this.size = size;
        this.shipGroup = new Group();

        for (int i = 0; i < size; i++) {
            Rectangle part = new Rectangle(34, 34);
            part.setFill(color);
            part.setStroke(Color.BLACK);
            part.setX(i * 37);
            shipGroup.getChildren().add(part);
        }
    }

    public Group getShipGroup() {
        return shipGroup;
    }

    public int getSize() {
        return size;
    }
}
