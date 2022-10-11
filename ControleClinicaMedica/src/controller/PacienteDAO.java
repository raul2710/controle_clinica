package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Paciente;

public class PacienteDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public PacienteDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = Conexao.conectar();
    }
    
    //OPERAÇÃO: inserir
    public int inserir(Paciente pcte){
        try {
            String SQL = "insert into tb_paciente(nome, sexo, data_nasc, fg_ativo, telefone, email, cpf) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
 
            //definir o valor do parâmetro
            cmd.setString(1, pcte.getNome());
            cmd.setString(2, pcte.getSexo());
            cmd.setDate(3, Date.valueOf(pcte.getData_nasc())); //Datas yyyy-mm-dd
            cmd.setBoolean(4, pcte.isFg_ativo());
            cmd.setString(5, pcte.getTelefone());
            cmd.setString(6, pcte.getEmail());
            cmd.setString(7, pcte.getCpf());
             
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
    
    public int atualizar(Paciente pcte){
        try {
            String SQL = "update tb_paciente set nome=?, sexo=?, data_nasc=?, fg_ativo=?, "
                    + "telefone=?, email=?, cpf=? where id=? ";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, pcte.getNome());
            cmd.setString(2, pcte.getSexo());
            cmd.setDate(3, Date.valueOf(pcte.getData_nasc()));  //Datas yyyy-mm-dd
            cmd.setBoolean(4, pcte.isFg_ativo());
            cmd.setString(5, pcte.getTelefone());
            cmd.setString(6, pcte.getEmail());
            cmd.setString(7, pcte.getCpf());
            cmd.setInt(8, pcte.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return pcte.getId();
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
    
    public Paciente pesquisarPorId(int id){
        try {
            String SQL = "select * from tb_paciente where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf") 
                );
                return p;
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
       
    public List<Paciente> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_paciente where nome ilike ?";
            
            cmd = con.prepareStatement(SQL);
            
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Paciente> lista = new ArrayList<>();
            
            while(rs.next()){
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf") 
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
     
    public List<Paciente> listarPorNome(){
        try {
            String SQL = "select * from tb_paciente order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Paciente> lista = new ArrayList<>();
            while(rs.next()){
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf") 
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
    
    public List<Paciente> listarPorId(){
        try {
            String SQL = "select * from tb_paciente order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Paciente> lista = new ArrayList<>();
            while(rs.next()){
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf") 
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
