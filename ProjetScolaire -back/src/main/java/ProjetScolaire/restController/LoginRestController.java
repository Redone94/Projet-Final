package ProjetScolaire.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.ProfesseurNotFoundException;
import ProjetScolaire.exception.UserInvalidException;
import ProjetScolaire.service.CompteService;
import ProjetScolaire.service.UserDetailsWithCompte;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="*")
public class LoginRestController {
	@Autowired
	private CompteService compteService;
	
	@GetMapping("")
	@JsonView(Vue.Versionexist.class)
	public ResponseEntity<Compte> login(Authentication auth) {
		UserDetailsWithCompte compte= (UserDetailsWithCompte) auth.getPrincipal();
		
		return new ResponseEntity<Compte>(compte.getCompte(), HttpStatus.OK);
	}
//	@PostMapping("/reset")
//	@JsonView(Vue.Common.class)
//	public Compte update(Authentication auth) {
//		UserDetailsWithCompte compte= (UserDetailsWithCompte) auth.getPrincipal();
//		if (br.hasErrors()) {
//			throw new UserInvalidException();
//		}
//		Compte CompteEnBase = compteService.findByLogin(compte.getUsername());
//		if (CompteEnBase.getId() == null) {
//			throw new ProfesseurNotFoundException();
//		}
//		CompteEnBase.setLogin(c.getLogin());
//		CompteEnBase.setPassword(c.getPassword());
//		compteService.save(CompteEnBase);
//		return CompteEnBase;
//	}
}
