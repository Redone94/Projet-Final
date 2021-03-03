package ProjetScolaire.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Vue;

import ProjetScolaire.service.UserDetailsWithCompte;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="*")
public class LoginRestController {

	@GetMapping("")
	@JsonView(Vue.Versionexist.class)
	public ResponseEntity<Compte> login(Authentication auth) {
		UserDetailsWithCompte compte= (UserDetailsWithCompte) auth.getPrincipal();
		
		return new ResponseEntity<Compte>(compte.getCompte(), HttpStatus.OK);
	}
}
