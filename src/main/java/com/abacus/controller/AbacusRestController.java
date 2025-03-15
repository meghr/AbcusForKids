package com.abacus.controller;

import com.abacus.service.AbacusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/abacus")
public class AbacusRestController {
    
    @Autowired
    private AbacusService abacusService;
    
    @PostMapping("/toggle")
    public Map<String, Object> toggleBead(@RequestParam("row") int row, 
                                          @RequestParam("column") int column) {
        abacusService.toggleBead(row, column);
        
        Map<String, Object> response = new HashMap<>();
        response.put("total", abacusService.getTotal());
        response.put("totalInWords", abacusService.getTotalInWords());
        return response;
    }
}