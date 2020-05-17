package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name="owners")
public class Owner extends Person {
	
    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.Address = address;
        this.City = city;
        this.Telephone = telephone;

        if(pets != null) {
            this.pet = pets;
        }
    }
    
    
    
	@Column(name="Address")
	private String Address;
	
	@Column(name="City")
	private String City;
	
	@Column(name="Telephone")
	private String Telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	private Set<Pet> pet = new HashSet<>();
	
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
		return pet;
	}
	public void setPets(Set<Pet> pets) {
		this.pet = pets;
	}
	public Owner() {
		super();
	}
	
}
