package com.codingdojo.SaveTravel.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.SaveTravel.models.SaveTravel;

public interface SaveTravelRespository extends CrudRepository<SaveTravel, Long>{
	List <SaveTravel> findAll();
	Optional <SaveTravel> findById(Long id); 

}
