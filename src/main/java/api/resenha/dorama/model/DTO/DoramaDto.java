package api.resenha.dorama.model.DTO;

import api.resenha.dorama.model.Dorama;

public record DoramaDto(
        Long id,
        String titulo,
        String descricao,
        String genero,
        int anoDeLancamento,
        String imagem) {

    public DoramaDto(Dorama dorama) {
        this(dorama.getId(),
                dorama.getTitulo(),
                dorama.getDescricao(),
                dorama.getGenero().getGenero(),
                dorama.getAnoDeLancamento(),
                dorama.getImagem()
        );
    }
}
