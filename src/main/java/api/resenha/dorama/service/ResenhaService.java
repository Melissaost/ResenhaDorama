package api.resenha.dorama.service;

import api.resenha.dorama.mapper.ResenhaMapper;
import api.resenha.dorama.model.DTO.DoramaDto;
import api.resenha.dorama.model.DTO.ResenhaDto;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.form.ResenhaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResenhaService {
    private final Map<Long, Resenha> resenhas = new HashMap<>();

    @Autowired
    DoramaService doramaService;

    public void incluir(Resenha resenha) {
        resenhas.put(resenha.getId(), resenha);
    }

    public void incluirForm(ResenhaForm resenha) {
        Dorama dorama = doramaService.obterPorIdDorama(resenha.idDorama());
        resenhas.put(resenha.id(), ResenhaMapper.toEntity(resenha, dorama));
    }

    public Collection<Resenha> obterLista() {
        return resenhas.values();
    }

    public List<ResenhaDto> obterListaDto() {
        Collection<Resenha> resenhasList = obterLista();
        return resenhasList.stream().map(ResenhaDto::new).toList();
    }

    public Resenha obterPorId(Long id) {
        return resenhas.get(id);
    }

    public ResenhaDto obterPorIdDto(Long id) {
        Resenha resenha = resenhas.get(id);
        return new ResenhaDto(resenha);
    }

    public void excluir(Long id) {
        resenhas.remove(id);
    }
}
