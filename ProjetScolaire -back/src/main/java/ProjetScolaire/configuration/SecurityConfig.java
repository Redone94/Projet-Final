package ProjetScolaire.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import ProjetScolaire.service.CompteService;


public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CompteService compteservice;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@// @formatter:off		
		//activation des restcontroller
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().ignoringAntMatchers("/api/**")
		.and()
		.antMatcher("/api/**")
		.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous()
		.antMatchers("/api/**").authenticated()
		.and().httpBasic();
		// @formatter:on
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(compteservice);
	}

}
