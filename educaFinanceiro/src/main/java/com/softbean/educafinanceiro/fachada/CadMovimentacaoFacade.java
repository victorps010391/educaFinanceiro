/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.fachada;

import com.softbean.educafinanceiro.entidade.CadMovimentacao;
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
public class CadMovimentacaoFacade extends AbstractFacade<CadMovimentacao> {

    @PersistenceContext(unitName = "com.softbean_educaFinanceiro_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadMovimentacaoFacade() {
        super(CadMovimentacao.class);
    }

    public List<Map<String, Object>> listarSitMov() {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select cod_valor_detalhe as codigo      ");
        sql.append("        ,desc_detalhe as nome     ");
        sql.append(" from cad_detalhe                 ");
        sql.append(" where cod_item_detalhe = 'STMOV' ");
        try {
            Query createQuery = em.createNativeQuery(sql.toString());
            resultArrays = createQuery.getResultList();
            resultMaps = new ArrayList<>();
            Map<String, Object> map;
            for (Object[] array : resultArrays) {
                map = new HashMap<>();
                map.put("codigo", array[0]);
                map.put("nome", array[1]);
                resultMaps.add(map);
            }
        } catch (Exception e) {
            System.out.println("ERRO no método listarSitMov " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }

    public List<Map<String, Object>> listarTipMov() {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select cod_valor_detalhe as codigo      ");
        sql.append("        ,desc_detalhe as nome     ");
        sql.append(" from cad_detalhe                 ");
        sql.append(" where cod_item_detalhe = 'TPMOV' ");
        try {
            Query createQuery = em.createNativeQuery(sql.toString());
            resultArrays = createQuery.getResultList();
            resultMaps = new ArrayList<>();
            Map<String, Object> map;
            for (Object[] array : resultArrays) {
                map = new HashMap<>();
                map.put("codigo", array[0]);
                map.put("nome", array[1]);
                resultMaps.add(map);
            }
        } catch (Exception e) {
            System.out.println("ERRO no método listarTipMov " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }

    public List<Map<String, Object>> listarPesquisa(Integer cod, String desc, String tip, String sit) {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select mov_id as codigo                                                                                                ");
        sql.append("        ,mov_desc as descricao                                                                                          ");
        sql.append("        ,(select desc_detalhe from cad_detalhe where cod_valor_detalhe = mov_tip and cod_item_detalhe = 'TPMOV') as tip ");
        sql.append("        ,(select desc_detalhe from cad_detalhe where cod_valor_detalhe = mov_sit and cod_item_detalhe = 'STMOV') as sit ");
        sql.append(" from cad_movimentacao where 1 = 1                                                                                      ");

        if (cod != null) {
            sql.append(" and mov_id = ").append(cod);
        }
        if (!desc.equals("")) {
            sql.append(" and mov_desc like'%").append(desc.toUpperCase()).append("%'");
        }
        if (tip != null) {
            sql.append(" and mov_tip = ").append(tip);
        }
        if (sit != null) {
            sql.append(" and mov_sit = ").append(sit);
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
                map.put("tip", array[2]);
                map.put("sit", array[3]);
                resultMaps.add(map);
            }
        } catch (Exception e) {
            System.out.println("ERRO no método listarPesquisa " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }
}
