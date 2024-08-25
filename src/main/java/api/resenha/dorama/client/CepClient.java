package api.resenha.dorama.client;


import api.resenha.dorama.model.DTO.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws")
public interface CepClient {

    @GetMapping("/{cep}/json/")
    CepDto getCep(@PathVariable("cep") String cep);
}
