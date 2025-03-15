package com.abacus.model;

import java.util.ArrayList;
import java.util.List;

public class Abacus {
    private List<List<Bead>> rows;
    private static final int NUM_ROWS = 10; // 0-9
    private static final int NUM_COLUMNS = 5;

    public Abacus() {
        rows = new ArrayList<>();
        
        // Initialize the abacus with beads (0-9)
        for (int i = 0; i < NUM_ROWS; i++) { // Changed from i = 0 to i < NUM_ROWS
            List<Bead> row = new ArrayList<>();
            for (int j = 0; j < NUM_COLUMNS; j++) {
                row.add(new Bead(i, j));
            }
            rows.add(row);
        }
    }

    public void toggleBead(int row, int column) {
        if (row >= 0 && row < NUM_ROWS && column >= 0 && column < NUM_COLUMNS) { // Corrected row index check
            rows.get(row).get(column).toggleSelected(); // Corrected row index usage
        }
    }

    public List<List<Bead>> getRows() {
        return rows;
    }

    public int calculateTotal() {
        int total = 0;
        for (List<Bead> row : rows) {
            for (Bead bead : row) {
                if (bead.isSelected()) {
                    total += bead.getValue();
                }
            }
        }
        return total;
    }
}