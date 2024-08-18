package api.resenha.dorama.model;

import java.util.ArrayList;
import java.util.List;

public class Dorama {

    private Long id;
    private String titulo;
    private String descricao;
    private Genero genero;
    private int anoDeLancamento;
    private String imagem;
    private List<Resenha> resenhas;
    private Usuario usuario;

    public Dorama(Long id, String titulo, String descricao, Genero genero, int anoDeLancamento, String imagem, List<Resenha> resenhas, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.anoDeLancamento = anoDeLancamento;
        this.imagem = imagem;
        this.resenhas = (resenhas != null) ? resenhas : new ArrayList<>();
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Dorama{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", genero=" + genero.getGenero() +
                ", anoDeLancamento=" + anoDeLancamento + '\'' +
                ", imagem='" + imagem + '\'' +
                ", usuario=" + usuario.getNome() +
                ", resenhas=" + resenhas +
                '}';
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public List<Resenha> getResenhas() {
        return resenhas;
    }

    public void setResenhas(List<Resenha> resenhas) {
        this.resenhas = resenhas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
