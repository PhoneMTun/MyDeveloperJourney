package com.codingdojo.SaveTravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.SaveTravel.models.SaveTravel;
import com.codingdojo.SaveTravel.repositories.SaveTravelRespository;

@Service
public class SaveTravelService {
	private final SaveTravelRespository saveTravelRespository;
	
	public SaveTravelService(SaveTravelRespository saveTravelRespository) {
		this.saveTravelRespository=saveTravelRespository;
	}
	public List<SaveTravel> allSaveTravels(){
		return saveTravelRespository.findAll();
	}
	public SaveTravel findSaveTravels(long id) {
		Optional<SaveTravel> optionalSaveTravels=saveTravelRespository.findById(id);
		if(optionalSaveTravels.isPresent()) {
			return optionalSaveTravels.get();
		}else {
			return null;
		}
	}
	public SaveTravel createSaveTravels(SaveTravel b) {
		return saveTravelRespository.save(b);
	}
	public SaveTravel updateSaveTravels(SaveTravel b) {
		return saveTravelRespository.save(b);
	}
	public void deleteSaveTravelService(Long id) {
		saveTravelRespository.deleteById(id);
	}
}
