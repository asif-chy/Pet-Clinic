package guru.springframework.sfgpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repository.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;

@Service
@Profile("springDataJpaService")
public class OwnerSDJpaService implements OwnerService{
	
	private final OwnerRepository ownerRepository;
 
	public OwnerSDJpaService(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
		
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public java.util.List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findAllByLastNameLike(lastName);
	}

	


	
	

}
