package ProjetScolaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 1, allocationSize = 1)
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView(Vue.Common.class)
	protected Integer id;
	
	@NotEmpty
	@Column(unique=true)
	@JsonView(Vue.Common.class)
	protected String login;
	
	@NotEmpty
	@Column(name="password", length = 150, nullable=false)
	protected String password;
		
	@Enumerated(EnumType.STRING)
	@JsonView(Vue.Common.class)
	protected Role role;
	
	@ManyToOne
	@JsonView(Vue.Common.class)
	protected Etablissement etablissement;
	
	@Version
	protected int version;

	public Compte() {
		
	}
	
	public Compte(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Compte(String login, String password, Role role, Etablissement etablissement) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
		this.etablissement = etablissement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	


	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
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
