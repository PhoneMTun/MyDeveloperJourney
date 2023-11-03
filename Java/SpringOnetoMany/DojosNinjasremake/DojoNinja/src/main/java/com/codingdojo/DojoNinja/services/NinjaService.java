package com.codingdojo.DojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoNinja.models.Dojo;
import com.codingdojo.DojoNinja.models.Ninja;
import com.codingdojo.DojoNinja.repo.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo repo;
	public NinjaService(NinjaRepo repo) {
		this.repo=repo;
	}
	public List<Ninja> all(){
		return repo.findAll();
	}
	public Ninja create(Ninja ninja) {
		return repo.save(ninja);
	}
	public Ninja find(Long id) {
		Optional<Ninja> result= repo.findById(id);
		if(result.isPresent()) {
			return result.get();
			
		}else {
			return null;
		}
	}
	public List<Ninja> byDojo(Dojo dojo){
		return repo.findAllByDojo(dojo);
		
	}
	 
}
