package ar.edu.undec.nlp.dto;

import ar.edu.undec.nlp.model.RolEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDto {

    private Integer usrIdDto;
    private String usrNombresDto;
    private String usrApellidosDto;
    private String usrEmailDto;
    private String usrContraseniaDto;
    private Date usrFechaCreacionDto;
    private boolean usrEstadoDto;
    private RolDto rolIdDto;

    public UsuarioDto(Integer usrIdDto, String usrNombresDto, String usrApellidosDto, String usrEmailDto, String usrContraseniaDto, Date usrFechaCreacionDto, boolean usrEstadoDto, RolDto rolIdDto) {
        this.usrIdDto = usrIdDto;
        this.usrNombresDto = usrNombresDto;
        this.usrApellidosDto = usrApellidosDto;
        this.usrEmailDto = usrEmailDto;
        this.usrContraseniaDto = usrContraseniaDto;
        this.usrFechaCreacionDto = usrFechaCreacionDto;
        this.usrEstadoDto = usrEstadoDto;
        this.rolIdDto = rolIdDto;
    }

    public UsuarioDto() {

    }

    public Integer getUsrIdDto() {
        return usrIdDto;
    }

    public void setUsrIdDto(Integer usrIdDto) {
        this.usrIdDto = usrIdDto;
    }

    public String getUsrNombresDto() {
        return usrNombresDto;
    }

    public void setUsrNombresDto(String usrNombresDto) {
        this.usrNombresDto = usrNombresDto;
    }

    public String getUsrApellidosDto() {
        return usrApellidosDto;
    }

    public void setUsrApellidosDto(String usrApellidosDto) {
        this.usrApellidosDto = usrApellidosDto;
    }

    public String getUsrEmailDto() {
        return usrEmailDto;
    }

    public void setUsrEmailDto(String usrEmailDto) {
        this.usrEmailDto = usrEmailDto;
    }

    public String getUsrContraseniaDto() {
        return usrContraseniaDto;
    }

    public void setUsrContraseniaDto(String usrContraseniaDto) {
        this.usrContraseniaDto = usrContraseniaDto;
    }

    public Date getUsrFechaCreacionDto() {
        return usrFechaCreacionDto;
    }

    public void setUsrFechaCreacionDto(Date usrFechaCreacionDto) {
        this.usrFechaCreacionDto = usrFechaCreacionDto;
    }

    public boolean isUsrEstadoDto() {
        return usrEstadoDto;
    }

    public void setUsrEstadoDto(boolean usrEstadoDto) {
        this.usrEstadoDto = usrEstadoDto;
    }

    public RolDto getRolIdDto() {
        return rolIdDto;
    }

    public void setRolIdDto(RolDto rolIdDto) {
        this.rolIdDto = rolIdDto;
    }

    public List<UsuarioDto> getUsuarioDtoList(List<UsuarioEntity> usuarios) {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();

        for (UsuarioEntity i: usuarios){
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setUsrIdDto(i.getUsrId());
            usuarioDto.setUsrNombresDto(i.getUsrNombres());
            usuarioDto.setUsrApellidosDto(i.getUsrApellidos());
            usuarioDto.setUsrEmailDto(i.getUsrEmail());
            usuarioDto.setUsrContraseniaDto(i.getUsrContrasenia());
            usuarioDto.setUsrFechaCreacionDto(i.getUsrFechaCreacion());
            usuarioDto.setUsrEstadoDto(i.isUsrEstado());
            usuarioDto.setRolIdDto(new RolDto().getRolDto(i.getRolId()));

            usuarioDtos.add(usuarioDto);
        }
        return usuarioDtos;
    }
}
