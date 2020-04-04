package guru.springframework.petclinicdata.services.map;

import java.util.Set;

import guru.springframework.petclinicdata.model.Pet;
import guru.springframework.petclinicdata.services.CrudService;
import guru.springframework.petclinicdata.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	public Set<Pet> findAll(){
		return super.findAll();
	}
	
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	public Pet save(Pet pet) {
		return super.save(pet.getId(), pet);
	}
	
	public void delete(Pet pet) {
		super.delete(pet);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
