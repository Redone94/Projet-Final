package ProjetScolaire.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="etablissement")
@SequenceGenerator(name = "seqEtablisssement", sequenceName = "seq_etablissement", initialValue = 1, allocationSize = 1)
public class Etablissement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEtablisssement")
	@JsonView(Vue.Common.class)
	private Integer id;
	
	
	@JsonView(Vue.Common.class)
	private String nom;

	
	@JsonView(Vue.Common.class)
	private int numeroTel;
	
	@OneToMany(mappedBy = "etablissement")
	private List<Compte> compte;
	
	@OneToMany(mappedBy = "etablissement")
	private List<SalleClasse> salleclasse;
	
	@Enumerated(EnumType.STRING)
	@JsonView(Vue.Common.class)
	private Type_Etablissemnt TypeEtablissement;
	
	@Embedded
	private Adresse adresse;
	
	
	@JsonView(Vue.Common.class)
	private String Logo;
	
	@Version
	protected int version;


	public Etablissement() {
		super();
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


	public int getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}


	public Type_Etablissemnt getTypeEtablissement() {
		return TypeEtablissement;
	}


	public void setTypeEtablissement(Type_Etablissemnt typeEtablissement) {
		TypeEtablissement = typeEtablissement;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getLogo() {
		return Logo;
	}


	public void setLogo(String logo) {
		Logo = logo;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public List<Compte> getCompte() {
		return compte;
	}


	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}


	public List<SalleClasse> getSalleclasse() {
		return salleclasse;
	}


	public void setSalleclasse(List<SalleClasse> salleclasse) {
		this.salleclasse = salleclasse;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Logo == null) ? 0 : Logo.hashCode());
		result = prime * result + ((TypeEtablissement == null) ? 0 : TypeEtablissement.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numeroTel;
		result = prime * result + ((salleclasse == null) ? 0 : salleclasse.hashCode());
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
		Etablissement other = (Etablissement) obj;
		if (Logo == null) {
			if (other.Logo != null)
				return false;
		} else if (!Logo.equals(other.Logo))
			return false;
		if (TypeEtablissement != other.TypeEtablissement)
			return false;
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
		if (numeroTel != other.numeroTel)
			return false;
		if (salleclasse == null) {
			if (other.salleclasse != null)
				return false;
		} else if (!salleclasse.equals(other.salleclasse))
			return false;
		if (version != other.version)
			return false;
		return true;
	}




}
