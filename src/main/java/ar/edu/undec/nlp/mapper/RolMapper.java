package ar.edu.undec.nlp.mapper;

import ar.edu.undec.nlp.dto.RolDto;
import ar.edu.undec.nlp.model.RolEntity;

import java.util.ArrayList;
import java.util.List;

public class RolMapper {


    public static RolEntity rolDtoToRolEntity(RolDto rolDto){

        RolEntity rolEntity = new RolEntity();

        rolEntity.setRolId(rolDto.getRolIdDto());

        return rolEntity;
    }

    public static RolDto rolEntityToRolDto(RolEntity rolEntity){

        RolDto rolDto = new RolDto();

        rolDto.setRolIdDto(rolEntity.getRolId());
        rolDto.setRolDescripcionDto(rolEntity.getRolDescripcion());
        rolDto.setRolEstadoDto(rolEntity.isRolEstado());
        rolDto.setRolFechaCreacionDto(rolEntity.getRolFechaCreacion());

        return rolDto;
    }

    public static List<RolDto> listRolEntityToListRolDto(List<RolEntity> rolEntities){

        List<RolDto> rolDtoList = new ArrayList<>();
        for(RolEntity i: rolEntities){
            rolDtoList.add(RolMapper.rolEntityToRolDto(i));
        }

        return rolDtoList;
    }
}
