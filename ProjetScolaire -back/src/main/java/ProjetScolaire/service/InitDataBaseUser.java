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
import ProjetScolaire.entity.SalleClasse;
import ProjetScolaire.entity.Type_Etablissement;

import ProjetScolaire.repository.ClasseRepository;
import ProjetScolaire.repository.CompteRepository;
import ProjetScolaire.repository.EtablissementRepository;
import ProjetScolaire.repository.MatiereRepository;
import ProjetScolaire.repository.ProfesseurRepository;
import ProjetScolaire.repository.SalleClasseRepository;

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
	
	@Autowired
	private SalleClasseRepository salleRepo;

	@Override
	public void run(String... args) throws Exception {
		
		
		Adresse a= new Adresse();
		a.setNumero(153);
		a.setVille("Limoges");
		a.setVoie("Rue de la nation");
		a.setCp(87000);
	
		Adresse a1= new Adresse();
		a1.setNumero(25);
		a1.setVille("Limoges");
		a1.setVoie("Avenue des pingouins");
		a1.setCp(87000);
		
		Adresse a2= new Adresse();
		a2.setNumero(13);
		a2.setVille("Limoges");
		a2.setVoie("rue mimosa");
		a2.setCp(87000);
		
		Adresse a3= new Adresse();
		a3.setNumero(1);
		a3.setVille("Bellac");
		a3.setVoie("Rue des tontons Flingeurs");
		a3.setCp(87011);
			
		Etablissement e = new Etablissement();
		e.setAdresse(a);
		e.setNom("Jules Verne");
		e.setTypeEtablissement(Type_Etablissement.COLLEGE);
		e.setNumeroTel("05.06.52.35.49");
		etabRepo.save(e);
		
		Etablissement e1 = new Etablissement();
		e1.setAdresse(a1);
		e1.setNom("St Marco");
		e1.setTypeEtablissement(Type_Etablissement.LYCEE);
		e1.setNumeroTel("05.49.52.49.49");
		etabRepo.save(e1);

	
		
		Matiere m = new Matiere();
		m.setNomMatiere("mathematiques");
		m.setCouleur("rouge");
		matiereRepo.save(m);
		
		Matiere m1 = new Matiere();
		m1.setNomMatiere("Histoire");
		m1.setCouleur("bleu");
		matiereRepo.save(m1);
		
		

		Classe c=new Classe();
		Classe c1=new Classe();
		Classe c2=new Classe();
		c.setCours(null);
		c.setNom("5eme D");
		c.setProfPrincipal("Mme Dupont");
		classeRepo.save(c);
		
		c1.setCours(null);
		c1.setNom("3eme B");
		c1.setProfPrincipal("M Dumbo");
		classeRepo.save(c1);
		
		c2.setCours(null);
		c2.setNom("6eme B");
		c2.setProfPrincipal("Mlle Rose");
		classeRepo.save(c2);
		
		Compte reset=new Compte();
		reset.setLogin("reset");
		reset.setPassword(passwordEncorder.encode("reset*123"));
		reset.setRole(Role.ROLE_ADMIN);
		reset.setMail("red.m");
		compteRepository.save(reset);

		Compte C1=new Compte();
		Compte C2=new Compte();
		Compte C3=new Compte();
		C1.setLogin("red");
		C1.setPassword(passwordEncorder.encode("123"));
		C1.setRole(Role.ROLE_ADMIN);
		C1.setMail("radwane");
		C1.setTel("0666");
		compteRepository.save(C1);
		
		C2.setLogin("moriarty");
		C2.setPassword(passwordEncorder.encode("phys1que"));
		C2.setRole(Role.ROLE_UTILISATEUR);
		C2.setMail("radwane2");
		compteRepository.save(C2);
		
		C3.setLogin("ombrage");
		C3.setPassword(passwordEncorder.encode("potters"));
		C3.setRole(Role.ROLE_UTILISATEUR);
		C3.setMail("radwane3");
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
		
		SalleClasse s1 =new SalleClasse();
		SalleClasse s2 =new SalleClasse();
		SalleClasse s3 =new SalleClasse();
		
		s1.setNom("Neptune");
		s1.setCapacite(35);
		s1.setEtablissement(e1);
		s1.setCours(null);
		salleRepo.save(s1);
		
		s2.setNom("Jupiter");
		s2.setCapacite(20);
		s2.setEtablissement(e1);
		s2.setCours(null);
		salleRepo.save(s2);
		
		s3.setNom("Uranus");
		s3.setCapacite(40);
		s3.setEtablissement(e);
		s3.setCours(null);
		salleRepo.save(s3);
		
		
		
		
		
		
		}

}
