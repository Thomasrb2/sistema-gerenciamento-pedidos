import dao.ClienteDAO;
import dao.EnderecoDAO;
import dao.PedidoDAO;
import dao.ItensPedidoDAO;

import model.Cliente;
import model.Endereco;
import model.Pedido;
import model.ItensPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ClienteDAO clienteDAO = new ClienteDAO();
    static EnderecoDAO enderecoDAO = new EnderecoDAO();
    static PedidoDAO pedidoDAO = new PedidoDAO();
    static ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println(" SISTEMA DE GERENCIAMENTO ");
            System.out.println("==============================");
            System.out.println("1 - Cliente");
            System.out.println("2 - Endereço");
            System.out.println("3 - Pedido");
            System.out.println("4 - Itens do Pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuCliente();
                    break;

                case 2:
                    menuEndereco();
                    break;

                case 3:
                    menuPedido();
                    break;

                case 4:
                    menuItensPedido();
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

    }

    // ==========================
    // MENU CLIENTE
    // ==========================

    public static void menuCliente() {

        int op;

        do {

            System.out.println("\n------ CLIENTES ------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    cadastrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    buscarCliente();
                    break;

                case 4:
                    atualizarCliente();
                    break;

                case 5:
                    excluirCliente();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (op != 0);

    }

    // ==========================
    // CADASTRAR CLIENTE
    // ==========================

    public static void cadastrarCliente() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Gmail: ");
        String gmail = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("ID do Endereço: ");
        int idEndereco = sc.nextInt();
        sc.nextLine();

        Cliente cliente = new Cliente(
                0,
                nome,
                idade,
                gmail,
                telefone,
                cpf,
                idEndereco
        );

        clienteDAO.salvar(cliente);

    }

    // ==========================
    // LISTAR CLIENTES
    // ==========================

    public static void listarClientes() {

        ArrayList<Cliente> lista = clienteDAO.listar();

        if (lista.isEmpty()) {

            System.out.println("Nenhum cliente encontrado.");
            return;

        }

        for (Cliente c : lista) {

            System.out.println("------------------------");
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("Gmail: " + c.getGmail());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("ID Endereço: " + c.getIdEndereco());

        }

    }

    // ==========================
    // BUSCAR CLIENTE
    // ==========================

    public static void buscarCliente() {

        System.out.print("Informe o ID: ");

        int id = sc.nextInt();
        sc.nextLine();

        Cliente cliente = clienteDAO.buscarPorId(id);

        if (cliente == null) {

            System.out.println("Cliente não encontrado.");
            return;

        }

        System.out.println("\nCliente encontrado:");

        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Idade: " + cliente.getIdade());
        System.out.println("Gmail: " + cliente.getGmail());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("ID Endereço: " + cliente.getIdEndereco());

    }

    // ==========================
    // ATUALIZAR CLIENTE
    // ==========================

    public static void atualizarCliente() {

        System.out.print("ID do cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Nova idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo gmail: ");
        String gmail = sc.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Novo ID Endereço: ");
        int idEndereco = sc.nextInt();
        sc.nextLine();

        Cliente cliente = new Cliente(
                id,
                nome,
                idade,
                gmail,
                telefone,
                cpf,
                idEndereco
        );

        clienteDAO.atualizar(cliente);

    }

    // ==========================
    // EXCLUIR CLIENTE
    // ==========================

    public static void excluirCliente() {

        System.out.print("ID do cliente: ");

        int id = sc.nextInt();
        sc.nextLine();

        clienteDAO.deletar(id);

    }

    // ==========================
    // MENU ENDEREÇO
    // ==========================

    public static void menuEndereco() {

        int op;

        do {

            System.out.println("\n------ ENDEREÇOS ------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    cadastrarEndereco();
                    break;

                case 2:
                    listarEnderecos();
                    break;

                case 3:
                    buscarEndereco();
                    break;

                case 4:
                    atualizarEndereco();
                    break;

                case 5:
                    excluirEndereco();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (op != 0);

    }

    // ==========================
    // CADASTRAR ENDEREÇO
    // ==========================

    public static void cadastrarEndereco() {

        System.out.print("Rua: ");
        String rua = sc.nextLine();

        System.out.print("Número: ");
        String numero = sc.nextLine();

        System.out.print("Bairro: ");
        String bairro = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Complemento: ");
        String complemento = sc.nextLine();

        Endereco endereco = new Endereco(
                0,
                rua,
                numero,
                bairro,
                cidade,
                complemento
        );

        enderecoDAO.salvar(endereco);

    }

    // ==========================
    // LISTAR ENDEREÇOS
    // ==========================

    public static void listarEnderecos() {

        ArrayList<Endereco> lista = enderecoDAO.listar();

        if (lista.isEmpty()) {

            System.out.println("Nenhum endereço encontrado.");
            return;

        }

        for (Endereco e : lista) {

            System.out.println("--------------------------");
            System.out.println("ID: " + e.getIdEndereco());
            System.out.println("Rua: " + e.getRua());
            System.out.println("Número: " + e.getNumero());
            System.out.println("Bairro: " + e.getBairro());
            System.out.println("Cidade: " + e.getCidade());
            System.out.println("Complemento: " + e.getComplemento());

        }

    }

    // ==========================
    // BUSCAR ENDEREÇO
    // ==========================

    public static void buscarEndereco() {

        System.out.print("Informe o ID: ");

        int id = sc.nextInt();
        sc.nextLine();

        Endereco endereco = enderecoDAO.buscarPorId(id);

        if (endereco == null) {

            System.out.println("Endereço não encontrado.");
            return;

        }

        System.out.println("\nEndereço encontrado:");

        System.out.println("ID: " + endereco.getIdEndereco());
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("Número: " + endereco.getNumero());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Complemento: " + endereco.getComplemento());

    }

    // ==========================
    // ATUALIZAR ENDEREÇO
    // ==========================

    public static void atualizarEndereco() {

        System.out.print("ID do endereço: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nova rua: ");
        String rua = sc.nextLine();

        System.out.print("Novo número: ");
        String numero = sc.nextLine();

        System.out.print("Novo bairro: ");
        String bairro = sc.nextLine();

        System.out.print("Nova cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Novo complemento: ");
        String complemento = sc.nextLine();

        Endereco endereco = new Endereco(
                id,
                rua,
                numero,
                bairro,
                cidade,
                complemento
        );

        enderecoDAO.atualizar(endereco);

    }

    // ==========================
    // EXCLUIR ENDEREÇO
    // ==========================

    public static void excluirEndereco() {

        System.out.print("Informe o ID do endereço: ");

        int id = sc.nextInt();
        sc.nextLine();

        enderecoDAO.deletar(id);

    }

    // ==========================
    // MENU PEDIDOS
    // ==========================

    public static void menuPedido() {

        int op;

        do {

            System.out.println("\n------ PEDIDOS ------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("6 - Listar pedidos de um cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    cadastrarPedido();
                    break;

                case 2:
                    listarPedidos();
                    break;

                case 3:
                    buscarPedido();
                    break;

                case 4:
                    atualizarPedido();
                    break;

                case 5:
                    excluirPedido();
                    break;

                case 6:
                    listarPedidosCliente();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (op != 0);

    }

    // ==========================
    // CADASTRAR PEDIDO
    // ==========================

    public static void cadastrarPedido() {

        System.out.print("ID do Cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        System.out.print("Data (AAAA-MM-DD): ");
        String data = sc.nextLine();

        System.out.print("Valor Total: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Pedido pedido = new Pedido(
                0,
                idCliente,
                data,
                valor
        );

        pedidoDAO.salvar(pedido);

    }

    // ==========================
    // LISTAR PEDIDOS
    // ==========================

    public static void listarPedidos() {

        ArrayList<Pedido> lista = pedidoDAO.listar();

        if (lista.isEmpty()) {

            System.out.println("Nenhum pedido encontrado.");
            return;

        }

        for (Pedido p : lista) {

            System.out.println("------------------------");
            System.out.println("ID Pedido: " + p.getIdPedido());
            System.out.println("ID Cliente: " + p.getIdCliente());
            System.out.println("Data: " + p.getData());
            System.out.println("Valor Total: R$ " + p.getValorTotal());

        }

    }

    // ==========================
    // BUSCAR PEDIDO
    // ==========================

    public static void buscarPedido() {

        System.out.print("Informe o ID do pedido: ");

        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = pedidoDAO.buscarPorId(id);

        if (pedido == null) {

            System.out.println("Pedido não encontrado.");
            return;

        }

        System.out.println("------------------------");
        System.out.println("ID Pedido: " + pedido.getIdPedido());
        System.out.println("ID Cliente: " + pedido.getIdCliente());
        System.out.println("Data: " + pedido.getData());
        System.out.println("Valor Total: R$ " + pedido.getValorTotal());

    }

    // ==========================
    // ATUALIZAR PEDIDO
    // ==========================

    public static void atualizarPedido() {

        System.out.print("ID do Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo ID Cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        System.out.print("Nova Data (AAAA-MM-DD): ");
        String data = sc.nextLine();

        System.out.print("Novo Valor Total: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Pedido pedido = new Pedido(
                idPedido,
                idCliente,
                data,
                valor
        );

        pedidoDAO.atualizar(pedido);

    }

    // ==========================
    // EXCLUIR PEDIDO
    // ==========================

    public static void excluirPedido() {

        System.out.print("ID do Pedido: ");

        int id = sc.nextInt();
        sc.nextLine();

        pedidoDAO.deletar(id);

    }

    // ==========================
    // LISTAR PEDIDOS DE UM CLIENTE
    // ==========================

    public static void listarPedidosCliente() {

        System.out.print("Informe o ID do cliente: ");

        int idCliente = sc.nextInt();
        sc.nextLine();

        ArrayList<Pedido> lista = pedidoDAO.listarPorCliente(idCliente);

        if (lista.isEmpty()) {

            System.out.println("Nenhum pedido encontrado para esse cliente.");
            return;

        }

        for (Pedido p : lista) {

            System.out.println("------------------------");
            System.out.println("ID Pedido: " + p.getIdPedido());
            System.out.println("Data: " + p.getData());
            System.out.println("Valor Total: R$ " + p.getValorTotal());

        }

    }

    // ==========================
    // MENU ITENS DO PEDIDO
    // ==========================

    public static void menuItensPedido() {

        int op;

        do {

            System.out.println("\n------ ITENS DO PEDIDO ------");
            System.out.println("1 - Adicionar Item");
            System.out.println("2 - Listar Itens");
            System.out.println("3 - Buscar Item");
            System.out.println("4 - Atualizar Item");
            System.out.println("5 - Excluir Item");
            System.out.println("6 - Listar Itens de um Pedido");
            System.out.println("7 - Calcular Valor Total do Pedido");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    cadastrarItem();
                    break;

                case 2:
                    listarItens();
                    break;

                case 3:
                    buscarItem();
                    break;

                case 4:
                    atualizarItem();
                    break;

                case 5:
                    excluirItem();
                    break;

                case 6:
                    listarItensPedido();
                    break;

                case 7:
                    calcularTotalPedido();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (op != 0);

    }

    // ==========================
    // CADASTRAR ITEM
    // ==========================

    public static void cadastrarItem() {

        System.out.print("ID do Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();

        System.out.print("Produto: ");
        String produto = sc.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        ItensPedido item = new ItensPedido(
                0,
                idPedido,
                produto,
                quantidade,
                preco
        );

        itensPedidoDAO.salvar(item);

    }

    // ==========================
    // LISTAR ITENS
    // ==========================

    public static void listarItens() {

        ArrayList<ItensPedido> lista = itensPedidoDAO.listar();

        if (lista.isEmpty()) {

            System.out.println("Nenhum item encontrado.");
            return;

        }

        for (ItensPedido item : lista) {

            System.out.println("------------------------");
            System.out.println("ID Item: " + item.getIdItem());
            System.out.println("ID Pedido: " + item.getIdPedido());
            System.out.println("Produto: " + item.getProduto());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço: R$ " + item.getPreco());

        }

    }

    // ==========================
    // BUSCAR ITEM
    // ==========================

    public static void buscarItem() {

        System.out.print("Informe o ID do Item: ");

        int id = sc.nextInt();
        sc.nextLine();

        ItensPedido item = itensPedidoDAO.buscarPorId(id);

        if (item == null) {

            System.out.println("Item não encontrado.");
            return;

        }

        System.out.println("------------------------");
        System.out.println("ID Item: " + item.getIdItem());
        System.out.println("ID Pedido: " + item.getIdPedido());
        System.out.println("Produto: " + item.getProduto());
        System.out.println("Quantidade: " + item.getQuantidade());
        System.out.println("Preço: R$ " + item.getPreco());

    }

    // ==========================
    // ATUALIZAR ITEM
    // ==========================

    public static void atualizarItem() {

        System.out.print("ID do Item: ");
        int idItem = sc.nextInt();
        sc.nextLine();

        System.out.print("ID Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();

        System.out.print("Produto: ");
        String produto = sc.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        ItensPedido item = new ItensPedido(
                idItem,
                idPedido,
                produto,
                quantidade,
                preco
        );

        itensPedidoDAO.atualizar(item);

    }

    // ==========================
    // EXCLUIR ITEM
    // ==========================

    public static void excluirItem() {

        System.out.print("Informe o ID do Item: ");

        int id = sc.nextInt();
        sc.nextLine();

        itensPedidoDAO.deletar(id);

    }

    // ==========================
    // LISTAR ITENS DE UM PEDIDO
    // ==========================

    public static void listarItensPedido() {

        System.out.print("Informe o ID do Pedido: ");

        int idPedido = sc.nextInt();
        sc.nextLine();

        ArrayList<ItensPedido> lista = itensPedidoDAO.listarPorPedido(idPedido);

        if (lista.isEmpty()) {

            System.out.println("Nenhum item encontrado para este pedido.");
            return;

        }

        for (ItensPedido item : lista) {

            System.out.println("------------------------");
            System.out.println("Produto: " + item.getProduto());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço: R$ " + item.getPreco());

        }

    }

    // ==========================
    // CALCULAR TOTAL DO PEDIDO
    // ==========================

    public static void calcularTotalPedido() {

        System.out.print("Informe o ID do Pedido: ");

        int idPedido = sc.nextInt();
        sc.nextLine();

        double total = itensPedidoDAO.calcularTotalPedido(idPedido);

        System.out.printf("Valor total do pedido: R$ %.2f%n", total);

    }

}