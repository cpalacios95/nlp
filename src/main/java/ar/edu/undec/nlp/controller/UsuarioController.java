package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.dto.DataDto;
import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.exceptions.UsuarioException;
import ar.edu.undec.nlp.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {



    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<?> getUsuarios(){

        return new ResponseEntity<>(usuarioService.getAllUsuarios(),HttpStatus.OK);
    }


    @PostMapping("/singup")
    public ResponseEntity<?> setNewUsuario( @RequestBody UsuarioDto usuarioDto) throws UsuarioException {

        return new ResponseEntity<>(usuarioService.setNuevoUsuario(usuarioDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById( @PathVariable Integer id ) throws UsuarioException {

        return new ResponseEntity<>(usuarioService.getUsuarioById(id), HttpStatus.OK);

    }

    @GetMapping("/pass")
    public ResponseEntity<?> getUserByEmail(@RequestBody String email){
        return new ResponseEntity<>(usuarioService.getUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto ) throws UsuarioException {

        return new ResponseEntity<>(usuarioService.updateDatos(id, usuarioDto), HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> sendMessage(@RequestBody String email){
        return new ResponseEntity<>(usuarioService.sendEmail(email), HttpStatus.OK);
    }

    @PostMapping("/confirm-code")
    public ResponseEntity<?> confirmCode(@RequestBody DataDto data){
        return new ResponseEntity<>(usuarioService.confirmCode(data), HttpStatus.OK);
    }

}
