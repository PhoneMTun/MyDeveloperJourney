package com.codingdojo.Burger.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Burger.models.Burger;


public interface BurgerRespository extends CrudRepository<Burger, Long>{
List<Burger> findAll();
}
