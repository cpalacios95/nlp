package ar.edu.undec.nlp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "comentario")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", nullable = false)
    private Integer comId;

    @Column(name = "com_comentario", nullable = false, length = 500)
    private String comComentario;

    @Column(name = "com_hora", nullable = false, length = 15)
    private String comHora;

    @Column(name = "com_fecha_creacion", nullable = false)
    private LocalDate comFechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usr_id", nullable = false)
    private UsuarioEntity usrId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "res_id", nullable = false)
    private ResumenEntity resId;

    public ComentarioEntity(){

    }

    public String getComHora() {
        return comHora;
    }

    public void setComHora(String comHora) {
        this.comHora = comHora;
    }

    public LocalDate getComFechaCreacion() {
        return comFechaCreacion;
    }

    public void setComFechaCreacion(LocalDate comFechaCreacion) {
        this.comFechaCreacion = comFechaCreacion;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComComentario() {
        return comComentario;
    }

    public void setComComentario(String comComentario) {
        this.comComentario = comComentario;
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
}
