package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    // PARÂMETROS DA CONEXÃO
    private static final String HOST = "127.0.0.1:5432";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "password";
    private static final String DATABASE = "CONTROLE_CLINICA";
    
    // STRING DE CONEXÃO
    private static final String URL = 
        "jdbc:postgresql://" + HOST + "/" + DATABASE;
    
    //
    // CONECTAR
    //
    public static Connection conectar(){
        try {
            //carregar o Driver do SGBD
            Class.forName("org.postgresql.Driver");
            //estabelecer a conexão
            return
                DriverManager.getConnection(
                    URL, USUARIO, SENHA
                );
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    //
    // DESCONECTAR
    //
    public static void desconectar(Connection con){
        try {
            if (con!=null){
                con.close();
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Connection con = Conexao.conectar();
        if ( con != null){
            System.out.println("Conexão realizada com sucesso!");
        }
    }
    
}











