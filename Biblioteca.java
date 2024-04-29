import java.util.ArrayList;
class Biblioteca {
    //Atributos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Livro> listaLivros;
    
    //Construtor inicializa as listas de clientes e livros quando um objeto da classe 
    public Biblioteca() {
        listaClientes = new ArrayList<>();
        listaLivros = new ArrayList<>();
    }

    //Métodos de Acesso (Getters), para obter as listas de clientes e livros da biblioteca
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }
    
    //Métodos para Adicionar Cliente e Livro
    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }
    //Métodos para Emprestar e Devolver Livros
    public void emprestarLivro(Cliente cliente, Livro livro) {
        cliente.emprestarLivro(livro);
    }

    public void devolverLivro(Cliente cliente, Livro livro) {
        cliente.devolverLivro(livro);
    }
}
