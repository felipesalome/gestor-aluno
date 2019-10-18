/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.view;

import com.felipe.gestor.controller.CursoController;

/**
 *
 * @author felipe
 */
public class TelaCurso extends javax.swing.JFrame {

    /**
     * Creates new form TelaCurso
     */
    public TelaCurso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCursoConteudo = new javax.swing.JPanel();
        jPanelFormularioCurso = new javax.swing.JPanel();
        jLabelCursoDescricao = new javax.swing.JLabel();
        jTextFieldCursoDescricao = new javax.swing.JTextField();
        jLabelCursoEmenta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCursoEmenta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAlunoNome = new javax.swing.JTextField();
        jButtonCursoSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jButtonCursoEditar = new javax.swing.JButton();
        jButtonCursoApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("frameCurso"); // NOI18N
        setResizable(false);

        jPanelFormularioCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar curso"));

        jLabelCursoDescricao.setText("Descrição");

        jLabelCursoEmenta.setText("Ementa");

        jTextAreaCursoEmenta.setColumns(20);
        jTextAreaCursoEmenta.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCursoEmenta);

        jLabel1.setText("Aluno");

        jButtonCursoSalvar.setText("Salvar");

        javax.swing.GroupLayout jPanelFormularioCursoLayout = new javax.swing.GroupLayout(jPanelFormularioCurso);
        jPanelFormularioCurso.setLayout(jPanelFormularioCursoLayout);
        jPanelFormularioCursoLayout.setHorizontalGroup(
            jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCursoEmenta)
                    .addGroup(jPanelFormularioCursoLayout.createSequentialGroup()
                        .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCursoDescricao)
                            .addComponent(jTextFieldCursoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldAlunoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jButtonCursoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanelFormularioCursoLayout.setVerticalGroup(
            jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCursoDescricao)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCursoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormularioCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormularioCursoLayout.createSequentialGroup()
                        .addComponent(jLabelCursoEmenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCursoSalvar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "codigo", "descricao", "ementa", "aluno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableCursos);
        CursoController cController = new CursoController(jTableCursos);
        cController.tabelaCurso();

        jButtonCursoEditar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonCursoEditar.setText("Editar");

        jButtonCursoApagar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jButtonCursoApagar.setText("Apagar");

        javax.swing.GroupLayout jPanelCursoConteudoLayout = new javax.swing.GroupLayout(jPanelCursoConteudo);
        jPanelCursoConteudo.setLayout(jPanelCursoConteudoLayout);
        jPanelCursoConteudoLayout.setHorizontalGroup(
            jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCursoConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCursoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCursoApagar, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCursoConteudoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFormularioCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelCursoConteudoLayout.setVerticalGroup(
            jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCursoConteudoLayout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCursoConteudoLayout.createSequentialGroup()
                        .addComponent(jButtonCursoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCursoApagar)))
                .addContainerGap())
            .addGroup(jPanelCursoConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCursoConteudoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFormularioCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(357, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCursoConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCursoConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCursoApagar;
    private javax.swing.JButton jButtonCursoEditar;
    private javax.swing.JButton jButtonCursoSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCursoDescricao;
    private javax.swing.JLabel jLabelCursoEmenta;
    private javax.swing.JPanel jPanelCursoConteudo;
    private javax.swing.JPanel jPanelFormularioCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JTextArea jTextAreaCursoEmenta;
    private javax.swing.JTextField jTextFieldAlunoNome;
    private javax.swing.JTextField jTextFieldCursoDescricao;
    // End of variables declaration//GEN-END:variables
}