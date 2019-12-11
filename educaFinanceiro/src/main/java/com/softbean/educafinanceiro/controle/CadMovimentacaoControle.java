/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.controle;

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
}
