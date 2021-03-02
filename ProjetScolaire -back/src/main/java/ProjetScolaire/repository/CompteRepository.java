package ProjetScolaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetScolaire.entity.Compte;
import ProjetScolaire.entity.Role;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
	
	public Optional<Compte> findByLogin(String login);
	public void deleteById(Integer id);
	public List<Compte> findAllByRole(Role role);
//	@Query("select c from Compte c left join fetch c.role where c.login=:login")
//	public Optional<Compte> findByLoginWithRole(@Param("login") String login);

}
