package ar.edu.undec.nlp.model;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Id;


@Entity(name = "Usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "usr_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer usrId;

    @Column(name = "usr_nombres")
    private String usrNombres;

    @Column(name = "usr_apellidos")
    private String usrApellidos;

    @Column(name = "usr_email")
    private String usrEmail;

    @Column(name = "usr_contrasenia")
    private String usrContrasenia;

    @Column(name = "usr_fecha_creacion")
    private Date usrFechaCreacion;

    @Column(name = "usr_estado")
    private boolean usrEstado;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable =false, updatable = false)
    private RolEntity rolId;

    public UsuarioEntity(){

    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrNombres() {
        return usrNombres;
    }

    public void setUsrNombres(String usrNombres) {
        this.usrNombres = usrNombres;
    }

    public String getUsrApellidos() {
        return usrApellidos;
    }

    public void setUsrApellidos(String usrApellidos) {
        this.usrApellidos = usrApellidos;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrContrasenia() {
        return usrContrasenia;
    }

    public void setUsrContrasenia(String usrContrasenia) {
        this.usrContrasenia = usrContrasenia;
    }

    public Date getUsrFechaCreacion() {
        return usrFechaCreacion;
    }

    public void setUsrFechaCreacion(Date usrFechaCreacion) {
        this.usrFechaCreacion = usrFechaCreacion;
    }

    public boolean isUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(boolean usrEstado) {
        this.usrEstado = usrEstado;
    }

    public RolEntity getRolId() {
        return rolId;
    }

    public void setRolId(RolEntity rolId) {
        this.rolId = rolId;
    }
}
