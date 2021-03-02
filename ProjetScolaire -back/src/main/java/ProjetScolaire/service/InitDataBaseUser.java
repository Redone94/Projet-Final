package ProjetScolaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Classe;
import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Matiere;
import ProjetScolaire.entity.Role;
import ProjetScolaire.repository.ClasseRepository;
import ProjetScolaire.repository.CompteRepository;
import ProjetScolaire.repository.MatiereRepository;
import ProjetScolaire.repository.ProfesseurRepository;

@Service	
public class InitDataBaseUser implements CommandLineRunner{

	@Autowired
	private MatiereRepository matiereRepo;

	@Autowired
	private ClasseRepository classeRepo;


	@Autowired
	private ProfesseurRepository profRepo;

	@Autowired
	private PasswordEncoder passwordEncorder;
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("test");
		Matiere m = new Matiere();
		m.setNomMatiere("mathematiques");
		m.setCouleur("rouge");

		Classe c=new Classe();
		c.setCours(null);
		c.setNom("5eme D");
		c.setProfPrincipal("Mme Dupont");


		matiereRepo.save(m);
		classeRepo.save(c);
		
		Compte C1=new Compte();
		
		C1.setLogin("red");
		C1.setPassword(passwordEncorder.encode("123"));
		C1.setRole(Role.ROLE_ADMIN);
		compteRepository.save(C1);
	}

}
