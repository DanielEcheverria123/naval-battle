package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Destroyer {
    private Group shipGroup;
    private Color color;
    private int size;
    private int row;
    private int col;

    public Destroyer(int size, int row, int col) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.shipGroup = new Group();

        Rectangle rectangle = new Rectangle();
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(Color.web("#d9e0e8"));
        rectangle.setHeight(24.0);
        rectangle.setLayoutX(226.0);
        rectangle.setLayoutY(366.0);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);
        rectangle.setWidth(44.0);

        QuadCurve quadCurve = new QuadCurve();
        quadCurve.setControlX(-22.25);
        quadCurve.setControlY(-24.0);
        quadCurve.setEndY(-34.0);
        quadCurve.setFill(Color.web("#d9e0e8"));
        quadCurve.setLayoutX(228.0);
        quadCurve.setLayoutY(400.0);
        quadCurve.setStartY(-10.0);
        quadCurve.setStroke(Color.BLACK);
        quadCurve.setStrokeType(StrokeType.INSIDE);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(Color.web("#b5bec6"));
        rectangle2.setHeight(14.0);
        rectangle2.setLayoutX(225.0);
        rectangle2.setLayoutY(371.0);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setStrokeType(StrokeType.INSIDE);
        rectangle2.setWidth(15.0);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.web("#5b5151"));
        polygon.setLayoutX(178.0);
        polygon.setLayoutY(397.0);
        polygon.getPoints().addAll(
                57.75, -23.0,
                57.75, -14.5,
                50.0, -19.0
        );
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeType(StrokeType.INSIDE);

        Circle circle = new Circle();
        circle.setFill(Color.web("#b5bec6"));
        circle.setLayoutX(260.0);
        circle.setLayoutY(378.0);
        circle.setRadius(6.0);
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);

        shipGroup.getChildren().addAll(rectangle, quadCurve, rectangle2, polygon, circle);
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
