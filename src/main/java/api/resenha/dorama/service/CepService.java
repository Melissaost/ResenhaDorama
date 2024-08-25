package api.resenha.dorama.service;

import api.resenha.dorama.client.CepClient;
import api.resenha.dorama.model.DTO.CepDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepClient cepClient;

    public CepDto getCep(String cep) {
        return cepClient.getCep(cep);
    }
}
