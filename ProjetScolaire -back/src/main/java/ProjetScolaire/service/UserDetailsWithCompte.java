package ProjetScolaire.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ProjetScolaire.entity.Compte;

public class UserDetailsWithCompte implements UserDetails{

	private Compte compte;
	
	public UserDetailsWithCompte(Compte compte) {
		super();
		this.compte = compte;
	}
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(compte.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		return compte.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
