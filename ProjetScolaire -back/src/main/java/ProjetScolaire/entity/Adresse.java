package ProjetScolaire.entity;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@JsonView(Vue.Common.class)
	protected int numero;
	@JsonView(Vue.Common.class)
	protected String voie;
	
	@JsonView(Vue.Common.class)
	protected int cp;
	
	@JsonView(Vue.Common.class)
	protected String ville;
	
	public Adresse() {
		super();
	}

	public Adresse(int numero, String voie, int cp, String ville) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		result = prime * result + ((voie == null) ? 0 : voie.hashCode());
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
		Adresse other = (Adresse) obj;
		if (numero != other.numero)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		if (voie == null) {
			if (other.voie != null)
				return false;
		} else if (!voie.equals(other.voie))
			return false;
		return true;
	}
	
	

}
