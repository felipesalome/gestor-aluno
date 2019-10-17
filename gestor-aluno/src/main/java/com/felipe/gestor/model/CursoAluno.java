/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.model;

/**
 *
 * @author felipe
 */
public class CursoAluno {
    private int codigo;
    private int codigo_aluno;
    private int codigo_curso;

    public CursoAluno() {}

    public CursoAluno(int codigo_aluno, int codigo_curso) {
        this.codigo_aluno = codigo_aluno;
        this.codigo_curso = codigo_curso;
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
     * @return the codigo_aluno
     */
    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    /**
     * @param codigo_aluno the codigo_aluno to set
     */
    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    /**
     * @return the codigo_curso
     */
    public int getCodigo_curso() {
        return codigo_curso;
    }

    /**
     * @param codigo_curso the codigo_curso to set
     */
    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    @Override
    public String toString() {
        return "CursoAluno{" + "codigo=" + codigo + ", codigo_aluno=" + codigo_aluno + ", codigo_curso=" + codigo_curso + '}';
    }
    
    
    
}
