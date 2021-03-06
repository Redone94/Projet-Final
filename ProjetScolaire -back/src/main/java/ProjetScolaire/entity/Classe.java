package ProjetScolaire.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
public class Classe {
	
	@JsonView(Vue.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	
	//@NotEmpty
	@JsonView(Vue.Common.class)
	private String profPrincipal;
	
	@OneToOne
	@JoinColumn(name="Cours")
	@JsonView(Vue.Common.class)
	private Cours cours;
	
	@Version
	protected int version;
	
	
	
	public Classe(Integer id, String nom, String profPrincipal, Cours cours, int version) {
		this.id = id;
		this.nom = nom;
		this.profPrincipal = profPrincipal;
		this.cours = cours;
		this.version = version;
	}

	public Classe()
	{
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProfPrincipal() {
		return profPrincipal;
	}

	public void setProfPrincipal(String profPrincipal) {
		this.profPrincipal = profPrincipal;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
