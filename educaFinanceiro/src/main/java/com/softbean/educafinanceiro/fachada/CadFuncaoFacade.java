/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.fachada;

import com.softbean.educafinanceiro.entidade.CadFuncao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class CadFuncaoFacade extends AbstractFacade<CadFuncao> {
    
    @PersistenceContext(unitName = "com.softbean_educaFinanceiro_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CadFuncaoFacade() {
        super(CadFuncao.class);
    }
    
    public List<Map<String, Object>> listarPesquisa(Integer cod, String desc, String sit) {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select funcao_id as codigo                                                                                                ");
        sql.append("        ,funcao_desc as descricao                                                                                          ");
        sql.append("        ,(select desc_detalhe from cad_detalhe where cod_valor_detalhe = funcao_sit and cod_item_detalhe = 'STMOV') as sit ");
        sql.append(" from cad_funcao where 1=1				                                    				       ");
        
        if (cod != null) {
            sql.append(" and funcao_id = ").append(cod);
        }
        if (desc != null) {
            sql.append(" and funcao_desc like'%").append(desc.toUpperCase()).append("%'");
        }        
        if (sit != null) {
            sql.append(" and funcao_sit = '").append(sit).append("'");
        }
        
        try {
            Query createQuery = em.createNativeQuery(sql.toString());
            resultArrays = createQuery.getResultList();
            resultMaps = new ArrayList<>();
            Map<String, Object> map;
            for (Object[] array : resultArrays) {
                map = new HashMap<>();
                map.put("codigo", array[0]);
                map.put("descricao", array[1]);                
                map.put("sit", array[2]);
                resultMaps.add(map);
            }
        } catch (Exception e) {
            System.out.println("ERRO no método listarPesquisa " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }
    
}
