package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.CalificacionDto;
import ar.edu.undec.nlp.model.CalificacionEntity;
import ar.edu.undec.nlp.model.ResumenEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.repository.ICalificacionRepository;
import ar.edu.undec.nlp.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalificacionService {
    
    @Autowired
    private ResumenService resumenService;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ICalificacionRepository calificacionRepository;

    public Boolean calificar(CalificacionDto calificacionDto) {

        ResumenEntity resumenEntity = this.resumenService.getResumen(calificacionDto.getResId());

        UsuarioEntity usuarioEntity = this.usuarioService.getUsuariEntityById(calificacionDto.getUsrId());

        CalificacionEntity calificacionEntity = new CalificacionEntity();

        String formato = "HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);

        String hora = formatter.format(localDateTime) ;

        calificacionEntity.setResId(resumenEntity);
        calificacionEntity.setUsrId(usuarioEntity);
        calificacionEntity.setCal_valor(calificacionDto.getCalValorDto());
        calificacionEntity.setCalDescripcion(calificacionDto.getCalDescripcionDto());
        calificacionEntity.setCalFechaCreacion(LocalDate.now());
        calificacionEntity.setCalHora(hora);


        this.calificacionRepository.save(calificacionEntity);
        return true;
    }

    public List<CalificacionEntity> getCalificacion(String id) {

        List<CalificacionEntity> calificacionEntity = this.calificacionRepository.obtener(Integer.parseInt(id));


        return calificacionEntity;
    }
}
