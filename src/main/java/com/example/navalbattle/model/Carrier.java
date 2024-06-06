package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

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

        Rectangle rectangle1 = new Rectangle(218.0, 366.0, 126.0, 24.0);
        rectangle1.setArcHeight(10.0);
        rectangle1.setArcWidth(20.0);
        rectangle1.setFill(Color.rgb(82, 85, 87)); // #525557
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeType(StrokeType.INSIDE);

        Rectangle rectangle2 = new Rectangle(258.0, 366.0, 32.0, 8.0);
        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(Color.rgb(181, 190, 198)); // #b5bec6
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setStrokeType(StrokeType.INSIDE);

        Rectangle rectangle3 = new Rectangle(222.0, 376.0, 101.0, 9.0);
        rectangle3.setArcHeight(5.0);
        rectangle3.setArcWidth(5.0);
        rectangle3.setFill(Color.WHITE);
        rectangle3.setStroke(Color.WHITE);
        rectangle3.setStrokeType(StrokeType.INSIDE);

        Rectangle rectangle4 = new Rectangle(261.0, 368.0, 8.0, 4.0);
        rectangle4.setArcHeight(5.0);
        rectangle4.setArcWidth(5.0);
        rectangle4.setFill(Color.rgb(147, 160, 171)); // #93a0ab
        rectangle4.setStroke(Color.BLACK);
        rectangle4.setStrokeType(StrokeType.INSIDE);

        Circle circle = new Circle(333.0, 378.0, 7.0);
        circle.setFill(Color.rgb(181, 190, 198)); // #b5bec6
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);

        shipGroup.getChildren().addAll(rectangle1, rectangle2, rectangle3, rectangle4, circle);

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
