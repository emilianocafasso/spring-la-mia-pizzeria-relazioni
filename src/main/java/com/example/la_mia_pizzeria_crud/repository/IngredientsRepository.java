package com.example.la_mia_pizzeria_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.la_mia_pizzeria_crud.model.Ingredient;

public interface IngredientsRepository extends JpaRepository<Ingredient, Integer> {

}
