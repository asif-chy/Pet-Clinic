package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Owner extends Person {

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Set<Pet> pets;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
