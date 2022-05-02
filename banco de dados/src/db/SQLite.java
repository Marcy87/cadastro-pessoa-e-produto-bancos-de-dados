package db;

import entities.Pessoa;
import entities.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLite {

    private Connection conn;
    private Statement stm;

    public SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:base.db");
        this.stm = this.conn.createStatement();
    }


    //PESSOAS

    //Método responsavél por inserir os dados na tabela pessoa
    public void insertPessoa(Pessoa pessoa){
        try {
            if (!this.checkPessoa(pessoa)){
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into pessoa(nome, sobreNome, idade, cpf) values ('"+pessoa.getNome()+"','"+pessoa.getSobreNome()+"', '"+pessoa.getIdade()+"', '"+pessoa.getCpf()+"')";
                this.stm.executeUpdate(cmdSQL);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Método para recuperar os dados da tabela Pessoa
    public List<Pessoa> getAllPessoa(){
        List<Pessoa> listaPessoa = new ArrayList<>();
        ResultSet resultSet;

        try{
            resultSet = this.stm.executeQuery("select * from pessoa");

            while (resultSet.next()){
                listaPessoa.add(new Pessoa(resultSet.getString("nome"), resultSet.getString("sobreNome"), resultSet.getInt("idade")));
            }

            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return listaPessoa;
    }

    //Método para verificar se o CPF está registrado no banco de dados
    private boolean checkPessoa(Pessoa pessoa){
        List<Pessoa> listaPessoa = new ArrayList<>();
        try{
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from pessoa where CPF = '"+pessoa.getCpf()+"' ");

            while (resultSet.next()){
                listaPessoa.add(new Pessoa(resultSet.getString("nome"), resultSet.getString("sobreNome"), resultSet.getInt("idade")));
            }

            if (listaPessoa.size() >= 1){
                return true;
            } else{
                return false;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de uma pessoa
    public void updatePessoa(Pessoa pessoa){
        try {
            if (this.checkPessoa(pessoa)){
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                                   "   pessoa " +
                                   "set " +
                                   "   idade = "+pessoa.getIdade()+", " +
                                   "   nome = '"+pessoa.getNome()+"', " +
                                   "   sobreNome = '"+pessoa.getSobreNome()+"' " +
                                   "where " +
                                   "   cpf = '"+pessoa.getCpf()+"'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Eliminar objeto pessoa dentro do banco de dados
    public void eliminarPessoa(Pessoa pessoa){
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from pessoa where CPF = '"+pessoa.getCpf()+"'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    //PRODUTOS

    //Método responsavél por inserir os dados na tabela Produto
    public void insertProduto(Produto produto){
        try {
            if (!this.checkProduto(produto)){
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into produto(codBarra, nomeProduto, preco) values ('"+produto.getCodBarra()+"','"+produto.getNomeProduto()+"', '"+produto.getPreco()+"')";
                this.stm.executeUpdate(cmdSQL);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Método para recuperar os dados da tabela Produto
    public List<Produto> getAllProduto(){
        List<Produto> listaProduto = new ArrayList<>();
        ResultSet resultSet;

        try{
            resultSet = this.stm.executeQuery("select * from produto");

            while (resultSet.next()){
                listaProduto.add(new Produto(resultSet.getString("codBarra"), resultSet.getString("nomeProduto"), resultSet.getDouble("preco")));
            }

            resultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return listaProduto;
    }

    //Método para verificar se o código Barra está registrado no banco de dados
    private boolean checkProduto(Produto produto){
        List<Produto> listaProduto = new ArrayList<>();
        try{
            ResultSet resultSet;
            resultSet = this.stm.executeQuery("select * from produto where codBarra = '"+produto.getCodBarra()+"' ");

            while (resultSet.next()){
                listaProduto.add(new Produto(resultSet.getString("codBarra"), resultSet.getString("nomeProduto"), resultSet.getDouble("preco")));
            }

            if (listaProduto.size() >= 1){
                return true;
            } else{
                return false;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //Método para atualizar dados de um Produto
    public void updateProduto(Produto produto){
        try {
            if (this.checkProduto(produto)){
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                        "   produto " +
                        "set " +
                        "   nomeProduto = '"+produto.getNomeProduto()+"', " +
                        "   preco = '"+produto.getPreco()+"' " +
                        "where " +
                        "   codBarra = '"+produto.getCodBarra()+"'";
                this.stm.executeUpdate(cmdUpdate);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Eliminar objeto Produto dentro do banco de dados
    public void eliminarProduto(Produto produto){
        try {
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from produto where codBarra = '"+produto.getCodBarra()+"'";
            this.stm.executeUpdate(cmdDelete);  //executar o comando

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
