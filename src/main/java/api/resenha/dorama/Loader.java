package api.resenha.dorama;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.repository.DoramaRepository;
import api.resenha.dorama.repository.GeneroRepository;
import api.resenha.dorama.repository.ResenhaRepository;
import api.resenha.dorama.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Transactional
public class Loader {

    private final DoramaRepository doramaRepository;
    private final ResenhaRepository resenhaRepository;
    private final UsuarioRepository usuarioRepository;
    private final GeneroRepository generoRepository;

    @Autowired
    public Loader(DoramaRepository doramaRepository, ResenhaRepository resenhaRepository,
                  UsuarioRepository usuarioRepository, GeneroRepository generoRepository) {
        this.doramaRepository = doramaRepository;
        this.resenhaRepository = resenhaRepository;
        this.usuarioRepository = usuarioRepository;
        this.generoRepository = generoRepository;
    }

    @PostConstruct
    public void loadData() {
        String filePath = "dorama_data.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                switch (data[0].toLowerCase()) {
                    case "usuario":
                        Usuario usuario = new Usuario(Long.parseLong(data[1]), data[2], data[3], data[4], data[5], Boolean.parseBoolean(data[6]));
                        usuarioRepository.save(usuario);
                        System.out.println("Usuário carregado: " + usuario);
                        break;
                    case "genero":
                        Genero genero = new Genero(Long.parseLong(data[1]), data[2]);
                        generoRepository.save(genero);
                        System.out.println("Gênero carregado: " + genero);
                        break;
                    case "dorama":
                        Optional<Genero> generoDoramaOpt = generoRepository.findById(Long.parseLong(data[4]));
                        Optional<Usuario> usuarioDoramaOpt = usuarioRepository.findById(Long.parseLong(data[6]));

                        if (generoDoramaOpt.isEmpty() || usuarioDoramaOpt.isEmpty()) {
                            System.err.println("Erro: Gênero ou Usuário não encontrado para o Dorama: " + data[2]);
                            continue;
                        }

                        Dorama dorama = new Dorama(Long.parseLong(data[1]), data[2], data[3], generoDoramaOpt.get(), Integer.parseInt(data[5]), data[7], new ArrayList<>(), usuarioDoramaOpt.get());
                        doramaRepository.save(dorama);
                        System.out.println("Dorama carregado: " + dorama);
                        break;
                    case "resenha":
                        Optional<Usuario> usuarioResenhaOpt = usuarioRepository.findById(Long.parseLong(data[6]));
                        Optional<Dorama> doramaResenhaOpt = doramaRepository.findById(Long.parseLong(data[7]));

                        if (usuarioResenhaOpt.isEmpty() || doramaResenhaOpt.isEmpty()) {
                            System.err.println("Erro: Usuário ou Dorama não encontrado para a Resenha: " + data[2]);
                            continue;
                        }

                        Resenha resenha = new Resenha(Long.parseLong(data[1]), data[2], data[3], Double.parseDouble(data[4]), LocalDateTime.parse(data[5]), usuarioResenhaOpt.get(), doramaResenhaOpt.get());
                        resenhaRepository.save(resenha);
                        System.out.println("Resenha carregada: " + resenha);

                        Dorama doramaToUpdate = doramaResenhaOpt.get();
                        doramaToUpdate.getResenhas().add(resenha);
                        doramaRepository.save(doramaToUpdate);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
