package com.example.navalbattle.model;

public class PlayerBoard {

    private int[][] board;

    public PlayerBoard() {
        // Constructor
        /**
         * State controller for the board:
         * 0 = Empty 1 = Carrier 2 = Submarine 3 = Destroyer 4 = Frigate
         * 5 = WaterMiss 6 = CarrierHit 7 = SubmarineHit 8 = DestroyerHit 9 = FrigateHit
         * 10 = CarrierSunk 11 = SubmarineSunk 12 = DestroyerSunk 13 = FrigateSunk
         */
        this.board = new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }

        };
    }

    public int[][] getPlayerBoard() {
        return board;
    }

    public int getSpecificPlayerBoardCell(int row, int column) {
        // System.out.println("Machine Board Cell [" + row + "][" + column + "] = " +
        // this.board[row][column]);
        return this.board[row][column];
    }

    public void setSpecificPlayerBoardCell(int row, int column, String value) {
        int cell = this.board[row][column];
        if (value.equals("WaterMiss")) {
            this.board[row][column] = 5;
        } else if (value.equals("CarrierHit")) {
            this.board[row][column] = 6;
        } else if (value.equals("SubmarineHit")) {
            this.board[row][column] = 7;
        } else if (value.equals("DestroyerHit")) {
            this.board[row][column] = 8;
        } else if (value.equals("FrigateHit")) {
            this.board[row][column] = 9;
        } else if (value.equals("CarrierSunk")) {
            this.board[row][column] = 10;
        } else if (value.equals("SubmarineSunk")) {
            this.board[row][column] = 11;
        } else if (value.equals("DestroyerSunk")) {
            this.board[row][column] = 12;
        } else if (value.equals("FrigateSunk")) {
            this.board[row][column] = 13;
        }
    }

    public void setShip(int row, int column, String ship) {

        if (ship.equals("Carrier")) {
            this.board[row][column] = 1;
            this.board[row][column + 1] = 1;
            this.board[row][column + 2] = 1;
            this.board[row][column + 3] = 1;
        } else if (ship.equals("Submarine")) {
            this.board[row][column] = 2;
            this.board[row][column + 1] = 2;
            this.board[row][column + 2] = 2;
        } else if (ship.equals("Destroyer")) {
            this.board[row][column] = 3;
            this.board[row][column + 1] = 3;
        } else if (ship.equals("Frigate")) {
            this.board[row][column] = 4;
        }
    }

    public boolean isEmpty(int row, int column) {
        if (this.board[row][column] == 0) {
            return true;
        } else {
            return false;
        }
    }

}
