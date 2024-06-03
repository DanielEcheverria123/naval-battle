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
        add_submarines();
        add_destroyers();
        add_frigates();
        for (int row = 0; row < 9; row++) {
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
        Submarine submarine1 = new Submarine(18 * 3, 0, 4);
        playerBoard.set_ship(submarine1.getRow(), submarine1.getCol(), "Submarine");
        gameBoardPlayer.add(submarine1.getShipGroup(), get_random_pos(), get_random_pos());
        Submarine submarine2 = new Submarine(18 * 3, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(submarine2.getShipGroup(), get_random_pos(), get_random_pos());
    }

    private void add_destroyers() {
        // Adding Destroyers to the player's board
        Destroyer destroyer1 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(destroyer1.getShipGroup(), get_random_pos(), get_random_pos());
        Destroyer destroyer2 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(destroyer2.getShipGroup(), get_random_pos(), get_random_pos());
        Destroyer destroyer3 = new Destroyer(18 * 2, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(destroyer3.getShipGroup(), get_random_pos(), get_random_pos());
    }

    private void add_frigates() {
        // Adding Frigates to the player's board
        Frigate frigate1 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(frigate1.getShipGroup(), get_random_pos(), get_random_pos());
        Frigate frigate2 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(frigate2.getShipGroup(), get_random_pos(), get_random_pos());
        Frigate frigate3 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(frigate3.getShipGroup(), get_random_pos(), get_random_pos());
        Frigate frigate4 = new Frigate(18 * 1, get_random_pos(), get_random_pos());
        gameBoardPlayer.add(frigate4.getShipGroup(), get_random_pos(), get_random_pos());
    }

    private boolean is_empty(int row, int column) {
        if (playerBoard.get_player_board()[row][column] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private int get_random_pos() {
        Random random = new Random();
        int random_position = random.nextInt(9);
        return random_position;
    }
}
