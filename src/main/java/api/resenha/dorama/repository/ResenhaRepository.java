package api.resenha.dorama.repository;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResenhaRepository extends JpaRepository<Resenha, Long> {

    List<Resenha> findByDoramaTitulo(String titulo);

    List<Resenha> findByUsuarioNome(String nome);
}
