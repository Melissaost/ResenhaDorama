package api.resenha.dorama.repository;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
