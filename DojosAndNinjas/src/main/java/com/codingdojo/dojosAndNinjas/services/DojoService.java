package com.codingdojo.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.repositories.DojoRepository;


@Service
public class DojoService {
	@Autowired
	private DojoRepository repo;
	
	public List<Dojo> allDojos(){
		return repo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = repo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	

}
