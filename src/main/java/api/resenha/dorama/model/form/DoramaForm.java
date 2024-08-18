package api.resenha.dorama.model.form;

import api.resenha.dorama.model.Dorama;

public record DoramaForm(
        Long id,
        String titulo,
        String descricao,
        Long idGenero,
        int anoDeLancamento,
        Long idUsuario,
        String imagem) {
}
