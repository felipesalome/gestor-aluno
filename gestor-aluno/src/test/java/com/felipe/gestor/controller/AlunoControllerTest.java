/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller;

import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.view.TelaAluno;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author felipe
 */
public class AlunoControllerTest {
    
    private AlunoController ac;
    private TelaAluno telaAluno;
    
    public AlunoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of adicionarCurso method, of class AlunoController.
     */
    @Test
    public void itShouldBeAbleToAddCourseInAStudent() {
        System.out.println("itShouldBeAbleToAddCourseInAStudent");
        
        ac = new AlunoController(telaAluno);

        Aluno felipe = new Aluno("Felipe");
        felipe.setCodigo(1);
        
        Curso ingles = new Curso("Inglês", "Revisão Gramatical e sintática da Língua Inglesa.");
        ingles.setCodigo(1);
        
        Curso prog = new Curso("Programação", "Estrutura");
        prog.setCodigo(2);
        
        List<Curso> cursos = new ArrayList();
        cursos.add(ingles);
        cursos.add(prog);
        
        felipe.setCurso(cursos);
        
        List<Curso> cursosDoFelipe = felipe.getCurso();
        
        String listaAtualizada = ac.adicionarCurso(cursosDoFelipe);
        
        String expResult = "Inglês, Programação";
        String result = listaAtualizada;
        
        assertEquals(expResult, result);
    }
    
}
