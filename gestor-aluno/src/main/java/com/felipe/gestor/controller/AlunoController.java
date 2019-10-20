/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.controller.helper.AlunoHelper;
import com.felipe.gestor.dao.AlunoDAO;
import com.felipe.gestor.dao.CursoAlunoDAO;
import com.felipe.gestor.dao.CursoDAO;
import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.model.CursoAluno;
import com.felipe.gestor.view.TelaAluno;
import java.util.List;

/**
 *
 * @author felipe
 */
public class AlunoController {
    
    private final TelaAluno view;
    private final AlunoHelper helper;
    
    public AlunoController(TelaAluno view) {
        this.view = view;
        this.helper = new AlunoHelper(view);
    }

    public void tabelaAluno() {
        // Pegar as informações no banco de dados
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.buscarTodos();
        
        // Preenche a tabela utilizando o helper
        helper.preencherTabela(alunos);
    }
    
    public void salvar() {
        // Busca a informação da view e cria um objeto Aluno
        Aluno aluno = helper.obterModelo();
        
        // Salva o aluno criado no banco de dados e pega o id
        new AlunoDAO().salvar(aluno);
        int codigoAluno = new AlunoDAO().buscarCodigo();
        
        // Se tiver preenchido o campo curso cria um curso novo e salva
        if (! aluno.getCurso().getDescricao().isEmpty()) {
            
            // Salva o curso criado no banco de dados e pega o id
            new CursoDAO().salvar(aluno.getCurso());
            int codigoCurso = new CursoDAO().buscarCodigo();
            
            // Salva o relacionamento
            CursoAluno ca = new CursoAluno(codigoAluno, codigoCurso);
            new CursoAlunoDAO().salvar(ca);
        }
        
        // Limpa os campos digitados
        helper.limparTela();
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
