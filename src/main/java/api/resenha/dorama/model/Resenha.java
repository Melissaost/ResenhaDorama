package api.resenha.dorama.model;

import java.time.LocalDateTime;

public class Resenha {

    private Long id;
    private String titulo;
    private String conteudo;
    private double nota;
    private LocalDateTime dataDaResenha;
    private Usuario usuario;
    private Dorama dorama;

    @Override
    public String toString() {
        return "Resenha{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", nota=" + nota +
                ", dataDaResenha=" + dataDaResenha +
                ", usuario=" + (usuario != null ? usuario.getNome() : "null") +
                '}';
    }

    public Resenha(Long id, String titulo, String conteudo, double nota, LocalDateTime dataDaResenha, Usuario usuario, Dorama dorama) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.nota = nota;
        this.dataDaResenha = dataDaResenha;
        this.usuario = usuario;
        this.dorama = dorama;
    }

    public Dorama getDorama() {
        return dorama;
    }

    public void setDorama(Dorama dorama) {
        this.dorama = dorama;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
