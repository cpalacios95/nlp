package ar.edu.undec.nlp.model;
import ar.edu.undec.nlp.security.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;


@Entity(name = "usuario")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id", nullable = false)
    private Integer usrId;

    @Column(name = "usr_nombres", nullable = false, length = 30)
    private String usrNombres;

    @Column(name = "usr_apellidos", nullable = false, length = 30)
    private String usrApellidos;

    @Column(name = "usr_email", nullable = false, length = 40)
    private String usrEmail;

    @Column(name = "usr_contrasenia", nullable = false, length = 40)
    private String usrContrasenia;

    @Column(name = "usr_fecha_creacion", nullable = false)
    private LocalDate usrFechaCreacion;

    @Column(name = "usr_codigo_verificacion", nullable = true, length = 5)
    private String usrCodigoVerificacion;

    public String getUsrCodigoVerificacion() {
        return usrCodigoVerificacion;
    }

    public void setUsrCodigoVerificacion(String usrCodigoVerificacion) {
        this.usrCodigoVerificacion = usrCodigoVerificacion;
    }

    @Column(name = "usr_estado", nullable = false)
    private Boolean usrEstado = false;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rolId;

    public RolEntity getRolId() {
        return rolId;
    }

    public void setRolId(RolEntity rol) {
        this.rolId = rol;
    }

    public Boolean getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(Boolean usrEstado) {
        this.usrEstado = usrEstado;
    }

    public LocalDate getUsrFechaCreacion() {
        return usrFechaCreacion;
    }

    public void setUsrFechaCreacion(LocalDate usrFechaCreacion) {
        this.usrFechaCreacion = usrFechaCreacion;
    }

    public String getUsrContrasenia() {
        return usrContrasenia;
    }

    public void setUsrContrasenia(String usrContrasenia) {
        this.usrContrasenia = usrContrasenia;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrApellidos() {
        return usrApellidos;
    }

    public void setUsrApellidos(String usrApellidos) {
        this.usrApellidos = usrApellidos;
    }

    public String getUsrNombres() {
        return usrNombres;
    }

    public void setUsrNombres(String usrNombres) {
        this.usrNombres = usrNombres;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer id) {
        this.usrId = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority(this.rolId.getRolDescripcion()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.usrContrasenia;
    }

    @Override
    public String getUsername() {
        return this.usrEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
