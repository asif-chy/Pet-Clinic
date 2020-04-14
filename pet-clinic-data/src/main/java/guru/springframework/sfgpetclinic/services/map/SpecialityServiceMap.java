package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService{

	public Set<Speciality> findAll(){
		return super.findAll();
	}
	
	public Speciality findById(Long id) {
		return super.findById(id);
	}
	
	public Speciality save(Speciality speciality) {
		return super.save(speciality);
	}
	
	public void delete(Speciality speciality) {
		super.delete(speciality);
	}

	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
