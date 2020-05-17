package guru.springframework.sfgpetclinic.springdatajpa;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repository.OwnerRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerSDJpaService ownerSDJpaService;
	
	Owner returnOwner;
	
	private final String lastName = "Chowdhury";

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1l).lastName(lastName).build();
	}

	@Test
	void testFindAll() {

		Set<Owner> returnOwnerSet = new HashSet();
		returnOwnerSet.add(Owner.builder().id(1l).build());
		returnOwnerSet.add(Owner.builder().id(2l).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = ownerSDJpaService.findAll();
		
		assertNotNull(owners);
		assertEquals(2,owners.size());
		//assertEquals("CHY", chy.getLastName());
	}

	@Test
	void testFindById() {
		
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = ownerSDJpaService.findById(1L);
		
		assertNotNull(owner);
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		//fail("Not yet implemented");
		
		Owner ownerToSave = Owner.builder().id(3L).build();
		
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner saveOwner = ownerSDJpaService.save(ownerToSave);
		
		assertNotNull(saveOwner);
		
	}

	@Test
	void testDelete() {
		
		ownerSDJpaService.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
		
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		
		ownerSDJpaService.deleteById(1L);
		
		verify(ownerRepository).deleteById(anyLong());
		//fail("Not yet implemented");
	}

	@Test
	void testFindByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner chy = ownerSDJpaService.findByLastName(lastName); 
		
		assertEquals(lastName, chy.getLastName());
	
	}

}
