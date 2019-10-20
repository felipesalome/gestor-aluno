/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller.helper;

import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.view.TelaAluno;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class AlunoHelper {
    private final TelaAluno view;
    
    public AlunoHelper(TelaAluno view) {
        this.view = view;
    }
    
    // Preenche o jTable da view TelaAluno com os valores armazenados no banco
    public void preencherTabela(List<Aluno> alunos) {
        // Pega o modelo da tabela na view e limpa pra receber novos elementos
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableAlunos().getModel();
        tableModel.setNumRows(0);
        
        // Percorre pela lista carregando a tabela linha por linha
        for (Aluno aluno : alunos) {
            tableModel.addRow(new Object[]{
                aluno.getCodigo(),
                aluno.getNome(),
                aluno.getCurso()
            });
        }
    }
    
    public Aluno obterModelo() {
        // Armazenando o conteudo digitado na view TelaAluno
        String nome = view.getjTextFieldAlunoNome().getText();
        String curso = view.getjTextFieldCursoDescricao().getText();
        
        Aluno aluno = new Aluno(nome);
        
        // Verifica se curso foi preenchido para alimentar a tabela relacional
        // adicionando um novo curso
        if (! curso.isEmpty()) {
            Curso setCurso = new Curso(curso);
            aluno.setCurso(setCurso);
        }
        
        return aluno;
    }
    
    public void setarModelo(Aluno modelo) {
        String nome = modelo.getNome();
        String curso = modelo.getCurso().toString();
        
        view.getjTextFieldAlunoNome().setText(nome);
        view.getjTextFieldCursoDescricao().setText(curso);
    } 
    
    public void limparTela() {
        view.getjTextFieldAlunoNome().setText("");
        view.getjTextFieldCursoDescricao().setText("");
    }
}
