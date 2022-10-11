package view;

import controller.AgendamentoDAO;
import controller.MedicoDAO;
import controller.PacienteDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Agendamento;
import model.Medico;
import model.Paciente;


public class FormAgendamentoConsulta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormAgendamentoConsulta
     */
    public FormAgendamentoConsulta() {
        initComponents();
        
        this.setTitle("Agendar consulta");
        this.setResizable(false);
        this.setIconifiable(false);
        this.setMaximizable(false);
        this.setClosable(false);
        txtId.setEditable(false);
        
        createFormatter("##/##/####").install(txtData);
        createFormatter("##:##:00").install(txtHorario);
        
        DefaultComboBoxModel n = new DefaultComboBoxModel();
        List<Paciente> listaPcte = new PacienteDAO().listarPorNome();
        for(Paciente p : listaPcte){
            n.addElement(p);
        }
        cbxPaciente.setModel(n);
        
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        List<Medico> listaMed = new MedicoDAO().listarPorNome();
        for(Medico med : listaMed){
            m.addElement(med);
        }
        cbxMedico.setModel(m);      
        
        ButtonGroup bg_fg = new ButtonGroup();
        bg_fg.add(rdbAgendada);
        bg_fg.add(rdbCancelada);
        bg_fg.add(rdbFinalizada);
        rdbAgendada.setSelected(true);
    }
    
    public FormAgendamentoConsulta(int id) {
        this();
        txtId.setText(String.valueOf(id));
        
        Agendamento agendamento = new AgendamentoDAO().pesquisarPorId(id);
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate dataNasc = LocalDate.parse(agendamento.getData(), formato);
        
        txtData.setText(
                String.format("%d%d%d", dataNasc.getDayOfMonth(), dataNasc.getMonthValue(), dataNasc.getYear())
            );
        txtHorario.setText(agendamento.getHorario());
  
        txtSintoma.setText(agendamento.getSintoma());
        
        DefaultComboBoxModel m = (DefaultComboBoxModel)cbxPaciente.getModel();
        
        int i;
        for (i = 0; i < m.getSize(); i++) {
            Paciente p = (Paciente)m.getElementAt(i);
            if (p.getId() == agendamento.getId_paciente()){
                break;
            }
        }
        cbxPaciente.setSelectedIndex(i);
        
        DefaultComboBoxModel n = (DefaultComboBoxModel)cbxMedico.getModel();
         
        for (i = 0; i < n.getSize(); i++) {
            Medico med = (Medico)n.getElementAt(i);
            if (med.getId() == agendamento.getId_medico()){
                break;
            }
        }
        cbxMedico.setSelectedIndex(i);

        ButtonGroup bg_fg = new ButtonGroup();
        bg_fg.add(rdbAgendada);
        bg_fg.add(rdbCancelada);
        bg_fg.add(rdbFinalizada);
        if(agendamento.getStatus().equals("Agendada"))
            rdbAgendada.setSelected(true);
        else if(agendamento.getStatus().equals("Cancelada"))
            rdbCancelada.setSelected(true);
        else
            rdbFinalizada.setSelected(true);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblPaciente = new javax.swing.JLabel();
        rdbAgendada = new javax.swing.JRadioButton();
        rdbCancelada = new javax.swing.JRadioButton();
        rdbFinalizada = new javax.swing.JRadioButton();
        lblHorario = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxPaciente = new javax.swing.JComboBox<>();
        lblMedico = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        txtHorario = new javax.swing.JFormattedTextField();
        lblSintoma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintoma = new javax.swing.JTextArea();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Agendar consulta");

        lblData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblData.setText("Data:");

        lblId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblId.setText("Id:");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPaciente.setText("Paciente:");

        rdbAgendada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbAgendada.setText("Agendada");
        rdbAgendada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAgendadaActionPerformed(evt);
            }
        });

        rdbCancelada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbCancelada.setText("Cancelada");

        rdbFinalizada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbFinalizada.setText("Finalizada");

        lblHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHorario.setText("Horário:");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setText("Status:");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedico.setText("Medico:");

        cbxMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSintoma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSintoma.setText("Sintoma:");

        txtSintoma.setColumns(20);
        txtSintoma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSintoma.setRows(5);
        jScrollPane1.setViewportView(txtSintoma);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico)
                            .addComponent(lblPaciente))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSintoma)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblData)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtData))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHorario)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbAgendada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbCancelada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbFinalizada))
                            .addComponent(cbxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblId)
                    .addComponent(lblHorario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSintoma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(rdbAgendada)
                    .addComponent(rdbCancelada)
                    .addComponent(rdbFinalizada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbAgendadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAgendadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbAgendadaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        Agendamento agendamento = new Agendamento();
        
        //Recuperar o ID paciente
        try {
            if(cbxPaciente.getItemCount() == 0 || cbxMedico.getItemCount() == 0){
                JOptionPane.showMessageDialog(
                    null,"Adicionar uma paciente ou médico!"
                );
            } else if(txtHorario.getText().contains("_")) {
                JOptionPane.showMessageDialog(
                    null,"Adicionar um horário válido"
                );
            } else {
                try {
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                    LocalDate data = LocalDate.parse(txtData.getText(), formato);
                    agendamento.setData(data.toString());
                    
                    Paciente p = (Paciente)cbxPaciente.getSelectedItem();
                    agendamento.setId_paciente(p.getId());
            
                    Medico m = (Medico)cbxMedico.getSelectedItem();
                    agendamento.setId_medico(m.getId());
                    
                    agendamento.setHorario(txtHorario.getText());
                    agendamento.setSintoma(txtSintoma.getText());

                    if(rdbAgendada.isSelected())
                        agendamento.setStatus("Agendada");
                    else if(rdbCancelada.isSelected())
                        agendamento.setStatus("Cancelada");
                    else
                        agendamento.setStatus("Finalizada");

                    int res = -1;
                    if (txtId.getText().isEmpty()){
                        res = new AgendamentoDAO().inserir(agendamento);
                    }else{
                        agendamento.setId(Integer.parseInt(txtId.getText()));
                        res = new AgendamentoDAO().atualizar(agendamento);
                    }

                    //Verificar se deu certo
                    if (res > 0){
                        txtId.setText(String.valueOf(res));
                        JOptionPane.showMessageDialog(
                            null,"Operação realizada com sucesso!"
                        );
                    }else{
                        JOptionPane.showMessageDialog(
                            null,"Não foi possível realizar a operação!"
                        );
                    }
                    this.dispose();    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                        null,"Insira uma data"
                    );
                }    
            }  
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,"Adicionar uma paciente ou médico!"
            );
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxMedico;
    private javax.swing.JComboBox<String> cbxPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblSintoma;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdbAgendada;
    private javax.swing.JRadioButton rdbCancelada;
    private javax.swing.JRadioButton rdbFinalizada;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtSintoma;
    // End of variables declaration//GEN-END:variables
    
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            formatter.setPlaceholderCharacter('_');
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }

        return formatter;
    }

}
