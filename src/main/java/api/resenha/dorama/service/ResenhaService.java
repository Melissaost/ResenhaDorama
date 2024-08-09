package api.resenha.dorama.service;

import api.resenha.dorama.model.Resenha;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResenhaService {
    private final Map<Long, Resenha> resenhas = new HashMap<>();

    public void incluir(Resenha resenha) {
        resenhas.put(resenha.getId(), resenha);
    }

    public Collection<Resenha> obterLista() {
        return resenhas.values();
    }
}
