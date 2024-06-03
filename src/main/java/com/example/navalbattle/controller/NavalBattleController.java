package com.example.navalbattle.controller;

import com.example.navalbattle.model.*;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class NavalBattleController {

    private PlayerBoard playerBoard;

    @FXML
    private GridPane gameBoardMachine;

    @FXML
    private GridPane gameBoardPlayer;

    @FXML
    public void initialize() {
        playerBoard = new PlayerBoard();
        // Node, Column, Row
        Random random = new Random();
        // System.out.println(random_position);
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
                System.out.print(playerBoard.get_player_board()[row][column]);
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
        playerBoard.set_ship(carrier1.getRow(), carrier1.getCol(), "Carrier");
        // if (condition) {

        // }
        gameBoardPlayer.add(carrier1.getShipGroup(), carrier1.getCol(), carrier1.getRow());
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
        gameBoardPlayer.add(submarine1.getShipGroup(), submarine1.getCol(), submarine1.getRow());

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
        gameBoardPlayer.add(submarine2.getShipGroup(), submarine2.getCol(), submarine2.getRow());
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

        gameBoardPlayer.add(destroyer1.getShipGroup(), destroyer1.getCol(), destroyer1.getRow());

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
        gameBoardPlayer.add(destroyer2.getShipGroup(), destroyer2.getCol(), destroyer2.getRow());

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
        gameBoardPlayer.add(destroyer3.getShipGroup(), destroyer3.getCol(), destroyer3.getRow());
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
        gameBoardPlayer.add(frigate1.getShipGroup(), frigate1.getCol(), frigate1.getRow());

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
        gameBoardPlayer.add(frigate2.getShipGroup(), frigate2.getCol(), frigate2.getRow());

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
        gameBoardPlayer.add(frigate3.getShipGroup(), frigate3.getCol(), frigate3.getRow());

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
        gameBoardPlayer.add(frigate4.getShipGroup(), frigate4.getCol(), frigate4.getRow());
    }

    private boolean is_empty(int row, int column) {
        if (playerBoard.get_player_board()[row][column] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void verifySub(Submarine sub) {
        if (is_empty(sub.getRow(), sub.getCol()) && is_empty(sub.getRow(), sub.getCol() + 1)
                && is_empty(sub.getRow(), sub.getCol() + 2)) {
            System.out.println("Empty");
            playerBoard.set_ship(sub.getRow(), sub.getCol(), "Submarine");
        } else {
            System.out.println("Not Empty");
            while ((is_empty(sub.getRow(), sub.getCol())
                    && is_empty(sub.getRow(), sub.getCol() + 1)
                    && is_empty(sub.getRow(), sub.getCol() + 2)) == false) {
                sub.setRow(get_random_pos());
            }
            playerBoard.set_ship(sub.getRow(), sub.getCol(), "Submarine");
        }
    }

    private void verifyDes(Destroyer des) {
        if (is_empty(des.getRow(), des.getCol()) && is_empty(des.getRow(), des.getCol() + 1)) {
            System.out.println("Empty");
            playerBoard.set_ship(des.getRow(), des.getCol(), "Destroyer");
        } else {
            System.out.println("Not Empty");
            while ((is_empty(des.getRow(), des.getCol())
                    && is_empty(des.getRow(), des.getCol() + 1)) == false) {
                des.setRow(get_random_pos());
            }
            playerBoard.set_ship(des.getRow(), des.getCol(), "Destroyer");
        }
    }

    private void verifyFri(Frigate fri) {
        if (is_empty(fri.getRow(), fri.getCol())) {
            System.out.println("Empty");
            playerBoard.set_ship(fri.getRow(), fri.getCol(), "Frigate");
        } else {
            System.out.println("Not Empty");
            while (is_empty(fri.getRow(), fri.getCol()) == false) {
                fri.setRow(get_random_pos());
            }
            playerBoard.set_ship(fri.getRow(), fri.getCol(), "Frigate");
        }
    }

    private int get_random_pos() {
        Random random = new Random();
        int random_position = random.nextInt(9);
        return random_position;
    }
}
