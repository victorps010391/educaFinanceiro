/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.entidade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "cad_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadFuncionario.findAll", query = "SELECT c FROM CadFuncionario c"),
    @NamedQuery(name = "CadFuncionario.findByCpfFunc", query = "SELECT c FROM CadFuncionario c WHERE c.cpfFunc = :cpfFunc"),
    @NamedQuery(name = "CadFuncionario.findByNomeFunc", query = "SELECT c FROM CadFuncionario c WHERE c.nomeFunc = :nomeFunc"),
    @NamedQuery(name = "CadFuncionario.findByFuncaoFunc", query = "SELECT c FROM CadFuncionario c WHERE c.funcaoFunc = :funcaoFunc"),
    @NamedQuery(name = "CadFuncionario.findBySalarioBrutFunc", query = "SELECT c FROM CadFuncionario c WHERE c.salarioBrutFunc = :salarioBrutFunc"),
    @NamedQuery(name = "CadFuncionario.findByDtRegFunc", query = "SELECT c FROM CadFuncionario c WHERE c.dtRegFunc = :dtRegFunc"),
    @NamedQuery(name = "CadFuncionario.findByUsuRegFunc", query = "SELECT c FROM CadFuncionario c WHERE c.usuRegFunc = :usuRegFunc"),
    @NamedQuery(name = "CadFuncionario.findByDtUltAtuFunc", query = "SELECT c FROM CadFuncionario c WHERE c.dtUltAtuFunc = :dtUltAtuFunc"),
    @NamedQuery(name = "CadFuncionario.findByUsuUltAtuFunc", query = "SELECT c FROM CadFuncionario c WHERE c.usuUltAtuFunc = :usuUltAtuFunc")})
public class CadFuncionario implements Serializable {

    @Column(name = "funcao_func")
    private Integer funcaoFunc;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf_func")
    private String cpfFunc;
    @Size(max = 512)
    @Column(name = "nome_func")
    private String nomeFunc;
    @Column(name = "salario_brut_func")
    private BigInteger salarioBrutFunc;
    @Column(name = "dt_reg_func")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRegFunc;
    @Column(name = "usu_reg_func")
    private Integer usuRegFunc;
    @Column(name = "dt_ult_atu_func")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUltAtuFunc;
    @Column(name = "usu_ult_atu_func")
    private Integer usuUltAtuFunc;

    public CadFuncionario() {
    }

    public CadFuncionario(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }
  
    public BigInteger getSalarioBrutFunc() {
        return salarioBrutFunc;
    }

    public void setSalarioBrutFunc(BigInteger salarioBrutFunc) {
        this.salarioBrutFunc = salarioBrutFunc;
    }

    public Date getDtRegFunc() {
        return dtRegFunc;
    }

    public void setDtRegFunc(Date dtRegFunc) {
        this.dtRegFunc = dtRegFunc;
    }

    public Integer getUsuRegFunc() {
        return usuRegFunc;
    }

    public void setUsuRegFunc(Integer usuRegFunc) {
        this.usuRegFunc = usuRegFunc;
    }

    public Date getDtUltAtuFunc() {
        return dtUltAtuFunc;
    }

    public void setDtUltAtuFunc(Date dtUltAtuFunc) {
        this.dtUltAtuFunc = dtUltAtuFunc;
    }

    public Integer getUsuUltAtuFunc() {
        return usuUltAtuFunc;
    }

    public void setUsuUltAtuFunc(Integer usuUltAtuFunc) {
        this.usuUltAtuFunc = usuUltAtuFunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfFunc != null ? cpfFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadFuncionario)) {
            return false;
        }
        CadFuncionario other = (CadFuncionario) object;
        if ((this.cpfFunc == null && other.cpfFunc != null) || (this.cpfFunc != null && !this.cpfFunc.equals(other.cpfFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softbean.educafinanceiro.entidade.CadFuncionario[ cpfFunc=" + cpfFunc + " ]";
    }

    public Integer getFuncaoFunc() {
        return funcaoFunc;
    }

    public void setFuncaoFunc(Integer funcaoFunc) {
        this.funcaoFunc = funcaoFunc;
    }
    
}
