class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    
    //O construtor inicializa um objeto Pessoa com o nome, endereço e telefone fornecidos.
    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    //Esses métodos permitem acessar e modificar os atributos da pessoa (nome, endereço e telefone).
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //printInfo(): Imprime as informações básicas da pessoa (nome, endereço e telefone).
    public void printInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
    
    //imprimirDetalhes(): Função idêntica a printInfo(), só que com um nome diferente.
    public void imprimirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
