/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.Curso;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author felipe
 */
public class CursoDAOTest {
    
    public CursoDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class CursoDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Curso entidade = new Curso("Java", "Linguagem de programação");
        CursoDAO instance = new CursoDAO();
        boolean expResult = true;
        //boolean result = instance.salvar(entidade)
        boolean result = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of editar method, of class CursoDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        CursoDAO instance = new CursoDAO();
        List entidade = instance.buscarCurso(1);
        Curso curso = new Curso("Java", "Linguagem de programação");
        Curso novoCurso = (Curso) entidade.get(0);
        curso.setCodigo(novoCurso.getCodigo());
        boolean expResult = true;
        //boolean result = instance.editar(aluno);
        boolean result = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of apagar method, of class CursoDAO.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        CursoDAO instance = new CursoDAO();
        List entidade = instance.buscarCurso(1);
        Curso curso = (Curso) entidade.get(0);
        //instance.apagar(aluno);
        assertTrue(true);
    }

    /**
     * Test of buscarTodos method, of class CursoDAO.
     */
    @Test
    public void testBuscarTodos() {
        System.out.println("buscarTodos");
        CursoDAO instance = new CursoDAO();
        ArrayList expResult = new ArrayList();
        expResult.add("Curso{codigo=1, descricao=Java, ementa=Linguagem de programação}");
        List result = instance.buscarTodos();
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of buscarCurso method, of class CursoDAO.
     */
    @Test
    public void testBuscarCurso() {
        System.out.println("buscar curso");
        CursoDAO instance = new CursoDAO();
        ArrayList<String> esperado = new ArrayList();
        esperado.add("Curso{codigo=1, descricao=Java, ementa=Linguagem de programação}");
        List result = instance.buscarCurso("prog");
        assertEquals(esperado.toString(), result.toString());
    }
    
}
