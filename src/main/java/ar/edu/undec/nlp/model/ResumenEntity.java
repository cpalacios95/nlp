package ar.edu.undec.nlp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "resumen")
public class ResumenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id", nullable = false)
    private Integer resId;

    @Column(name = "res_contenido", nullable = false, length = 2000)
    private String resContenido;

    @Column(name = "res_estado", nullable = false)
    private Boolean usrEstado;

    @Column(name = "res_fecha_creacion", nullable = false)
    private LocalDate resFechaCreacion;

    @Column(name = "res_hora", nullable = false, length = 15)
    private String resHora;

    @Column(name = "res_resultado_analisis", nullable = true, length = 2000)
    private String resResultadoAnalisis;

    @Column(name = "res_titulo", nullable = false, length = 140)
    private String resTitulo;

    @Column(name = "res_revision", nullable = false)
    private Boolean resRevision;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usr_id", nullable = false)
    private UsuarioEntity usrId;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JoinColumn(name = "alg_id", nullable = true)
    private AlgoritmoEntity algId;

    public ResumenEntity(){

    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResContenido() {
        return resContenido;
    }

    public void setResContenido(String resContenido) {
        this.resContenido = resContenido;
    }

    public Boolean getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(Boolean usrEstado) {
        this.usrEstado = usrEstado;
    }

    public LocalDate getResFechaCreacion() {
        return resFechaCreacion;
    }

    public void setResFechaCreacion(LocalDate resFechaCreacion) {
        this.resFechaCreacion = resFechaCreacion;
    }

    public String getResResultadoAnalisis() {
        return resResultadoAnalisis;
    }

    public void setResResultadoAnalisis(String resResultadoAnalisis) {
        this.resResultadoAnalisis = resResultadoAnalisis;
    }

    public String getResTitulo() {
        return resTitulo;
    }

    public void setResTitulo(String resTitulo) {
        this.resTitulo = resTitulo;
    }

    public UsuarioEntity getUsrId() {
        return usrId;
    }

    public void setUsrId(UsuarioEntity usrId) {
        this.usrId = usrId;
    }

    public AlgoritmoEntity getAlgId() {
        return algId;
    }

    public void setAlgId(AlgoritmoEntity algId) {
        this.algId = algId;
    }

    public Boolean getResRevision() {
        return resRevision;
    }

    public void setResRevision(Boolean resRevision) {
        this.resRevision = resRevision;
    }

    public String getResHora() {
        return resHora;
    }

    public void setResHora(String resHora) {
        this.resHora = resHora;
    }
}
