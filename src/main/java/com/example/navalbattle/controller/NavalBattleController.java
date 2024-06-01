package com.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import com.example.navalbattle.model.Ship;

public class NavalBattleController {

    @FXML
    private GridPane gameBoardMachine;

    @FXML
    private GridPane gameBoardPlayer;

    @FXML
    public void initialize() {

        // Node, Column, Row
        gameBoardPlayer.add(new Ship(Color.YELLOW, 2).getShipGroup(), 0, 1);
        gameBoardMachine.add(new Ship(Color.RED, 4).getShipGroup(), 1, 3);
    }
}
