package ProjetScolaire.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Reset;
import ProjetScolaire.entity.Vue;
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
	@PostMapping("/reset")
	@JsonView(Vue.Common.class)
	public void resetCompte(@RequestBody Reset o) {
		String email=o.getEmail();
		String numero=o.getNumero();
//		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//		System.out.println(email);
		Compte c= new Compte();
		// find by email and check phone number if correct//
		
	}
}
