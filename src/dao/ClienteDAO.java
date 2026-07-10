package dao;

import Conexao.Conexao;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    // Inserir cliente
    public void salvar(Cliente cliente) {

        String sql = "INSERT INTO cliente(nome, idade, gmail, telefone, cpf, idEndereco) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getGmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCpf());
            stmt.setInt(6, cliente.getIdEndereco());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente.");
            e.printStackTrace();
        }
    }

    // Listar clientes
    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(

                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("gmail"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getInt("idEndereco")

                );

                lista.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id = ?";

        Cliente cliente = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                cliente = new Cliente(

                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("gmail"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getInt("idEndereco")

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    // Atualizar cliente
    public void atualizar(Cliente cliente) {

        String sql = "UPDATE cliente SET nome=?, idade=?, gmail=?, telefone=?, cpf=?, idEndereco=? WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getGmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCpf());
            stmt.setInt(6, cliente.getIdEndereco());
            stmt.setInt(7, cliente.getId());

            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Excluir cliente
    public void deletar(int id) {

        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Cliente removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}