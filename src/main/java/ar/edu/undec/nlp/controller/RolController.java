package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping()
    public ResponseEntity<?> getRoles(){
        return new ResponseEntity<>(rolService.getRoles(), HttpStatus.OK);
    }

}
