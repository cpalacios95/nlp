package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.CalificacionEntity;
import ar.edu.undec.nlp.model.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ICalificacionRepository extends JpaRepository<CalificacionEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE calificacion SET cal_descripcion = :descripcion, cal_valor= :valor, cal_fecha_creacion = :fecha WHERE cal_id= :id")
    void updateCalificacion(int id, String descripcion, String valor, LocalDate fecha);

    CalificacionEntity getByResIdOrderByCalIdDesc (Integer id);

    List<CalificacionEntity> findAllByResId (Integer id);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM calificacion WHERE res_id = :id", nativeQuery = true)
    List<CalificacionEntity> obtener(int id);

}
