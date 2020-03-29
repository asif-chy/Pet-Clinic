package guru.springframework.petclinicdata.services;

import java.util.Set;

import guru.springframework.petclinicdata.model.Owner;
import guru.springframework.petclinicdata.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();

}
