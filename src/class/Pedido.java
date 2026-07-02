public class Pedido {
    private int idPedido; 
    private int idCliente;
    private String data;
    private double valorTotal;

    public Pedido(int idPedido, int idCliente, String data, double valorTotal){

        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public int getIdPedido(){
        return idPedido;
    }
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }

    public int getIdCliente(){
        return idCliente;
    }
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public double getValorTotal(){
        return valorTotal;
    }
    public void setValorTotal(double valorTotal){
        this.valorTotal = valorTotal;
    }




}
