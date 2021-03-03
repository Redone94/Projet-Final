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

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.ProfesseurNotFoundException;
import ProjetScolaire.exception.UserInvalidException;

import ProjetScolaire.service.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins="*")
public class CompteRestController {
	@Autowired
	private CompteService compteService;
	
//	
//	@GetMapping({ "", "/" })
//	@JsonView(Vue.Common.class)
//	public UserDetailsWithCompte getUser(Model model,Authentication authentif) {
//        UserDetailsWithCompte compte= (UserDetailsWithCompte) authentif.getPrincipal();
//        return compte;
//    }
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Compte> getComptes() {
		return compteService.allCompte();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Compte> addCompte(@Valid @RequestBody Compte c, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		compteService.creationCompte(c);
		URI uri = uCB.path("/api/compte/{id}").buildAndExpand(c.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Compte>(c, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{login}")
	@JsonView(Vue.Common.class)
	public Compte findById(@PathVariable("login") String login) {
		Compte c = compteService.findByLogin(login);
		if (c.getId() != null) {
			return c;
		}
		throw new UserInvalidException();
	}

	@PutMapping("/{login}")
	@JsonView(Vue.Common.class)
	public Compte update(@Valid @RequestBody Compte c, BindingResult br, @PathVariable("login") String login) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		Compte CompteEnBase = compteService.findByLogin(login);
		if (CompteEnBase.getId() == null) {
			throw new ProfesseurNotFoundException();
		}
		CompteEnBase.setLogin(c.getLogin());
		CompteEnBase.setPassword(c.getPassword());
		compteService.save(CompteEnBase);
		return CompteEnBase;
	}

	@DeleteMapping("/{login}")
	public ResponseEntity<Void> delete(@PathVariable("login") String login) {
		Compte CompteEnBase = compteService.findByLogin(login);
		if (CompteEnBase.getId() == null) {
			throw new ProfesseurNotFoundException();
		}
		compteService.delete(login);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
