package ar.edu.undec.nlp.controller;

import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.mapper.UsuarioMapper;
import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.security.JwtRequest;
import ar.edu.undec.nlp.security.JwtResponse;
import ar.edu.undec.nlp.security.JwtUtils;
import ar.edu.undec.nlp.service.usuario.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        UserDetails userDetails = this.usuarioDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token= this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException disabledException){
            throw new Exception("Usuario desabilitado" + disabledException.getMessage());
        }catch(BadCredentialsException badCredentialsException){
            throw new Exception("Credenciales invalidas"+ badCredentialsException.getMessage());
        }
    }

    @GetMapping("/usuario-actual")
    public UsuarioDto getUsuarioActual(Principal principal){
        UsuarioEntity usuarioEntity = (UsuarioEntity) this.usuarioDetailsService.loadUserByUsername(principal.getName());
        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioEntity);
    }
}
