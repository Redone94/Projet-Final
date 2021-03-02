package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ProjetScolaire.entity.Matiere;
import ProjetScolaire.repository.MatiereRepository;

public class MatiereService {

	@Autowired
	private MatiereRepository matiereRepo;
	
	public void creation(Matiere service) {
		matiereRepo.save(service);
	}
	
	public void modification(Matiere service) {
		matiereRepo.save(service);
	}

	public List<Matiere> allservice() {
		return matiereRepo.findAll();
	}

	public void delete(Matiere m) {
		matiereRepo.delete(m);
	}

	public void delete(Integer id) {
		matiereRepo.deleteById(id);
	}

	public Matiere findById(Integer id) {
		Optional<Matiere> opt = matiereRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Matiere();
	}
	public Matiere save(Matiere m) {
		return matiereRepo.save(m);
	}

	
}
