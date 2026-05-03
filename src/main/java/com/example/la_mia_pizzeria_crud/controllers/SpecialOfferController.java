package com.example.la_mia_pizzeria_crud.controllers;

import com.example.la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.la_mia_pizzeria_crud.model.Pizza;
import com.example.la_mia_pizzeria_crud.model.SpecialOffer;
import com.example.la_mia_pizzeria_crud.repository.SpecialOfferRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/specialoffers")
public class SpecialOfferController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private SpecialOfferRepository specialOfferRepository;

    @GetMapping("/create/{pizzaId}")
    public String getCreateForm(@PathVariable Integer pizzaId, Model model) {
        // creo offerta vuota da passare al form
        SpecialOffer newOffer = new SpecialOffer();
        // recupero la pizza dal db tramite id
        Pizza pizza = pizzaRepository.findById(pizzaId).get();
        // collego la pizza all'offer
        newOffer.setPizza(pizza);
        // passo offer al model
        model.addAttribute("offer", newOffer);

        return "specialoffers/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offer") SpecialOffer formOffer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialoffers/create";
        }
        specialOfferRepository.save(formOffer);
        return "redirect:/pizzas/" + formOffer.getPizza().getId();
    }

    // * metodo che restituisce una edit da compilare (con dati già inseriti)
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("offer", specialOfferRepository.findById(id).get());
        return "specialoffers/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("offer") SpecialOffer formOffer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialoffers/edit";
        }
        specialOfferRepository.save(formOffer);
        return "redirect:/pizzas/" + formOffer.getPizza().getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // recupero offerta per salvare l'id della pizza
        SpecialOffer offer = specialOfferRepository.findById(id).get();
        Integer pizzaId = offer.getPizza().getId();
        // elimino
        specialOfferRepository.delete(offer);

        return "redirect:/pizzas/" + pizzaId;
    }

}
