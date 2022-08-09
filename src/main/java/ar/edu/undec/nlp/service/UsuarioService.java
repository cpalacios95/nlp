package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getUsuarios(){
        List<UsuarioDto> usuarioDtos = new UsuarioDto().getUsuarioDtoList(usuarioRepository.findAll());
        return usuarioDtos;
    }

}
