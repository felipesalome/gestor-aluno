/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.view.TelaAluno;
import com.felipe.gestor.view.TelaCurso;
import com.felipe.gestor.view.TelaPrincipal;

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
    }
    
    public void telaCurso() {
        TelaCurso telaCurso = new TelaCurso();
        telaCurso.setVisible(true);
    }
}
