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
    private int codigoAluno;
    private int codigoCurso;

    public CursoAluno() {}

    public CursoAluno(int codigoAluno, int codigoCurso) {
        this.codigoAluno = codigoAluno;
        this.codigoCurso = codigoCurso;
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
    public int getCodigoAluno() {
        return codigoAluno;
    }

    /**
     * @param codigoAluno the codigoAluno to set
     */
    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    /**
     * @return the codigoCurso
     */
    public int getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * @param codigoCurso the codigoCurso to set
     */
    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "CursoAluno{" + "codigo=" + codigo + ", codigoAluno=" + codigoAluno + ", codigoCurso=" + codigoCurso + '}';
    }
    
    
    
}
