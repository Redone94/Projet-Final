package ProjetScolaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetScolaire.entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
	
public List<Professeur> findByPrenomContaining(String prenom);
	
	@Query("from Professeur e where e.nom like :filter")
	public List<Professeur> findAllFilter(@Param("filter")String nom);

}
