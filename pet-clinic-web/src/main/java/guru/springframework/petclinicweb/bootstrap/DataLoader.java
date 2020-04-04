package guru.springframework.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.petclinicdata.model.Owner;
import guru.springframework.petclinicdata.model.Vet;
import guru.springframework.petclinicdata.services.OwnerService;
import guru.springframework.petclinicdata.services.PetService;
import guru.springframework.petclinicdata.services.VetService;
import guru.springframework.petclinicdata.services.map.OwnerServiceMap;
import guru.springframework.petclinicdata.services.map.PetServiceMap;
import guru.springframework.petclinicdata.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final PetService petService;
	private final VetService vetService;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		petService = new PetServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setLastName("CHY");
		owner1.setFirstName("ASIF");
		
		ownerService.save(owner1);
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setLastName("DOGGO");
		vet1.setFirstName("MAN");
		
		vetService.save(vet1);
	}
	
	

}
