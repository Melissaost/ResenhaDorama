package api.resenha.dorama.mapper;

import api.resenha.dorama.Loader;
import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.model.form.ResenhaForm;

import java.time.LocalDateTime;

public interface ResenhaMapper {

    static Resenha toEntity(ResenhaForm resenhaForm, Dorama dorama, Usuario usuario) {

        return new Resenha(
                resenhaForm.id(),
                resenhaForm.titulo(),
                resenhaForm.conteudo(),
                resenhaForm.nota(),
                LocalDateTime.now(),
                usuario,
                dorama
        );
    }
}
