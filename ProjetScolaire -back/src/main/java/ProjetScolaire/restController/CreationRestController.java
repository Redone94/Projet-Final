package ProjetScolaire.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Role;
import ProjetScolaire.exception.UserInvalidException;
import ProjetScolaire.repository.CompteRepository;

@RestController
@RequestMapping("/api/creation")
@CrossOrigin(origins="*")
public class CreationRestController {
	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Void> ajoutUser(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new UserInvalidException();
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		compteRepository.save(compte);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{login}")
	public boolean mailDispo(@PathVariable("login") String login) {
		return compteRepository.findByLogin(login).isPresent();
	}

}
