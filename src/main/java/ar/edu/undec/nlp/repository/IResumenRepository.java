package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.ResumenEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IResumenRepository extends JpaRepository<ResumenEntity, Integer> {
//
//    @Modifying
//    @Transactional
//    @Query(value = "select ")
    List<ResumenEntity> findAllByUsrId (UsuarioEntity usuarioEntity);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM resumen WHERE res_revision = false", nativeQuery = true)
    List<ResumenEntity> getAllSinRevision();

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM resumen WHERE usr_id = :id", nativeQuery = true)
    List<ResumenEntity> getResumenByIdUsr(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE resumen SET res_resultado_analisis = :analisis WHERE res_id= :id")
    void updateResumen(Integer id, String analisis);


    ResumenEntity findResumenEntityByResId (int id);

}
