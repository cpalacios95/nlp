package ar.edu.undec.nlp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Rol")
public class RolEntity {

    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer rolId;

    @Column(name = "rol_estado")
    private boolean rolEstado;

    @Column(name = "rol_fecha_creacion")
    private Date rolFechaCreacion;

    @Column(name = "rol_descripcion")
    private String rolDescripcion;

    @OneToMany(mappedBy = "rolId")
    private List<UsuarioEntity> usuarios;

    public RolEntity(){

    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public boolean isRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(boolean rolEstado) {
        this.rolEstado = rolEstado;
    }

    public Date getRolFechaCreacion() {
        return rolFechaCreacion;
    }

    public void setRolFechaCreacion(Date rolFechaCreacion) {
        this.rolFechaCreacion = rolFechaCreacion;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }
}
