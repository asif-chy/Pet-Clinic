package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.*;


@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final PetService petService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, PetService petService, VetService vetService,
			PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.petService = petService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogType = petTypeService.save(dog);
		
		System.out.println("Insert dog");
		
		PetType cat = new PetType();
		cat.setName("Dog");
		PetType savedCatType = petTypeService.save(cat);
		
		System.out.println("Insert cat");
		
		
		Owner owner1 = new Owner();
		
		owner1.setLastName("CHY");
		owner1.setFirstName("ASIF");
		
		Pet myPet = new Pet();
		myPet.setPetType(dog);
		myPet.setOwner(owner1);
		myPet.setBirthDate(LocalDate.now());
		myPet.setName("JOJO");
		myPet.setPetType(savedDogType);
		owner1.getPets().add(myPet);
		
		ownerService.save(owner1);
		System.out.println("Insert Owner1");
		
	    Owner owner2 = new Owner();
		
		owner2.setLastName("JACK");
		owner2.setFirstName("RABBIT");
		
		ownerService.save(owner2);
		
		Pet yoPet = new Pet();
		yoPet.setPetType(cat);
		yoPet.setOwner(owner2);
		yoPet.setBirthDate(LocalDate.now());
		yoPet.setName("GIGI");
		yoPet.setPetType(savedCatType);
		owner2.getPets().add(yoPet);
		
		ownerService.save(owner2);
		System.out.println("Insert Owner2");
		
		Vet vet1 = new Vet();
		
		vet1.setLastName("DOGGO");
		vet1.setFirstName("MAN");
		
		vetService.save(vet1);
		
		System.out.println("Insert Vet1");
	}

}
