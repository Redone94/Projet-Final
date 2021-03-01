package ProjetScolaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Integer id;
	
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
	
	
	@JoinColumn(name = "Matiere")
	@JsonView(Vue.Common.class)
	private Matiere matiere;
	
	@Embedded
	@JsonView(Vue.Common.class)
	private Adresse adresse;
		
	
	@JsonView(Vue.Common.class)
	private Cours cours;
	
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

	
	public Professeur(@NotEmpty String nom, @NotEmpty String prenom, LocalDate datenaissance, Matiere matiere,
			Adresse adresse, Cours cours, String image, Compte compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.matiere = matiere;
		this.adresse = adresse;
		this.cours = cours;
		this.image = image;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
		Professeur other = (Professeur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	

}
