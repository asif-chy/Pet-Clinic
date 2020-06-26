package guru.springframework.sfgpetclinic.controller;

import javax.validation.Valid;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Controller
public class VisitController {
	
	private final VisitService visitService;
	private final PetService petService;
	private final OwnerService ownerService;
	
	public VisitController(VisitService visitService, PetService petService, OwnerService ownerService) {
		super();
		this.visitService = visitService;
		this.petService = petService;
		this.ownerService = ownerService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
		
		Pet pet = petService.findById(petId);
		Visit visit = new Visit();
		pet.getVisit().add(visit);
		visit.setPet(pet);
		model.addAttribute("pet", pet);
		
		return visit;
		
	}
	
	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String viewVisitForm(@PathVariable Long petId, Model model) {
		return "pets/createOrUpdateVisitForm";
	}
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processVisitForm(@Valid Visit visit, BindingResult result){
		if(result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}else {
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}
	
	

}
