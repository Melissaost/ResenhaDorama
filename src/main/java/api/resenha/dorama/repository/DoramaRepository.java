package api.resenha.dorama.repository;

import api.resenha.dorama.model.Dorama;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoramaRepository extends JpaRepository<Dorama, Long> {

    List<Dorama> findAll(Sort sort);
}
