package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.dto.ComentarioDto;
import ar.edu.undec.nlp.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<?> nuevoComentario(@RequestBody ComentarioDto comentarioDto){
        return new ResponseEntity<>(this.comentarioService.nuevoComentario(comentarioDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCoomentario(@PathVariable Integer id){
        return new ResponseEntity<>(this.comentarioService.getComentario(id), HttpStatus.OK);
    }

}
