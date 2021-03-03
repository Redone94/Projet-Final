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

import ProjetScolaire.entity.Cours;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.CoursInvalidException;
import ProjetScolaire.exception.CoursNotFoundException;
import ProjetScolaire.service.CoursService;

@RestController
@RequestMapping("/api/cours")
@CrossOrigin(origins="*")
public class CoursRestController {

	@Autowired
	private CoursService coursService;
	
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Cours> getCours() {
		return coursService.allcours();
	}
	@PostMapping({ "", "/" })
	public ResponseEntity<Cours> addCours(@Valid @RequestBody Cours e, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new CoursInvalidException();
		}
			
		
		coursService.creation(e);
		URI uri = uCB.path("/api/Cours/{id}").buildAndExpand(e.getId_cours()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Cours>(e, headers, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Cours findById(@PathVariable("id") Integer id) {
		Cours e = coursService.findById(id);
		if (e.getId_cours() != null) {
			return e;
		}
		throw new CoursNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Cours update(@Valid @RequestBody Cours c, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new CoursInvalidException();
		}
		Cours CoursEnBase = coursService.findById(id);
		if (CoursEnBase.getId_cours() == null) {
			throw new CoursNotFoundException();
		}
	
		CoursEnBase.setClasse(c.getClasse());
		CoursEnBase.setDateDebut(c.getDateDebut());
		CoursEnBase.setDateFin(c.getDateDebut());
		CoursEnBase.setMatieres(c.getMatieres());
		CoursEnBase.setProfesseur(c.getProfesseur());
		CoursEnBase.setSalleClasse(c.getSalleClasse());
		coursService.save(CoursEnBase);
		return CoursEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Cours CoursEnBase = coursService.findById(id);
		if (CoursEnBase.getId_cours() == null) {
			throw new CoursNotFoundException();
		}
		coursService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
