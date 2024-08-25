package api.resenha.dorama.repository;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
