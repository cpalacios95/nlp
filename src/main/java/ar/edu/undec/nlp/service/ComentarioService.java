package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.ComentarioDto;
import ar.edu.undec.nlp.model.ComentarioEntity;
import ar.edu.undec.nlp.model.ResumenEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.repository.IComentarioRepository;
import ar.edu.undec.nlp.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ResumenService resumenService;

    @Autowired
    private IComentarioRepository iComentarioRepository;

    public boolean nuevoComentario(ComentarioDto comentarioDto) {

        UsuarioEntity usuarioEntity = this.usuarioService.getUsuariEntityById(comentarioDto.getUsrId());
        ResumenEntity resumenEntity = this.resumenService.getResumen(comentarioDto.getResId());


        String formato = "HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);

        String hora = formatter.format(localDateTime) ;

        ComentarioEntity comentarioEntity = new ComentarioEntity();

        comentarioEntity.setComComentario(comentarioDto.getContenido());
        comentarioEntity.setUsrId(usuarioEntity);
        comentarioEntity.setResId(resumenEntity);
        comentarioEntity.setComFechaCreacion(LocalDate.now());
        comentarioEntity.setComHora(hora);
        this.iComentarioRepository.save(comentarioEntity);
        return true;
    }


    public List<ComentarioEntity> getComentario(Integer id){

//        List<ComentarioEntity> comentarioEntities = this.iComentarioRepository.obtenerPorID(id);
//        List<ComentarioDto> comentarioDtos = new ArrayList<>();
//        for(ComentarioEntity c: comentarioEntities){
//            ComentarioDto comentarioDto = new ComentarioDto();
//            comentarioDto.setUsrId(c.getUsrId().getUsrId());
//            comentarioDto.setResId(c.getResId().getResId());
//            comentarioDto.setContenido(c.getComComentario());
//        }

        return this.iComentarioRepository.obtenerPorID(id);
    }
}
