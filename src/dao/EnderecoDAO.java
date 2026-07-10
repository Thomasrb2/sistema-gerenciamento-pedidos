package dao;

import Conexao.Conexao;
import model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO {

    // Inserir endereço
    public void salvar(Endereco endereco) {

        String sql = "INSERT INTO endereco(rua, numero, bairro, cidade, complemento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getComplemento());

            stmt.executeUpdate();

            System.out.println("Endereço cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar endereço.");
            e.printStackTrace();
        }
    }

    // Listar endereços
    public ArrayList<Endereco> listar() {

        ArrayList<Endereco> lista = new ArrayList<>();

        String sql = "SELECT * FROM endereco";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Endereco endereco = new Endereco(
                        rs.getInt("idEndereco"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("complemento")
                );

                lista.add(endereco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar endereço por ID
    public Endereco buscarPorId(int idEndereco) {

        String sql = "SELECT * FROM endereco WHERE idEndereco = ?";

        Endereco endereco = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEndereco);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                endereco = new Endereco(
                        rs.getInt("idEndereco"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("complemento")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    // Atualizar endereço
    public void atualizar(Endereco endereco) {

        String sql = "UPDATE endereco SET rua=?, numero=?, bairro=?, cidade=?, complemento=? WHERE idEndereco=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getComplemento());
            stmt.setInt(6, endereco.getIdEndereco());

            stmt.executeUpdate();

            System.out.println("Endereço atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Excluir endereço
    public void deletar(int idEndereco) {

        String sql = "DELETE FROM endereco WHERE idEndereco = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEndereco);

            stmt.executeUpdate();

            System.out.println("Endereço removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
