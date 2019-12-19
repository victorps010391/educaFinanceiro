/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.fachada;

import com.softbean.educafinanceiro.entidade.CadFuncionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class CadFuncionarioFacade extends AbstractFacade<CadFuncionario> {

    @PersistenceContext(unitName = "com.softbean_educaFinanceiro_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadFuncionarioFacade() {
        super(CadFuncionario.class);
    }
    
}
