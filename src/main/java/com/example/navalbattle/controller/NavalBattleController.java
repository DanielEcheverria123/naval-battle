package com.example.navalbattle.controller;

import com.example.navalbattle.model.GameBoard;
import com.example.navalbattle.model.Ship;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class NavalBattleController {

    @FXML
    private Canvas gameBoard;

    @FXML
    private Canvas gameBoard2;

    private GameBoard playerGameBoard;
    private GameBoard machineGameBoard;

    @FXML
    public void initialize() {
        playerGameBoard = new GameBoard(gameBoard, 10, 10);
        machineGameBoard = new GameBoard(gameBoard2, 10, 10);

        // Crear instancias de los barcos y desplegarlos en el tablero del jugador
        Ship portaaviones = new Ship("Portaaviones", 4, Color.RED, false);
        portaaviones.deployShip(gameBoard, 0, 0, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship submarino1 = new Ship("Submarino", 3, Color.BLUE, true);
        submarino1.deployShip(gameBoard, 2, 3, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship submarino2 = new Ship("Submarino", 3, Color.BLUE, false);
        submarino2.deployShip(gameBoard, 4, 5, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship destructor1 = new Ship("Destructor", 2, Color.GREEN, true);
        destructor1.deployShip(gameBoard, 6, 1, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship destructor2 = new Ship("Destructor", 2, Color.GREEN, false);
        destructor2.deployShip(gameBoard, 8, 7, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship destructor3 = new Ship("Destructor", 2, Color.GREEN, true);
        destructor3.deployShip(gameBoard, 5, 9, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship fragata1 = new Ship("Fragata", 1, Color.YELLOW, false);
        fragata1.deployShip(gameBoard, 1, 6, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship fragata2 = new Ship("Fragata", 1, Color.YELLOW, true);
        fragata2.deployShip(gameBoard, 3, 2, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship fragata3 = new Ship("Fragata", 1, Color.YELLOW, false);
        fragata3.deployShip(gameBoard, 7, 8, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);

        Ship fragata4 = new Ship("Fragata", 1, Color.YELLOW, true);
        fragata4.deployShip(gameBoard, 9, 4, gameBoard.getWidth() / 10, gameBoard.getHeight() / 10);
    }
}
