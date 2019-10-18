/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.dao.CursoDAO;
import com.felipe.gestor.model.Curso;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class CursoController implements ICursoController{
    
    private JTable jTableCursos;

    public CursoController(JTable jTableCursos) {
        this.jTableCursos = jTableCursos;
    }

    @Override
    public void tabelaCurso() {
        if (jTableCursos != null) {
            DefaultTableModel modelo = (DefaultTableModel) jTableCursos.getModel();
            if (modelo.getRowCount() > 0) {
                modelo.setRowCount(0);
            }
            CursoDAO aluno = new CursoDAO();
            List<Curso> listAluno = aluno.buscarTodos();
            for (Curso a : listAluno) {
                Object[] linha = new Object[4];
                linha[0] = a.getCodigo();
                linha[1] = a.getDescricao();
                linha[2] = a.getEmenta();
                linha[3] = a.getAluno();
                modelo.addRow(linha);
            }
        }
    }
    
}
