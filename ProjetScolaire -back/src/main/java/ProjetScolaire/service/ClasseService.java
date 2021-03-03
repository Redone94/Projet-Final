package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Classe;
import ProjetScolaire.repository.ClasseRepository;

@Service
public class ClasseService {
	
	@Autowired
	private ClasseRepository classerepo;
	
	public void creation(Classe service) {
		classerepo.save(service);
	}
	
	public void modification(Classe service) {
		classerepo.save(service);
	}

	public List<Classe> allclasse() {
		return classerepo.findAll();
	}

	public void delete(Classe c) {
		classerepo.delete(c);
	}

	public void delete(Integer id) {
		classerepo.deleteById(id);
	}

	public Classe findById(Integer id) {
		Optional<Classe> opt = classerepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Classe();
	}
	public Classe save(Classe c) {
		return classerepo.save(c);
	}

}
