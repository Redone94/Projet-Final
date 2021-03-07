package ProjetScolaire.restController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetScolaire.entity.Etablissement;
import ProjetScolaire.entity.Vue;
import ProjetScolaire.exception.EtablissementInvalidException;
import ProjetScolaire.exception.EtablissementNotFoundException;
import ProjetScolaire.service.EtablisssementService;

@RestController
@RequestMapping("/api/etablissement")
@CrossOrigin(origins="*")
public class EtablissementRestController {

	@Autowired
	private EtablisssementService etabliService;
	
	@GetMapping({ "", "/" })
	@JsonView(Vue.Common.class)
	public List<Etablissement> geEtablissement() {
		return etabliService.alletablissement();
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Etablissement> addEtablissement(@Valid @RequestBody Etablissement e, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new EtablissementInvalidException();
		}
			
		
		etabliService.creation(e);
		URI uri = uCB.path("/api/Etablissement/{id}").buildAndExpand(e.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Etablissement>(e, headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Etablissement findById(@PathVariable("id") Integer id) {
		Etablissement e = etabliService.findById(id);
		if (e.getId() != null) {
			return e;
		}
		throw new EtablissementNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(Vue.Common.class)
	public Etablissement update(@Valid @RequestBody Etablissement e, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new EtablissementInvalidException();
		}
		Etablissement EtablissementEnBase = etabliService.findById(id);
		if (EtablissementEnBase.getId() == null) {
			throw new EtablissementNotFoundException();
		}
		EtablissementEnBase.setNom(e.getNom());
		EtablissementEnBase.setAdresse(e.getAdresse());
		EtablissementEnBase.setLogo(e.getLogo());
		EtablissementEnBase.setNumeroTel(e.getNumeroTel());
		EtablissementEnBase.setTypeEtablissement(e.getTypeEtablissement());
		etabliService.save(EtablissementEnBase);
		return EtablissementEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Etablissement EtablissementEnBase = etabliService.findById(id);
		if (EtablissementEnBase.getId() == null) {
			throw new EtablissementNotFoundException();
		}
		etabliService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
