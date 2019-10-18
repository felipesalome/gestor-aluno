/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

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
public class CursoDAO implements DataAccessObject<Curso> {

    @Override
    public boolean salvar(Curso entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO curso (descricao, ementa) VALUES (?, ?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getDescricao());
            pstm.setString(2, entidade.getEmenta());
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
    public boolean editar(Curso entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql =
                "UPDATE curso SET descricao = ?, ementa = ? " +
                "WHERE codigo = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entidade.getDescricao());
            pstm.setString(2, entidade.getEmenta());
            pstm.setInt(3, entidade.getCodigo());
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
    public boolean apagar(Curso entidade) {
        Connection conn = Conexao.open();
        boolean apagou = false;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM curso WHERE codigo = ?";
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
        String sql = "SELECT * FROM curso";
        List cursoList = new ArrayList();
        Curso curso = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                cursoList.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return cursoList;
    }
    
    public List buscarCurso(int codigo) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM curso WHERE codigo = ?";
        List cursoList = new ArrayList();
        Curso curso = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                cursoList.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return cursoList;
    }
    
    public List buscarCurso(String busca) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql =
                "SELECT * FROM curso " +
                "WHERE descricao LIKE ? "+
                "OR ementa LIKE ?";
        List cursoList = new ArrayList();
        Curso curso = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, '%' + busca + '%');
            pstm.setString(2, '%' + busca + '%');
            rs = pstm.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                cursoList.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return cursoList;
    }
    
    public List buscarCursoPorAluno(String nome) {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql =
                "SELECT * " +
                "FROM aluno a, curso_aluno ca, curso c " +
                "WHERE a.nome = ? " +
                "AND c.codigo = ca.codigo_curso" +
                "AND a.codigo = ca.codigo_aluno";
        List cursoList = new ArrayList();
        Curso curso = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                cursoList.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return cursoList;
    }
    
}
