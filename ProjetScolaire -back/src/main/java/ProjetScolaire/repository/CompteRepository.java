package ProjetScolaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Role;

public interface CompteRepository extends JpaRepository<Compte, String> {
	
	public Optional<Compte> findByLogin(String login);
	public void deleteById(Integer id);
	public List<Compte> findAllByRole(Role role);
	public Compte findByMailAndTel(String mail,String tel);
	public Compte findByLoginAndPassword(String login,String passwrod);
	public Optional<Compte> findById(Integer id);
//	@Query("select c from Compte c left join fetch c.role where c.login=:login")
//	public Optional<Compte> findByLoginWithRole(@Param("login") String login);

}
