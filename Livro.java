class Livro {
    private String titulo;
    private String autor;
    private int idLivro;
    private String status;
    
    //O construtor inicializa um objeto Livro com o título, autor, identificador único e status fornecidos.
    public Livro(String titulo, String autor, int idLivro, String status) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLivro = idLivro;
        this.status = status;
    }
    
    //Esses métodos permitem acessar e modificar os atributos do livro (título, autor, identificador e status).
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //Sobrescreve o método toString() para retornar uma representação em forma de string do objeto Livro, incluindo título, autor, identificador e status.
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idLivro=" + idLivro +
                ", status='" + status + '\'' +
                '}';
    }
}
