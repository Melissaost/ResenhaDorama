package api.resenha.dorama.model;

import java.time.LocalDateTime;

public class Resenha {

    private Long id;
    private String titulo;
    private String conteudo;
    private double nota;
    private LocalDateTime dataDaResenha;
    private Genero genero;
    private Usuario usuario;

    @Override
    public String toString() {
        return "Resenha{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", nota=" + nota +
                ", dataDaResenha=" + dataDaResenha +
                ", genero=" + (genero != null ? genero.getGenero() : "null") +
                ", usuario=" + (usuario != null ? usuario.getNome() : "null") +
                '}';
    }

    public Resenha(Long id, String titulo, String conteudo, double nota, LocalDateTime dataDaResenha, Genero genero, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.nota = nota;
        this.dataDaResenha = dataDaResenha;
        this.genero = genero;
        this.usuario = usuario;
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataDaResenha() {
        return dataDaResenha;
    }

    public void setDataDaResenha(LocalDateTime dataDaResenha) {
        this.dataDaResenha = dataDaResenha;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
