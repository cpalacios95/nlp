package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.ComentarioEntity;
import ar.edu.undec.nlp.model.ResumenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IComentarioRepository extends JpaRepository<ComentarioEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM comentario WHERE res_id = :id", nativeQuery = true)
    List<ComentarioEntity> obtenerPorID(int id);

}
