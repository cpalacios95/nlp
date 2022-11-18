package ar.edu.undec.nlp.controller;


import ar.edu.undec.nlp.dto.CalificacionDto;
import ar.edu.undec.nlp.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping("")
    public ResponseEntity<?> calificarResumen(@RequestBody CalificacionDto calificacionDto){
        return new ResponseEntity<>(calificacionService.calificar(calificacionDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalificacion(@PathVariable String id){
        return new ResponseEntity<>(calificacionService.getCalificacion(id), HttpStatus.OK);
    }

}
