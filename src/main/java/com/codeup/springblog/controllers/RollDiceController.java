package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        Random rand = new Random();
        int random = rand.nextInt(6) + 1;

        model.addAttribute("n", n);
        model.addAttribute("random", random);
        if (n == random) {
            model.addAttribute("correct", true);
        }
        return "roll-dice";
    }
}
