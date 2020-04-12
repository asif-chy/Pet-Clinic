package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

	public Set<PetType> findAll(){
		return super.findAll();
	}
	
	public PetType findById(Long id) {
		return super.findById(id);
	}
	
	public PetType save(PetType petType) {
		return super.save(petType);
	}
	
	public void delete(PetType petType) {
		super.delete(petType);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
