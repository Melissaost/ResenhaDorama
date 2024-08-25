package api.resenha.dorama.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genero;

    @OneToMany(mappedBy = "genero")

    @JsonIgnore
    private List<Dorama> doramas;

    public Genero(Long id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public Genero() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", genero='" + genero + '\'' +
                '}';
    }

    public List<Dorama> getDoramas() {
        return doramas;
    }

    public void setDoramas(List<Dorama> doramas) {
        this.doramas = doramas;
    }
}
