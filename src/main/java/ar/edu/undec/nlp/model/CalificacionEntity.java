package ar.edu.undec.nlp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "calificacion")
public class CalificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cal_id", nullable = false)
    private Integer calId;

    @Column(name = "cal_descripcion", nullable = true, length = 1000)
    private String calDescripcion;

    @Column(name = "cal_fecha_creacion", nullable = false)
    private LocalDate calFechaCreacion;

    @Column(name = "cal_hora", nullable = false, length = 15)
    private String calHora;

    @Column(name = "cal_valor", nullable = false, length = 2000)
    private String cal_valor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usr_id", nullable = false)
    private UsuarioEntity usrId;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JoinColumn(name = "res_id", nullable = false)
    private ResumenEntity resId;

    public CalificacionEntity(){

    }

    public Integer getCalId() {
        return calId;
    }

    public String getCalDescripcion() {
        return calDescripcion;
    }

    public String getCalHora() {
        return calHora;
    }

    public void setCalHora(String calHora) {
        this.calHora = calHora;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getCalDescripcion(String calDescripcionDto) {
        return calDescripcion;
    }

    public void setCalDescripcion(String calDescripcion) {
        this.calDescripcion = calDescripcion;
    }

    public LocalDate getCalFechaCreacion() {
        return calFechaCreacion;
    }

    public void setCalFechaCreacion(LocalDate calFechaCreacion) {
        this.calFechaCreacion = calFechaCreacion;
    }

    public String getCal_valor(String calValorDto) {
        return cal_valor;
    }

    public void setCal_valor(String cal_valor) {
        this.cal_valor = cal_valor;
    }

    public UsuarioEntity getUsrId() {
        return usrId;
    }

    public void setUsrId(UsuarioEntity usrId) {
        this.usrId = usrId;
    }

    public ResumenEntity getResId() {
        return resId;
    }

    public void setResId(ResumenEntity resId) {
        this.resId = resId;
    }

    public String getCal_valor() {
        return this.cal_valor;
    }
}
