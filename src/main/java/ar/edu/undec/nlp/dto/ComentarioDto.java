package ar.edu.undec.nlp.dto;

public class ComentarioDto {

    private int usrId;
    private int resId;
    private String hora;
    private String contenido;

    public ComentarioDto(int usrId, int resId, String contenido) {
        this.usrId = usrId;
        this.resId = resId;
        this.contenido = contenido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ComentarioDto(){}
}
