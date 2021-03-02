package ProjetScolaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Classe;
import ProjetScolaire.entity.Matiere;
import ProjetScolaire.repository.ClasseRepository;
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
			
			

		}
		
}
