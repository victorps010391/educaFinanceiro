/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.fachada;

import com.softbean.educafinanceiro.entidade.CadFuncionario;
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

    public List<Map<String, Object>> listarFuncao() {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select funcao_id as codigo  ");
        sql.append("        ,funcao_desc as nome ");
        sql.append(" from cad_funcao where 1=1   ");

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
            System.out.println("ERRO no método listarFuncao " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }

    public List<Map<String, Object>> listarPesquisa(String cpf, String nome, Integer funcao) {
        List<Object[]> resultArrays;
        List<Map<String, Object>> resultMaps = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select cpf_func as cpf                                                               ");
        sql.append("        ,nome_func as nome                                                            ");
        sql.append("        ,(select funcao_desc from cad_funcao where funcao_id = funcao_func) as funcao ");
        sql.append("        ,to_char(salario_brut_func, 'L9G999G990D99') as salario                       ");
        sql.append("        ,salario_brut_func                                                            ");
        sql.append(" from cad_funcionario where 1=1                                                       ");

        if (cpf != null) {
            sql.append(" and cpf_func = '").append(cpf).append("'");
        }
        if (nome != null) {
            sql.append(" and nome_func like'%").append(nome.toUpperCase()).append("%'");
        }
        if (funcao != null) {
            sql.append(" and funcao_func = ").append(funcao);
        }
        try {
            Query createQuery = em.createNativeQuery(sql.toString());
            resultArrays = createQuery.getResultList();
            resultMaps = new ArrayList<>();
            Map<String, Object> map;
            for (Object[] array : resultArrays) {
                map = new HashMap<>();
                map.put("cpf", array[0]);
                map.put("nome", array[1]);
                map.put("funcao", array[2]);
                map.put("salario", array[3]);
                map.put("salario_brut_func", array[4]);
                resultMaps.add(map);
            }
        } catch (Exception e) {
            System.out.println("ERRO no método listarPesquisa " + e.getMessage());
            e.printStackTrace();
        }
        return resultMaps;
    }

}
