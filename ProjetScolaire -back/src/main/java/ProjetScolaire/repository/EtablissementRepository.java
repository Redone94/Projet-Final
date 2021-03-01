package ProjetScolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetScolaire.entity.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {

}
