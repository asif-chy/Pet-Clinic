package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.*;


@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final PetService petService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, PetService petService, VetService vetService) {
		this.ownerService = ownerService;
		this.petService = petService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setLastName("CHY");
		owner1.setFirstName("ASIF");
		
		ownerService.save(owner1);
		
		System.out.println("Insert Owner1");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setLastName("DOGGO");
		vet1.setFirstName("MAN");
		
		vetService.save(vet1);
		
		System.out.println("Insert Vet1");
	}

}
