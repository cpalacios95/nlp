package ar.edu.undec.nlp.dto;

import ar.edu.undec.nlp.model.RolEntity;

import java.util.Date;

public class RolDto {

    private int rolIdDto;
    private boolean rolEstadoDto;
    private Date rolFechaCreacionDto;
    private String rolDescripcionDto;

    public RolDto(int rolIdDto, boolean rolEstadoDto, Date rolFechaCreacionDto, String rolDescripcionDto) {
        this.rolIdDto = rolIdDto;
        this.rolEstadoDto = rolEstadoDto;
        this.rolFechaCreacionDto = rolFechaCreacionDto;
        this.rolDescripcionDto = rolDescripcionDto;
    }

    public RolDto() {

    }

    public RolDto getRolDto(RolEntity rolId) {

        return new RolDto(rolId.getRolId(), rolId.isRolEstado(), rolId.getRolFechaCreacion(), rolId.getRolDescripcion());

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
}
