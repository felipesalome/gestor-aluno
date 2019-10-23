/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller.helper;

import com.felipe.gestor.dao.AlunoDAO;
import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;
import com.felipe.gestor.view.TelaAluno;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class AlunoHelperTest {

    private TelaAluno telaAluno;
    
    public AlunoHelperTest() {
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
     * Test of limparSentenca method, of class AlunoHelper.
     */
    @Test
    public void sentenceShouldBeWithoutBrackets() {
        System.out.println("limparSentenca");
        String inicial = "{curso}";
        AlunoHelper instance = new AlunoHelper(telaAluno);
        String expResult = "curso";
        String result = instance.limparSentenca(inicial);
        assertEquals(expResult, result);
    }
    
    @Test
    public void itShouldBeAbleToCreateASentenceOfAListOfCourses() {
        System.out.println("criarLista");
        
        Aluno aluno = new Aluno();
        
        Curso curso1 = new Curso();
        Curso curso2 = new Curso();
        Curso curso3 = new Curso();


        List<Curso> cursoList = new ArrayList();
        
        AlunoHelper instance = new AlunoHelper(telaAluno);
        
        aluno.setCodigo(1);
        aluno.setNome("Jose");
        
        curso1.setCodigo(1);
        curso1.setDescricao("PHP");
        curso1.setEmenta("Alguma coisa");
        
        curso1.setAluno(aluno);
        
        curso2.setCodigo(2);
        curso2.setDescricao("JAVA");
        curso2.setEmenta("Alguma coisa");
        
        curso2.setAluno(aluno);
        
        curso3.setCodigo(3);
        curso3.setDescricao("HTML");
        curso3.setEmenta("Alguma coisa");
        
        curso3.setAluno(aluno);
        
        cursoList.add(curso1);
        cursoList.add(curso2);
        cursoList.add(curso3);
        
        aluno.setCurso(cursoList);
        
        List<Curso> cursos = aluno.getCurso();
        
//        cursos.forEach((curso) -> {
//            System.out.println(curso);
//        });
        
        String expResult = "PHP, JAVA, HTML";
        String result = instance.criarLista(cursos);
        
        assertEquals(expResult, result);
    }
    
}
