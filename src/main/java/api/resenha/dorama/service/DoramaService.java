package api.resenha.dorama.service;

import api.resenha.dorama.model.Dorama;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DoramaService {
    private final Map<Long, Dorama> doramas = new HashMap<>();

    public void incluir(Dorama dorama) {
        doramas.put(dorama.getId(), dorama);
    }

    public Collection<Dorama> obterLista() {
        return doramas.values();
    }
}
