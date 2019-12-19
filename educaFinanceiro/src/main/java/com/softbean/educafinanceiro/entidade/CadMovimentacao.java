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
@Table(name = "cad_movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadMovimentacao.findAll", query = "SELECT c FROM CadMovimentacao c"),
    @NamedQuery(name = "CadMovimentacao.findByMovId", query = "SELECT c FROM CadMovimentacao c WHERE c.movId = :movId"),
    @NamedQuery(name = "CadMovimentacao.findByMovDesc", query = "SELECT c FROM CadMovimentacao c WHERE c.movDesc = :movDesc"),
    @NamedQuery(name = "CadMovimentacao.findByMovSit", query = "SELECT c FROM CadMovimentacao c WHERE c.movSit = :movSit"),
    @NamedQuery(name = "CadMovimentacao.findByMovDtRegi", query = "SELECT c FROM CadMovimentacao c WHERE c.movDtRegi = :movDtRegi"),
    @NamedQuery(name = "CadMovimentacao.findByMovUsuRegi", query = "SELECT c FROM CadMovimentacao c WHERE c.movUsuRegi = :movUsuRegi"),
    @NamedQuery(name = "CadMovimentacao.findByMovDtUltAtu", query = "SELECT c FROM CadMovimentacao c WHERE c.movDtUltAtu = :movDtUltAtu"),
    @NamedQuery(name = "CadMovimentacao.findByMovUsuUltAtu", query = "SELECT c FROM CadMovimentacao c WHERE c.movUsuUltAtu = :movUsuUltAtu")})
public class CadMovimentacao implements Serializable {

    @Size(max = 2)
    @Column(name = "mov_tip")
    private String movTip;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mov_id")
    private Integer movId;
    @Size(max = 512)
    @Column(name = "mov_desc")
    private String movDesc;
    @Size(max = 2)
    @Column(name = "mov_sit")
    private String movSit;
    @Column(name = "mov_dt_regi")
    @Temporal(TemporalType.DATE)
    private Date movDtRegi;
    @Column(name = "mov_usu_regi")
    private Integer movUsuRegi;
    @Column(name = "mov_dt_ult_atu")
    @Temporal(TemporalType.DATE)
    private Date movDtUltAtu;
    @Column(name = "mov_usu_ult_atu")
    private Integer movUsuUltAtu;

    public CadMovimentacao() {
    }

    public CadMovimentacao(Integer movId) {
        this.movId = movId;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public String getMovDesc() {
        return movDesc;
    }

    public void setMovDesc(String movDesc) {
        this.movDesc = movDesc;
    }

    public String getMovSit() {
        return movSit;
    }

    public void setMovSit(String movSit) {
        this.movSit = movSit;
    }

    public Date getMovDtRegi() {
        return movDtRegi;
    }

    public void setMovDtRegi(Date movDtRegi) {
        this.movDtRegi = movDtRegi;
    }

    public Integer getMovUsuRegi() {
        return movUsuRegi;
    }

    public void setMovUsuRegi(Integer movUsuRegi) {
        this.movUsuRegi = movUsuRegi;
    }

    public Date getMovDtUltAtu() {
        return movDtUltAtu;
    }

    public void setMovDtUltAtu(Date movDtUltAtu) {
        this.movDtUltAtu = movDtUltAtu;
    }

    public Integer getMovUsuUltAtu() {
        return movUsuUltAtu;
    }

    public void setMovUsuUltAtu(Integer movUsuUltAtu) {
        this.movUsuUltAtu = movUsuUltAtu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadMovimentacao)) {
            return false;
        }
        CadMovimentacao other = (CadMovimentacao) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softbean.educafinanceiro.entidade.CadMovimentacao[ movId=" + movId + " ]";
    }

    public String getMovTip() {
        return movTip;
    }

    public void setMovTip(String movTip) {
        this.movTip = movTip;
    }
    
}
