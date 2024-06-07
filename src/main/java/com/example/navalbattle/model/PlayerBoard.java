package com.example.navalbattle.model;

public class PlayerBoard {

    private int[][] board;

    public PlayerBoard() {
        // Constructor
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
