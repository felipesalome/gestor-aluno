/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller.helper;

import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.view.TelaAluno;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        alunos.forEach((aluno) -> {
            tableModel.addRow(new Object[]{
                aluno.getCodigo(),
                aluno.getNome(),
                criarLista(aluno.getCurso())
            });
        });
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
            List<Curso> cursoList = new ArrayList();
            cursoList.add(setCurso);
            aluno.setCurso(cursoList);
        }
        
        return aluno;
    }
    
    public void setarModelo(Aluno modelo) {
        String nome = modelo.getNome();
        String curso = limparSentenca(modelo.getCurso().toString());
        
        view.getjTextFieldAlunoNome().setText(nome);
        view.getjTextFieldCursoDescricao().setText(curso);
    } 
    
    public void limparTela() {
        view.getjTextFieldAlunoNome().setText("");
        view.getjTextFieldCursoDescricao().setText("");
    }
    
    public String limparSentenca(String inicial) {
        String resultadoFinal = "";
        
        // Regex para remover caracteres não alfanuméricos
        String regex = "([\\w])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(inicial);
        
        while (match.find()) {
            System.out.println(match.group());
            resultadoFinal = match.group();
        }
        
        // Retorna a sentena limpa
        return resultadoFinal;
    }

    public String criarLista(List<Curso> cursosAluno) {
        String cursos = "";
        
        for (Curso curso : cursosAluno) {
            if (cursos.trim().isEmpty()) {
                cursos = limparSentenca(curso.toString());
            } else {
                cursos = cursos + ", " + limparSentenca(curso.toString());
            }
        }
        
        return cursos;
    }
}
