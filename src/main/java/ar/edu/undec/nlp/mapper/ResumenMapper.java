package ar.edu.undec.nlp.mapper;

import ar.edu.undec.nlp.dto.ResumenDto;
import ar.edu.undec.nlp.model.ResumenEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResumenMapper {

    public static ResumenEntity resumenDtoToResumenEntitySinRevisionNiAnalisis(ResumenDto resumenDto){

        String formato = "HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);

        String hora = formatter.format(localDateTime) ;

        ResumenEntity resumenEntity = new ResumenEntity();

        resumenEntity.setResHora(hora);
        resumenEntity.setResTitulo(resumenDto.getResTituloDto());
        resumenEntity.setResContenido(resumenDto.getResContenidoDto());
        resumenEntity.setResFechaCreacion(LocalDate.now());
        resumenEntity.setUsrEstado(true);
        resumenEntity.setResRevision(false);

        return resumenEntity;
    }

}
