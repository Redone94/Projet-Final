package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ProjetScolaire.entity.Cours;
import ProjetScolaire.repository.CoursRepository;

public class CoursService {
	
	@Autowired
	private CoursRepository coursRepo;
	
	public void creation(Cours service) {
		coursRepo.save(service);
	}
	
	public void modification(Cours service) {
		coursRepo.save(service);
	}

	public List<Cours> allservice() {
		return coursRepo.findAll();
	}

	public void delete(Cours c) {
		coursRepo.delete(c);
	}

	public void delete(Integer id) {
		coursRepo.deleteById(id);
	}

	public Cours findById(Integer id) {
		Optional<Cours> opt = coursRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Cours();
	}
	public Cours save(Cours c) {
		return coursRepo.save(c);
	}

}
