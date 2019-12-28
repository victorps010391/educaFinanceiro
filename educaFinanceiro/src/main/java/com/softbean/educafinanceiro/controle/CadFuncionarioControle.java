/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.controle;

import com.softbean.educafinanceiro.entidade.CadFuncionario;
import com.softbean.educafinanceiro.fachada.CadFuncionarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author DELL
 */
@Named(value = "cadFuncionarioControle")
@SessionScoped
public class CadFuncionarioControle implements Serializable {

    /**
     * Creates a new instance of CadFuncionarioControle
     */
    public CadFuncionarioControle() {
    }

    @Inject
    CadFuncionarioFacade funcionarioFacade;

    public Boolean salvarFuncionario(CadFuncionario obj) {
        try {
            funcionarioFacade.create(obj);
            return true;
        } catch (Exception e) {
            System.out.println("salvarFuncionario (controle) " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Map<String, Object>> listarFuncao() {
        return funcionarioFacade.listarFuncao();
    }

    public List<Map<String, Object>> listarPesquisa(String cpf, String nome, Integer funcao) {
        return funcionarioFacade.listarPesquisa(cpf, nome, funcao);
    }

}
