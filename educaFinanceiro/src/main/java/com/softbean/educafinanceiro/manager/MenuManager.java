/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.manager;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author admin
 */
@Named(value = "menuManager")
@SessionScoped
public class MenuManager implements Serializable {

    /**
     * Creates a new instance of MenuManager
     */
    public MenuManager() {
    }

    public String menuCadMovimentacao() {
        return "/educaFinanceiro/sistema/cadMovimentacao.xhtml";
    }

    public String menuHome() {
        return "/educaFinanceiro/sistema/home.xhtml";
    }

}
