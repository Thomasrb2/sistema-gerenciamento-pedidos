package dao;

import Conexao.Conexao;
import model.ItensPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItensPedidoDAO {

    // Salvar item do pedido
    public void salvar(ItensPedido item) {

        String sql = "INSERT INTO itens_pedido(idPedido, produto, quantidade, preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getIdPedido());
            stmt.setString(2, item.getProduto());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPreco());

            stmt.executeUpdate();

            System.out.println("Item cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar item.");
            e.printStackTrace();
        }
    }

    // Listar todos os itens
    public ArrayList<ItensPedido> listar() {

        ArrayList<ItensPedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM itens_pedido";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                ItensPedido item = new ItensPedido(

                        rs.getInt("idItem"),
                        rs.getInt("idPedido"),
                        rs.getString("produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")

                );

                lista.add(item);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar item por ID
    public ItensPedido buscarPorId(int idItem) {

        String sql = "SELECT * FROM itens_pedido WHERE idItem = ?";

        ItensPedido item = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItem);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                item = new ItensPedido(

                        rs.getInt("idItem"),
                        rs.getInt("idPedido"),
                        rs.getString("produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")

                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    // Atualizar item
    public void atualizar(ItensPedido item) {

        String sql = "UPDATE itens_pedido SET idPedido=?, produto=?, quantidade=?, preco=? WHERE idItem=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getIdPedido());
            stmt.setString(2, item.getProduto());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPreco());
            stmt.setInt(5, item.getIdItem());

            stmt.executeUpdate();

            System.out.println("Item atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Excluir item
    public void deletar(int idItem) {

        String sql = "DELETE FROM itens_pedido WHERE idItem = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idItem);

            stmt.executeUpdate();

            System.out.println("Item removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Listar itens de um pedido
    public ArrayList<ItensPedido> listarPorPedido(int idPedido) {

        ArrayList<ItensPedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM itens_pedido WHERE idPedido = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ItensPedido item = new ItensPedido(

                        rs.getInt("idItem"),
                        rs.getInt("idPedido"),
                        rs.getString("produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")

                );

                lista.add(item);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Calcular o valor total de um pedido
    public double calcularTotalPedido(int idPedido) {

        String sql = "SELECT SUM(quantidade * preco) AS total FROM itens_pedido WHERE idPedido = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

}