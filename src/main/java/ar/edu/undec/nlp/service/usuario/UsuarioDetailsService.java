package ar.edu.undec.nlp.service.usuario;

import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = this.iUsuarioRepository.findUsuarioEntityByUsrEmail(username);

        if(usuarioEntity == null){
            throw new UsernameNotFoundException("Usuario no encontradoooooo");
        }
        return usuarioEntity;
    }
}
