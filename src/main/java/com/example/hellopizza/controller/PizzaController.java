package com.example.hellopizza.controller;

import com.example.hellopizza.entity.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PizzaController {

    private final List<Pizza> pizzas = new ArrayList<>();


    @GetMapping("/")
    public String index(Model model){

            pizzas.add(new Pizza ("Fungi"));
            pizzas.add(new Pizza ("Tuna"));

            model.addAttribute("pizza", new Pizza());
            model.addAttribute("pizzas", pizzas);

            return "index";
        }
        @PostMapping("/addPizza")
        public String addPizza(Pizza pizza, Model model) {

                pizzas.add(pizza);

                Collections.reverse(pizzas);

            model.addAttribute("pizza", new Pizza());
            model.addAttribute("pizzas", pizzas);

        return "index";
        }
}
