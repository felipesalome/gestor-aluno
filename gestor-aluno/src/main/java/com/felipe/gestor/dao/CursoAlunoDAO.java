/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import com.felipe.gestor.model.CursoAluno;
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
public class CursoAlunoDAO implements DataAccessObject<CursoAluno>{

    @Override
    public boolean salvar(CursoAluno entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO curso_aluno (codigo_aluno, codigo_curso) VALUES (?, ?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, entidade.getCodigoAluno());
            pstm.setInt(2, entidade.getCodigoCurso());
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
    public boolean editar(CursoAluno entidade) {
        Connection conn = Conexao.open();
        boolean salvou = false;
        PreparedStatement pstm = null;
        String sql =
                "UPDATE curso_aluno SET codigo_aluno = ?, codigo_curso = ? " +
                "WHERE codigo = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, entidade.getCodigoAluno());
            pstm.setInt(2, entidade.getCodigoCurso());
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
    public boolean apagar(CursoAluno entidade) {
        Connection conn = Conexao.open();
        boolean apagou = false;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM curso_aluno WHERE codigo = ?";
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
        String sql = "SELECT * FROM curso_aluno";
        List cursoAlunoList = new ArrayList();
        CursoAluno cursoAluno = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cursoAluno = new CursoAluno();
                cursoAluno.setCodigo(rs.getInt("codigo"));
                cursoAluno.setCodigoAluno(rs.getInt("codigo_aluno"));
                cursoAluno.setCodigoCurso(rs.getInt("codigo_curso"));
                cursoAlunoList.add(cursoAluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conn, pstm, rs);
        }
        return cursoAlunoList;
    }

    @Override
    public int buscarCodigo() {
        Connection conn = Conexao.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(codigo) FROM curso_aluno";
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
    
}
