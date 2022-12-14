/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AgendamentoDAO;
import controller.MedicoDAO;
import controller.PacienteDAO;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.Agendamento;
import model.Medico;
import model.Paciente;

/**
 *
 * @author Raul
 */
public class FormPesquisaConsulta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormPesquisaConsulta
     */
    public FormPesquisaConsulta() {
        initComponents();
        
        this.setTitle("Pesquisar Consulta");
        this.setResizable(false);
        this.setIconifiable(false);
        this.setMaximizable(false);
        this.setClosable(true);
        
        createFormatter("##/##/####").install(txtData);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbData);
        bg.add(rdbPaciente);
        bg.add(rdbMedico);
        rdbData.setSelected(true);
        
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        List<Medico> listaMed = new MedicoDAO().listarPorNome();
        for(Medico med : listaMed){
            m.addElement(med);
        }
        cbxMedico.setModel(m);

        
        DefaultComboBoxModel n = new DefaultComboBoxModel();
        List<Paciente> listaPcte = new PacienteDAO().listarPorNome();
        for(Paciente p : listaPcte){
            n.addElement(p);
        }
        cbxPaciente.setModel(n);
        
        configurarTabela();
        
        List<Agendamento> listaAgd = new AgendamentoDAO().listarPorId();
        if (listaAgd.size() > 0) {
            DefaultTableModel mTab = (DefaultTableModel) tabResultado.getModel();
            for (Agendamento agendamento : listaAgd) {
                mTab.addRow(new Object[]{
                    agendamento.getId(),
                    agendamento.getData(),
                    agendamento.getId_paciente(),
                    agendamento.getId_medico(),
                    agendamento.getStatus(),
                    agendamento.getHorario(),
                    agendamento.getSintoma()
                });
            }
            tabResultado.setModel(mTab);
        } else {
            JOptionPane.showMessageDialog(
                null, "Nenhum registro encontrado."
            );
        }   
    }

    private void configurarTabela() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("Id");
        m.addColumn("Data");
        m.addColumn("Id Paciente");
        m.addColumn("Id Medico");
        m.addColumn("Status");
        m.addColumn("Horario");
        m.addColumn("Sintoma");
       
        tabResultado.setModel(m);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        cbxMedico = new javax.swing.JComboBox<>();
        cbxPaciente = new javax.swing.JComboBox<>();
        rdbData = new javax.swing.JRadioButton();
        rdbMedico = new javax.swing.JRadioButton();
        rdbPaciente = new javax.swing.JRadioButton();
        lblPesquisarPor = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        btnId = new javax.swing.JButton();
        lblListarPor = new javax.swing.JLabel();

        tabResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultado);

        cbxMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedicoActionPerformed(evt);
            }
        });
        cbxMedico.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxMedicoPropertyChange(evt);
            }
        });

        cbxPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPacienteActionPerformed(evt);
            }
        });

        rdbData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbData.setText("Data:");

        rdbMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbMedico.setText("Medico:");

        rdbPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbPaciente.setText("Paciente:");

        lblPesquisarPor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPesquisarPor.setText("Pesquisar consulta por:");

        txtData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataKeyPressed(evt);
            }
        });

        btnId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnId.setText("Id");
        btnId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdActionPerformed(evt);
            }
        });

        lblListarPor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblListarPor.setText("Listar por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisarPor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbPaciente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdbMedico)
                                            .addComponent(rdbData))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtData))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblListarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnId)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPesquisarPor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnId)
                        .addComponent(lblListarPor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbMedico)
                    .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPaciente)
                    .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadoMouseClicked
        // TODO add your handling code here:
        //CLIQUE DUPLO
        if (evt.getClickCount() == 2) {
            //Descobrir a linha selecionada
            int linha = tabResultado.getSelectedRow();

            //Recuperar o ID selecionado
            int id = Integer.parseInt(
                    tabResultado.getValueAt(linha, 0).toString()
            );

            //Abrir o FormCadastro
            FormAgendamentoConsulta f = new FormAgendamentoConsulta(id);
            this.getDesktopPane().add(f);
            f.setVisible(true);

            //Fechar o FormPesquisa
            this.dispose();
        }
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void cbxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedicoActionPerformed
        // TODO add your handling code here:
        // PESQUISAR POR NOME
        
        if(rdbMedico.isSelected()){
            configurarTabela();
            Medico med = (Medico)cbxMedico.getSelectedItem();
                    
            List<Agendamento> lista = new AgendamentoDAO().pesquisarPorMedico(med.getId());
            if (lista.size() > 0) {
                DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                for (Agendamento agendamento : lista) {
                m.addRow(new Object[]{
                    agendamento.getId(),
                    agendamento.getData(),
                    agendamento.getId_paciente(),
                    agendamento.getId_medico(),
                    agendamento.getStatus(),
                    agendamento.getHorario(),
                    agendamento.getSintoma()
                });
                }
                tabResultado.setModel(m);
                } else {
                JOptionPane.showMessageDialog(
                null, "Nenhum registro encontrado."
                );
            }
        }
    }//GEN-LAST:event_cbxMedicoActionPerformed

    private void cbxMedicoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxMedicoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMedicoPropertyChange

    private void cbxPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPacienteActionPerformed
        // TODO add your handling code here:
        if(rdbPaciente.isSelected()){
            configurarTabela();
            Paciente pcte = (Paciente)cbxPaciente.getSelectedItem();
                    
            List<Agendamento> lista = new AgendamentoDAO().pesquisarPorPaciente(pcte.getId());
            if (lista.size() > 0) {
                DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                for (Agendamento agendamento : lista) {
                m.addRow(new Object[]{
                    agendamento.getId(),
                    agendamento.getData(),
                    agendamento.getId_paciente(),
                    agendamento.getId_medico(),
                    agendamento.getStatus(),
                    agendamento.getHorario(),
                    agendamento.getSintoma()
                });
                }
                tabResultado.setModel(m);
                } else {
                JOptionPane.showMessageDialog(
                null, "Nenhum registro encontrado."
                );
            }
        }
    }//GEN-LAST:event_cbxPacienteActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
        // TODO add your handling code here:
        
        // PESQUISAR POR DATA
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && rdbData.isSelected()) {
            if (txtData.getText().isEmpty() && rdbData.isSelected()) {
                JOptionPane.showMessageDialog(
                    null, "Informe o crit??rio de pesquisa."
                );
            } else{

                try{
                    configurarTabela();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                    LocalDate data  = LocalDate.parse(txtData.getText(), formato);
                    
                    List<Agendamento> lista = new AgendamentoDAO().pesquisarPorData(data.toString());
                if (lista.size() > 0) {
                    DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                    for (Agendamento agendamento : lista) {
                    m.addRow(new Object[]{
                        agendamento.getId(),
                        agendamento.getData(),
                        agendamento.getId_paciente(),
                        agendamento.getId_medico(),
                        agendamento.getStatus(),
                        agendamento.getHorario(),
                        agendamento.getSintoma()
                    });
                }
                tabResultado.setModel(m);
                } else {
                    JOptionPane.showMessageDialog(
                        null, "Nenhum registro encontrado."
                    );
                }
                } catch(Exception e){
                    JOptionPane.showMessageDialog(
                        null, "Informe uma data v??lida."
                    );
                } 
            }             
        }                 
    }//GEN-LAST:event_txtDataKeyPressed

    private void btnIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdActionPerformed
        // TODO add your handling code here:
        configurarTabela();
        List<Agendamento> listaAgd = new AgendamentoDAO().listarPorId();
        if (listaAgd.size() > 0) {
            DefaultTableModel mTab = (DefaultTableModel) tabResultado.getModel();
            for (Agendamento agendamento : listaAgd) {
                mTab.addRow(new Object[]{
                    agendamento.getId(),
                    agendamento.getData(),
                    agendamento.getId_paciente(),
                    agendamento.getId_medico(),
                    agendamento.getStatus(),
                    agendamento.getHorario(),
                    agendamento.getSintoma()
                });
            }
            tabResultado.setModel(mTab);
        } else {
            JOptionPane.showMessageDialog(
                null, "Nenhum registro encontrado."
            );
        }  
    }//GEN-LAST:event_btnIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnId;
    private javax.swing.JComboBox<String> cbxMedico;
    private javax.swing.JComboBox<String> cbxPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListarPor;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JRadioButton rdbData;
    private javax.swing.JRadioButton rdbMedico;
    private javax.swing.JRadioButton rdbPaciente;
    private javax.swing.JTable tabResultado;
    private javax.swing.JFormattedTextField txtData;
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
