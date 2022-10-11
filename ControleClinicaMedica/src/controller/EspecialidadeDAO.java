package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Especialidade;

public class EspecialidadeDAO {
        
    private Connection con;
    private PreparedStatement cmd;
    
    public EspecialidadeDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = Conexao.conectar();
    }
    
    //OPERAÇÃO: inserir médico
    public int inserir(Especialidade med){
        try {
            String SQL = "insert into tb_especialidade(nome) "
                    + "values (?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setString(1, med.getNome());
            
            //executar a operação
            if (cmd.executeUpdate() > 0){
                //operação realizada com sucesso!
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }else{
                //não foi possível realizar a operação
                return -1;
            }
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public int atualizar(Especialidade espc){
        try {
            String SQL = "update tb_especialidade set nome=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, espc.getNome());
            cmd.setInt(2, espc.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return espc.getId();
            }else{
                //Ocorreu um erro ao atualizar;
                return -1;
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public Especialidade pesquisarPorId(int id){
        try {
            String SQL = "select * from tb_especialidade where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Especialidade e = new Especialidade(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                return e;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Especialidade> listarPorNome(){
        try {
            String SQL = "select * from tb_especialidade order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Especialidade> lista = new ArrayList<>();
            while(rs.next()){
                Especialidade e = new Especialidade(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(e);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Especialidade> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_especialidade where nome ilike ?";
            
            cmd = con.prepareStatement(SQL);
            
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Especialidade> lista = new ArrayList<>();
            
            while(rs.next()){
                Especialidade p = new Especialidade(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Especialidade> listarPorId(){
        try {
            String SQL = "select * from tb_especialidade order by id";
            
            cmd = con.prepareStatement(SQL);
        
            ResultSet rs = cmd.executeQuery();
            List<Especialidade> lista = new ArrayList<>();
            
            while(rs.next()){
                Especialidade p = new Especialidade(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
}
