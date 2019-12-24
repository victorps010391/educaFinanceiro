/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.controle;

import com.softbean.educafinanceiro.entidade.CadFuncao;
import com.softbean.educafinanceiro.fachada.CadFuncaoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author admin
 */
@Named(value = "cadFuncaoControle")
@SessionScoped
public class CadFuncaoControle implements Serializable {

    /**
     * Creates a new instance of CadFuncaoControle
     */
    public CadFuncaoControle() {
    }

    @Inject
    CadFuncaoFacade funcaoFacade;

    public Boolean salvarFuncao(CadFuncao obj) {
        try {
            funcaoFacade.create(obj);
            return true;
        } catch (Exception e) {
            System.out.println("salvarFuncao (controle) " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
