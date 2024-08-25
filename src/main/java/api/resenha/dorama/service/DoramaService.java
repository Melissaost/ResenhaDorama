package api.resenha.dorama.service;

import api.resenha.dorama.mapper.DoramaMapper;
import api.resenha.dorama.model.DTO.DoramaDto;
import api.resenha.dorama.model.DTO.DoramaResenhaDto;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.model.form.DoramaForm;
import api.resenha.dorama.repository.DoramaRepository;
import api.resenha.dorama.repository.GeneroRepository;
import api.resenha.dorama.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoramaService {

    @Autowired
    private DoramaRepository doramaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Dorama> getAllDoramaSortedByTitulo() {
        return doramaRepository.findAll(Sort.by(Sort.Order.asc("titulo")));
    }


    public void incluir(Dorama dorama) {
        doramaRepository.save(dorama);
    }

    public void incluirForm(DoramaForm doramaForm) {
        Genero genero = generoRepository.findById(doramaForm.idGenero())
                .orElseThrow(() -> new IllegalArgumentException("Gênero não encontrado com ID: " + doramaForm.idGenero()));

        Usuario usuario = usuarioRepository.findById(doramaForm.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + doramaForm.idUsuario()));


        Dorama dorama = DoramaMapper.toEntity(doramaForm, genero, usuario);
        doramaRepository.save(dorama);
    }

    public Collection<Dorama> obterLista() {
        return doramaRepository.findAll();
    }

    public List<DoramaDto> obterListaDto() {
        Collection<Dorama> doramasList = doramaRepository.findAll();
        return doramasList.stream().map(DoramaDto::new).toList();
    }

    public DoramaResenhaDto obterPorId(Long id) {
        return new DoramaResenhaDto(Objects.requireNonNull(doramaRepository.findById(id).orElse(null)));
    }

    public Dorama obterPorIdDorama(Long id) {
        return doramaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        doramaRepository.deleteById(id);
    }
}
