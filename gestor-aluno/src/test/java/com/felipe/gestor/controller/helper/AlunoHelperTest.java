/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.controller.helper;

import com.felipe.gestor.view.TelaAluno;
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
    
}
