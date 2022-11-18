package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.analisis.Analizador;
import ar.edu.undec.nlp.dto.ResumenDto;
import ar.edu.undec.nlp.exceptions.UsuarioException;
import ar.edu.undec.nlp.mapper.ResumenMapper;
import ar.edu.undec.nlp.mapper.UsuarioMapper;
import ar.edu.undec.nlp.model.ResumenEntity;
import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.repository.IResumenRepository;
import ar.edu.undec.nlp.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumenService {

    @Autowired
    private IResumenRepository iResumenRepository;

    @Autowired
    private UsuarioService usuarioService;


    public boolean setResumen(ResumenDto resumenDto) throws UsuarioException {

        UsuarioEntity usuarioEntity = this.usuarioService.getUsuariEntityById(resumenDto.getUsrIdDto());

        ResumenEntity resumenEntity = ResumenMapper.resumenDtoToResumenEntitySinRevisionNiAnalisis(resumenDto);
        resumenEntity.setUsrId(usuarioEntity);
        this.iResumenRepository.save(resumenEntity);

        return true;

    }

    public List<ResumenEntity> getResumenes(Integer id) throws UsuarioException {

        return this.iResumenRepository.getResumenByIdUsr(id);
    }

    public List<ResumenEntity> getResumenesSinRevision() {

        return iResumenRepository.getAllSinRevision();

    }

    public String analizarResumen(Integer id) {
        ResumenEntity resumenEntity = this.iResumenRepository.findResumenEntityByResId(id);
        Analizador analizador = new Analizador();
        String resultado = analizador.analizarTexto(resumenEntity.getResContenido());

        this.iResumenRepository.updateResumen(id, resultado);

        return resultado;
    }

    public ResumenEntity getResumen(Integer id){


        return this.iResumenRepository.findResumenEntityByResId(id);
    }

}
