/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.controle;

import com.softbean.educafinanceiro.entidade.CadMovimentacao;
import com.softbean.educafinanceiro.fachada.CadMovimentacaoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author admin
 */
@Named(value = "cadMovimentacaoControle")
@SessionScoped
public class CadMovimentacaoControle implements Serializable {

    /**
     * Creates a new instance of CadMovimentacaoControle
     */
    public CadMovimentacaoControle() {
    }

    @Inject
    CadMovimentacaoFacade movimentacaoFacade;

    public List<Map<String, Object>> ListaSitMovimentacao() {
        return movimentacaoFacade.listarSitMov();
    }

    public List<Map<String, Object>> listarTipMov() {
        return movimentacaoFacade.listarTipMov();
    }

    public List<Map<String, Object>> listarPesquisa(Integer cod, String desc, String tip, String sit) {
        return movimentacaoFacade.listarPesquisa(cod, desc, tip, sit);
    }

    public Boolean salvarMovimento(CadMovimentacao obj) {
        try {
            movimentacaoFacade.create(obj);
            return true;
        } catch (Exception e) {
            System.out.println("salvarMovimento (controle) " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Boolean alterarMovimento(CadMovimentacao obj) {
        try {
            movimentacaoFacade.edit(obj);
            return true;
        } catch (Exception e) {
            System.out.println("alterarMovimento (controle) " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public CadMovimentacao buscarMovimento(Integer cod) {
        try {
            return movimentacaoFacade.find(cod);
        } catch (Exception e) {
            System.out.println("buscarMovimento (controle) " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
