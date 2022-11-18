package ar.edu.undec.nlp.dto;

import java.time.LocalDate;

public class CalificacionDto {

    private Integer calIdDto;
    private String calDescripcionDto;
    private String calValorDto;
    private LocalDate calFechaCreacion;
    private String calHora;
    private Integer usrId;
    private Integer resId;


    public CalificacionDto(){

    }

    public String getCalHora() {
        return calHora;
    }

    public void setCalHora(String calHora) {
        this.calHora = calHora;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getCalIdDto() {
        return calIdDto;
    }

    public void setCalIdDto(Integer calIdDto) {
        this.calIdDto = calIdDto;
    }

    public String getCalDescripcionDto() {
        return calDescripcionDto;
    }

    public void setCalDescripcionDto(String calDescripcionDto) {
        this.calDescripcionDto = calDescripcionDto;
    }

    public String getCalValorDto() {
        return calValorDto;
    }

    public void setCalValorDto(String calValorDto) {
        this.calValorDto = calValorDto;
    }

    public LocalDate getCalFechaCreacion() {
        return calFechaCreacion;
    }

    public void setCalFechaCreacion(LocalDate calFechaCreacion) {
        this.calFechaCreacion = calFechaCreacion;
    }
}
