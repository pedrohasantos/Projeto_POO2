import java.util.ArrayList;
class Biblioteca {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Livro> listaLivros;

    public Biblioteca() {
        listaClientes = new ArrayList<>();
        listaLivros = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public void emprestarLivro(Cliente cliente, Livro livro) {
        cliente.emprestarLivro(livro);
    }

    public void devolverLivro(Cliente cliente, Livro livro) {
        cliente.devolverLivro(livro);
    }
}
