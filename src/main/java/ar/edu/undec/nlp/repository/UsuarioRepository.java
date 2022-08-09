package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
