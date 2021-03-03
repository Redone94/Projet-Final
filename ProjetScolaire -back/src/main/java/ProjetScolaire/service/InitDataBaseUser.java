package ProjetScolaire.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Adresse;
import ProjetScolaire.entity.Classe;
import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Etablissement;
import ProjetScolaire.entity.Matiere;
import ProjetScolaire.entity.Professeur;
import ProjetScolaire.entity.Role;
import ProjetScolaire.entity.Type_Etablissement;

import ProjetScolaire.repository.ClasseRepository;
import ProjetScolaire.repository.CompteRepository;
import ProjetScolaire.repository.EtablissementRepository;
import ProjetScolaire.repository.MatiereRepository;
import ProjetScolaire.repository.ProfesseurRepository;

@Service	
public class InitDataBaseUser implements CommandLineRunner{

	@Autowired
	private MatiereRepository matiereRepo;

	@Autowired
	private ClasseRepository classeRepo;
	
	@Autowired
	private EtablissementRepository  etabRepo;

	@Autowired
	private ProfesseurRepository profRepo;

	@Autowired
	private PasswordEncoder passwordEncorder;
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Adresse a= new Adresse();
		a.setNumero(153);
		a.setVille("Limoges");
		a.setVoie("Rue de la nation");
	
		Adresse a1= new Adresse();
		a1.setNumero(25);
		a1.setVille("Limoges");
		a1.setVoie("Avenue des pingouins");
		
		Adresse a2= new Adresse();
		a2.setNumero(13);
		a2.setVille("Limoges");
		a2.setVoie("rue mimosa");
		
		Adresse a3= new Adresse();
		a3.setNumero(1);
		a3.setVille("Bellac");
		a3.setVoie("Rue des tontons Flingeurs");
		
			
		Etablissement e = new Etablissement();
		e.setAdresse(a);
		e.setNom("Jules Verne");
		e.setTypeEtablissement(Type_Etablissement.TYPE_COLLEGE);
		etabRepo.save(e);
		
		Etablissement e1 = new Etablissement();
		e1.setAdresse(a1);
		e1.setNom("St Marco");
		e1.setTypeEtablissement(Type_Etablissement.TYPE_LYCEE);
		etabRepo.save(e1);

		System.out.println("test");
		
		Matiere m = new Matiere();
		m.setNomMatiere("mathematiques");
		m.setCouleur("rouge");
		matiereRepo.save(m);
		
		Matiere m1 = new Matiere();
		m1.setNomMatiere("Histoire");
		m1.setCouleur("bleu");
		matiereRepo.save(m1);
		
		

		Classe c=new Classe();
		c.setCours(null);
		c.setNom("5eme D");
		c.setProfPrincipal("Mme Dupont");
		classeRepo.save(c);
		
		Compte C1=new Compte();
		Compte C2=new Compte();
		Compte C3=new Compte();
		C1.setLogin("red");
		C1.setPassword(passwordEncorder.encode("123"));
		C1.setRole(Role.ROLE_ADMIN);
		compteRepository.save(C1);
		
		C2.setLogin("moriarty");
		C2.setPassword(passwordEncorder.encode("phys1que"));
		C2.setRole(Role.ROLE_UTILISATEUR);
		compteRepository.save(C2);
		
		C3.setLogin("ombrage");
		C3.setPassword(passwordEncorder.encode("potters"));
		C3.setRole(Role.ROLE_UTILISATEUR);
		compteRepository.save(C3);
		
		
		Professeur p = new Professeur();
		p.setNom("Moriarty");
		p.setPrenom("James");
		p.setDatenaissance(LocalDate.of(1988, 11, 25));
		p.setCompte(C2);
		p.setAdresse(a3);
		profRepo.save(p);
		
		Professeur p1 = new Professeur();
		p1.setNom("Dupont");
		p1.setPrenom("Dolores");
		p1.setDatenaissance(LocalDate.of(1968, 05, 01));
		p1.setCompte(C3);
		p1.setAdresse(a2);
		profRepo.save(p1);
		
		
		
		}

}
