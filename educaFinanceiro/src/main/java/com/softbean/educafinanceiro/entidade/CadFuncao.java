/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbean.educafinanceiro.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "cad_funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadFuncao.findAll", query = "SELECT c FROM CadFuncao c"),
    @NamedQuery(name = "CadFuncao.findByFuncaoId", query = "SELECT c FROM CadFuncao c WHERE c.funcaoId = :funcaoId"),
    @NamedQuery(name = "CadFuncao.findByFuncaoDesc", query = "SELECT c FROM CadFuncao c WHERE c.funcaoDesc = :funcaoDesc"),
    @NamedQuery(name = "CadFuncao.findByFuncaoSit", query = "SELECT c FROM CadFuncao c WHERE c.funcaoSit = :funcaoSit"),
    @NamedQuery(name = "CadFuncao.findByFuncaoDtRegi", query = "SELECT c FROM CadFuncao c WHERE c.funcaoDtRegi = :funcaoDtRegi"),
    @NamedQuery(name = "CadFuncao.findByFuncaoUsuRegi", query = "SELECT c FROM CadFuncao c WHERE c.funcaoUsuRegi = :funcaoUsuRegi"),
    @NamedQuery(name = "CadFuncao.findByFuncaoDtUltAtu", query = "SELECT c FROM CadFuncao c WHERE c.funcaoDtUltAtu = :funcaoDtUltAtu"),
    @NamedQuery(name = "CadFuncao.findByFuncaoUsuUltAtu", query = "SELECT c FROM CadFuncao c WHERE c.funcaoUsuUltAtu = :funcaoUsuUltAtu")})
public class CadFuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcao_id")
    private Integer funcaoId;
    @Size(max = 512)
    @Column(name = "funcao_desc")
    private String funcaoDesc;
    @Size(max = 2)
    @Column(name = "funcao_sit")
    private String funcaoSit;
    @Column(name = "funcao_dt_regi")
    @Temporal(TemporalType.DATE)
    private Date funcaoDtRegi;
    @Column(name = "funcao_usu_regi")
    private Integer funcaoUsuRegi;
    @Column(name = "funcao_dt_ult_atu")
    @Temporal(TemporalType.DATE)
    private Date funcaoDtUltAtu;
    @Column(name = "funcao_usu_ult_atu")
    private Integer funcaoUsuUltAtu;

    public CadFuncao() {
    }

    public CadFuncao(Integer funcaoId) {
        this.funcaoId = funcaoId;
    }

    public Integer getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(Integer funcaoId) {
        this.funcaoId = funcaoId;
    }

    public String getFuncaoDesc() {
        return funcaoDesc;
    }

    public void setFuncaoDesc(String funcaoDesc) {
        this.funcaoDesc = funcaoDesc;
    }

    public String getFuncaoSit() {
        return funcaoSit;
    }

    public void setFuncaoSit(String funcaoSit) {
        this.funcaoSit = funcaoSit;
    }

    public Date getFuncaoDtRegi() {
        return funcaoDtRegi;
    }

    public void setFuncaoDtRegi(Date funcaoDtRegi) {
        this.funcaoDtRegi = funcaoDtRegi;
    }

    public Integer getFuncaoUsuRegi() {
        return funcaoUsuRegi;
    }

    public void setFuncaoUsuRegi(Integer funcaoUsuRegi) {
        this.funcaoUsuRegi = funcaoUsuRegi;
    }

    public Date getFuncaoDtUltAtu() {
        return funcaoDtUltAtu;
    }

    public void setFuncaoDtUltAtu(Date funcaoDtUltAtu) {
        this.funcaoDtUltAtu = funcaoDtUltAtu;
    }

    public Integer getFuncaoUsuUltAtu() {
        return funcaoUsuUltAtu;
    }

    public void setFuncaoUsuUltAtu(Integer funcaoUsuUltAtu) {
        this.funcaoUsuUltAtu = funcaoUsuUltAtu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcaoId != null ? funcaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadFuncao)) {
            return false;
        }
        CadFuncao other = (CadFuncao) object;
        if ((this.funcaoId == null && other.funcaoId != null) || (this.funcaoId != null && !this.funcaoId.equals(other.funcaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softbean.educafinanceiro.entidade.CadFuncao[ funcaoId=" + funcaoId + " ]";
    }
    
}
