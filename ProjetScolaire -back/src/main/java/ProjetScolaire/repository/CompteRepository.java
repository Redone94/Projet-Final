package ProjetScolaire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetScolaire.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
	@Query("select c from Compte c left join fetch c.role where c.login=:login")

	public Optional<Compte> findByLoginWithRole(@Param("login") String login);

}
