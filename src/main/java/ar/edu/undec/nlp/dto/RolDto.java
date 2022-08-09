package ar.edu.undec.nlp.dto;


import ar.edu.undec.nlp.model.RolEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RolDto {

    private int rolIdDto;
    private boolean rolEstadoDto;
    private Date rolFechaCreacionDto;
    private String rolDescripcionDto;

    public RolDto(){

    }

    public RolDto(int rolIdDto, boolean rolEstadoDto, Date rolFechaCreacionDto, String rolDescripcionDto) {
        this.rolIdDto = rolIdDto;
        this.rolEstadoDto = rolEstadoDto;
        this.rolFechaCreacionDto = rolFechaCreacionDto;
        this.rolDescripcionDto = rolDescripcionDto;
    }

    public int getRolIdDto() {
        return rolIdDto;
    }

    public void setRolIdDto(int rolIdDto) {
        this.rolIdDto = rolIdDto;
    }

    public boolean isRolEstadoDto() {
        return rolEstadoDto;
    }

    public void setRolEstadoDto(boolean rolEstadoDto) {
        this.rolEstadoDto = rolEstadoDto;
    }

    public Date getRolFechaCreacionDto() {
        return rolFechaCreacionDto;
    }

    public void setRolFechaCreacionDto(Date rolFechaCreacionDto) {
        this.rolFechaCreacionDto = rolFechaCreacionDto;
    }

    public String getRolDescripcionDto() {
        return rolDescripcionDto;
    }

    public void setRolDescripcionDto(String rolDescripcionDto) {
        this.rolDescripcionDto = rolDescripcionDto;
    }

    public List<RolDto> getRolDtoList(List<RolEntity> all) {

        List<RolDto> rolDtos = new ArrayList<>();
        for(RolEntity i: all){

            RolDto rolDto = new RolDto();
            rolDto.setRolIdDto(i.getRolId());
            rolDto.setRolDescripcionDto(i.getRolDescripcion());
            rolDto.setRolEstadoDto(i.isRolEstado());
            rolDto.setRolFechaCreacionDto(i.getRolFechaCreacion());

            rolDtos.add(rolDto);
        }

        return rolDtos;
    }

    public RolDto getRolDto(RolEntity rolId) {

        return new RolDto(rolId.getRolId(), rolId.isRolEstado(), rolId.getRolFechaCreacion(), rolId.getRolDescripcion());

    }
}
