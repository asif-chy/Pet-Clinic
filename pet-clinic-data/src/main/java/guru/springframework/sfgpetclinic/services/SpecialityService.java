package guru.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;

@Service
public interface SpecialityService extends CrudService<Speciality, Long> {

}
