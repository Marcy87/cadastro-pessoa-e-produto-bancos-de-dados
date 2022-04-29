import db.SQLite;
import entities.Pessoa;
import entities.Produto;

public class Main {

    public static void main(String[] args){
        try{
            SQLite dbcon = new SQLite();


            //PESSOA
            System.out.println("Inserindo pessoa na tabela");
            dbcon.insertPessoa(new Pessoa("Rodrigo", "Della Justina", 39, "38464968768"));
            dbcon.insertPessoa(new Pessoa("Matheus", "Assis Viera", 19, "5743876684648"));
            dbcon.insertPessoa(new Pessoa("Diogo", "Borges Kompier", 24, "31688348744893"));
            dbcon.insertPessoa(new Pessoa("Tiago", "Delfino da Silva", 34, "4548464968768"));
            dbcon.insertPessoa(new Pessoa("Marcello", "Di Silvestro", 34, "0632716846389"));

            for (Pessoa people : dbcon.getAllPessoa()){
                System.out.println(people.getNome() + " | " + people.getSobreNome() + " | " + people.getIdade());
            }


            System.out.println("");
            System.out.println("");
            System.out.println("Atualizando Tiago..");

            Pessoa pessoAtualiza = new Pessoa("Tiago", "da Silva", 25, "4548464968768");
            dbcon.updatePessoa(pessoAtualiza);

            for (Pessoa people : dbcon.getAllPessoa()){
                System.out.println(people.getNome() + " | " + people.getSobreNome() + " | " + people.getIdade());
            }


            System.out.println("");
            System.out.println("");
            System.out.println("Eliminando Marcello..");

            Pessoa pessoaDelete = new Pessoa("", "", 35, "0632716846389");
            dbcon.eliminarPessoa(pessoaDelete);

            for (Pessoa people : dbcon.getAllPessoa()){
                System.out.println(people.getNome() + " | " + people.getSobreNome() + " | " + people.getIdade());
            }



            //PRODUTO
            System.out.println("Inserindo produto na tabela");
            dbcon.insertProduto(new Produto("345686874866", "Leite", 4.99));
            dbcon.insertProduto(new Produto("649648596589", "Biscoito", 2.99));
            dbcon.insertProduto(new Produto("354948684978", "Creme de leite", 3.99));
            dbcon.insertProduto(new Produto("319646697484", "Azeite", 24.99));
            dbcon.insertProduto(new Produto("231646846486", "Vinagre", 2.99));

            for (Produto prod : dbcon.getAllProduto()){
                System.out.println(prod.getCodBarra() + " | " + prod.getNomeProduto() + " | " + prod.getPreco());
            }


            System.out.println("");
            System.out.println("");
            System.out.println("Atualizando Biscoito");

            Produto produtoAtualiza = new Produto("649648596589", "Coca-cola", 5.99);
            dbcon.updateProduto(produtoAtualiza);

            for (Produto prod : dbcon.getAllProduto()){
                System.out.println(prod.getCodBarra() + " | " + prod.getNomeProduto() + " | " + prod.getPreco());
            }


            System.out.println("");
            System.out.println("");
            System.out.println("Eliminando Vinagre");

            Produto produtoDelete = new Produto("231646846486", "", 2.99);
            dbcon.eliminarProduto(produtoDelete);

            for (Produto prod : dbcon.getAllProduto()){
                System.out.println(prod.getCodBarra() + " | " + prod.getNomeProduto() + " | " + prod.getPreco());
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
