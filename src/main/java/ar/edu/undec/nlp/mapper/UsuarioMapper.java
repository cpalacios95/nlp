package ar.edu.undec.nlp.mapper;

import ar.edu.undec.nlp.dto.RolDto;
import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.model.RolEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static UsuarioEntity usuarioDtoToUsuarioEntity(UsuarioDto usuarioDto){

        RolEntity rolEntity = RolMapper.rolDtoToRolEntity(usuarioDto.getRolIdDto());

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setUsrNombres(usuarioDto.getUsrNombresDto());
        usuarioEntity.setUsrApellidos(usuarioDto.getUsrApellidosDto());
        usuarioEntity.setUsrEmail(usuarioDto.getUsrEmailDto());
        usuarioEntity.setUsrContrasenia(usuarioDto.getUsrContraseniaDto());
        usuarioEntity.setUsrFechaCreacion(LocalDate.now());
        usuarioEntity.setUsrEstado(true);
        usuarioEntity.setUsrCodigoVerificacion(usuarioDto.getUsrCodigoVerificacionDto());
        usuarioEntity.setRolId(rolEntity);

        return usuarioEntity;

    }

    public static UsuarioDto usuarioEntityToUsuarioDto( UsuarioEntity usuarioEntity ){

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setUsrIdDto(usuarioEntity.getUsrId());
        usuarioDto.setUsrNombresDto(usuarioEntity.getUsrNombres());
        usuarioDto.setUsrApellidosDto(usuarioEntity.getUsrApellidos());
        usuarioDto.setUsrEmailDto(usuarioEntity.getUsrEmail());
        usuarioDto.setUsrContraseniaDto(usuarioEntity.getUsrContrasenia());
        usuarioDto.setUsrFechaCreacionDto(usuarioEntity.getUsrFechaCreacion());
        usuarioDto.setUsrEstadoDto(usuarioEntity.getUsrEstado());
        usuarioDto.setUsrCodigoVerificacionDto(usuarioEntity.getUsrCodigoVerificacion());
        usuarioDto.setRolIdDto( RolMapper.rolEntityToRolDto(usuarioEntity.getRolId()));

        return usuarioDto;
    }

    public static List<UsuarioDto> listUsuarioEntityToListUsuarioDto( List<UsuarioEntity> usuarioEntities ){

        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for(UsuarioEntity i: usuarioEntities){
            usuarioDtoList.add(UsuarioMapper.usuarioEntityToUsuarioDto(i));
        }
        return usuarioDtoList;
    }
}
