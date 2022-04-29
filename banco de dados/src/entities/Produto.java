package entities;

public class Produto {

    //Atributos
    private String codBarra;
    private String nomeProduto;
    private double preco;

    //Método Construtor
    public Produto(String codBarra, String nomeProduto, double preco){
        this.codBarra = codBarra;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    //Método de acesso get e set

    // CÓDIGO DE BARRA
    public String getCodBarra() {
        return this.codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    //NOME PRODUTO
    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    //PREÇO
    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
