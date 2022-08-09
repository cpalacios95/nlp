package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<?> getUsuarios(){

        List<UsuarioDto> usuarioDto = usuarioService.getUsuarios();

        return new ResponseEntity<>(usuarioDto,HttpStatus.OK);
    }

}
