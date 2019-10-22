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
import com.felipe.gestor.model.CursoAluno;
import com.felipe.gestor.view.TelaAluno;
import com.felipe.gestor.view.TelaPrincipal;
import java.util.List;
import javax.swing.JOptionPane;

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
        // Verifica se existe conteudo para salvar
        if (helper.obterModelo().getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher o campo nome do formulario");
        } else {
            // Busca a informação da view e cria um objeto Aluno
            Aluno aluno = helper.obterModelo();

            // Salva o aluno criado no banco de dados e pega o id
            new AlunoDAO().salvar(aluno);
            int codigoAluno = new AlunoDAO().buscarCodigo();

            // Se tiver preenchido o campo curso cria um curso novo e salva
            if (aluno.getCurso() != null) {

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
    }
    
    public void editar() {
        // Verifica se existe conteudo para salvar
        if (helper.obterModelo().getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor selecionar o aluno correto");
        } else {
            // Busca o codigo do Aluno na view
            int codigoExisteAluno = Integer.parseInt(view.getjTableAlunos().getValueAt(view.getjTableAlunos().getSelectedRow(), 0).toString());
            // Busca o aluno com o codigo
            Aluno existeAluno = new AlunoDAO().buscarAluno(codigoExisteAluno);
            
            // Verifica se o aluno existe
            if (!"".equals(existeAluno.toString())) {
                // Pega a informação da view e cria um objeto Aluno
                Aluno aluno = helper.obterModelo();
                aluno.setCodigo(codigoExisteAluno);
                
                // Salva o aluno criado no banco de dados e pega o id
                new AlunoDAO().editar(aluno);
                int codigoAluno = new AlunoDAO().buscarCodigo();
                
                // Se tiver preenchido o campo curso cria um curso novo e salva
                if (aluno.getCurso() != null) {

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
        }
    }
    
    public void apagar() {
        // Busca o codigo do Aluno selecionado na view
        int codigoAluno = Integer.parseInt(view.getjTableAlunos().getValueAt(view.getjTableAlunos().getSelectedRow(), 0).toString());
        
        // Verifica se o codigo é valido
        if (codigoAluno != 0) {
            // Cria um objeto do tipo aluno para apagar no banco
            Aluno aluno = new Aluno();
            aluno.setCodigo(codigoAluno);
            new AlunoDAO().apagar(aluno);
        }
    }

    public void selecionaLinha() {
        // Verifica se alguma linha da jTable foi selecionado    
        if (view.getjTableAlunos().getSelectedRow() != -1) {
            // Busca o codigo do aluno no jTableAlunos da view
            int codAluno =
                    Integer.parseInt(view.getjTableAlunos()
                    .getValueAt(view.getjTableAlunos().getSelectedRow(), 0)
                    .toString());
            // Busca no banco o aluno selecionado
            Aluno aluno = new AlunoDAO().buscarAluno(codAluno);

            // Envia pra view os dados do banco
            helper.setarModelo(aluno);
        }
    }

    public void atualizaPrincipal() {
        new TelaPrincipal().iniciar();
    }
}
