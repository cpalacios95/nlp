package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.RolDto;
import ar.edu.undec.nlp.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    public List<RolDto> getRoles(){

        List<RolDto> rolDtos = new RolDto().getRolDtoList(repository.findAll());
        return rolDtos;
    }

}
