/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.gestor.dao;

import java.util.List;

/**
 *
 * @author felipe
 * @param <T>
 */
public interface DataAccessObject<T> {

    boolean salvar(T entidade);
    boolean editar(T entidade);
    boolean apagar(T entidade);
    List<T> buscarTodos();
    int buscarCodigo();
}