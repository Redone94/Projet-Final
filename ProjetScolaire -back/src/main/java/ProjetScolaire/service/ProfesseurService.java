package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Professeur;
import ProjetScolaire.repository.ProfesseurRepository;

@Service
public class ProfesseurService {
	
	@Autowired
	private ProfesseurRepository professeurRepo;
	
	
	public void creationProfesseur(Professeur e) {
		if (e.getPrenom() != null && !e.getPrenom().isEmpty() && e.getNom() != null && !e.getNom().isEmpty()) {
			professeurRepo.save(e);
		} else {
			System.out.println("l'Professeur n'a pas toute les infos obligatoires");
		}
	}

	public void creationProfesseur(String prenom, String nom) {
		creationProfesseur(new Professeur(nom,prenom));
	}

	public List<Professeur> allProfesseur() {
		return professeurRepo.findAll();
	}
	
	public void delete(Professeur p) {
		professeurRepo.delete(p);
	}

	public void delete(Integer id) {
		professeurRepo.deleteById(id);
	}

	public Professeur save(Professeur p) {
		return professeurRepo.save(p);
	}

	public Professeur findbyId(Integer id) {
		Optional<Professeur> opt = professeurRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Professeur();
	}

}
