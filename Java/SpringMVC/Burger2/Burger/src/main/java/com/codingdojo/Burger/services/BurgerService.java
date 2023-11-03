package com.codingdojo.Burger.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Burger.models.Burger;
import com.codingdojo.Burger.respositories.BurgerRespository;

@Service
public class BurgerService {
	private final BurgerRespository burgerRespository;
	
	public BurgerService(BurgerRespository burgerRespository) {
		this.burgerRespository=burgerRespository;
	}
	public List<Burger> allBurgers(){
		return burgerRespository.findAll();
	}
	public Burger findBurger(Long id){
		Optional<Burger> optionalBurger=burgerRespository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
	}else {
		return null;
	}
	}
	public Burger createBurger(Burger b) {
		return burgerRespository.save(b);
	}
	public Burger updateBurger(Burger b) {
		return burgerRespository.save(b);
	}
}
