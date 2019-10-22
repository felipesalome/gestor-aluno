/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.Aluno;
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
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
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
     * Test of salvar method, of class AlunoDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Aluno entidade = new Aluno("Jose");
        AlunoDAO instance = new AlunoDAO();
        boolean expResult = true;
        boolean result = instance.salvar(entidade);
        assertEquals(expResult, result);
        int codigo = instance.buscarCodigo();
        Aluno aluno = instance.buscarAluno(codigo);
        instance.apagar(aluno);
    }

    /**
     * Test of editar method, of class AlunoDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        AlunoDAO instance = new AlunoDAO();
        instance.salvar(new Aluno("Jose"));
        int codigo = instance.buscarCodigo();
        Aluno entidade = instance.buscarAluno(codigo);
        Aluno aluno = new Aluno("Carlos");
        aluno.setCodigo(entidade.getCodigo());
        boolean expResult = true;
        boolean result = instance.editar(entidade);
        assertEquals(expResult, result);
        instance.apagar(aluno);
    }

    /**
     * Test of apagar method, of class AlunoDAO.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        AlunoDAO instance = new AlunoDAO();
        instance.salvar(new Aluno("Jose"));
        int codigo = instance.buscarCodigo();
        Aluno entidade = instance.buscarAluno(codigo);
        boolean expResult = true;
        boolean result = instance.apagar(entidade);
        assertEquals(expResult, result);
    }

    /**
     * Test of countAluno method, of class AlunoDAO.
     */
    @Test
    public void testCountAluno() {
        System.out.println("countAluno");
        AlunoDAO instance = new AlunoDAO();
        instance.salvar(new Aluno("Jose"));
        int expResult = 1;
        int result = instance.countAluno();
        assertEquals(expResult, result);
        int codigo = instance.buscarCodigo();
        Aluno entidade = instance.buscarAluno(codigo);
        instance.apagar(entidade);
    }

    /**
     * Test of countAlunoSemCurso method, of class AlunoDAO.
     */
    @Test
    public void testCountAlunoSemCurso() {
        System.out.println("countAlunoSemCurso");
        AlunoDAO instance = new AlunoDAO();
        instance.salvar(new Aluno("Jose"));
        int expResult = 1;
        int result = instance.countAlunoSemCurso();
        assertEquals(expResult, result);
        int codigo = instance.buscarCodigo();
        Aluno entidade = instance.buscarAluno(codigo);
        instance.apagar(entidade);
    }
    
}
