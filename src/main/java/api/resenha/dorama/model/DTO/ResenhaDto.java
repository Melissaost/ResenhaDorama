package api.resenha.dorama.model.DTO;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Resenha;

import java.time.LocalDateTime;

public record ResenhaDto(Long id,
                         String titulo,
                         String conteudo,
                         Double nota,
                         LocalDateTime dataDaResenha,
                         String nomeUsuario) {

    public ResenhaDto(Resenha dorama) {
        this(dorama.getId(),
                dorama.getTitulo(),
                dorama.getConteudo(),
                dorama.getNota(),
                dorama.getDataDaResenha(),
                dorama.getUsuario().getNome()
        );
    }
}
