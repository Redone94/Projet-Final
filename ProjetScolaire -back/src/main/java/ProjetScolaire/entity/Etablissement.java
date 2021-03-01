package ProjetScolaire.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		Etablissement other = (Etablissement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	


	
	


}
