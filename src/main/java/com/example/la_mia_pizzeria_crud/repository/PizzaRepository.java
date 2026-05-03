package com.example.la_mia_pizzeria_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.la_mia_pizzeria_crud.model.Pizza;

// JpaRepository<TipoEntity, TipoChiavePrimaria>
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    /*
     * ottengo gratis: findAll, findById, save, deleteById, count, existById e
     * supporto paginazione e ordinamento
     * posso aggiungere anche metodi personalizzati (query personalizzate)
     */

}
