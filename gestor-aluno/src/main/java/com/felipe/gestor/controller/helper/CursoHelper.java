/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller.helper;

import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.view.TelaCurso;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class CursoHelper {
    
    private final TelaCurso view;
    
    public CursoHelper(TelaCurso view) {
        this.view = view;
    }

    public void preencherTabela(List<Curso> cursos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableCursos().getModel();
        tableModel.setNumRows(0);
        
        for (Curso curso : cursos) {
            tableModel.addRow(new Object[]{
                curso.getCodigo(),
                curso.getDescricao(),
                curso.getEmenta(),
                curso.getAluno()
            });
        }
    }
    
    public Curso obterModelo() {
        String descricao = view.getjTextFieldCursoDescricao().getText();
        String ementa = view.getjTextAreaCursoEmenta().getText();
        String aluno = view.getjTextFieldAlunoNome().getText();
                
        Curso curso = new Curso(descricao, ementa);
        
        if (! aluno.isEmpty()) {
            Aluno setAluno = new Aluno(aluno);
            curso.setAluno(setAluno);
        }
        
        return curso;
    }
    
    public void setarModelo(Curso modelo) {
        String descricao = modelo.getDescricao();
        String ementa = modelo.getEmenta();
        String aluno = modelo.getAluno().toString();
        
        view.getjTextFieldCursoDescricao().setText(descricao);
        view.getjTextAreaCursoEmenta().setText(ementa);
        view.getjTextFieldAlunoNome().setText(aluno);
    }
    
    public void limparTela() {
        view.getjTextFieldCursoDescricao().setText("");
        view.getjTextAreaCursoEmenta().setText("");
        view.getjTextFieldAlunoNome().setText("");
    }
}
