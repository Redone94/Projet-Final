package ProjetScolaire.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cours;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private LocalDate dateDebut;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private LocalDate dateFin;
	
	
	@ManyToMany
	@JoinTable(name="List_matieres",joinColumns = {@JoinColumn(name="id_cours")},inverseJoinColumns = {@JoinColumn(name="id")} )
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private List<Matiere> matieres;
	
	@ManyToMany
	@JoinTable(name="List_classes",joinColumns = {@JoinColumn(name="id_cours")},inverseJoinColumns = {@JoinColumn(name="id")} )
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private List<SalleClasse> salleClasse;
	
	@OneToOne(mappedBy = "cours")
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private Classe classe;
	
	@ManyToMany
	@JoinTable(name="List_professeurs",joinColumns = {@JoinColumn(name="id")},inverseJoinColumns = {@JoinColumn(name="id_professeur")} )
	@JsonView(Vue.Common.class)
	private List<Professeur> professeur;
	
	@Version
	protected int version;
	
	public Cours()
	{
		
	}



	public Integer getId_cours() {
		return id_cours;
	}



	public void setId_cours(Integer id_cours) {
		this.id_cours = id_cours;
	}



	public List<Professeur> getProfesseur() {
		return professeur;
	}



	public void setProfesseur(List<Professeur> professeur) {
		this.professeur = professeur;
	}



	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public List<SalleClasse> getSalleClasse() {
		return salleClasse;
	}

	public void setSalleClasse(List<SalleClasse> salleClasse) {
		this.salleClasse = salleClasse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((id_cours == null) ? 0 : id_cours.hashCode());
		result = prime * result + ((matieres == null) ? 0 : matieres.hashCode());
		result = prime * result + ((professeur == null) ? 0 : professeur.hashCode());
		result = prime * result + ((salleClasse == null) ? 0 : salleClasse.hashCode());
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
		Cours other = (Cours) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (id_cours == null) {
			if (other.id_cours != null)
				return false;
		} else if (!id_cours.equals(other.id_cours))
			return false;
		if (matieres == null) {
			if (other.matieres != null)
				return false;
		} else if (!matieres.equals(other.matieres))
			return false;
		if (professeur == null) {
			if (other.professeur != null)
				return false;
		} else if (!professeur.equals(other.professeur))
			return false;
		if (salleClasse == null) {
			if (other.salleClasse != null)
				return false;
		} else if (!salleClasse.equals(other.salleClasse))
			return false;
		if (version != other.version)
			return false;
		return true;
	}



}
