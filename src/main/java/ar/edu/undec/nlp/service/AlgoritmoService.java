package ar.edu.undec.nlp.service;

import ar.edu.undec.nlp.dto.AlgoritmoDto;
import ar.edu.undec.nlp.mapper.AlgoritmoMapper;
import ar.edu.undec.nlp.repository.IAlgorimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgoritmoService {

    @Autowired
    private IAlgorimoRepository iAlgorimoRepository;

    public AlgoritmoDto getAlgoritmo() {

        AlgoritmoDto algoritmoDto = AlgoritmoMapper.algoritmoEntityToAlgoritmoDto(iAlgorimoRepository.findAlgoritmoEntitiesByAlgId(1));

        return algoritmoDto;
    }
}
