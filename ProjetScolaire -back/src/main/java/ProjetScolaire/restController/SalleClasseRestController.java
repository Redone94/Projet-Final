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

import ProjetScolaire.entity.SalleClasse;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.SalleClasseInvalidException;
import ProjetScolaire.exception.SalleClasseNotFoundException;
import ProjetScolaire.service.SalleClasseService;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin(origins="*")
public class SalleClasseRestController {

	@Autowired
	private SalleClasseService salleClasseService;
	
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<SalleClasse> geSalleClasse() {
		return salleClasseService.allsalleclasse();
	}
	@PostMapping({ "", "/" })
	public ResponseEntity<SalleClasse> addSalleClasse(@Valid @RequestBody SalleClasse s, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new SalleClasseInvalidException();
		}
			
		
		salleClasseService.creation(s);
		URI uri = uCB.path("/api/salles/{id}").buildAndExpand(s.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<SalleClasse>(s, headers, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public SalleClasse findById(@PathVariable("id") Integer id) {
		SalleClasse s = salleClasseService.findById(id);
		if (s.getId() != null) {
			return s;
		}
		throw new SalleClasseNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public SalleClasse update(@Valid @RequestBody SalleClasse s, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new SalleClasseInvalidException();
		}
		SalleClasse SalleClasseEnBase = salleClasseService.findById(id);
		if (SalleClasseEnBase.getId() == null) {
			throw new SalleClasseNotFoundException();
		}
		SalleClasseEnBase.setNom(s.getNom());
		SalleClasseEnBase.setCapacite(s.getCapacite());
		SalleClasseEnBase.setCours(s.getCours());
		SalleClasseEnBase.setEtablissement(s.getEtablissement());
		salleClasseService.save(SalleClasseEnBase);
		return SalleClasseEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		SalleClasse SalleClasseEnBase = salleClasseService.findById(id);
		if (SalleClasseEnBase.getId() == null) {
			throw new SalleClasseNotFoundException();
		}
		salleClasseService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
