/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.dao.AlunoDAO;
import com.felipe.gestor.dao.CursoAlunoDAO;
import com.felipe.gestor.dao.CursoDAO;
import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.model.CursoAluno;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class CursoController implements ICursoController{
    
    private JTable jTableCursos;

    public CursoController() {}

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
    
    public void salvar(String descricao, String ementa, String nome) {
        if (!descricao.isEmpty()) {
            Curso curso = new Curso();
            curso.setDescricao(descricao);
            curso.setEmenta(ementa);
            new CursoDAO().salvar(curso);
            int codCurso = new CursoDAO().buscarCodigo();
            if (!nome.isEmpty()) {
                Aluno aluno = new Aluno(nome);
                new AlunoDAO().salvar(aluno);
                int codAluno = new AlunoDAO().buscarCodigo();
                CursoAluno cursoAluno = new CursoAluno();
                cursoAluno.setCodigoAluno(codAluno);
                cursoAluno.setCodigoCurso(codCurso);
                new CursoAlunoDAO().salvar(cursoAluno);
            }
        }
    }
    
    public void editar(int codigo, String descricao ,String ementa ,String nome) {
        if (!descricao.isEmpty()) {
            Curso curso = new Curso();
            curso.setCodigo(codigo);
            curso.setDescricao(descricao);
            curso.setEmenta(ementa);
            new CursoDAO().editar(curso);
            int codCurso = new CursoDAO().buscarCodigo();
            if (!nome.isEmpty()) {
                Aluno aluno = new Aluno(nome);
                new AlunoDAO().salvar(aluno);
                int codAluno = new AlunoDAO().buscarCodigo();
                CursoAluno cursoAluno = new CursoAluno();
                cursoAluno.setCodigoAluno(codAluno);
                cursoAluno.setCodigoCurso(codCurso);
                new CursoAlunoDAO().salvar(cursoAluno);
            }
        }
    }
    
    public void apagar(int codigo) {
        if (codigo != 0) {
            Curso curso = new Curso();
            curso.setCodigo(codigo);
            new CursoDAO().apagar(curso);
        }
    }
    
}
