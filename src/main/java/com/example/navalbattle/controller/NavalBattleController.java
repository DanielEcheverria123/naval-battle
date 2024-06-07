package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Point3D;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.QuadCurve;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.input.TransferMode;

import java.util.Random;

public class NavalBattleController {
    private int turn;
    private int leftPLayerShip;
    private int leftMachineShip;
    private double mouseX, mouseY;
    private String selectedShip;
    private Carrier carrierDeck = new Carrier(18 * 4, 0, 2);
    private Submarine submarineDeck = new Submarine(18 * 3, 1, 2);
    private Destroyer destroyerDeck = new Destroyer(18 * 2, 2, 2);
    private Frigate frigateDeck = new Frigate(18 * 1, 3, 2);

    @FXML
    private GridPane gridDeck;

    @FXML
    private Label labelCarrierQuantityLeft;

    @FXML
    private Label labelDestroyerQuantityLeft;

    @FXML
    private Label labelFrigateQuantityLeft;

    @FXML
    private Label labelSubmarineQuantityLeft;

    @FXML
    private Button buttonHandlerPlay;

    private MachineBoard machineBoard;

    private PlayerBoard playerBoard;

    @FXML
    private GridPane gameBoardMachine;

    @FXML
    private GridPane gameBoardPlayer;

    @FXML
    public void initialize() {
        machineBoard = new MachineBoard();
        playerBoard = new PlayerBoard();

        // Node, Column, Row
        Random random = new Random();
        // System.out.println(random_position);
        turn = 9;
        leftPLayerShip = 10;
        leftMachineShip = 10;
        addLeftQuantity();
        add_carriers();
        add_submarines();
        add_destroyers();
        add_frigates();
        addDeckShips();
        // try {
        // } catch (Exception e) {
        // // TODO: handle exception
        // System.out.println(e);
        // }

        // Machine Board
        // for (int row = 0; row <= 9; row++) {
        // for (int column = 0; column <= 9; column++) {
        // System.out.print(machineBoard.getMachineBoard()[row][column]);
        // System.out.print("");
        // }
        // System.out.println("");
        // }for (int row = 0; row <= 9; row++) {
        // for (int column = 0; column <= 9; column++) {
        // System.out.print(machineBoard.getMachineBoard()[row][column]);
        // System.out.print("");
        // }
        // System.out.println("");
        // }

        // Player Board
        // for (int row = 0; row <= 9; row++) {
        // for (int column = 0; column <= 9; column++) {
        // System.out.print(playerBoard.getPlayerBoard()[row][column]);
        // System.out.print("");
        // }
        // System.out.println("");
        // }
    }

    private void addLeftQuantity() {
        labelCarrierQuantityLeft.setText("1");
        labelSubmarineQuantityLeft.setText("2");
        labelDestroyerQuantityLeft.setText("3");
        labelFrigateQuantityLeft.setText("4");
    }

    private void add_carriers() {
        // Adding Carriers to the player's board
        Carrier carrier1 = new Carrier(18 * 4, 0, 6);
        machineBoard.setShip(carrier1.getRow(), carrier1.getCol(), "Carrier");
        gameBoardMachine.add(carrier1.getShipGroup(), carrier1.getCol(), carrier1.getRow());
    }

    private void add_submarines() {
        // Adding Submarines to the player's board
        Submarine submarine1 = new Submarine(18 * 3, get_random_pos(), get_random_pos());
        try {
            verifySub(submarine1);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Submarino fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                submarine1.setCol(get_random_pos());
            } while (submarine1.getCol() > 7);

            verifySub(submarine1);
        }
        // verifySub(submarine1);
        gameBoardMachine.add(submarine1.getShipGroup(), submarine1.getCol(), submarine1.getRow());

        Submarine submarine2 = new Submarine(18 * 3, 0, 8);
        try {
            verifySub(submarine2);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("Submarino fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                submarine2.setCol(get_random_pos());
            } while (submarine2.getCol() > 7);

            verifySub(submarine2);
        }
        // verifySub(submarine2);
        // System.out.println(submarine2.getRow() + " " + submarine2.getCol());
        gameBoardMachine.add(submarine2.getShipGroup(), submarine2.getCol(), submarine2.getRow());
    }

    private void add_destroyers() {
        // Adding Destroyers to the player's board
        Destroyer destroyer1 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        try {
            verifyDes(destroyer1);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Destructor fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                destroyer1.setCol(get_random_pos());
            } while (destroyer1.getCol() > 8);

            verifyDes(destroyer1);
        }

        gameBoardMachine.add(destroyer1.getShipGroup(), destroyer1.getCol(), destroyer1.getRow());

        Destroyer destroyer2 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        try {
            verifyDes(destroyer2);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Destructor fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                destroyer2.setCol(get_random_pos());
            } while (destroyer2.getCol() > 8);

            verifyDes(destroyer2);
        }
        gameBoardMachine.add(destroyer2.getShipGroup(), destroyer2.getCol(), destroyer2.getRow());

        Destroyer destroyer3 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        try {
            verifyDes(destroyer3);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Destructor fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                destroyer3.setCol(get_random_pos());
            } while (destroyer3.getCol() > 8);

            verifyDes(destroyer3);
        }
        gameBoardMachine.add(destroyer3.getShipGroup(), destroyer3.getCol(), destroyer3.getRow());
    }

    private void add_frigates() {
        // Adding Frigates to the player's board
        Frigate frigate1 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        try {
            verifyFri(frigate1);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Fragata fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                frigate1.setCol(get_random_pos());
            } while (frigate1.getCol() > 8);

            verifyFri(frigate1);
        }
        gameBoardMachine.add(frigate1.getShipGroup(), frigate1.getCol(), frigate1.getRow());

        Frigate frigate2 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        try {
            verifyFri(frigate2);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Fragata fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                frigate2.setCol(get_random_pos());
            } while (frigate2.getCol() > 8);

            verifyFri(frigate2);
        }
        gameBoardMachine.add(frigate2.getShipGroup(), frigate2.getCol(), frigate2.getRow());

        Frigate frigate3 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        try {
            verifyFri(frigate3);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Fragata fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                frigate3.setCol(get_random_pos());
            } while (frigate3.getCol() > 8);

            verifyFri(frigate3);
        }
        gameBoardMachine.add(frigate3.getShipGroup(), frigate3.getCol(), frigate3.getRow());

        Frigate frigate4 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        try {
            verifyFri(frigate4);
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            System.out.println("Fragata fuera de los límites maritimos, cambiando a una posición adecuada...");
            do {
                frigate4.setCol(get_random_pos());
            } while (frigate4.getCol() > 8);

            verifyFri(frigate4);
        }
        gameBoardMachine.add(frigate4.getShipGroup(), frigate4.getCol(), frigate4.getRow());
    }

    private boolean is_empty(int row, int column) {
        if (machineBoard.getMachineBoard()[row][column] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean is_empty_player(int row, int column) {
        if (playerBoard.getPlayerBoard()[row][column] == 0) {
            System.out.println(row + " " + column);
            return true;
        } else {
            return false;
        }
    }

    private boolean verifyCarrDeck(Carrier carr) {
        System.out.println("POSICION DEL PORTAAVIONES");
        System.out.println(carr.getRow() + " " + carr.getCol());
        if (is_empty_player(carr.getRow(), carr.getCol()) && is_empty_player(carr.getRow(), carr.getCol() + 1)
                && is_empty_player(carr.getRow(), carr.getCol() + 2)
                && is_empty_player(carr.getRow(), carr.getCol() + 3)) {
            System.out.println("Empty");
            playerBoard.setShip(carr.getRow(), carr.getCol(), "Carrier");
            return true;
        } else {
            System.out.println("Not Empty");
            return false;
        }
    }

    private boolean verifySubmarineDeck(Submarine sub) {
        if (is_empty_player(sub.getRow(), sub.getCol()) && is_empty_player(sub.getRow(), sub.getCol() + 1)
                && is_empty_player(sub.getRow(), sub.getCol() + 2)) {
            System.out.println("Empty");
            playerBoard.setShip(sub.getRow(), sub.getCol(), "Submarine");
            return true;
        } else {
            System.out.println("Not Empty");
            return false;
        }
    }

    private boolean verifyDestroyerDeck(Destroyer des) {
        if (is_empty_player(des.getRow(), des.getCol()) && is_empty_player(des.getRow(), des.getCol() + 1)) {
            System.out.println("Empty");
            playerBoard.setShip(des.getRow(), des.getCol(), "Destroyer");
            return true;
        } else {
            System.out.println("Not Empty");
            return false;
        }
    }

    private boolean verifyFrigateDeck(Frigate fri) {
        if (is_empty_player(fri.getRow(), fri.getCol())) {
            System.out.println("Empty");
            playerBoard.setShip(fri.getRow(), fri.getCol(), "Frigate");
            return true;
        } else {
            System.out.println("Not Empty");
            return false;
        }
    }

    private void verifySub(Submarine sub) {
        if (is_empty(sub.getRow(), sub.getCol()) && is_empty(sub.getRow(), sub.getCol() + 1)
                && is_empty(sub.getRow(), sub.getCol() + 2)) {
            System.out.println("Empty");
            System.out.println(sub.getRow() + " " + sub.getCol());
            System.out.println("#####################");
            machineBoard.setShip(sub.getRow(), sub.getCol(), "Submarine");
        } else {
            System.out.println("Not Empty");
            while ((is_empty(sub.getRow(), sub.getCol())
                    && is_empty(sub.getRow(), sub.getCol() + 1)
                    && is_empty(sub.getRow(), sub.getCol() + 2)) == false) {
                sub.setRow(get_random_pos());
            }
            machineBoard.setShip(sub.getRow(), sub.getCol(), "Submarine");
        }
    }

    private void verifyDes(Destroyer des) {
        if (is_empty(des.getRow(), des.getCol()) && is_empty(des.getRow(), des.getCol() + 1)) {
            System.out.println("Empty");
            machineBoard.setShip(des.getRow(), des.getCol(), "Destroyer");
        } else {
            System.out.println("Not Empty");
            while ((is_empty(des.getRow(), des.getCol())
                    && is_empty(des.getRow(), des.getCol() + 1)) == false) {
                des.setRow(get_random_pos());
            }
            machineBoard.setShip(des.getRow(), des.getCol(), "Destroyer");
        }
    }

    private void verifyFri(Frigate fri) {
        if (is_empty(fri.getRow(), fri.getCol())) {
            System.out.println("Empty");
            machineBoard.setShip(fri.getRow(), fri.getCol(), "Frigate");
        } else {
            System.out.println("Not Empty");
            while (is_empty(fri.getRow(), fri.getCol()) == false) {
                fri.setRow(get_random_pos());
            }
            machineBoard.setShip(fri.getRow(), fri.getCol(), "Frigate");
        }
    }

    private int get_random_pos() {
        Random random = new Random();
        int random_position = random.nextInt(9);
        return random_position;
    }

    // Adding ships to the player's deck
    private void addDeckShips() {
        carrierDeck.getShipGroup().setId("carrierDeck");
        gridDeck.add(carrierDeck.getShipGroup(), carrierDeck.getCol(), carrierDeck.getRow());

        submarineDeck.getShipGroup().setId("submarineDeck");
        gridDeck.add(submarineDeck.getShipGroup(), submarineDeck.getCol(), submarineDeck.getRow());

        destroyerDeck.getShipGroup().setId("destroyerDeck");
        gridDeck.add(destroyerDeck.getShipGroup(), destroyerDeck.getCol(), destroyerDeck.getRow());

        frigateDeck.getShipGroup().setId("frigateDeck");
        gridDeck.add(frigateDeck.getShipGroup(), frigateDeck.getCol(), frigateDeck.getRow());

        // gridDeck.setHalignment((Node) frigateDeck.getShipGroup(), HPos.CENTER);
    }

    // Water and Ship Hit drawers
    private void drawWaterHit(int col, int row) {
        Ellipse waterHit = new Ellipse(18, 17);
        Ellipse innerWaterHit = new Ellipse(15, 14);
        Ellipse subInnerWaterHit = new Ellipse(12, 11);
        Ellipse smallWaterHit = new Ellipse(8, 7);

        waterHit.setFill(javafx.scene.paint.Color.BLUE);
        innerWaterHit.setFill(javafx.scene.paint.Color.LIGHTBLUE);
        subInnerWaterHit.setFill(javafx.scene.paint.Color.AQUA);
        smallWaterHit.setFill(javafx.scene.paint.Color.DARKBLUE);

        gameBoardMachine.add(waterHit, col, row);
        gameBoardMachine.add(innerWaterHit, col, row);
        gameBoardMachine.add(subInnerWaterHit, col, row);
        gameBoardMachine.add(smallWaterHit, col, row);

    }

    private void drawHitFlame(int col, int row, String gridX, String gridY) {
        // Coordenadas de la celda
        double startX = col * 35 + 17.5; // Coordenada X del centro de la celda
        double startY = row * 35 + 17.5; // Coordenada Y del centro de la celda

        // Tamaño de la estrella
        double size = 20;

        // Agregando curvas para formar la estrella
        for (int i = 0; i < 5; i++) {
            double angle1 = Math.toRadians(72 * i - 18);
            double angle2 = Math.toRadians(72 * i + 18);

            // Puntos de control
            double controlX1 = startX + Math.cos(angle1) * size;
            double controlY1 = startY + Math.sin(angle1) * size;
            double controlX2 = startX + Math.cos(angle2) * size;
            double controlY2 = startY + Math.sin(angle2) * size;

            // Punto final
            double endX = startX + Math.cos(Math.toRadians(72 * i)) * size * 2;
            double endY = startY + Math.sin(Math.toRadians(72 * i)) * size * 2;

            // Agregar la curva a la escena
            QuadCurve curve = new QuadCurve();
            curve.setStartX(startX);
            curve.setStartY(startY);
            curve.setEndX(endX);
            curve.setEndY(endY);
            curve.setControlX(controlX1);
            curve.setControlY(controlY1);
            curve.setFill(javafx.scene.paint.Color.RED);
            gameBoardMachine.add(curve, col, row);

            QuadCurve curve2 = new QuadCurve();
            curve2.setStartX(startX);
            curve2.setStartY(startY);
            curve2.setEndX(endX);
            curve2.setEndY(endY);
            curve2.setControlX(controlX2);
            curve2.setControlY(controlY2);
            curve2.setFill(javafx.scene.paint.Color.RED);
            gameBoardMachine.add(curve2, col, row);
        }
    }

    // Mouse controllers

    @FXML
    void onMouseClickedDeck(MouseEvent event) {
        // System.out.println(event.getTarget());
        // Node spot = ;
        System.out.println(event);
        System.out.println(event.getX());
        // System.out.println(GridPane.getRowIndex(spot));
        // Node selectedDeckShip = getNodeByRowColumnIndex(0, 2, gridDeck);
        // Node spot = event.getPickResult().getIntersectedNode();
        // System.out.println(spot);
        int verticalDeckCellSize = 38;
        Point3D point;
        point = (Point3D) event.getPickResult().getIntersectedPoint();
        // System.out.println("X: " + point.getX() + " Y: " + point.getY());
        int coordinateX = (int) event.getX();
        int coordinateY = (int) event.getY();

        if (coordinateX > 380.0 && coordinateX < 518.0) {
            if (coordinateY > 0 && coordinateY < verticalDeckCellSize) {
                System.out.println("Carrier Deck");
                selectedShip = "Carrier";
            } else if (coordinateY > verticalDeckCellSize && coordinateY < verticalDeckCellSize * 2) {
                System.out.println("Submarine Deck");
                selectedShip = "Submarine";
            } else if (coordinateY > verticalDeckCellSize * 2 && coordinateY < verticalDeckCellSize * 3) {
                System.out.println("Destroyer Deck");
                selectedShip = "Destroyer";
            } else if (coordinateY > verticalDeckCellSize * 3 && coordinateY < verticalDeckCellSize * 4) {
                System.out.println("Frigate Deck");
                selectedShip = "Frigate";
            }
            // System.out.println("Dentro del rango");
        } else {
            selectedShip = null;
            System.out.println("Fuera del rango");
        }

        /*
         * Distancia de las celdas del DECK
         * x>380.0 y z<518.0
         * y>0 y y<38.0
         * 
         */

        // GridPane grid;/*
        // grid = (GridPane) spot;
        // System.out.println(grid);
        // System.out.println(gridDeck.getColumnConstraints().get(2)); */
    }

    // Get Node by Row and Column

    @FXML
    void onMouseDraggedDeck(MouseEvent event) {

    }

    @FXML
    void onMouseClickedPlayerGrid(MouseEvent event) {
        System.out.println("POSICION DEL TABLERO DEL JUGADOR SELECCIONADA ");
        // System.out.println(event);
        // System.out.println(event.getX() / 37);
        // System.out.println(event.getY());
        int coordinateX = (int) event.getX() / 37;
        int coordinateY = (int) event.getY() / 35;
        System.out.println("X: " + coordinateX + " Y: " + coordinateY);
        if (selectedShip != null) {
            if (selectedShip == "Carrier" && !labelCarrierQuantityLeft.getText().equals("0")) {
                System.out.println("Carrier");
                Carrier carrierPlayer = new Carrier(18 * 4, coordinateY, coordinateX);
                int left = Integer.parseInt(labelCarrierQuantityLeft.getText());
                if (carrierPlayer.getCol() > 6) {
                    selectedShip = "Carrier";
                } else {
                    if (verifyCarrDeck(carrierPlayer)) {
                        gameBoardPlayer.add(carrierPlayer.getShipGroup(), carrierPlayer.getCol(),
                                carrierPlayer.getRow());
                        selectedShip = null;
                        labelCarrierQuantityLeft.setText(String.valueOf(left - 1));
                    }
                }

            } else if (selectedShip == "Submarine" && !labelSubmarineQuantityLeft.getText().equals("0")) {
                System.out.println("Submarine");
                Submarine submarinePlayer = new Submarine(18 * 3, coordinateY, coordinateX);
                int left = Integer.parseInt(labelSubmarineQuantityLeft.getText());
                if (submarinePlayer.getCol() > 7) {
                    selectedShip = "Submarine";
                } else {
                    if (verifySubmarineDeck(submarinePlayer)) {
                        gameBoardPlayer.add(submarinePlayer.getShipGroup(), submarinePlayer.getCol(),
                                submarinePlayer.getRow());
                        selectedShip = null;
                        labelSubmarineQuantityLeft.setText(String.valueOf(left - 1));
                    }
                }
            } else if (selectedShip == "Destroyer" && !labelDestroyerQuantityLeft.getText().equals("0")) {
                System.out.println("Destroyer");
                Destroyer destroyerPlayer = new Destroyer(18 * 2, coordinateY, coordinateX);
                int left = Integer.parseInt(labelDestroyerQuantityLeft.getText());
                if (destroyerPlayer.getCol() > 8) {
                    selectedShip = "Destroyer";
                } else {
                    if (verifyDestroyerDeck(destroyerPlayer)) {
                        gameBoardPlayer.add(destroyerPlayer.getShipGroup(), destroyerPlayer.getCol(),
                                destroyerPlayer.getRow());
                        selectedShip = null;
                        labelDestroyerQuantityLeft.setText(String.valueOf(left - 1));
                    }
                }
            } else if (selectedShip == "Frigate" && !labelFrigateQuantityLeft.getText().equals("0")) {
                System.out.println("Frigate");
                Frigate frigatePlayer = new Frigate(18 * 1, coordinateY, coordinateX);
                int left = Integer.parseInt(labelFrigateQuantityLeft.getText());
                if (frigatePlayer.getCol() > 9) {
                    selectedShip = "Frigate";
                } else {
                    if (verifyFrigateDeck(frigatePlayer)) {
                        gameBoardPlayer.add(frigatePlayer.getShipGroup(), frigatePlayer.getCol(),
                                frigatePlayer.getRow());
                        selectedShip = null;
                        labelFrigateQuantityLeft.setText(String.valueOf(left - 1));
                    }
                }
            }
            if (labelCarrierQuantityLeft.getText().equals("0")) {
                disableCarrier(carrierDeck);
            }
            if (labelDestroyerQuantityLeft.getText().equals("0")) {
                disableDestroyer(destroyerDeck);
            }
            if (labelFrigateQuantityLeft.getText().equals("0")) {
                disableFrigate(frigateDeck);
            }
            if (labelSubmarineQuantityLeft.getText().equals("0")) {
                disableSubmarine(submarineDeck);
            }

        } else {

        }
        for (int row = 0; row <= 9; row++) {
            for (int column = 0; column <= 9; column++) {
                System.out.print(playerBoard.getPlayerBoard()[row][column]);
                System.out.print("");
            }
            System.out.println("");
        }
    }

    private void disableCarrier(Carrier carrier) {
        carrier.getShipGroup().setOpacity(0.1);
    }

    private void disableSubmarine(Submarine submarine) {
        submarine.getShipGroup().setOpacity(0.1);
    }

    private void disableDestroyer(Destroyer destroyer) {
        destroyer.getShipGroup().setOpacity(0.1);
    }

    private void disableFrigate(Frigate frigate) {
        frigate.getShipGroup().setOpacity(0.1);
    }

    @FXML
    void onMouseEnteredPlayerGrid(MouseEvent event) {

    }

    @FXML
    void onMouseExitPlayerGrid(MouseEvent event) {

    }

    // Machine Grid
    @FXML
    void onMouseExitMachineGrid(MouseEvent event) {

    }

    @FXML
    void onMouseClickedMachineAttack(MouseEvent event) {
        if (turn != 0 || turn != 1) {
            System.out.println("Preparación del juego");
        } else {
            if (turn == 1) {
                Node spot = event.getPickResult().getIntersectedNode();
                // System.out.println("NODE: " + spot);
                GridPane grid;
                Ellipse cell;
                Point3D point;
                if (spot.getClass() == GridPane.class) {
                    System.out.println("GridPane");
                    System.out.println(event.getPickResult());
                    grid = (GridPane) spot;
                    point = (Point3D) event.getPickResult().getIntersectedPoint();
                    System.out.println("X: " + point.getX() + " Y: " + point.getY());
                    int coordinateX = (int) point.getX() / 37;
                    int coordinateY = (int) point.getY() / 35;
                    System.out.println("X: " + coordinateX + " Y: " + coordinateY);
                    // Verificamos si tocó agua o no
                    int machineCell = machineBoard.getSpecificMachineBoardCell(coordinateY, coordinateX);
                    if (machineCell == 0) {
                        System.out.println("Water");
                        drawWaterHit(coordinateX, coordinateY);
                    } else {
                        System.out.println("Ship");
                        switch (machineCell) {
                            case 1:
                                System.out.println("Carrier");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            case 2:
                                System.out.println("Submarine");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            case 3:
                                System.out.println("Destroyer");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            case 4:
                                System.out.println("Frigate");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            default:
                                break;
                        }
                    }
                    // System.out.println(machineBoard.getSpecificMachineBoardCell(coordinateY,
                    // coordinateX));

                } else if (spot.getClass() == Ellipse.class) {
                    System.out.println("Ellipse Event");
                    // System.out.println(event.getX() / 38 + " " + event.getY() / 36);
                    cell = (Ellipse) spot;
                    // System.out.println(cell.getRadiusX());
                    point = (Point3D) event.getPickResult().getIntersectedPoint();
                    System.out.println(point);
                    int coordinateX = (int) event.getX() / 37;
                    int coordinateY = (int) event.getY() / 35;
                    // System.out.println("X: " + coordinateX + " Y: " + coordinateY);
                    if (spot.getClass() == Ellipse.class) {
                        String selectedCell = String.valueOf(cell.getRadiusX());
                        switch (selectedCell) {
                            case "72.0":
                                System.out.println("Carrier");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(event.getX()),
                                        String.valueOf(event.getY()));
                                break;
                            case "54.0":
                                System.out.println("Submarine");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            case "36.0":
                                System.out.println("Destroyer");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            case "18.0":
                                System.out.println("Frigate");
                                drawHitFlame(coordinateX, coordinateY, String.valueOf(point.getX()),
                                        String.valueOf(point.getY()));
                                break;
                            default:
                                break;
                        }

                        // System.out.println("CLASE AGARRADO: " + spot.getClass());
                    }
                }
                // System.out.println(cell.getRadiusX());
                // System.out.println("Machine Attack" + spot);
                turn = 0;
            } else {
                System.out.println("Machine's turn");
                // System.out.println("It's not your turn");
                // System.out.println("Turn: " + turn);
                turn = 1;
            }
        }

        // System.out.println(turn);
    }

    @FXML
    void onMouseEnteredMachineGrid(MouseEvent event) {

    }

    @FXML
    void onMouseEnteredGridDeck(MouseEvent event) {

    }

    @FXML
    void onMouseExitDeckGrid(MouseEvent event) {

    }

    // Player Grid
    @FXML
    void onHandlerButtonPlay(ActionEvent event) {

    }

}
