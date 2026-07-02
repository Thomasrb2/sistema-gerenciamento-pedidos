public class Endereco{
    private int idEndereco;  
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;

    public Endereco(int idEndereco, String rua, String numero, String bairro, String cidade, String complemento){
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
    }

    public int getIdEndereco(){
        return idEndereco;
    }
    public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }

    public String getRua(){
        return rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }

    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }

    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getComplemento(){
        return complemento;
    }
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }


}
