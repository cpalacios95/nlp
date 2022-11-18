package ar.edu.undec.nlp.repository;


import ar.edu.undec.nlp.model.AlgoritmoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlgorimoRepository extends JpaRepository<AlgoritmoEntity, Integer> {

    AlgoritmoEntity findAlgoritmoEntitiesByAlgId (int id);

}
