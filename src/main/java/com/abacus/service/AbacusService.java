package com.abacus.service;

import com.abacus.model.Abacus;
import com.abacus.model.Bead;
import com.abacus.util.NumberToWordsConverter;
import org.springframework.stereotype.Service;

@Service
public class AbacusService {
    private Abacus abacus;
    
    public AbacusService() {
        this.abacus = new Abacus();
    }
    
    public Abacus getAbacus() {
        return abacus;
    }
    
    public void toggleBead(int row, int column) {
        // First, deselect any other beads in the same column
        for (int i = 0; i <= 9; i++) {  // Changed from 1 to 0 as starting point
            if (i != row) {
                // Get the bead at this position
                Bead bead = abacus.getRows().get(i).get(column);
                if (bead.isSelected()) {
                    bead.setSelected(false);
                }
            }
        }
        
        // Now toggle the selected bead
        abacus.toggleBead(row, column);
    }
    
    public int getTotal() {
        return abacus.calculateTotal();
    }
    
    public String getTotalInWords() {
        return NumberToWordsConverter.convert(getTotal());
    }
    
    public void reset() {
        this.abacus = new Abacus();
    }
}