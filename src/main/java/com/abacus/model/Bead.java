package com.abacus.model;

public class Bead {
    private boolean selected;
    private int value;
    private int row;    // 0-9 (representing the digit)
    private int column; // 0: ten thousands, 1: thousands, 2: hundreds, 3: tens, 4: ones

    public Bead(int row, int column) {
        this.row = row;
        this.column = column;
        // Calculate value based on the row number (0-9) and column position
        this.value = row * (int) Math.pow(10, column); // Correct calculation
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void toggleSelected() {
        this.selected = !this.selected;
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}