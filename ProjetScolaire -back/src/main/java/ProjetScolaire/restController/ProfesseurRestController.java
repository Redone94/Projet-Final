package ProjetScolaire.restController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;


import ProjetScolaire.entity.Professeur;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.ProfesseurNotFoundException;
import ProjetScolaire.exception.ProfesseurinvalidException;
import ProjetScolaire.service.CompteService;
import ProjetScolaire.service.ProfesseurService;



@RestController
@RequestMapping("/api/professeur")
@CrossOrigin(origins="*")
public class ProfesseurRestController {

	@Autowired
	private ProfesseurService professeurService;

	@Autowired
	private CompteService compteService;

	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Professeur> getAllEmploye() {
		return professeurService.allProfesseur();
	}
	@PostMapping({ "", "/" })
	public ResponseEntity<Professeur> addEmploye(@Valid @RequestBody Professeur p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new ProfesseurinvalidException();
		}
		compteService.creationCompte(p.getCompte());
		
		
		professeurService.creationProfesseur(p);
		URI uri = uCB.path("/api/Employe/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Professeur>(p, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Professeur findById(@PathVariable("id") Integer id) {
		Professeur p = professeurService.findbyId(id);
		if (p.getId() != null) {
			return p;
		}
		throw new ProfesseurNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Professeur update(@Valid @RequestBody Professeur p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new ProfesseurinvalidException();
		}
		Professeur EmployeEnBase = professeurService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new ProfesseurNotFoundException();
		}
		EmployeEnBase.setPrenom(p.getPrenom());
		EmployeEnBase.setNom(p.getNom());
		professeurService.save(EmployeEnBase);
		return EmployeEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Professeur EmployeEnBase = professeurService.findbyId(id);
		if (EmployeEnBase.getId() == null) {
			throw new ProfesseurNotFoundException();
		}
		professeurService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
