package ar.edu.undec.nlp.dto;

import java.time.LocalDate;


public class UsuarioDto {

    private Integer usrIdDto;
    private String usrNombresDto;
    private String usrApellidosDto;
    private String usrEmailDto;
    private String usrContraseniaDto;
    private LocalDate usrFechaCreacionDto;
    private boolean usrEstadoDto;
    private String usrCodigoVerificacionDto;
    private RolDto rolIdDto;

    public UsuarioDto(Integer usrIdDto, String usrNombresDto, String usrApellidosDto, String usrEmailDto, String usrContraseniaDto, LocalDate usrFechaCreacionDto, boolean usrEstadoDto, RolDto rolIdDto, String usrCodigoVerificacionDto) {
        this.usrIdDto = usrIdDto;
        this.usrNombresDto = usrNombresDto;
        this.usrApellidosDto = usrApellidosDto;
        this.usrEmailDto = usrEmailDto;
        this.usrContraseniaDto = usrContraseniaDto;
        this.usrFechaCreacionDto = usrFechaCreacionDto;
        this.usrEstadoDto = usrEstadoDto;
        this.rolIdDto = rolIdDto;
        this.usrCodigoVerificacionDto= usrCodigoVerificacionDto;
    }

    public String getUsrCodigoVerificacionDto() {
        return usrCodigoVerificacionDto;
    }

    public void setUsrCodigoVerificacionDto(String usrCodigoVerificacionDto) {
        this.usrCodigoVerificacionDto = usrCodigoVerificacionDto;
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

    public LocalDate getUsrFechaCreacionDto() {
        return usrFechaCreacionDto;
    }

    public void setUsrFechaCreacionDto(LocalDate usrFechaCreacionDto) {
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

}
