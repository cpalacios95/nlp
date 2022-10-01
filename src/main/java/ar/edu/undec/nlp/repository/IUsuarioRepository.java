package ar.edu.undec.nlp.repository;

import ar.edu.undec.nlp.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Boolean existsByUsrEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET usr_nombres = :nombre, usr_apellidos= :apellido, usr_contrasenia = :contrasenia WHERE usr_id= :id")
    void updateUsuario(int id, String nombre, String apellido, String contrasenia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuario SET usr_codigo_verificacion = :codigo WHERE usr_id= :id")
    void updateCode(int id, String codigo);

    UsuarioEntity findUsuarioEntityByUsrEmail (String email);

}
