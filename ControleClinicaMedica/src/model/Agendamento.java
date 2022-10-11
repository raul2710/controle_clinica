package model;

public class Agendamento {
    
    private int id;
    private String data;
    private int id_paciente;
    private int id_medico;
    private String status;
    private String horario;
    private String sintoma;

    public Agendamento() {
    }

    public Agendamento(int id, String data, int id_paciente, int id_medico, String status, String horario, String sintoma) {
        this.id = id;
        this.data = data;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.status = status;
        this.horario = horario;
        this.sintoma = sintoma;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

}
