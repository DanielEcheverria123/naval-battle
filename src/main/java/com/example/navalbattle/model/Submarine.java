package com.example.navalbattle.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Submarine {
    private Group shipGroup;
    private Color color;
    private int size;
    private int row;
    private int col;

    public Submarine(int size, int row, int col) {
        this.size = size;
        this.row = row;
        this.col = col;
        this.shipGroup = new Group();

        Circle subCircle = new Circle();
        subCircle.setFill(Color.GREY);
        subCircle.setLayoutX(235.0);
        subCircle.setLayoutY(388.0);
        subCircle.setRadius(15.0);
        subCircle.setStroke(Color.BLACK);
        subCircle.setStrokeType(StrokeType.INSIDE);

        Rectangle subRectangle = new Rectangle();
        subRectangle.setArcHeight(5.0);
        subRectangle.setArcWidth(5.0);
        subRectangle.setFill(Color.GREY);
        subRectangle.setHeight(30.0);
        subRectangle.setLayoutX(231.0);
        subRectangle.setLayoutY(373.0);
        subRectangle.setStroke(Color.BLACK);
        subRectangle.setStrokeType(StrokeType.INSIDE);
        subRectangle.setWidth(43.0);

        QuadCurve subQuadCurve = new QuadCurve();
        subQuadCurve.setControlX(12.75);
        subQuadCurve.setControlY(-14.5);
        subQuadCurve.setEndX(-40.5);
        subQuadCurve.setEndY(3.0);
        subQuadCurve.setFill(Color.GREY);
        subQuadCurve.setLayoutX(312.0);
        subQuadCurve.setLayoutY(400.0);
        subQuadCurve.setStartX(-40.5);
        subQuadCurve.setStartY(-27.0);
        subQuadCurve.setStroke(Color.BLACK);
        subQuadCurve.setStrokeType(StrokeType.INSIDE);

        Circle subCircle2 = new Circle();
        subCircle2.setFill(Color.web("#a4ecf5"));
        subCircle2.setLayoutX(245.0);
        subCircle2.setLayoutY(387.0);
        subCircle2.setRadius(8.0);
        subCircle2.setStroke(Color.BLACK);
        subCircle2.setStrokeType(StrokeType.INSIDE);

        Polyline subPolyline = new Polyline();
        subPolyline.setFill(Color.GREY);
        subPolyline.setLayoutX(341.0);
        subPolyline.setLayoutY(368.0);
        subPolyline.getPoints().addAll(
                -49.75, 12.0,
                -39.25, 4.25,
                -39.25, 34.0,
                -49.75, 25.5
        );
        subPolyline.setStroke(Color.BLACK);
        subPolyline.setStrokeType(StrokeType.INSIDE);

        shipGroup.getChildren().addAll(subCircle, subRectangle, subQuadCurve, subCircle2, subPolyline);
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
