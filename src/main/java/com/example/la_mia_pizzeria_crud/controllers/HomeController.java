// package com.example.la_mia_pizzeria_crud.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.la_mia_pizzeria_crud.model.Pizza;
// import com.example.la_mia_pizzeria_crud.repository.PizzaRepository;

// @Controller
// @RequestMapping("/")
// public class HomeController {

// @Autowired // spring initetta in automatico il repository
// private PizzaRepository pizzaRepository;

// @GetMapping
// public String index(Model model) {

// // recupero tutte le pizze dal db
// List<Pizza> pizzas = pizzaRepository.findAll();
// // e le pesso al model con nome "pizzas"
// model.addAttribute("pizzas", pizzas);

// // infine restituisco il nome del template thymeleaf
// return "pizzas/index";
// }
// }
