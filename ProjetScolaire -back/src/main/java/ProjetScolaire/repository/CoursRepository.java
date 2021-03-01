package ProjetScolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetScolaire.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer>{

}
