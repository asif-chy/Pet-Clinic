package guru.springframework.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {

}
