package api.resenha.dorama.model.DTO;

import api.resenha.dorama.model.Dorama;

import java.util.List;
import java.util.stream.Collectors;

public record DoramaResenhaDto(Long id,
                               String titulo,
                               String descricao,
                               String genero,
                               int anoDeLancamento,
                               String imagem,
                               List<ResenhaDto> resenhas) {

    public DoramaResenhaDto(Dorama dorama) {
        this(dorama.getId(),
                dorama.getTitulo(),
                dorama.getDescricao(),
                dorama.getGenero().getGenero(),
                dorama.getAnoDeLancamento(),
                dorama.getImagem(),
                dorama.getResenhas().stream()
                        .map(ResenhaDto::new)
                        .collect(Collectors.toList())
        );
    }
}
