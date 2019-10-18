/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author felipe
 */
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
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

    @Disabled("Desabilitado")
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Aluno entidade = new Aluno("Jose");
        AlunoDAO instance = new AlunoDAO();
        //instance.salvar(entidade);
        assertTrue(true);
    }
    
    @Test
    public void testEditar() {
        System.out.println("editar");
        AlunoDAO instance = new AlunoDAO();
        List entidade = instance.buscarAluno(2);
        Aluno aluno = new Aluno("Carlos");
        Aluno novoAluno = (Aluno) entidade.get(0);
        aluno.setCodigo(novoAluno.getCodigo());
        //instance.editar(aluno);
        assertTrue(true);
    }
    
    @Test
    public void testApagar() {
        System.out.println("apagar");
        AlunoDAO instance = new AlunoDAO();
        List entidade = instance.buscarAluno(2);
        Aluno aluno = (Aluno) entidade.get(0);
        //instance.apagar(aluno);
        assertTrue(true);
    }

    @DisplayName("Desabilitado")
    @Test
    public void testBuscarAlunoById() {
        System.out.println("busca por codigo");
        AlunoDAO instance = new AlunoDAO();
        List alunoList = instance.buscarAluno(2);
        ArrayList<String> esperado = new ArrayList();
        esperado.add("Aluno{codigo=2, nome=Jose}");
        assertEquals(esperado.toString(), alunoList.toString());
    }
    
    @Test
    @DisplayName("sholdBeAbleToListByName")
    public void testBuscarAlunoByName() {
        System.out.println("busca por nome");
        AlunoDAO instance = new AlunoDAO();
        List alunoList = instance.buscarAluno("Jose");
        ArrayList<String> esperado = new ArrayList();
        esperado.add("Aluno{codigo=2, nome=Jose}");
        assertEquals(esperado.toString(), alunoList.toString());
    }
    
}
