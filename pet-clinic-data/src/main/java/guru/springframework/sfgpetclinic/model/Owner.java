package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Owner extends Person {

	private String Address;
	private String City;
	private String Telephone;
	private Set<Pet> pets;
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public Set<Pet> getPets() {
		return pets;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
}
