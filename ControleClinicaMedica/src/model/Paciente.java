package model;

/**
 *
 * @author Raul
 */
public class Paciente {
  
    private int id;
    private String nome;
    private String sexo;
    private String data_nasc;
    private boolean fg_ativo;
    private String telefone;
    private String email;
    private String cpf;

    public Paciente() {
    }
    
    public Paciente(int id, String nome, String sexo, String data_nasc, boolean fg_ativo, String telefone, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.fg_ativo = fg_ativo;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public boolean isFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(boolean fg_ativo) {
        this.fg_ativo = fg_ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome;
    }
}
