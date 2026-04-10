package com.example.la_mia_pizzeria_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.la_mia_pizzeria_crud.model.Pizza;

// JpaRepository<TipoEntity, TipoChiavePrimaria>
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
