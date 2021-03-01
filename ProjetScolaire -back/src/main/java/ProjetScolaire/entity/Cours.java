package ProjetScolaire.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private LocalDate dateDebut;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private LocalDate dateFin;
	
	
	@ManyToMany
	@JoinColumn(name="matiere")
	@NotEmpty
	@JsonView(Vue.Common.class)
	private Set<Matiere> matieres;
	
	@ManyToMany
	@JoinColumn(name="salleClasse")
	@NotEmpty
	@JsonView(Vue.Common.class)
	private Set<SalleClasse> salleClasse;
	
	@OneToOne
	@NotEmpty
	@JsonView(Vue.Common.class)
	private Classe classe;
	
	@ManyToMany
	@JoinColumn(name ="professeur")
	@NotEmpty
	@JsonView
	private Professeur professeur;
	
	@Version
	protected int version;
	
	public Cours()
	{
		
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
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


	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Set<SalleClasse> getSalleClasse() {
		return salleClasse;
	}

	public void setSalleClasse(Set<SalleClasse> salleClasse) {
		this.salleClasse = salleClasse;
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
