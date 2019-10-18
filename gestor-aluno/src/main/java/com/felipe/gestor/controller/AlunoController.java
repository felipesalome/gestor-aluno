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
public class AlunoController implements IAlunoController{
    
    private JTable jTableAlunos;
    
    public AlunoController() {}

    public AlunoController(JTable jTableAlunos) {
        this.jTableAlunos = jTableAlunos;
    }

    @Override
    public void tabelaAluno() {
        if (jTableAlunos != null) {
            DefaultTableModel modelo = (DefaultTableModel) jTableAlunos.getModel();
            if (modelo.getRowCount() > 0) {
                modelo.setRowCount(0);
            }
            AlunoDAO aluno = new AlunoDAO();
            List<Aluno> listAluno = aluno.buscarTodos();
            for (Aluno a : listAluno) {
                Object[] linha = new Object[3];
                linha[0] = a.getCodigo();
                linha[1] = a.getNome();
                linha[2] = a.getCurso();
                modelo.addRow(linha);
            }
        }
    }
    
    public void salvar(String nome, String descricao) {
        if (!nome.isEmpty()) {
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            new AlunoDAO().salvar(aluno);
            int codAluno = new AlunoDAO().buscarCodigo();
            if (!descricao.isEmpty()) {
                Curso curso = new Curso();
                curso.setDescricao(descricao);
                new CursoDAO().salvar(curso);
                int codCurso = new CursoDAO().buscarCodigo();
                CursoAluno cursoAluno = new CursoAluno();
                cursoAluno.setCodigoAluno(codAluno);
                cursoAluno.setCodigoCurso(codCurso);
                new CursoAlunoDAO().salvar(cursoAluno);
            }
        }
    }
    
    public void editar(int codigo, String nome, String descricao) {
        if (!nome.isEmpty()) {
            Aluno aluno = new Aluno();
            aluno.setCodigo(codigo);
            aluno.setNome(nome);
            new AlunoDAO().editar(aluno);
            int codAluno = new AlunoDAO().buscarCodigo();
            if (!descricao.isEmpty()) {
                Curso curso = new Curso();
                curso.setDescricao(descricao);
                new CursoDAO().salvar(curso);
                int codCurso = new CursoDAO().buscarCodigo();
                CursoAluno cursoAluno = new CursoAluno();
                cursoAluno.setCodigoAluno(codAluno);
                cursoAluno.setCodigoCurso(codCurso);
                new CursoAlunoDAO().salvar(cursoAluno);
            }
        }
    }
    
    public void apagar(int codigo) {
        if (codigo != 0) {
            Aluno aluno = new Aluno();
            aluno.setCodigo(codigo);
            new AlunoDAO().apagar(aluno);
        }
    }
}
