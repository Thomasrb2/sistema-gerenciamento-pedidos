public class Cliente{
    private int id;
    private String nome;
    private int idade;
    private String gmail;
    private String telefone;
    private String cpf;
    private int idEndereco;


    public Cliente (int id, String nome, int idade, String gmail, String telefone, String cpf, int idEndereco){
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            this.gmail = gmail;
            this.telefone = telefone;
            this.cpf = cpf;
            this.idEndereco = idEndereco;

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getGmail(){
        return gmail;
    }
    public void setGmail(String gmail){
        this.gmail = gmail;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public int getIdEndereco(){
        return idEndereco;
    }
    public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }


}