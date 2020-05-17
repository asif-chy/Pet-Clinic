package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	
	final Long ownerId = 1L;
    final String lastName = "Chowdhury";
    
	@BeforeEach
	void setUp() throws Exception {
		
		ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
		
	}

	@Test
	void testFindAll() {
		
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		
		assertEquals(1,ownerSet.size());
		
	}

	@Test
	void testFindByIdLong() {
		
		Owner owner = ownerServiceMap.findById(ownerId);
		
		assertEquals(ownerId, owner.getId());
	
	}

	@Test
	void testSaveOwner() {
		
		Long id = 2L;
		
		Owner owner2 = Owner.builder().id(id).build();
		
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertEquals(id,savedOwner.getId());
	
	}

	@Test
	void testDeleteOwner() {
		
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		
		assertEquals(0,ownerServiceMap.findAll().size());
		
	}

	@Test
	void testDeleteByIdLong() {
		
		ownerServiceMap.deleteById(ownerId);
		
		assertEquals(0,ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() throws Exception {
		
		  setUp();
		
		  Owner Chowdhury = ownerServiceMap.findByLastName(lastName);

	      assertNotNull(Chowdhury);

	      assertEquals(ownerId, Chowdhury.getId());
	
	}

}
