package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.repository.CompteRepository;

@Service
public class CompteService implements UserDetailsService  {

	@Autowired
	private CompteRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Compte> opt = userRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UserDetailsWithCompte(opt.get());
		}
		throw new UsernameNotFoundException("login inconnu");
	}
	public void creationCompte(Compte c) {
		if (c.getLogin() != null && !c.getLogin().isEmpty() && c.getPassword() != null && !c.getPassword().isEmpty()) {
			userRepo.save(c);
		} else {
			System.out.println("Le compte n'a pas toute les infos obligatoires");
		}
	}
	public void creationCompte(String login, String password) {
		creationCompte(new Compte(login,password));
	}

	public List<Compte> allCompte() {
		return userRepo.findAll();
	}
	
	public void delete(Compte c) {
		userRepo.delete(c);
	}

	public void delete(String login) {
		userRepo.deleteById(login);
	}

	public Compte save(Compte c) {
		return userRepo.save(c);
	}

	public Compte findByLogin(String login) {
		Optional<Compte> opt = userRepo.findByLogin(login);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Compte();
	}
	
}
