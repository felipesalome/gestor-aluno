/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.Curso;
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
public class CursoDAOTest {
    
    public CursoDAOTest() {
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
     * Test of salvar method, of class CursoDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Curso entidade = new Curso("POO", "Objetos, Classes, Atributos e Métodos");
        CursoDAO instance = new CursoDAO();
        boolean expResult = true;
        boolean result = instance.salvar(entidade);
        assertEquals(expResult, result);
        int codigo = instance.buscarCodigo();
        Curso curso = instance.buscarCurso(codigo);
        instance.apagar(curso);
    }

    /**
     * Test of editar method, of class CursoDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        CursoDAO instance = new CursoDAO();
        instance.salvar(new Curso("POO", "Objetos, Classes, Atributos e Métodos"));
        int codigo = instance.buscarCodigo();
        Curso entidade = instance.buscarCurso(codigo);
        Curso curso = new Curso("Java POO", "Objetos, Classes, Atributos e Métodos");
        curso.setCodigo(entidade.getCodigo());
        boolean expResult = true;
        boolean result = instance.editar(entidade);
        assertEquals(expResult, result);
        instance.apagar(entidade);
    }

    /**
     * Test of apagar method, of class CursoDAO.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        CursoDAO instance = new CursoDAO();
        instance.salvar(new Curso("POO", "Obj, class, attr, method"));
        int codigo = instance.buscarCodigo();
        Curso entidade = instance.buscarCurso(codigo);
        boolean expResult = true;
        boolean result = instance.apagar(entidade);
        assertEquals(expResult, result);
    }

    /**
     * Test of countCurso method, of class CursoDAO.
     */
    @Test
    public void testCountCurso() {
        System.out.println("countCurso");
        
        CursoDAO instance = new CursoDAO();
        instance.salvar(new Curso("Java", "Obj, class, attr, method"));
        
        int expResult = 1;
        int result = instance.countCurso();
        
        int codigo = instance.buscarCodigo();
        Curso curso = instance.buscarCurso(codigo);
        instance.apagar(curso);
        assertEquals(expResult, result);
    }

    /**
     * Test of countCursoSemAluno method, of class CursoDAO.
     */
    @Test
    public void testCountCursoSemAluno() {
        System.out.println("countCursoSemAluno");
        CursoDAO instance = new CursoDAO();
        instance.salvar(new Curso("Java", "Obj, class, attr, method"));
        int expResult = 1;
        int result = instance.countCursoSemAluno();
        assertEquals(expResult, result);
        int codigo = instance.buscarCodigo();
        Curso entidade = instance.buscarCurso(codigo);
        instance.apagar(entidade);
    }
    
}
