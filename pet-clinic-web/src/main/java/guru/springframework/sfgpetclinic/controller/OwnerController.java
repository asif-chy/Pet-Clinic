package guru.springframework.sfgpetclinic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedField(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/*
	 * @RequestMapping({ "/owners", "/owners/index", "/owners/index.html" }) public
	 * String listOwner(Model model) {
	 * 
	 * model.addAttribute("owners", ownerService.findAll());
	 * 
	 * return "owners/index"; }
	 */

	@GetMapping("/owners/{ownerId}")
	public String viewOwner(@PathVariable String ownerId, Model model) {

		model.addAttribute("owner", ownerService.findById(Long.valueOf(ownerId)));

		return "/owners/ownerDetails";
	}

	@RequestMapping("/findOwnerForm")
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());

		return "owners/findOwners";
	}

	@GetMapping("/owners")
	public String processFindForm(Owner owner, BindingResult result, Model model) {

		if (null == owner.getLastName()) {
			owner.setLastName("");
		}

		List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

		if (owners.isEmpty()) {

			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		} else if (owners.size() == 1) {
			owner = owners.get(0);
			return "redirect:/owners/" + owner.getId();
		} else {
			model.addAttribute("selections", owners);
			return ("owners/ownersList");
		}

	}
	
	@GetMapping("/owners/new")
	public String viewCreateForm(Model model) {
		
		model.addAttribute("owner", Owner.builder().build());
		
		return "owners/createOrUpdateOwnerForm";
	}
	
	@PostMapping("/owners/new")
	public String processCreateForm(@Valid Owner owner, BindingResult result) {
		
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}else {
			
			Owner savedOwner = ownerService.save(owner);
			return"redirect:/owners/"+savedOwner.getId();
		}
		
		
	}
	
	@GetMapping("owners/{ownerId}/edit")
	public String viewUpdateForm(@PathVariable Long ownerId, Model model) {
		
		Owner owner = ownerService.findById(ownerId);
		
		model.addAttribute("owner", owner);
		
		return "owners/createOrUpdateOwnerForm";
	}
	
	@PostMapping("owners/{ownerId}/edit")
	public String processUpdateForm(Owner owner, BindingResult result, @PathVariable Long ownerId) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}else {
			owner.setId(ownerId);
			Owner savedOwner = ownerService.save(owner);
			
			return"redirect:owners/"+savedOwner.getId();
		}
	}
	

}
