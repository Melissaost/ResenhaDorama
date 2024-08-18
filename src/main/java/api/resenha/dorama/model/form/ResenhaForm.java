package api.resenha.dorama.model.form;

import java.time.LocalDateTime;

public record ResenhaForm(
        Long id,
        String titulo,
        String conteudo,
        Double nota,
        Long idUsuario,
        Long idDorama) {
}
