package ar.edu.undec.nlp.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "algoritmo")
public class AlgoritmoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alg_id", nullable = false)
    private Integer algId;

    @Column(name = "alg_titulo")
    private String algTitulo;

    @Column(name = "alg_estado")
    private boolean algEstado;

    @Column(name = "alg_descripcion")
    private String algDescripcion;

    public AlgoritmoEntity(){

    }

    public Integer getAlgId() {
        return algId;
    }

    public void setAlgId(Integer algId) {
        this.algId = algId;
    }

    public String getAlgTitulo() {
        return algTitulo;
    }

    public void setAlgTitulo(String algTitulo) {
        this.algTitulo = algTitulo;
    }

    public boolean isAlgEstado() {
        return algEstado;
    }

    public void setAlgEstado(boolean algEstado) {
        this.algEstado = algEstado;
    }

    public String getAlgDescripcion() {
        return algDescripcion;
    }

    public void setAlgDescripcion(String algDescripcion) {
        this.algDescripcion = algDescripcion;
    }
}
