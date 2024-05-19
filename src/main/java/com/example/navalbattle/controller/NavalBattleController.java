package com.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

//hello
public class NavalBattleController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane gameBoard;

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final double PREF_WIDTH = 296;
    private static final double PREF_HEIGHT = 311;
    private TextField[][] boardCells;

    @FXML
    public void initialize() {
        boardCells = new TextField[ROWS][COLS];
        double cellWidth = PREF_WIDTH / COLS;
        double cellHeight = PREF_HEIGHT / ROWS;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                TextField textField = new TextField();
                textField.setPrefWidth(cellWidth);
                textField.setPrefHeight(cellHeight);
                textField.setEditable(false);
                gameBoard.add(textField, col, row);
                boardCells[row][col] = textField;

                // Agregar evento de clic
                textField.setOnMouseClicked(event -> textField.setStyle("-fx-control-inner-background: red;"));
            }
        }
    }
}
