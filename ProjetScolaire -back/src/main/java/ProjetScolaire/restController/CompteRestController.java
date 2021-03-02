package ProjetScolaire.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Etablissement;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.repository.CompteRepository;
import ProjetScolaire.service.UserDetailsWithCompte;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins="*")
public class CompteRestController {
	@Autowired
	private CompteRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public UserDetailsWithCompte getUser(Model model,Authentication authentif) {
        UserDetailsWithCompte compte= (UserDetailsWithCompte) authentif.getPrincipal();
        return compte;
    }
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public Etablissement getEtablissement(Model model,Authentication authentif) {
		return null;
		
	}
	
}
