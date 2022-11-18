package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.service.AlgoritmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algoritmo")
public class AlgoritmoController {

    @Autowired
    private AlgoritmoService algoritmoService;

    @GetMapping
    public ResponseEntity<?> getAlgoritmo(){
        return new ResponseEntity<>(algoritmoService.getAlgoritmo(), HttpStatus.OK);
    }

}
