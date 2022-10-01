package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.RolDto;
import ar.edu.undec.nlp.mapper.RolMapper;
import ar.edu.undec.nlp.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private IRolRepository repository;

    public List<RolDto> getAllRoles(){

        return RolMapper.listRolEntityToListRolDto(repository.findAll());
    }

}
