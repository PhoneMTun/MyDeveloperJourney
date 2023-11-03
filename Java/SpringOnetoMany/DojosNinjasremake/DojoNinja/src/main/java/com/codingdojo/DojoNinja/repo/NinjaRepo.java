package com.codingdojo.DojoNinja.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoNinja.models.Dojo;
import com.codingdojo.DojoNinja.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}
