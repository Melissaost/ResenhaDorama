package api.resenha.dorama.controller;

import api.resenha.dorama.model.DTO.DoramaDto;
import api.resenha.dorama.model.DTO.DoramaResenhaDto;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.form.DoramaForm;
import api.resenha.dorama.service.DoramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/dorama")
public class DoramaController {

    @Autowired
    private DoramaService doramaService;

    @PostMapping
    public ResponseEntity<DoramaForm> incluir(@RequestBody DoramaForm dorama) {
        doramaService.incluirForm(dorama);
        return ResponseEntity.status(HttpStatus.CREATED).body(dorama);
    }

    @GetMapping
    public ResponseEntity<List<DoramaDto>> obterLista() {
        List<DoramaDto> doramas = doramaService.obterListaDto();
        return ResponseEntity.ok(doramas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoramaResenhaDto> obterPorId(@PathVariable Long id) {
        DoramaResenhaDto dorama = doramaService.obterPorId(id);
        if (dorama != null) {
            return ResponseEntity.ok(dorama);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        doramaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
