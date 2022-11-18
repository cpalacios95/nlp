package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.dto.ResumenDto;
import ar.edu.undec.nlp.exceptions.UsuarioException;
import ar.edu.undec.nlp.service.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumen")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;

    @PostMapping
    public ResponseEntity<?> setResumen(@RequestBody ResumenDto resumenDto) throws UsuarioException {
        return new ResponseEntity<>(resumenService.setResumen(resumenDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResumenes(@PathVariable Integer id) throws UsuarioException {
        return new ResponseEntity<>(resumenService.getResumenes(id), HttpStatus.OK);
    }

    @GetMapping("/sin-revision")
    public ResponseEntity<?> getResumenesSinRevision(){
        return new ResponseEntity<>(resumenService.getResumenesSinRevision(), HttpStatus.OK);
    }

    @GetMapping("/analizar/{id}")
    public ResponseEntity<?> analizarResumen(@PathVariable Integer id){
        return new ResponseEntity<>(resumenService.analizarResumen(id), HttpStatus.OK);
    }
}
