/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.bean;

import com.softbean.educafinanceiro.controle.CadMovimentacaoControle;
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
@Named(value = "cadMovimentacaoBean")
@SessionScoped
public class CadMovimentacaoBean implements Serializable {

    /**
     * Creates a new instance of CadMovimentacaoBean
     */
    public CadMovimentacaoBean() {
    }

    @Inject
    CadMovimentacaoControle movimentacaoControle;

    List<Map<String, Object>> listarSitMov;
    Integer codMov;
    String descMov, sitMov;

    public List<Map<String, Object>> carregaSitMov() {
        try {
            setListarSitMov(movimentacaoControle.ListaSitMovimentacao());
        } catch (Exception e) {
            System.out.println("Erro no método carregaSitMov " + e.getMessage());
            e.printStackTrace();
        }
        return getListarSitMov();
    }

    public List<Map<String, Object>> getListarSitMov() {
        return listarSitMov;
    }

    public void setListarSitMov(List<Map<String, Object>> listarSitMov) {
        this.listarSitMov = listarSitMov;
    }

    public Integer getCodMov() {
        return codMov;
    }

    public void setCodMov(Integer codMov) {
        this.codMov = codMov;
    }

    public String getDescMov() {
        return descMov;
    }

    public void setDescMov(String descMov) {
        this.descMov = descMov;
    }

    public String getSitMov() {
        return sitMov;
    }

    public void setSitMov(String sitMov) {
        this.sitMov = sitMov;
    }

}
