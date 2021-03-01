package ProjetScolaire.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.repository.CompteRepository;


public class CompteService implements org.springframework.security.core.userdetails.UserDetailsService  {

	@Autowired
	private CompteRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Compte> opt = userRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UserDetailsWithCompte(opt.get());
		}
		throw new UsernameNotFoundException("Login inconnu");
	}
}
