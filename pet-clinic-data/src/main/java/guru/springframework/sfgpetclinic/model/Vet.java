package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vet")
public class Vet extends Person {

	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="vet_specialties", joinColumns = @JoinColumn(name="vet_id"),
	inverseJoinColumns = @JoinColumn(name="specialty_id"))
	private Set<Speciality> speciality = new HashSet<>();

	public Set<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Set<Speciality> speciality) {
		this.speciality = speciality;
	}
	
}
