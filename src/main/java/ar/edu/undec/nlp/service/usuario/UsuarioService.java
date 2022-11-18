package ar.edu.undec.nlp.service.usuario;

import ar.edu.undec.nlp.dto.DataDto;
import ar.edu.undec.nlp.dto.UsuarioDto;
import ar.edu.undec.nlp.exceptions.UsuarioException;
import ar.edu.undec.nlp.mapper.UsuarioMapper;
import ar.edu.undec.nlp.model.UsuarioEntity;
import ar.edu.undec.nlp.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository IUsuarioRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public List<UsuarioDto> getAllUsuarios(){

        return UsuarioMapper.listUsuarioEntityToListUsuarioDto(IUsuarioRepository.findAll());
    }

    public boolean setNuevoUsuario(UsuarioDto usuarioDto) throws UsuarioException {

        if(IUsuarioRepository.existsByUsrEmail(usuarioDto.getUsrEmailDto())) {
            throw new UsuarioException("El email ingresado ya existe");
        }

        IUsuarioRepository.save(UsuarioMapper.usuarioDtoToUsuarioEntity(usuarioDto));

        return true;
    }


    public UsuarioDto getUsuarioById(Integer id) throws UsuarioException {

        if ( ! IUsuarioRepository.existsById(id) ){
            throw new UsuarioException("El usuario no existe");
        }

        return UsuarioMapper.usuarioEntityToUsuarioDto(IUsuarioRepository.findById(id).get());
    }

    public UsuarioEntity getUsuariEntityById(Integer id){
        return this.IUsuarioRepository.findById(id).get();
    }


    public UsuarioDto getUserByEmail(String email) {

        UsuarioEntity usuarioEntity= IUsuarioRepository.findUsuarioEntityByUsrEmail(email);

        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioEntity);
    }

    public boolean updateDatos(Integer id, UsuarioDto usuarioDto) throws UsuarioException {

        UsuarioEntity usuarioEntity = UsuarioMapper.usuarioDtoToUsuarioEntity(usuarioDto);
        IUsuarioRepository.updateUsuario(id, usuarioEntity.getUsrNombres(), usuarioEntity.getUsrApellidos(), usuarioEntity.getUsrContrasenia()) ;
        return true;
    }

    public boolean sendEmail(String email) {

        String code = generateCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ccpalacios95@gmail.com");
        message.setTo(email);
        message.setText("Codigo de verificacion " + code);
        UsuarioEntity usuarioEntity = IUsuarioRepository.findUsuarioEntityByUsrEmail(email);
        IUsuarioRepository.updateCode(usuarioEntity.getUsrId(), code);

        javaMailSender.send(message);

        return true;
    }

    private String generateCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randomString = "";
        int length = 5;

        Random rand = new Random();

        char [] text = new char [length];

        for(int i=0; i< length; i++){
            text[i]= characters.charAt(rand.nextInt(characters.length()));
        }
        for(int i=0; i< length; i++){
            randomString+= text[i];
        }
        return randomString;
    }

    public UsuarioDto confirmCode(DataDto data) {

        UsuarioEntity usuarioEntity= IUsuarioRepository.findUsuarioEntityByUsrEmail(data.getEmail());

        return UsuarioMapper.usuarioEntityToUsuarioDto(usuarioEntity);
    }
}
