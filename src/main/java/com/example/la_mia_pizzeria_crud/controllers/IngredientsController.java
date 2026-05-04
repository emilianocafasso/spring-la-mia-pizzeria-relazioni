package com.example.la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.la_mia_pizzeria_crud.model.Ingredient;
import com.example.la_mia_pizzeria_crud.repository.IngredientsRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    // lista + form creazione
    @GetMapping()
    public String index(Model model) {
        List<Ingredient> ingredients = ingredientsRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("newIngredient", new Ingredient());

        return "ingredients/index";
    }

    // salva nuovo ingrediente
    @PostMapping("/create")
    public String create(Ingredient newIngredient) {
        ingredientsRepository.save(newIngredient);
        return "redirect:/ingredients";
    }

    // elimina ingrediente
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        ingredientsRepository.deleteById(id);
        return "redirect:/ingredients";
    }

}
