/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.bean;

import com.softbean.educafinanceiro.controle.CadFuncionarioControle;
import com.softbean.educafinanceiro.entidade.CadFuncionario;
import com.softbean.educafinanceiro.util.Util;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author DELL
 */
@Named(value = "cadFuncionarioBean")
@SessionScoped
public class CadFuncionarioBean implements Serializable {

    /**
     * Creates a new instance of CadFuncionarioBean
     */
    public CadFuncionarioBean() {
    }

    @Inject
    CadFuncionarioControle funcionarioControle;
    @Inject
    Util util;

    CadFuncionario cadObj, altObj;

    BigInteger cadSalario;
    Integer cadFuncao, PesqFuncao;
    String cadCpf, cadNome, pesqCpf, pesqNome;

    List<Map<String, Object>> listarFuncao, gridPesquisa;

    public void pesquisarFuncionario() {
        try {
            setGridPesquisa(funcionarioControle.listarPesquisa(getPesqCpf(), getPesqNome(), getPesqFuncao()));
        } catch (Exception e) {
            System.out.println("ERRO no método pesquisarFuncionario " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void salvarFuncionario() {
        FacesContext mensagem = FacesContext.getCurrentInstance();
        PrimeFaces sessao = PrimeFaces.current();
        try {
            setCadObj(null);
            setCadObj(new CadFuncionario());
            getCadObj().setCpfFunc(getCadCpf());
            getCadObj().setFuncaoFunc(getCadFuncao());
            getCadObj().setNomeFunc(getCadNome().toUpperCase());
            getCadObj().setSalarioBrutFunc(getCadSalario());
            getCadObj().setDtRegFunc(new Date());
            getCadObj().setUsuRegFunc(999);
            getCadObj().setDtUltAtuFunc(new Date());
            getCadObj().setUsuUltAtuFunc(999);

            if (util.CPFcorreto(getCadCpf())) {
                if (funcionarioControle.salvarFuncionario(getCadObj())) {
                    mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "educaFinanceiro Informa:", "Funcionário Cadastrado com Sucesso."));
                    sessao.executeScript("PF('dlCadFunc').hide()");
                    setGridPesquisa(funcionarioControle.listarPesquisa(getCadObj().getCpfFunc(), null, null));
                    limparCadastro();
                } else {
                    mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Funcionário."));
                }
            } else {
                mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "CPF inválido."));
            }

        } catch (Exception e) {
            System.out.println("ERRO no metódo salvarFuncionario " + e.getMessage());
            e.printStackTrace();
            mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "educaFinanceiro Informa:", "Erro ao Cadastrar Funcionário."));
        }
    }

    public List<Map<String, Object>> carregaFuncao() {
        try {
            setListarFuncao(funcionarioControle.listarFuncao());
        } catch (Exception e) {
            System.out.println("Erro no método carregaFuncao " + e.getMessage());
            e.printStackTrace();
        }
        return getListarFuncao();
    }

    public void limparCadastro() {
        setCadCpf(null);
        setCadFuncao(null);
        setCadNome(null);
        setCadSalario(null);
    }

    public void limparPesquisa() {
        setPesqCpf(null);
        setPesqFuncao(null);
        setPesqNome(null);
        setGridPesquisa(null);
    }

    public CadFuncionario getCadObj() {
        if (cadObj == null) {
            cadObj = new CadFuncionario();
        }
        return cadObj;
    }

    public void setCadObj(CadFuncionario cadObj) {
        this.cadObj = cadObj;
    }

    public CadFuncionario getAltObj() {
        if (altObj == null) {
            altObj = new CadFuncionario();
        }
        return altObj;
    }

    public void setAltObj(CadFuncionario altObj) {
        this.altObj = altObj;
    }

    public BigInteger getCadSalario() {
        return cadSalario;
    }

    public void setCadSalario(BigInteger cadSalario) {
        this.cadSalario = cadSalario;
    }

    public Integer getPesqFuncao() {
        return PesqFuncao;
    }

    public void setPesqFuncao(Integer PesqFuncao) {
        this.PesqFuncao = PesqFuncao;
    }

    public String getPesqCpf() {
        return pesqCpf;
    }

    public void setPesqCpf(String pesqCpf) {
        this.pesqCpf = pesqCpf;
    }

    public String getPesqNome() {
        return pesqNome;
    }

    public void setPesqNome(String pesqNome) {
        this.pesqNome = pesqNome;
    }

    public Integer getCadFuncao() {
        return cadFuncao;
    }

    public void setCadFuncao(Integer cadFuncao) {
        this.cadFuncao = cadFuncao;
    }

    public String getCadCpf() {
        return cadCpf;
    }

    public void setCadCpf(String cadCpf) {
        this.cadCpf = cadCpf;
    }

    public String getCadNome() {
        return cadNome;
    }

    public void setCadNome(String cadNome) {
        this.cadNome = cadNome;
    }

    public List<Map<String, Object>> getListarFuncao() {
        return listarFuncao;
    }

    public void setListarFuncao(List<Map<String, Object>> listarFuncao) {
        this.listarFuncao = listarFuncao;
    }

    public List<Map<String, Object>> getGridPesquisa() {
        return gridPesquisa;
    }

    public void setGridPesquisa(List<Map<String, Object>> gridPesquisa) {
        this.gridPesquisa = gridPesquisa;
    }

}
