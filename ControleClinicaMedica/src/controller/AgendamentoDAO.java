package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import model.Agendamento;

public class AgendamentoDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public AgendamentoDAO(){
        //abrir uma nova conexão com o banco de dados
        this.con = Conexao.conectar();
    }
    
    //OPERAÇÃO: inserir médico
    public int inserir(Agendamento agd){
        try {
            String SQL = "insert into tb_agendamento(data, id_paciente, id_medico, status, horario, sintoma) "
                    + "values (?, ?, ?, ?, ?, ?)";
                    
            cmd = con.prepareStatement(
                SQL,
                Statement.RETURN_GENERATED_KEYS
            );
            
            //definir o valor do parâmetro
            cmd.setDate(1, Date.valueOf(agd.getData())); //Datas yyyy-mm-dd
            cmd.setInt(2, agd.getId_paciente());
            cmd.setInt(3, agd.getId_medico());
            cmd.setString(4, agd.getStatus());
            cmd.setTime(5, Time.valueOf(agd.getHorario()));
            cmd.setString(6, agd.getSintoma());
            
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
    
    public int atualizar(Agendamento agd){
        try {
            String SQL = "update tb_agendamento set data=?, id_paciente=?, id_medico=?, status=?, horario=?, sintoma=? "
                    + "where id=?";
            
            cmd = con.prepareStatement(SQL);
            
            //definir o valor do parâmetro
            cmd.setDate(1, Date.valueOf(agd.getData())); //Datas yyyy-mm-dd
            cmd.setInt(2, agd.getId_paciente());
            cmd.setInt(3, agd.getId_medico());
            cmd.setString(4, agd.getStatus());
            cmd.setTime(5, Time.valueOf(agd.getHorario()));
            cmd.setString(6, agd.getSintoma());
            cmd.setInt(7, agd.getId());
            
            if (cmd.executeUpdate() > 0){
                //Tudo certo com a atualização
                return agd.getId();
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
    
    public List<Agendamento> pesquisarPorData(String data){
        try {
            String SQL = "select * from tb_agendamento where data=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setDate(1, Date.valueOf(data));
            
            ResultSet rs = cmd.executeQuery();
            List<Agendamento> lista = new ArrayList<>();
            
            while(rs.next()){
                Agendamento m = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getString("status"),
                    rs.getString("horario"),
                    rs.getString("sintoma")
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
    
    public List<Agendamento> pesquisarPorMedico(int id_med){
        try {
            String SQL = "select * from tb_agendamento where id_medico=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id_med);
            
            ResultSet rs = cmd.executeQuery();
            List<Agendamento> lista = new ArrayList<>();
            
            while(rs.next()){
                Agendamento m = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getString("status"),
                    rs.getString("horario"),
                    rs.getString("sintoma")
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
    
    public List<Agendamento> pesquisarPorPaciente(int id_pcte){
        try {
            String SQL = "select * from tb_agendamento where id_paciente=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id_pcte);
            
            ResultSet rs = cmd.executeQuery();
            List<Agendamento> lista = new ArrayList<>();
            
            while(rs.next()){
                Agendamento m = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getString("status"),
                    rs.getString("horario"),
                    rs.getString("sintoma")
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
    
    public Agendamento pesquisarPorId(int id){
        try {
            String SQL = "select * from tb_agendamento where id=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Agendamento m = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getString("status"),
                    rs.getString("horario"),
                    rs.getString("sintoma")
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
    
    public List<Agendamento> listarPorId(){
        try {
            String SQL = "select * from tb_agendamento order by id";
            
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();
            List<Agendamento> lista = new ArrayList<>();
            
            while(rs.next()){
                Agendamento m = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getInt("id_paciente"),
                    rs.getInt("id_medico"),
                    rs.getString("status"),
                    rs.getString("horario"),
                    rs.getString("sintoma")
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
