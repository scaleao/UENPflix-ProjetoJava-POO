/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.ClienteController;
import banco.FilmeController;
import filme.Filme;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static telas.TelaFuncionario.listaFilme;
import usuario.cliente.Cliente;
import usuario.cliente.HistoricoCliente;

/**
 *
 * @author jscal
 */
public class TelaCliente_ResultadoBusca extends javax.swing.JFrame {
    ArrayList<Filme> resultado = new ArrayList();
    private String codFuncSelecionado;
    private ClienteController cc = new ClienteController();
    private Cliente clienteAtual;
    private FilmeController fic = new FilmeController();
    /**
     * Creates new form TelaCliente_ResultadoBusca
     */
    public TelaCliente_ResultadoBusca() {
        initComponents();
    }
    
    public TelaCliente_ResultadoBusca(ArrayList<Filme> resultado, Cliente clienteAtual) {
        initComponents();
        this.resultado = resultado;
        this.clienteAtual = clienteAtual;
        btAssistir.setEnabled(false);
        btFavoritos.setEnabled(false);
    }
    
    public void criarTabela(){
    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("Genero");
    modelo.addColumn("Titulo");
    modelo.addColumn("Duracao");
    modelo.addColumn("Produtora");
    modelo.addColumn("Elenco");
    modelo.addColumn("Avaliação");
    
    
    
    for (Filme a : this.resultado) {
            modelo.addRow(new Object[]{
                a.getGenero(), a.getTitulo(), a.getDuracao(), a.getProdutora(),
                a.getElenco(), a.getPontuacao()
            });
        }
    
        this.tabelaResultado.setModel(modelo);
        this.tabelaResultado.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent e) {
        int linha = tabelaResultado.getSelectedRow();
                if (linha != -1) {
                    //rowDelete = linha;
                    codFuncSelecionado
                            = (String) tabelaResultado.getValueAt(linha, 1);
                    /*   A variavel codFuncSelecionado armazenao 
                     * o conteudo referente a coluna determina, 
                     * no caso a coluna determina é a 1, que é
                     * a coluna referente aos TITULOS dos filmes
                     */
                    btAssistir.setEnabled(true);
                    btFavoritos.setEnabled(true);
                } else {
                    btAssistir.setEnabled(false);
                    btFavoritos.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        labelUENPflix = new javax.swing.JLabel();
        labelResultado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultado = new javax.swing.JTable();
        btAssistir = new javax.swing.JButton();
        btFavoritos = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        labelUENPflix.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        labelUENPflix.setForeground(new java.awt.Color(255, 0, 0));
        labelUENPflix.setText("UENPflix");

        labelResultado.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelResultado.setForeground(new java.awt.Color(255, 0, 0));
        labelResultado.setText("Resultado da Busca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUENPflix))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelUENPflix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelResultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaResultado);

        btAssistir.setText("Assistir");
        btAssistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAssistirActionPerformed(evt);
            }
        });

        btFavoritos.setText("Add Favoritos");
        btFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFavoritosActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAssistir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFavoritos)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btAssistir)
                        .addComponent(btFavoritos)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.white);
        criarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAssistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAssistirActionPerformed
                HistoricoCliente historico = new HistoricoCliente();
        /*
        for (Filme f : listaFilme) {
            if (f.getTitulo().equals(codFuncSelecionado)) {
                filme = f;
            }
        }
        */
        int op = JOptionPane.showConfirmDialog(this, "Desejar assistir: \n" + codFuncSelecionado +
                "?");

        if (op == 0) {
            JOptionPane.showMessageDialog(null, "ASSISTINDO\n" + codFuncSelecionado);
            
            historico.setFilmeAssistidos(codFuncSelecionado);
            historico.setMovimentacao("Assistido");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String horario = String.valueOf(sdf.format(new Date()));
            historico.setHorario(horario);
            
            try {
                cc.addHist(this.clienteAtual.getLogin(), historico);
            } catch (SQLException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            TelaCliente_AvaliarFilme telaAvaliar = new TelaCliente_AvaliarFilme(codFuncSelecionado);
            telaAvaliar.setLocationRelativeTo(null);
            telaAvaliar.setVisible(true);
            
            btAssistir.setEnabled(false);
        }
        try {//adiciona um ao contador de vezes que o filme foi assistido
            fic.assistirFilme(codFuncSelecionado);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAssistirActionPerformed

    private void btFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFavoritosActionPerformed
        int op = JOptionPane.showConfirmDialog(this, codFuncSelecionado +
                "\n" + "Deseja adicionar aos favoritos?");

        if (op == 0) {
            try {
                cc.addFavorito(this.clienteAtual.getLogin(), codFuncSelecionado);
                JOptionPane.showMessageDialog(this, "Filme adicionado aos favoritos!");
            } catch (SQLException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            HistoricoCliente historico = new HistoricoCliente();
            historico.setFilmeAssistidos(codFuncSelecionado);
            historico.setMovimentacao("Inserido Favoritos");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String horario = String.valueOf(sdf.format(new Date()));
            historico.setHorario(horario);
            try {
                cc.addHist(this.clienteAtual.getLogin(), historico);
            } catch (SQLException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //listaHistorico.add(historico);
            
            btAssistir.setEnabled(false);
        }
    }//GEN-LAST:event_btFavoritosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente_ResultadoBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente_ResultadoBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente_ResultadoBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente_ResultadoBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente_ResultadoBusca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAssistir;
    private javax.swing.JButton btFavoritos;
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JLabel labelUENPflix;
    private javax.swing.JTable tabelaResultado;
    // End of variables declaration//GEN-END:variables
}
