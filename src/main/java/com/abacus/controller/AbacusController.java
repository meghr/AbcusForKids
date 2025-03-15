package com.abacus.controller;

import com.abacus.model.Abacus;
import com.abacus.service.AbacusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AbacusController {
    
    @Autowired
    private AbacusService abacusService;
    
    @GetMapping("/")
    public String showAbacus(Model model) {
        model.addAttribute("abacus", abacusService.getAbacus());
        model.addAttribute("total", abacusService.getTotal());
        model.addAttribute("totalInWords", abacusService.getTotalInWords());
        return "abacus";
    }
    
    @PostMapping("/toggle")
    public String toggleBead(@RequestParam("row") int row, 
                             @RequestParam("column") int column) {
        abacusService.toggleBead(row, column);
        return "redirect:/";
    }
    
    @PostMapping("/reset")
    public String reset() {
        abacusService.reset();
        return "redirect:/";
    }
}