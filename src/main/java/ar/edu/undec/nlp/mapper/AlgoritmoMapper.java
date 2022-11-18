package ar.edu.undec.nlp.mapper;

import ar.edu.undec.nlp.dto.AlgoritmoDto;
import ar.edu.undec.nlp.model.AlgoritmoEntity;

public class AlgoritmoMapper {

    public static AlgoritmoDto algoritmoEntityToAlgoritmoDto(AlgoritmoEntity algoritmoEntity){

        AlgoritmoDto algoritmoDto = new AlgoritmoDto();

        algoritmoDto.setAlgIdDto(algoritmoEntity.getAlgId());
        algoritmoDto.setAlgTituloDto(algoritmoEntity.getAlgTitulo());
        algoritmoDto.setAlgDescripcionDto(algoritmoEntity.getAlgDescripcion());
        algoritmoDto.setAlgEstadoDto(algoritmoEntity.isAlgEstado());

        return algoritmoDto;
    }

}
