package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Medico;

public class MedicoDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public MedicoDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = Conexao.conectar();
    }
    
    //OPERAÇÃO: inserir médico
    public int inserir(Medico med){
        try {
            String SQL = "insert into tb_medico(nome, id_especialidade, nro_crm, fg_ativo, telefone, email) "
                    + "values (?, ?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setString(1, med.getNome());
            cmd.setInt(2, med.getId_especialidade());
            cmd.setString(3, med.getNro_crm());
            cmd.setBoolean(4, med.isFg_ativo());
            cmd.setString(5, med.getTelefone());
            cmd.setString(6, med.getEmail());
            
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
    
    public int atualizar(Medico med){
        try {
            String SQL = "update tb_medico set nome=?, id_especialidade=?, nro_crm=?, fg_ativo=?, "
                    + "telefone=?, email=? where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setString(1, med.getNome());
            cmd.setInt(2, med.getId_especialidade());
            cmd.setString(3, med.getNro_crm());
            cmd.setBoolean(4, med.isFg_ativo());
            cmd.setString(5, med.getTelefone());
            cmd.setString(6, med.getEmail());
            cmd.setInt(7, med.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return med.getId();
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
    
    public Medico pesquisarPorId(int id){
        try {
            String SQL = "select * from tb_medico where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Medico m = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("id_especialidade"),
                    rs.getString("nro_crm"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                return m;
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
    
    public List<Medico> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_medico where nome ilike ?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");
            
            ResultSet rs = cmd.executeQuery();
            List<Medico> lista = new ArrayList<>();
            
            while(rs.next()){
                Medico m = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("id_especialidade"),
                    rs.getString("nro_crm"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Medico> pesquisarPorEspecialidade(int id_espc){
        try {
            String SQL = "select * from tb_medico where id_especialidade=?";
            
            cmd = con.prepareStatement(SQL);

            cmd.setInt(1, id_espc);
            
            ResultSet rs = cmd.executeQuery();
            List<Medico> lista = new ArrayList<>();
            
            while(rs.next()){
                Medico m = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("id_especialidade"),
                    rs.getString("nro_crm"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Medico> listarPorNome(){
        try {
            String SQL = "select * from tb_medico order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Medico> lista = new ArrayList<>();
            while(rs.next()){
                Medico m = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("id_especialidade"),
                    rs.getString("nro_crm"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(m);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    } 
    
    public List<Medico> listarPorId(){
        try {
            String SQL = "select * from tb_medico order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Medico> lista = new ArrayList<>();
            while(rs.next()){
                Medico m = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("id_especialidade"),
                    rs.getString("nro_crm"),
                    rs.getBoolean("fg_ativo"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                lista.add(m);
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
