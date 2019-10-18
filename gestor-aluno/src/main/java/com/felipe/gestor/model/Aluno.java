/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Aluno {
    private int codigo;
    private String nome;
    
    private List curso = new ArrayList();
    
    public Aluno() {}
    
    public Aluno(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getCurso() {
        return curso;
    }

    public void setCurso(List curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" + " nome=" + nome + '}';
    }
    
}
