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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Matiere;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.MatiereInvalidException;
import ProjetScolaire.exception.MatiereNotFoundException;

import ProjetScolaire.service.MatiereService;


@RestController
@RequestMapping("/api/matieres")
@CrossOrigin(origins="*")
public class MatiereRestController {


	@Autowired
	private MatiereService matiereService;


	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Matiere> getMatieres() {
		return matiereService.allMatiere();
	}
	@PostMapping({ "", "/" })
	public ResponseEntity<Matiere> addMatiere(@Valid @RequestBody Matiere m, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new MatiereInvalidException();
		}
		
		matiereService.creationMatiere(m);
		URI uri = uCB.path("/api/matieres/{id}").buildAndExpand(m.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Matiere>(m, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Matiere findById(@PathVariable("id") Integer id) {
		Matiere m = matiereService.find(id);
		if (m.getId() != null) {
			return m;
		}
		throw new MatiereNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Matiere update(@Valid @RequestBody Matiere m, BindingResult br, @PathVariable("id") Integer id) {
		
		
		if (br.hasErrors()) {
			throw new MatiereInvalidException();
		}
		Matiere matiereEnBase = matiereService.find(id);
		if (matiereEnBase.getId() == null) {
			throw new MatiereNotFoundException();
		}
		matiereEnBase.setNomMatiere(m.getNomMatiere());
		matiereEnBase.setCouleur(m.getCouleur());

		matiereService.save(matiereEnBase);
		return matiereEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Matiere MatiereEnBase = matiereService.find(id);
		if (MatiereEnBase.getId() != null) {
			throw new MatiereNotFoundException();
		}
		matiereService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}	
	
