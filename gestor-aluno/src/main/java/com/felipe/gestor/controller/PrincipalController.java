/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.dao.AlunoDAO;
import com.felipe.gestor.dao.CursoDAO;
import com.felipe.gestor.view.TelaAluno;
import com.felipe.gestor.view.TelaCurso;
import com.felipe.gestor.view.TelaPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author felipe
 */
public class PrincipalController {

    private final TelaPrincipal view;

    public PrincipalController(TelaPrincipal view) {
        this.view = view;
    }

    public void telaAluno() {
        
        TelaAluno telaAluno = new TelaAluno();
        telaAluno.setVisible(true);
        telaAluno.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                contadores();
            }
        });
    }
    
    public void telaCurso() {
        
        TelaCurso telaCurso = new TelaCurso();
        telaCurso.setVisible(true);
        telaCurso.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                contadores();
            }
        });
    }

    public void contadores() {
        String countAluno = new AlunoDAO().countAluno() + "";
        view.getCountAlunos().setText(countAluno);
        
        String contAlunoSemCurso = new AlunoDAO().countAlunoSemCurso() + "";
        view.getCountAlunosOutCurso().setText(contAlunoSemCurso);
        
        String countCurso = new CursoDAO().countCurso() + "";
        view.getCountCursos().setText(countCurso);
        
        String contCursoSemAluno = new CursoDAO().countCursoSemAluno() + "";
        view.getCountCursosOutAluno().setText(contCursoSemAluno);
    }
}
