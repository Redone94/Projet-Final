package ProjetScolaire.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	protected int numero;
	protected String voie;
	protected String ville;
	
	public Adresse() {
		super();
	}


	public Adresse(int numero, String voie, String ville) {
		super();
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
	
	

}
