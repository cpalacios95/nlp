package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity, Integer> {
}
