package api.resenha.dorama;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.service.DoramaService;
import api.resenha.dorama.service.ResenhaService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Loader {

    private final DoramaService doramaService;
    private final ResenhaService resenhaService;

    public static Map<Long, Usuario> usuarios = new HashMap<>();
    public static Map<Long, Genero> generos = new HashMap<>();

    @Autowired
    public Loader(DoramaService doramaService, ResenhaService resenhaService) {
        this.doramaService = doramaService;
        this.resenhaService = resenhaService;
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
                        usuarios.put(usuario.getId(), usuario);
                        break;
                    case "genero":
                        Genero genero = new Genero(Long.parseLong(data[1]), data[2]);
                        generos.put(genero.getId(), genero);
                        break;
                    case "dorama":
                        Genero generoDorama = generos.get(Long.parseLong(data[4]));
                        Usuario usuarioDorama = usuarios.get(Long.parseLong(data[6]));
                        Dorama dorama = new Dorama(Long.parseLong(data[1]), data[2], data[3], generoDorama, Integer.parseInt(data[5]), data[7], new ArrayList<>(), usuarioDorama);
                        doramaService.incluir(dorama);
                        break;
                    case "resenha":
                        Usuario usuarioResenha = usuarios.get(Long.parseLong(data[6]));
                        Dorama doramaResenha = doramaService.obterPorIdDorama(Long.parseLong(data[7]));
                        Resenha resenha = new Resenha(Long.parseLong(data[1]), data[2], data[3], Double.parseDouble(data[4]), LocalDateTime.parse(data[5]), usuarioResenha, doramaResenha);
                        resenhaService.incluir(resenha);
                        Dorama doramaRelacionado = doramaService.obterLista().stream()
                                .filter(d -> d.getId().equals(Long.parseLong(data[7])))
                                .findFirst()
                                .orElse(null);
                        if (doramaRelacionado != null) {
                            doramaRelacionado.getResenhas().add(resenha);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        doramaService.obterLista().forEach(System.out::println);
        resenhaService.obterLista().forEach(System.out::println);
    }
}
