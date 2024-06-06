package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Frigate {
    private Group shipGroup;
    private Color color;
    private int size;
    private int row;
    private int col;

    public Frigate(int size, int row, int col) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.shipGroup = new Group();

        Rectangle rectangle = new Rectangle();
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(Color.web("#d9e0e8"));
        rectangle.setHeight(16.0);
        rectangle.setLayoutX(261.0);
        rectangle.setLayoutY(367.0);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);
        rectangle.setWidth(15.0);

        QuadCurve quadCurve = new QuadCurve();
        quadCurve.setControlX(-22.0);
        quadCurve.setControlY(-27.5);
        quadCurve.setEndY(-34.0);
        quadCurve.setFill(Color.web("#d9e0e8"));
        quadCurve.setLayoutX(263.0);
        quadCurve.setLayoutY(401.0);
        quadCurve.setStartY(-18.0);
        quadCurve.setStroke(Color.BLACK);
        quadCurve.setStrokeType(StrokeType.INSIDE);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.web("#5b5151"));
        polygon.setLayoutX(212.0);
        polygon.setLayoutY(394.0);
        polygon.getPoints().addAll(
                57.75, -23.0,
                57.75, -14.5,
                50.0, -19.0
        );
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeType(StrokeType.INSIDE);

        shipGroup.getChildren().addAll(rectangle, quadCurve, polygon);

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

    public Group getShipGroup() {
        return shipGroup;
    }

    public int getSize() {
        return size;
    }
}
