package api.resenha.dorama.controller;

import api.resenha.dorama.model.DTO.CepDto;
import api.resenha.dorama.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ceps")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public CepDto getCep(@PathVariable("cep") String cep) {
        return cepService.getCep(cep);
    }
}
