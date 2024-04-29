import java.util.ArrayList;

//Define a classe Cliente, que estende a classe Pessoa, o que sugere que Cliente herda características de uma pessoa.
class Cliente extends Pessoa {
    private int idCliente;
    private ArrayList<Livro> livrosEmprestados;

    //O construtor inicializa um cliente com seu nome, endereço, telefone e um identificador único. Além disso, inicializa a lista de livros emprestados como uma nova instância de ArrayList.
    public Cliente(String nome, String endereco, String telefone, int idCliente) {
        super(nome, endereco, telefone);
        this.idCliente = idCliente;
        this.livrosEmprestados = new ArrayList<>();
    }

    //Métodos para acessar e modificar o identificador do cliente e a lista de livros emprestados.
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(ArrayList<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
    //Adiciona um livro à lista de livros emprestados pelo cliente e atualiza o status do livro para "Emprestado".
    public void emprestarLivro(Livro livro) {
        livrosEmprestados.add(livro);
        livro.setStatus("Emprestado");
    }
    
    //Remove um livro da lista de livros emprestados pelo cliente e atualiza o status do livro para "Disponível".
    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
        livro.setStatus("Disponível");
    }
    
    //Este método verifica se há livros emprestados que estão atrasados para devolução e imprime uma mensagem para cada livro atrasado.
    public void verificarLivrosAtrasados() {
        boolean atrasado = false;
        for (Livro livro : livrosEmprestados) {
            if (!livro.getStatus().equals("Disponível")) { // Se o livro estiver emprestado (ou seja, atrasado para devolução)
                atrasado = true;
                System.out.println("O livro '" + livro.getTitulo() + "' está atrasado para devolução!");
            }
        }
        if (atrasado) {
            System.out.println("Em caso de atraso na devolução, multa ao dia no valor de 75 centavos.");
        }
    }
    
    //Sobrescreve o método toString() para retornar uma representação em forma de string do objeto Cliente, incluindo o identificador do cliente e a lista de livros emprestados.
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", livrosEmprestados=" + livrosEmprestados +
                '}';
    }
}
