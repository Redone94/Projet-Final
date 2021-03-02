package ProjetScolaire.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqSalle", sequenceName = "seq_Salle", initialValue = 1, allocationSize = 1)
@Table(name = "Salle")
public class SalleClasse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSalle")
	@JsonView(Vue.Common.class)
	private Integer id;
	
	@JsonView(Vue.Common.class)
	private String nom;
	
	private int capacite;
	
	@ManyToOne
	@JsonView(Vue.Common.class)
	protected Etablissement etablissement; 

	@ManyToMany
	@JoinTable(name="List_classes",joinColumns = {@JoinColumn(name="id")},inverseJoinColumns = {@JoinColumn(name="id_cours")} )
	@JsonView(Vue.Common.class)
	protected List<Cours> cours;
	
	@Version
	protected int version;

	public SalleClasse() {
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


	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
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
		SalleClasse other = (SalleClasse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
