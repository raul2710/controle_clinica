package model;

public class Medico {
    
    private int id;
    private String nome;
    private int id_especialidade;
    private String nro_crm;
    private boolean fg_ativo;
    private String telefone;
    private String email;

    public Medico() {
    }

    public Medico(int id, String nome, int id_especialidade, String nro_crm, boolean fg_ativo, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.id_especialidade = id_especialidade;
        this.nro_crm = nro_crm;
        this.fg_ativo = fg_ativo;
        this.telefone = telefone;
        this.email = email;
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

    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public String getNro_crm() {
        return nro_crm;
    }

    public void setNro_crm(String nro_crm) {
        this.nro_crm = nro_crm;
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

    @Override
    public String toString() {
        return nome;
    }
}
