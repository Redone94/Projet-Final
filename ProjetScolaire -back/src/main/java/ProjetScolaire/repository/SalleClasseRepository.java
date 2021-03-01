package ProjetScolaire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ProjetScolaire.entity.SalleClasse;

public interface SalleClasseRepository extends JpaRepository<SalleClasse,Integer>{

	@Query("select s from SalleClasse s left join fetch s.etablissement where c.nom=:nom")

	public Optional<SalleClasse> findByNomWithEtablissement(@Param("nom") String nom);




}
