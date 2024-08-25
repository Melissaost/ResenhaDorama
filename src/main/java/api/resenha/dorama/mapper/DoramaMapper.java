package api.resenha.dorama.mapper;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.model.form.DoramaForm;

public interface DoramaMapper {

    static Dorama toEntity(DoramaForm doramaForm, Genero genero, Usuario usuario) {
        return new Dorama(
                doramaForm.id(),
                doramaForm.titulo(),
                doramaForm.descricao(),
                genero,
                doramaForm.anoDeLancamento(),
                doramaForm.imagem(),
                null,
                usuario
        );
    }
}
