package dao;

import Conexao.Conexao;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    // Salvar pedido
    public void salvar(Pedido pedido){

        String sql = "INSERT INTO pedidos(idCliente, data, valorTotal) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, pedido.getIdCliente());
            stmt.setString(2, pedido.getData());
            stmt.setDouble(3, pedido.getValorTotal());

            stmt.executeUpdate();

            System.out.println("Pedido cadastrado com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao cadastrar pedido.");
            e.printStackTrace();
        }

    }

    // Listar pedidos
    public ArrayList<Pedido> listar(){

        ArrayList<Pedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM pedidos";

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){

                Pedido pedido = new Pedido(

                        rs.getInt("idPedido"),
                        rs.getInt("idCliente"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal")

                );

                lista.add(pedido);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return lista;

    }

    // Buscar pedido por ID
    public Pedido buscarPorId(int idPedido){

        String sql = "SELECT * FROM pedidos WHERE idPedido = ?";

        Pedido pedido = null;

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, idPedido);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){

                pedido = new Pedido(

                        rs.getInt("idPedido"),
                        rs.getInt("idCliente"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal")

                );

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return pedido;

    }

    // Atualizar pedido
    public void atualizar(Pedido pedido){

        String sql = "UPDATE pedidos SET idCliente=?, data=?, valorTotal=? WHERE idPedido=?";

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, pedido.getIdCliente());
            stmt.setString(2, pedido.getData());
            stmt.setDouble(3, pedido.getValorTotal());
            stmt.setInt(4, pedido.getIdPedido());

            stmt.executeUpdate();

            System.out.println("Pedido atualizado com sucesso!");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    // Excluir pedido
    public void deletar(int idPedido){

        String sql = "DELETE FROM pedidos WHERE idPedido = ?";

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, idPedido);

            stmt.executeUpdate();

            System.out.println("Pedido removido com sucesso!");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    // Listar pedidos de um cliente
    public ArrayList<Pedido> listarPorCliente(int idCliente){

        ArrayList<Pedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM pedidos WHERE idCliente = ?";

        try(Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                Pedido pedido = new Pedido(

                        rs.getInt("idPedido"),
                        rs.getInt("idCliente"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal")

                );

                lista.add(pedido);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return lista;

    }

}