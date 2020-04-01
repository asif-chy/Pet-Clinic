package guru.springframework.petclinicdata.services.map;

import java.util.Set;

import guru.springframework.petclinicdata.model.Vet;
import guru.springframework.petclinicdata.services.CrudService;

public class VetService extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long>{

	public Set<Vet> findAll(){
		return super.findAll();
	}
	
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}
	
	public void delete(Vet vet) {
		super.delete(vet);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
