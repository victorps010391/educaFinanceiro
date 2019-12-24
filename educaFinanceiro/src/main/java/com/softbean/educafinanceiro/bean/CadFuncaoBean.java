/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.bean;

import com.softbean.educafinanceiro.controle.CadFuncaoControle;
import com.softbean.educafinanceiro.entidade.CadFuncao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author admin
 */
@Named(value = "cadFuncaoBean")
@SessionScoped
public class CadFuncaoBean implements Serializable {

    /**
     * Creates a new instance of CadFuncaoBean
     */
    public CadFuncaoBean() {
    }

    @Inject
    CadFuncaoControle funcaoControle;

    CadFuncao cadObj, altObj;

    List<Map<String, Object>> listarSitFuncao, gridPesquisa;
    Integer pesqCodFuncao;
    String pesqDescFuncao, pesqSitFuncao, cadDescFuncao, cadSitFuncao;

    public void salvarFuncao() {
        FacesContext mensagem = FacesContext.getCurrentInstance();
        PrimeFaces sessao = PrimeFaces.current();
        try {
            setCadObj(null);
            setCadObj(new CadFuncao());
            getCadObj().setFuncaoDesc(getCadDescFuncao().toUpperCase());
            getCadObj().setFuncaoSit(getCadSitFuncao());
            getCadObj().setFuncaoDtRegi(new Date());
            getCadObj().setFuncaoUsuRegi(999);
            getCadObj().setFuncaoDtUltAtu(new Date());
            getCadObj().setFuncaoUsuUltAtu(999);
            if (funcaoControle.salvarFuncao(getCadObj())) {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "educaFinanceiro Informa:", "Cadastro de Função Realizado com Sucesso."));
                sessao.executeScript("PF('dlCadFuncao').hide()");
                //setGridPesquisa(movimentacaoControle.listarPesquisa(getCadObj().getFuncaoId(), getCadObj().getFuncaoDesc(), getCadObj().getFuncaoSit()));
            } else {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Função."));
            }
        } catch (Exception e) {
            System.out.println("ERRO no metódo salvarFuncao " + e.getMessage());
            e.printStackTrace();
            mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Função."));
        }
    }

    public CadFuncao getCadObj() {
        if (cadObj == null) {
            cadObj = new CadFuncao();
        }
        return cadObj;
    }

    public void setCadObj(CadFuncao cadObj) {
        this.cadObj = cadObj;
    }

    public CadFuncao getAltObj() {
        if (altObj == null) {
            altObj = new CadFuncao();
        }
        return altObj;
    }

    public void setAltObj(CadFuncao altObj) {
        this.altObj = altObj;
    }

    public List<Map<String, Object>> getListarSitFuncao() {
        return listarSitFuncao;
    }

    public void setListarSitFuncao(List<Map<String, Object>> listarSitFuncao) {
        this.listarSitFuncao = listarSitFuncao;
    }

    public List<Map<String, Object>> getGridPesquisa() {
        return gridPesquisa;
    }

    public void setGridPesquisa(List<Map<String, Object>> gridPesquisa) {
        this.gridPesquisa = gridPesquisa;
    }

    public Integer getPesqCodFuncao() {
        return pesqCodFuncao;
    }

    public void setPesqCodFuncao(Integer pesqCodFuncao) {
        this.pesqCodFuncao = pesqCodFuncao;
    }

    public String getPesqDescFuncao() {
        return pesqDescFuncao;
    }

    public void setPesqDescFuncao(String pesqDescFuncao) {
        this.pesqDescFuncao = pesqDescFuncao;
    }

    public String getPesqSitFuncao() {
        return pesqSitFuncao;
    }

    public void setPesqSitFuncao(String pesqSitFuncao) {
        this.pesqSitFuncao = pesqSitFuncao;
    }

    public String getCadDescFuncao() {
        return cadDescFuncao;
    }

    public void setCadDescFuncao(String cadDescFuncao) {
        this.cadDescFuncao = cadDescFuncao;
    }

    public String getCadSitFuncao() {
        return cadSitFuncao;
    }

    public void setCadSitFuncao(String cadSitFuncao) {
        this.cadSitFuncao = cadSitFuncao;
    }

}
