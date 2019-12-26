/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.bean;

import com.softbean.educafinanceiro.controle.CadMovimentacaoControle;
import com.softbean.educafinanceiro.entidade.CadMovimentacao;
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

    CadMovimentacao cadObj, altObj;

    List<Map<String, Object>> listarSitMov, listarTipMov, gridPesquisa;
    Integer codMov;
    String descMov, sitMov, tipMov, cadDescMov, cadSitMov, cadTipMov;

    public void pesquisarMovimento() {
        try {
            setGridPesquisa(movimentacaoControle.listarPesquisa(getCodMov(), getDescMov(), getTipMov(), getSitMov()));
        } catch (Exception e) {
            System.out.println("ERRO no método pesquisarMovimento " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarMovimento(Integer cod) {
        try {
            setAltObj(movimentacaoControle.buscarMovimento(cod));
        } catch (Exception e) {
            System.out.println("ERRO no método buscarMovimento " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void alterarMovimento() {
        FacesContext mensagem = FacesContext.getCurrentInstance();
        PrimeFaces sessao = PrimeFaces.current();
        try {
            getAltObj().setMovDtRegi(new Date());
            getAltObj().setMovUsuRegi(999);
            getAltObj().setMovDtUltAtu(new Date());
            getAltObj().setMovUsuUltAtu(999);
            if (movimentacaoControle.alterarMovimento(getAltObj())) {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "educaFinanceiro Informa:", "Movimento Alterado com Sucesso."));
                setGridPesquisa(movimentacaoControle.listarPesquisa(getAltObj().getMovId(), getAltObj().getMovDesc(), getAltObj().getMovTip(), getAltObj().getMovSit()));
                sessao.executeScript("PF('dlAltMov').hide()");
            } else {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Alterar Movimento."));
            }
        } catch (Exception e) {
            System.out.println("ERRO no metódo alterarMovimento " + e.getMessage());
            e.printStackTrace();
            mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Alterar Movimento."));
        }
    }

    public void salvarMovimento() {
        FacesContext mensagem = FacesContext.getCurrentInstance();
        PrimeFaces sessao = PrimeFaces.current();
        try {
            setCadObj(null);
            setCadObj(new CadMovimentacao());
            getCadObj().setMovDesc(getCadDescMov().toUpperCase());
            getCadObj().setMovSit(getCadSitMov());
            getCadObj().setMovTip(getCadTipMov());
            getCadObj().setMovDtRegi(new Date());
            getCadObj().setMovUsuRegi(999);
            getCadObj().setMovDtUltAtu(new Date());
            getCadObj().setMovUsuUltAtu(999);
            if (movimentacaoControle.salvarMovimento(getCadObj())) {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "educaFinanceiro Informa:", "Cadastro de Movimento Realizado com Sucesso."));
                sessao.executeScript("PF('dlCadMov').hide()");
                setGridPesquisa(movimentacaoControle.listarPesquisa(getCadObj().getMovId(), getCadObj().getMovDesc(), getCadObj().getMovTip(), getCadObj().getMovSit()));
            } else {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Movimento."));
            }
        } catch (Exception e) {
            System.out.println("ERRO no metódo salvarMovimento " + e.getMessage());
            e.printStackTrace();
            mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Movimento."));
        }
    }

    public List<Map<String, Object>> carregaSitMov() {
        try {
            setListarSitMov(movimentacaoControle.ListaSitMovimentacao());
        } catch (Exception e) {
            System.out.println("Erro no método carregaSitMov " + e.getMessage());
            e.printStackTrace();
        }
        return getListarSitMov();
    }

    public List<Map<String, Object>> carregaTipMov() {
        try {
            setListarTipMov(movimentacaoControle.listarTipMov());
        } catch (Exception e) {
            System.out.println("Erro no método carregaSitMov " + e.getMessage());
            e.printStackTrace();
        }
        return getListarTipMov();
    }

    public void limparCadastro() {
        setCadDescMov(null);
        setCadSitMov(null);
        setListarTipMov(null);
    }

    public void limparPesquisa() {
        setSitMov(null);
        setTipMov(null);
        setListarSitMov(null);
        setListarTipMov(null);
        setCodMov(null);
        setDescMov(null);
        setGridPesquisa(null);

    }

    public List<Map<String, Object>> getGridPesquisa() {
        return gridPesquisa;
    }

    public void setGridPesquisa(List<Map<String, Object>> gridPesquisa) {
        this.gridPesquisa = gridPesquisa;
    }

    public List<Map<String, Object>> getListarSitMov() {
        return listarSitMov;
    }

    public void setListarSitMov(List<Map<String, Object>> listarSitMov) {
        this.listarSitMov = listarSitMov;
    }

    public List<Map<String, Object>> getListarTipMov() {
        return listarTipMov;
    }

    public void setListarTipMov(List<Map<String, Object>> listarTipMov) {
        this.listarTipMov = listarTipMov;
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

    public String getCadDescMov() {
        return cadDescMov;
    }

    public void setCadDescMov(String cadDescMov) {
        this.cadDescMov = cadDescMov;
    }

    public String getCadSitMov() {
        return cadSitMov;
    }

    public void setCadSitMov(String cadSitMov) {
        this.cadSitMov = cadSitMov;
    }

    public String getTipMov() {
        return tipMov;
    }

    public void setTipMov(String tipMov) {
        this.tipMov = tipMov;
    }

    public String getCadTipMov() {
        return cadTipMov;
    }

    public void setCadTipMov(String cadTipMov) {
        this.cadTipMov = cadTipMov;
    }

    public CadMovimentacao getAltObj() {
        if (altObj == null) {
            altObj = new CadMovimentacao();
        }
        return altObj;
    }

    public void setAltObj(CadMovimentacao altObj) {
        this.altObj = altObj;
    }

    public CadMovimentacao getCadObj() {
        if (cadObj == null) {
            cadObj = new CadMovimentacao();
        }
        return cadObj;
    }

    public void setCadObj(CadMovimentacao cadObj) {
        this.cadObj = cadObj;
    }

}
