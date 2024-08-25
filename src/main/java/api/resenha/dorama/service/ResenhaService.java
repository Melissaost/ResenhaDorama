package api.resenha.dorama.service;

import api.resenha.dorama.mapper.ResenhaMapper;
import api.resenha.dorama.model.DTO.ResenhaDto;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.model.form.ResenhaForm;
import api.resenha.dorama.repository.ResenhaRepository;
import api.resenha.dorama.repository.UsuarioRepository;
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

    @Autowired
    private ResenhaRepository resenhaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void incluir(Resenha resenha) {
        resenhaRepository.save(resenha);
    }

    public List<Resenha> buscarResenhasPorTituloDorama(String titulo) {
        return resenhaRepository.findByDoramaTitulo(titulo);
    }

    public List<Resenha> buscarResenhasPorNomeUsuario(String nome) {
        return resenhaRepository.findByUsuarioNome(nome);
    }

    public void incluirForm(ResenhaForm resenha) {
        Dorama dorama = doramaService.obterPorIdDorama(resenha.idDorama());

        Usuario usuario = usuarioRepository.findById(resenha.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + resenha.idUsuario()));

        resenhaRepository.save(ResenhaMapper.toEntity(resenha, dorama, usuario));
    }

    public Collection<Resenha> obterLista() {
        return resenhaRepository.findAll();
    }

    public List<ResenhaDto> obterListaDto() {
        Collection<Resenha> resenhasList = obterLista();
        return resenhasList.stream().map(ResenhaDto::new).toList();
    }

    public Resenha obterPorId(Long id) {
        return resenhaRepository.findById(id).orElse(null);
    }

    public ResenhaDto obterPorIdDto(Long id) {
        Resenha resenha = obterPorId(id);
        return new ResenhaDto(resenha);
    }

    public void excluir(Long id) {
        resenhaRepository.deleteById(id);
    }
}
