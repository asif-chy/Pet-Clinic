package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	public Set<Vet> findAll(){
		return super.findAll();
	}
	
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	public Vet save(Vet vet) {
		return super.save(vet);
	}
	
	public void delete(Vet vet) {
		super.delete(vet);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
