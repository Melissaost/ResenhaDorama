package api.resenha.dorama;

import api.resenha.dorama.model.Dorama;
import api.resenha.dorama.model.Genero;
import api.resenha.dorama.model.Resenha;
import api.resenha.dorama.model.Usuario;
import api.resenha.dorama.service.DoramaService;
import api.resenha.dorama.service.ResenhaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader {

    public static void main(String[] args) {
        String filePath = "src/main/resources/dorama_data.txt";
        DoramaService doramaService = new DoramaService();
        ResenhaService resenhaService = new ResenhaService();

        Map<Long, Usuario> usuarios = new HashMap<>();
        Map<Long, Genero> generos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                switch (data[0]) {
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
                        Dorama dorama = new Dorama(Long.parseLong(data[1]), data[2], data[3], generoDorama, Integer.parseInt(data[5]), new ArrayList<>(), usuarioDorama);
                        doramaService.incluir(dorama);
                        break;
                    case "resenha":
                        Genero generoResenha = generos.get(Long.parseLong(data[6]));
                        Usuario usuarioResenha = usuarios.get(Long.parseLong(data[7]));
                        Resenha resenha = new Resenha(Long.parseLong(data[1]), data[2], data[3], Double.parseDouble(data[4]), LocalDateTime.parse(data[5]), generoResenha, usuarioResenha);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        doramaService.obterLista().forEach(System.out::println);
        resenhaService.obterLista().forEach(System.out::println);
    }
}
