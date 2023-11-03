package com.codingdojo.DojoNinja.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoNinja.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
