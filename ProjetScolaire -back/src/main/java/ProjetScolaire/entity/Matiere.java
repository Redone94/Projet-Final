package ProjetScolaire.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;


import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Matiere {
	
	@JsonView(Vue.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private String couleur;
	
	@ManyToMany
	@JoinTable(name="List_prof_matiere",joinColumns = {@JoinColumn(name="id_matiere")},inverseJoinColumns = {@JoinColumn(name="id_professeur")} )
	@JsonView(Vue.Common.class)
	private List<Professeur> professeurs;
	
	@ManyToMany
	@JoinTable(name="List_matiere_cours",joinColumns = {@JoinColumn(name="id_matiere")},inverseJoinColumns = {@JoinColumn(name="id_cours")} )
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private List<Cours> cours;
	
	@Version
	protected int version;
	
	

	public Matiere(Integer id, String nom, String couleur, List<Professeur> professeurs, List<Cours> cours,
			int version) {
		this.id = id;
		this.nom = nom;
		this.couleur = couleur;
		this.professeurs = professeurs;
		this.cours = cours;
		this.version = version;
	}


	public Matiere() {
		
	}

	
	public List<Cours> getCours() {
		return cours;
	}


	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}


	public String getNomMatiere() {
		return nom;
	}

	public void setNomMatiere(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((cours == null) ? 0 : cours.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((professeurs == null) ? 0 : professeurs.hashCode());
		result = prime * result + version;
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
		Matiere other = (Matiere) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (cours == null) {
			if (other.cours != null)
				return false;
		} else if (!cours.equals(other.cours))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (professeurs == null) {
			if (other.professeurs != null)
				return false;
		} else if (!professeurs.equals(other.professeurs))
			return false;
		if (version != other.version)
			return false;
		return true;
	}



	
}
