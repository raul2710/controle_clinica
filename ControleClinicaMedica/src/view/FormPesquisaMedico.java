/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EspecialidadeDAO;
import controller.MedicoDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Especialidade;
import model.Medico;

/**
 *
 * @author Raul
 */
public class FormPesquisaMedico extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormPesquisaMedico
     */
    public FormPesquisaMedico() {
        initComponents();
        
        this.setTitle("Pesquisar Medico");
        this.setResizable(false);
        this.setIconifiable(false);
        this.setMaximizable(false);
        this.setClosable(true);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbId);
        bg.add(rdbNome);
        bg.add(rdbEspec);
        rdbId.setSelected(true);
        
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        List<Especialidade> lista = new EspecialidadeDAO().listarPorNome();
        for(Especialidade e : lista){
            m.addElement(e);
        }
        
        cbxEspec.setModel(m);
        
        configurarTabela();
        List<Medico> listaMed = new MedicoDAO().listarPorId();
        if (listaMed.size() > 0) {
            //String nomeEspec = new EspecialidadeDAO().pesquisarPorId(medico.getId_especialidade()).toString();
            DefaultTableModel mTab = (DefaultTableModel) tabResultado.getModel();
            for (Medico medico : listaMed) {
                mTab.addRow(new Object[]{
                    medico.getId(),
                    medico.getNome(),
                    new EspecialidadeDAO().pesquisarPorId(medico.getId_especialidade()).toString(),
                    medico.getNro_crm(),
                    medico.isFg_ativo(),
                    medico.getTelefone(),
                    medico.getEmail()
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
        m.addColumn("Nome");
        m.addColumn("Id especialidade");
        m.addColumn("Número CRM");
        m.addColumn("Fg_ativo");
        m.addColumn("Telefone");
        m.addColumn("Email");
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

        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultado = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        rdbId = new javax.swing.JRadioButton();
        rdbNome = new javax.swing.JRadioButton();
        rdbEspec = new javax.swing.JRadioButton();
        cbxEspec = new javax.swing.JComboBox<>();
        btnId = new javax.swing.JButton();
        lblListarPor = new javax.swing.JLabel();

        txtPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

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

        lblPesquisarPor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPesquisarPor.setText("Pesquisar médico por:");

        rdbId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbId.setText("Id");
        rdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbIdActionPerformed(evt);
            }
        });

        rdbNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbNome.setText("Nome");

        rdbEspec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbEspec.setText("Especialidade");
        rdbEspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEspecActionPerformed(evt);
            }
        });

        cbxEspec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxEspec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEspec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEspecItemStateChanged(evt);
            }
        });
        cbxEspec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxEspecMouseClicked(evt);
            }
        });
        cbxEspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdbId)
                                .addGap(18, 18, 18)
                                .addComponent(rdbNome)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdbEspec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblListarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnId))
                            .addComponent(cbxEspec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisarPor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblPesquisarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbId)
                    .addComponent(rdbNome)
                    .addComponent(rdbEspec)
                    .addComponent(btnId)
                    .addComponent(lblListarPor))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER && (rdbId.isSelected() || rdbNome.isSelected())) {
            if (txtPesquisa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                    null, "Informe o critério de pesquisa."
                );
            } else {
                configurarTabela();
                // PESQUISAR POR ID
                if (rdbId.isSelected()) {
                    try {
                        Medico medico = new MedicoDAO().pesquisarPorId(
                            Integer.parseInt(txtPesquisa.getText())
                        );
                        if (medico != null) {
                            DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                            m.addRow(new Object[]{
                                medico.getId(),
                                medico.getNome(),
                                medico.getId_especialidade(),
                                medico.getNro_crm(),
                                medico.isFg_ativo(),
                                medico.getTelefone(),
                                medico.getEmail()
                            });
                            tabResultado.setModel(m);
                        } else {
                            JOptionPane.showMessageDialog(
                                null, "Nenhum registro encontrado."
                            );
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(
                            null, "O campo de pesquisa deve ser numérico."
                        );
                    }
                } else if(rdbNome.isSelected()) {
                    // PESQUISAR POR NOME
                    List<Medico> lista = new MedicoDAO().pesquisarPorNome(txtPesquisa.getText());
                    if (lista.size() > 0) {
                        DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                        for (Medico medico : lista) {
                            m.addRow(new Object[]{
                                medico.getId(),
                                medico.getNome(),
                                medico.getId_especialidade(),
                                medico.getNro_crm(),
                                medico.isFg_ativo(),
                                medico.getTelefone(),
                                medico.getEmail()
                            });
                        }
                        tabResultado.setModel(m);
                    } else {
                        JOptionPane.showMessageDialog(
                            null, "Nenhum registro encontrado."
                        );
                    }

                }
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void rdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbIdActionPerformed

    private void rdbEspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEspecActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rdbEspecActionPerformed

    private void cbxEspecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEspecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecMouseClicked

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
            FormCadastroMedico f = new FormCadastroMedico(id);
            this.getDesktopPane().add(f);
            f.setVisible(true);

            //Fechar o FormPesquisa
            this.dispose();
        }
    }//GEN-LAST:event_tabResultadoMouseClicked

    private void cbxEspecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEspecItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecItemStateChanged

    private void cbxEspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecActionPerformed
        // TODO add your handling code here:
        // PESQUISAR POR ESPECIALIDADE
        if(rdbEspec.isSelected()){
            configurarTabela();
            Especialidade e = (Especialidade)cbxEspec.getSelectedItem();

            List<Medico> lista = new MedicoDAO().pesquisarPorEspecialidade(e.getId());
            if (lista.size() > 0) {
                DefaultTableModel m = (DefaultTableModel) tabResultado.getModel();
                for (Medico medico : lista) {
                    m.addRow(new Object[]{
                        medico.getId(),
                        medico.getNome(),
                        medico.getId_especialidade(),
                        medico.getNro_crm(),
                        medico.isFg_ativo(),
                        medico.getTelefone(),
                        medico.getEmail()
                    });
                }
                tabResultado.setModel(m);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Nenhum registro encontrado."
                );
            } 
        }
    }//GEN-LAST:event_cbxEspecActionPerformed

    private void btnIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdActionPerformed
        // TODO add your handling code here:
        configurarTabela();
        List<Medico> lista = new MedicoDAO().listarPorId();
        if (lista.size() > 0) {
            DefaultTableModel mTab = (DefaultTableModel) tabResultado.getModel();
            for (Medico medico : lista) {
                mTab.addRow(new Object[]{
                    medico.getId(),
                    medico.getNome(),
                    medico.getId_especialidade(),
                    medico.getNro_crm(),
                    medico.isFg_ativo(),
                    medico.getTelefone(),
                    medico.getEmail()
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
    private javax.swing.JComboBox<String> cbxEspec;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListarPor;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JRadioButton rdbEspec;
    private javax.swing.JRadioButton rdbId;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JTable tabResultado;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}