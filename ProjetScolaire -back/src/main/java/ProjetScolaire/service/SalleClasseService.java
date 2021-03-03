package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.SalleClasse;
import ProjetScolaire.repository.SalleClasseRepository;

@Service
public class SalleClasseService {
	
	@Autowired
	private SalleClasseRepository salleClasseRepo;
	
	
	public void creation(SalleClasse service) {
		salleClasseRepo.save(service);
	}
	
	public void modification(SalleClasse service) {
		salleClasseRepo.save(service);
	}

	public List<SalleClasse> allsalleclasse() {
		return salleClasseRepo.findAll();
	}

	public void delete(SalleClasse s) {
		salleClasseRepo.delete(s);
	}

	public void delete(Integer id) {
		salleClasseRepo.deleteById(id);
	}

	public SalleClasse findById(Integer id) {
		Optional<SalleClasse> opt = salleClasseRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new SalleClasse();
	}
	public SalleClasse save(SalleClasse s) {
		return salleClasseRepo.save(s);
	}


}
