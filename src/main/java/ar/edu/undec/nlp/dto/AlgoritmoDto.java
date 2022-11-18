package ar.edu.undec.nlp.dto;

import java.util.Date;

public class AlgoritmoDto {

    private int algIdDto;
    private String algTituloDto;
    private boolean algEstadoDto;
    private String algDescripcionDto;

    public AlgoritmoDto(int algIdDto, String algTituloDto, boolean algEstadoDto, String algDescripcionDto) {
        this.algIdDto = algIdDto;
        this.algTituloDto = algTituloDto;
        this.algEstadoDto = algEstadoDto;
        this.algDescripcionDto = algDescripcionDto;
    }

    public AlgoritmoDto(){

    }

    public int getAlgIdDto() {
        return algIdDto;
    }

    public void setAlgIdDto(int algIdDto) {
        this.algIdDto = algIdDto;
    }

    public String getAlgTituloDto() {
        return algTituloDto;
    }

    public void setAlgTituloDto(String algTituloDto) {
        this.algTituloDto = algTituloDto;
    }

    public boolean isAlgEstadoDto() {
        return algEstadoDto;
    }

    public void setAlgEstadoDto(boolean algEstadoDto) {
        this.algEstadoDto = algEstadoDto;
    }

    public String getAlgDescripcionDto() {
        return algDescripcionDto;
    }

    public void setAlgDescripcionDto(String algDescripcionDto) {
        this.algDescripcionDto = algDescripcionDto;
    }
}
