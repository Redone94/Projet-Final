package ProjetScolaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetScolaire.entity.Etablissement;
import ProjetScolaire.repository.EtablissementRepository;


@Service
public class EtablisssementService {
	
	@Autowired
	private EtablissementRepository etablissementrepo;
	
	public void creation(Etablissement etablissement) {
		etablissementrepo.save(etablissement);
	}
	
	public void modification(Etablissement etablissement) {
		etablissementrepo.save(etablissement);
	}

	public List<Etablissement> alletablissement() {
		return etablissementrepo.findAll();
	}

	public void delete(Etablissement e) {
		etablissementrepo.delete(e);
	}

	public void delete(Integer id) {
		etablissementrepo.deleteById(id);
	}

	public Etablissement findById(Integer id) {
		Optional<Etablissement> opt = etablissementrepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Etablissement();
	}
	public Etablissement save(Etablissement e) {
		return etablissementrepo.save(e);
	}

}
