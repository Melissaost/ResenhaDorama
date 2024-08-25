package api.resenha.dorama.controller;

import api.resenha.dorama.model.DTO.ResenhaDto;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.form.ResenhaForm;
import api.resenha.dorama.service.ResenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/resenhas")
public class ResenhaController {

    @Autowired
    private ResenhaService resenhaService;

    @GetMapping("/dorama/{titulo}")
    public List<Resenha> buscarResenhasPorTituloDorama(@PathVariable String titulo) {
        return resenhaService.buscarResenhasPorTituloDorama(titulo);
    }

    @GetMapping("/usuario/{nome}")
    public List<Resenha> buscarResenhasPorNomeUsuario(@PathVariable String nome) {
        return resenhaService.buscarResenhasPorNomeUsuario(nome);
    }

    @PostMapping
    public ResponseEntity<ResenhaForm> incluir(@RequestBody ResenhaForm resenha) {
        resenhaService.incluirForm(resenha);
        return ResponseEntity.status(HttpStatus.CREATED).body(resenha);
    }

    @GetMapping
    public ResponseEntity<List<ResenhaDto>> obterListaDto() {
        List<ResenhaDto> resenhas = resenhaService.obterListaDto();
        return ResponseEntity.ok(resenhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenhaDto> obterPorIdDto(@PathVariable Long id) {
        ResenhaDto resenha = resenhaService.obterPorIdDto(id);
        if (resenha != null) {
            return ResponseEntity.ok(resenha);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        resenhaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
