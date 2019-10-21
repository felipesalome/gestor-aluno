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
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class CursoController {
    
    private final TelaCurso view;
    private final CursoHelper helper;

    public CursoController(TelaCurso view) {
        this.view = view;
        this.helper = new CursoHelper(view);
    }

    public void tabelaCurso() {
        // Pegar as informações no banco de dados
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.buscarTodos();
        
        // Preenche a tabela utilizando o helper
        helper.preencherTabela(cursos);
    }
    
    public void salvar() {
        // Verifica se existe conteudo para salvar
        if (helper.obterModelo().getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Favor preencher o campo descrição do formulario");
        } else {
            // Busca as informações da view e cria um objeto curso
            Curso curso = helper.obterModelo();

            // Salva o curso criado no banco de dados e pega o id
            new CursoDAO().salvar(curso);
            int codigoCurso = new CursoDAO().buscarCodigo();

            // Se tiver preenchido o campo aluno cria um aluno novo e salva
            if (!curso.getAluno().getNome().isEmpty()) {

                // Salva o aluno criado no banco de dados e pega o id
                new AlunoDAO().salvar(curso.getAluno());
                int codigoAluno = new AlunoDAO().buscarCodigo();

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
        if (helper.obterModelo().getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Favor selecionar o curso correto");
        } else {
            // Busca o codigo do Curso na view
            int codigoExisteCurso = Integer.parseInt(view.getjTableCursos().getValueAt(view.getjTableCursos().getSelectedRow(), 0).toString());
            // Busca o curso com o codigo
            Curso existeCurso = new CursoDAO().buscarCurso(codigoExisteCurso);
            
            // Verifica se o curso existe
            if (!"".equals(existeCurso.toString())) {
                // Pega a informação da view e cria um objeto Curso
                Curso curso = helper.obterModelo();
                curso.setCodigo(codigoExisteCurso);
                
                // Salva o curso criado no banco de dados e pega o id
                new CursoDAO().editar(curso);
                int codigoCurso = new CursoDAO().buscarCodigo();
                
                // Se tiver preenchido o campo curso cria um aluno novo e salva
                if (! curso.getAluno().getNome().isEmpty()) {

                    // Salva o aluno criado no banco de dados e pega o id
                    new AlunoDAO().salvar(curso.getAluno());
                    int codigoAluno = new AlunoDAO().buscarCodigo();

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
        // Busca o codigo do Curso selecionado na view
        int codigoCurso = Integer.parseInt(view.getjTableCursos().getValueAt(view.getjTableCursos().getSelectedRow(), 0).toString());
        
        // Verifica se o codigo é valido
        if (codigoCurso != 0) {
            // Cria um objeto do tipo curso para apagar no banco
            Curso curso = new Curso();
            curso.setCodigo(codigoCurso);
            new CursoDAO().apagar(curso);
        }
    }
    
    public void selecionaLinha() {
        // Verifica se alguma linha da jTable foi selecionado    
        if (view.getjTableCursos().getSelectedRow() != -1) {
            // Busca o codigo do curso no jTableCursos da view
            int codCurso =
                    Integer.parseInt(view.getjTableCursos()
                    .getValueAt(view.getjTableCursos().getSelectedRow(), 0)
                    .toString());
            // Busca no banco o curso selecionado
            Curso curso = new CursoDAO().buscarCurso(codCurso);

            // Envia pra view os dados do banco
            helper.setarModelo(curso);
        }
    }
    
}
