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
	
	@NotEmpty
	@Column(name="mail")
	protected String mail;
	
	
	@Column(name="tel")
	protected String tel;
		
	@Enumerated(EnumType.STRING)
	@JsonView(Vue.Common.class)
	protected Role role;
	
	
	@ManyToOne
	@JsonView(Vue.Common.class)
	protected Etablissement etablissement;
	
	@JsonView(Vue.Versionexist .class)
	@Version
	protected int version;
	
	@JsonView(Vue.Common.class)
	protected boolean statut=true;

	public Compte() {
		
	}
	
	public Compte(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}


	public Compte( @NotEmpty String login, @NotEmpty String password, @NotEmpty String mail, String tel,
			Role role, Etablissement etablissement) {
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.tel = tel;
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
	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	
	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etablissement == null) ? 0 : etablissement.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + (statut ? 1231 : 1237);
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Compte other = (Compte) obj;
		if (etablissement == null) {
			if (other.etablissement != null)
				return false;
		} else if (!etablissement.equals(other.etablissement))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (statut != other.statut)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (version != other.version)
			return false;
		return true;
	}


	
	

}
