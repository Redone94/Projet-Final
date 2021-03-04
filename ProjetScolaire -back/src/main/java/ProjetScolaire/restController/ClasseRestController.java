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

import ProjetScolaire.entity.Classe;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.ClasseInvalidException;
import ProjetScolaire.exception.ClasseNotFoundException;

import ProjetScolaire.service.ClasseService;


@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins="*")
public class ClasseRestController {


	@Autowired
	private ClasseService classeService;


	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Classe> getClasses() {
		return classeService.allclasse();
	}
	@PostMapping({ "", "/" })
	public ResponseEntity<Classe> addClasse(@Valid @RequestBody Classe c, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new ClasseInvalidException();
		}
		
		classeService.creation(c);
		URI uri = uCB.path("/api/classes/{id}").buildAndExpand(c.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Classe>(c, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Classe findById(@PathVariable("id") Integer id) {
		Classe m = classeService.findById(id);
		if (m.getId() != null) {
			return m;
		}
		throw new ClasseNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Classe update(@Valid @RequestBody Classe c, BindingResult br, @PathVariable("id") Integer id) {
		
		
		if (br.hasErrors()) {
			throw new ClasseInvalidException();
		}
		Classe classeEnBase = classeService.findById(id);
		if (classeEnBase.getId() == null) {
			throw new ClasseNotFoundException();
		}
		classeEnBase.setNom(c.getNom());
		classeEnBase.setProfPrincipal(c.getProfPrincipal());

		classeService.save(classeEnBase);
		return classeEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Classe ClasseEnBase = classeService.findById(id);
		if (ClasseEnBase.getId() == null) {
			throw new ClasseNotFoundException();
		}
		classeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}	
	
