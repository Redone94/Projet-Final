package ProjetScolaire.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Matiere {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nomMatiere;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String couleur;
	
	
	@JoinColumn(name="professeur")
	@JsonView(Vue.Common.class)
	private Set<Professeur> professeurs;
	
	@Version
	protected int version;

	public Matiere() {
		
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Set<Professeur> getProfesseur() {
		return professeurs;
	}

	public void setProfesseur(Set<Professeur> professeur) {
		this.professeurs = professeur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
