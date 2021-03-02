package ProjetScolaire.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="professeur")
@SequenceGenerator(name = "seqProfesseur", sequenceName = "seq_professeur", initialValue = 1, allocationSize = 1)
public class Professeur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@JsonView(Vue.Common.class)
	private Integer id_professeur;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String prenom;
	
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonView(Vue.Common.class)
	private LocalDate datenaissance;
	
	
	@ManyToMany
	@JoinTable(name="List_professeurs",joinColumns = {@JoinColumn(name="id_professeur")},inverseJoinColumns = {@JoinColumn(name="id")} )
	@JsonView(Vue.Common.class)
	private List<Matiere> matiere;
	
	@Embedded
	@JsonView(Vue.Common.class)
	private Adresse adresse;
		
	@ManyToMany
	@JoinTable(name="List_professeur",joinColumns = {@JoinColumn(name="id_professeur")},inverseJoinColumns = {@JoinColumn(name="id_cours")} )
	@JsonView(Vue.Common.class)
	private List<Cours> cours;
	
	@JsonView(Vue.Common.class)
	protected String image;
	
	@OneToOne
	@JoinColumn(name="compte")
	@JsonView(Vue.Common.class)
	protected Compte compte;
	
	@Version
	protected int version;

	public Professeur() {
		super();
	}
	
	public Professeur(@NotEmpty String nom, @NotEmpty String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Professeur(Integer id_professeur, @NotEmpty String nom, @NotEmpty String prenom, LocalDate datenaissance,
			List<Matiere> matiere, Adresse adresse, List<Cours> cours, String image, Compte compte) {
		super();
		this.id_professeur = id_professeur;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.matiere = matiere;
		this.adresse = adresse;
		this.cours = cours;
		this.image = image;
		this.compte = compte;
	}

	public Integer getId_professeur() {
		return id_professeur;
	}

	public void setId_professeur(Integer id_professeur) {
		this.id_professeur = id_professeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}

	public List<Matiere> getMatiere() {
		return matiere;
	}

	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		result = prime * result + ((cours == null) ? 0 : cours.hashCode());
		result = prime * result + ((datenaissance == null) ? 0 : datenaissance.hashCode());
		result = prime * result + ((id_professeur == null) ? 0 : id_professeur.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Professeur other = (Professeur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (compte == null) {
			if (other.compte != null)
				return false;
		} else if (!compte.equals(other.compte))
			return false;
		if (cours == null) {
			if (other.cours != null)
				return false;
		} else if (!cours.equals(other.cours))
			return false;
		if (datenaissance == null) {
			if (other.datenaissance != null)
				return false;
		} else if (!datenaissance.equals(other.datenaissance))
			return false;
		if (id_professeur == null) {
			if (other.id_professeur != null)
				return false;
		} else if (!id_professeur.equals(other.id_professeur))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	

	

}
