package api.resenha.dorama.service;

import api.resenha.dorama.mapper.DoramaMapper;
import api.resenha.dorama.model.DTO.DoramaDto;
import api.resenha.dorama.model.DTO.DoramaResenhaDto;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.model.form.DoramaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoramaService {

    private final Map<Long, Dorama> doramas = new HashMap<>();


    public void incluir(Dorama dorama) {
        doramas.put(dorama.getId(), dorama);
    }

    public void incluirForm(DoramaForm doramaForm) {
        Dorama dorama = DoramaMapper.toEntity(doramaForm);
        doramas.put(doramaForm.id(), dorama);
    }

    public Collection<Dorama> obterLista() {
        return doramas.values();
    }

    public List<DoramaDto> obterListaDto() {
        Collection<Dorama> doramasList = doramas.values();
        return doramasList.stream().map(DoramaDto::new).toList();
    }

    public DoramaResenhaDto obterPorId(Long id) {
        Dorama dorama = doramas.get(id);
        if (dorama != null) {
            return new DoramaResenhaDto(dorama);
        } else {
            return null;
        }
    }

    public Dorama obterPorIdDorama(Long id) {
        return doramas.get(id);
    }

    public void excluir(Long id) {
        doramas.remove(id);
    }
}
