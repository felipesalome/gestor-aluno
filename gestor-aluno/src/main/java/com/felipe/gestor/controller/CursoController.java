/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.controller.helper.CursoHelper;
import com.felipe.gestor.dao.AlunoDAO;
import com.felipe.gestor.dao.CursoAlunoDAO;
import com.felipe.gestor.dao.CursoDAO;
import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.model.CursoAluno;
import com.felipe.gestor.view.TelaCurso;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class CursoController {
    
    private JTable jTableCursos;
    private final TelaCurso view;
    private final CursoHelper helper;

    public CursoController(TelaCurso view) {
        this.view = view;
        this.helper = new CursoHelper(view);
    }

    public void tabelaCurso() {
        
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.buscarTodos();
        
        helper.preencherTabela(cursos);
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
