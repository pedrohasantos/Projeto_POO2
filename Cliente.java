import java.util.ArrayList;
class Cliente extends Pessoa {
    private int idCliente;
    private ArrayList<Livro> livrosEmprestados;

    public Cliente(String nome, String endereco, String telefone, int idCliente) {
        super(nome, endereco, telefone);
        this.idCliente = idCliente;
        this.livrosEmprestados = new ArrayList<>();
    }

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

    public void emprestarLivro(Livro livro) {
        livrosEmprestados.add(livro);
        livro.setStatus("Emprestado");
    }

    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
        livro.setStatus("Disponível");
    }

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

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", livrosEmprestados=" + livrosEmprestados +
                '}';
    }
}
