import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    //Declara duas variáveis globais: biblioteca, do tipo Biblioteca, e clienteLogado, do tipo Cliente.
    // A biblioteca é utilizada para gerenciar os livros e clientes, enquanto clienteLogado é usado para armazenar o cliente que está atualmente logado no sistema.
    private static Biblioteca biblioteca = new Biblioteca();
    private static Cliente clienteLogado = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Bem-vindo à biblioteca. Escolha uma opção:");
            System.out.println("1. Cadastrar-se como cliente");
            System.out.println("2. Identificar-se como cliente");
            System.out.println("3. Adicionar livro à biblioteca");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
    //Utiliza um loop do-while para exibir um menu de opções e processar a escolha do usuário até que a opção "Sair" seja selecionada.
    ////A classe main implementa um sistema simples de gerenciamento de biblioteca.
            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    identificarCliente(scanner);
                    if (clienteLogado != null) {
                        menuCliente(scanner);
                    }
                    break;
                case 3:
                    adicionarLivro(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o seu endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o seu ID de cliente: ");
        int idCliente = scanner.nextInt();

        clienteLogado = new Cliente(nome, endereco, telefone, idCliente);
        biblioteca.adicionarCliente(clienteLogado);
        System.out.println("Cadastro realizado com sucesso.");
    }

    private static void identificarCliente(Scanner scanner) {
        System.out.print("Digite o seu ID de cliente: ");
        int idCliente = scanner.nextInt();
        clienteLogado = encontrarClientePorID(idCliente);
        if (clienteLogado != null) {
            System.out.println("Identificação realizada com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Cliente encontrarClientePorID(int idCliente) {
        for (Cliente cliente : biblioteca.getListaClientes()) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    private static void adicionarLivro(Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o ID do livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Livro novoLivro = new Livro(titulo, autor, idLivro, "Disponível");
        biblioteca.adicionarLivro(novoLivro);
        System.out.println("Livro adicionado à biblioteca com sucesso.");
    }

    private static void menuCliente(Scanner scanner) {
        int opcao;
        do {
            System.out.println("Menu Cliente. Escolha uma opção:");
            System.out.println("1. Consultar livros disponíveis");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Verificar livros atrasados");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    consultarLivros();
                    break;
                case 2:
                    emprestarLivro(scanner);
                    break;
                case 3:
                    devolverLivro(scanner);
                    break;
                case 4:
                    clienteLogado.verificarLivrosAtrasados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void consultarLivros() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : biblioteca.getListaLivros()) {
            if (livro.getStatus().equals("Disponível")) {
                System.out.println("- " + livro.getTitulo() + " (" + livro.getAutor() + ")");
            }
        }
    }

    private static void emprestarLivro(Scanner scanner) {
        if (clienteLogado == null) {
            System.out.println("Você precisa se identificar como cliente primeiro.");
            return;
        }

        System.out.print("Digite o ID do livro que deseja emprestar: ");
        int idLivro = scanner.nextInt();
        Livro livro = encontrarLivroPorID(idLivro);
        if (livro != null) {
            clienteLogado.emprestarLivro(livro);
            biblioteca.emprestarLivro(clienteLogado, livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void devolverLivro(Scanner scanner) {
        if (clienteLogado == null) {
            System.out.println("Você precisa se identificar como cliente primeiro.");
            return;
        }

        System.out.print("Digite o ID do livro que deseja devolver: ");
        int idLivro = scanner.nextInt();
        Livro livro = encontrarLivroPorID(idLivro);
        if (livro != null) {
            clienteLogado.devolverLivro(livro);
            biblioteca.devolverLivro(clienteLogado, livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static Livro encontrarLivroPorID(int idLivro) {
        for (Livro livro : biblioteca.getListaLivros()) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        return null;
    }
}

