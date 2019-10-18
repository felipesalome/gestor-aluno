/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.Aluno;
import com.felipe.gestor.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class AlunoDAO implements DataAccessObject<Aluno>{

    @Override
    public boolean salvar(Aluno entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO aluno (nome) VALUES (?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getNome());
            if (pstm.executeUpdate() == 1) {
                salvou = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, null);
        }
        return salvou;
    }

    @Override
    public boolean editar(Aluno entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql =
                "UPDATE aluno SET nome = ? " +
                "WHERE codigo = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getNome());
            pstm.setInt(2, entidade.getCodigo());
            if (pstm.executeUpdate() == 1) {
                salvou = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, null);
        }
        return salvou;
    }

    @Override
    public boolean apagar(Aluno entidade) {
        Connection conn = Conexao.open();
        boolean apagou = false;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM aluno WHERE codigo = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, entidade.getCodigo());
            if (pstm.executeUpdate() == 1) {
                apagou = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, null);
        }
        return apagou;
    }

    @Override
    public List buscarTodos() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM aluno";
        List alunoList = new ArrayList();
        Aluno aluno = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(listarCursoPorAluno(conn, aluno.getCodigo()));
                alunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return alunoList;
    }
    
    @Override
    public int buscarCodigo() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(codigo) FROM aluno";
        int codigo = 0;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return codigo;
    }
    
    private List listarCursoPorAluno(Connection conn, int codigo) {
        String sql =
                "SELECT c.* " +
                "FROM curso c, curso_aluno ca " +
                "WHERE ca.codigo_aluno = ? " +
                "AND ca.codigo_curso = c.codigo";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List cursoList = new ArrayList();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                cursoList.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(null, pstm, rs);
        }
        return cursoList;
    }
    
    public List buscarAluno(int codigo) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM aluno WHERE aluno.codigo = ?";
        List alunoList = new ArrayList();
        Aluno aluno = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                alunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return alunoList;
    }
    
    public List buscarAluno(String nome) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM aluno WHERE aluno.nome = ?";
        List alunoList = new ArrayList();
        Aluno aluno = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                alunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return alunoList;
    }
    
    public List buscarAlunoPorCurso(String curso) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql =
                "SELECT * " +
                "FROM aluno a, curso_aluno ca, curso c " +
                "WHERE c.descricao = ? " +
                "AND c.codigo = ca.codigo_curso" +
                "AND a.codigo = ca.codigo_aluno";
        List alunoList = new ArrayList();
        Aluno aluno = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, curso);
            rs = pstm.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                alunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return alunoList;
    }
    
}
