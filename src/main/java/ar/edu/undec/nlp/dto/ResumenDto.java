package ar.edu.undec.nlp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResumenDto {

    private Integer resIdDto;
    private String resContenidoDto;
    private boolean resEstadoDto;
    private boolean resRevisionDto;
    private LocalDate resFechaCreacionDto;
    private String resResultadoAnalisisDto;
    private String resTituloDto;
    private String resHora;
    private int usrIdDto;
    private int algIdDto;

    public ResumenDto(){

    }

    public ResumenDto(Integer resIdDto, String resContenidoDto, boolean resEstadoDto, boolean resRevisionDto, LocalDate resFechaCreacionDto, String resResultadoAnalisisDto, String resTituloDto, int usrIdDto, int algIdDto, String hora) {
        this.resIdDto = resIdDto;
        this.resContenidoDto = resContenidoDto;
        this.resEstadoDto = resEstadoDto;
        this.resFechaCreacionDto = resFechaCreacionDto;
        this.resResultadoAnalisisDto = resResultadoAnalisisDto;
        this.resTituloDto = resTituloDto;
        this.usrIdDto = usrIdDto;
        this.algIdDto = algIdDto;
        this.resHora = hora;
        this.resRevisionDto = resRevisionDto;
    }

    public boolean isResRevisionDto() {
        return resRevisionDto;
    }

    public String getResHora() {
        return resHora;
    }

    public void setResHora(String resHora) {
        this.resHora = resHora;
    }

    public Integer getResIdDto() {
        return resIdDto;
    }

    public void setResIdDto(Integer resIdDto) {
        this.resIdDto = resIdDto;
    }

    public String getResContenidoDto() {
        return resContenidoDto;
    }

    public void setResContenidoDto(String resContenidoDto) {
        this.resContenidoDto = resContenidoDto;
    }

    public boolean isResEstadoDto() {
        return resEstadoDto;
    }

    public void setResEstadoDto(boolean resEstadoDto) {
        this.resEstadoDto = resEstadoDto;
    }

    public LocalDate getResFechaCreacionDto() {
        return resFechaCreacionDto;
    }

    public void setResFechaCreacionDto(LocalDate resFechaCreacionDto) {
        this.resFechaCreacionDto = resFechaCreacionDto;
    }

    public String getResResultadoAnalisisDto() {
        return resResultadoAnalisisDto;
    }

    public void setResResultadoAnalisisDto(String resResultadoAnalisisDto) {
        this.resResultadoAnalisisDto = resResultadoAnalisisDto;
    }

    public String getResTituloDto() {
        return resTituloDto;
    }

    public void setResTituloDto(String resTituloDto) {
        this.resTituloDto = resTituloDto;
    }

    public int getUsrIdDto() {
        return usrIdDto;
    }

    public void setUsrIdDto(int usrIdDto) {
        this.usrIdDto = usrIdDto;
    }

    public int getAlgIdDto() {
        return algIdDto;
    }

    public void setAlgIdDto(int algIdDto) {
        this.algIdDto = algIdDto;
    }

    public boolean getResRevisionDto() {
        return resRevisionDto;
    }

    public void setResRevisionDto(boolean resRevisionDto) {
        this.resRevisionDto = resRevisionDto;
    }
}
