/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.FuncionarioController;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static telas.TelaLogin.listaUsuario;
import usuario.cliente.Cliente;
import usuario.Usuario;

/**
 *
 * @author jscal
 */
public class TelaFuncionario_TelaMenu_GerenciarCliente extends javax.swing.JFrame {
    String colunas[] = {"Nome", "Idade", "Endereco", "Login", "Senha"};
    private int rowDelete;
    private String codFuncSelecionado;
    private FuncionarioController fc = new FuncionarioController();

    /**
     * Creates new form TelaMenu_GerenciarCliente
     */
    public TelaFuncionario_TelaMenu_GerenciarCliente() {
        initComponents();
        try {
            listaUsuario = fc.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        btExcluir.setEnabled(false);
        btEditar.setEnabled(false);
    }
    
    public void criarTabela(){
    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("Nome");
    modelo.addColumn("Idade");
    modelo.addColumn("Endereco");
    modelo.addColumn("Login");
    modelo.addColumn("Senha");
    
    
    
    
    for (Usuario a : listaUsuario){
        if(a.getCliente()!=false){
            modelo.addRow(new Object[]{
                a.getNome(), a.getIdade(), a.getEndereco(), a.getLogin(), a.getSenha()
            });
        }
    }   
    
        tabelaCliente.setModel(modelo);
        tabelaCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent e) {
        int linha = tabelaCliente.getSelectedRow();
                if (linha != -1) {
                    rowDelete = linha;
                    codFuncSelecionado
                            = (String) tabelaCliente.getValueAt(linha, 3);
                    //= (String) tabelaCliente.getValueAt(linha, 0);
                    /*   A variavel codFuncSelecionado armazenao 
                     * o conteudo referente a coluna determina, 
                     * no caso a coluna determina é a 0, que é
                     * a coluna referente aos NOME do Usuario Cliente
                     */
                    btExcluir.setEnabled(true);
                    btEditar.setEnabled(true);
                } else {
                    btExcluir.setEnabled(false);
                    btEditar.setEnabled(false);
                }
        }    
        });
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
        tabelaCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelGerenciarClientes = new javax.swing.JLabel();
        labelGerenCliente = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaCliente);

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        labelGerenciarClientes.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        labelGerenciarClientes.setForeground(new java.awt.Color(255, 0, 0));
        labelGerenciarClientes.setText("UENPflix");

        labelGerenCliente.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelGerenCliente.setForeground(new java.awt.Color(255, 0, 0));
        labelGerenCliente.setText("Gerenciador de Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(labelGerenciarClientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(labelGerenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGerenciarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelGerenCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel1)))
                .addGap(14, 14, 14))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        /*
        Cliente cliente = null;
        for (Usuario c : listaUsuario) {
            if (c.getNome().equals(codFuncSelecionado)) {
                cliente = (Cliente) c;
            }
        }
        */
        int op = JOptionPane.showConfirmDialog(this,
                "Deseja excluir o: " + codFuncSelecionado + " ?");

        if (op == 0) {
            try {
                fc.excluir(codFuncSelecionado);
            } catch (SQLException ex) {
                Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //listaUsuario.remove(cliente);
            btExcluir.setEnabled(false);
        }
        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.white);
        criarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        Cliente cliente = null;
        for (Usuario a : listaUsuario) {
            if(a.getCliente()==true){
                if (a.getLogin().equals(codFuncSelecionado)) {
                    cliente = (Cliente) a;
                }
            }
        }
        TelaFuncionario_TelaMenu_GerenciarCliente_Editar telaEditarCliente = new TelaFuncionario_TelaMenu_GerenciarCliente_Editar(cliente);
        telaEditarCliente.setLocationRelativeTo(null);
        telaEditarCliente.setVisible(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        try {
            listaUsuario = fc.listarTodos();
            JOptionPane.showMessageDialog(this, "Lista de clientes atualizada!");
        } catch (SQLException ex) {
            Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario_TelaMenu_GerenciarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario_TelaMenu_GerenciarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGerenCliente;
    private javax.swing.JLabel labelGerenciarClientes;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables
}
