package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.QuadCurve;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

import java.util.Random;

public class NavalBattleController {
    private int turn;

    @FXML
    private Button buttonHandlerPlay;

    private MachineBoard machineBoard;

    @FXML
    void onHandlerButtonPlay(ActionEvent event) {

    }

    @FXML
    private GridPane gameBoardMachine;

    @FXML
    private GridPane gameBoardPlayer;

    @FXML
    public void initialize() {
        machineBoard = new MachineBoard();
        // Node, Column, Row
        Random random = new Random();
        // System.out.println(random_position);
        turn = 1;
        add_carriers();
        // try {
        add_submarines();
        // } catch (Exception e) {
        // // TODO: handle exception
        // System.out.println(e);
        // }

        add_destroyers();
        add_frigates();
        for (int row = 0; row <= 9; row++) {
            for (int column = 0; column <= 9; column++) {
                System.out.print(machineBoard.getMachineBoard()[row][column]);
                System.out.print("");
            }
            System.out.println("");

        }
        // gameBoardMachine.add(new Carrier(4).getShipGroup(), random.nextInt(10),
        // random.nextInt(10));
    }

    private void add_carriers() {
        // Adding Carriers to the player's board
        Carrier carrier1 = new Carrier(18 * 4, 0, 6);
        machineBoard.setShip(carrier1.getRow(), carrier1.getCol(), "Carrier");
        // if (condition) {

        // }
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
        System.out.println(submarine2.getRow() + " " + submarine2.getCol());
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

    private void verifySub(Submarine sub) {
        if (is_empty(sub.getRow(), sub.getCol()) && is_empty(sub.getRow(), sub.getCol() + 1)
                && is_empty(sub.getRow(), sub.getCol() + 2)) {
            System.out.println("Empty");
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

    // Player Grid

    @FXML
    void onMouseClickedPlayerGrid(MouseEvent event) {

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

        // System.out.println(turn);
    }

    @FXML
    void onMouseEnteredMachineGrid(MouseEvent event) {

    }
}
