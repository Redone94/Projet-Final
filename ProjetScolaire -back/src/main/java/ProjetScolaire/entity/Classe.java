package ProjetScolaire.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String profPrincipal;
	
	@OneToOne(mappedBy = "classe")
	@JsonView(Vue.Common.class)
	private Cours cours;
	
	@Version
	protected int version;
	
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
