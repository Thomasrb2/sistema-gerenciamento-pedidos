package model;
public class ItensPedido {
    private int idItem;
    private int idPedido;
    private String produto;
    private int quantidade;
    private double preco;

    public ItensPedido(int idItem, int idPedido, String produto, int quantidade, double preco){
        this.idItem = idItem;
        this.idPedido = idPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getIdItem(){
        return idItem;
    }
    public void setIdItem(int idItem){
        this.idItem = idItem;
    }

    public int getIdPedido(){
        return idPedido;
    }
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }

    public String getProduto(){
        return produto;
    }
    public void setProduto(String produto){
        this.produto = produto;
    }

    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }


    
    


}
