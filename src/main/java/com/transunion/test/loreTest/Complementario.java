/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transunion.test.loreTest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lorena Pinzón
 */
@Entity
@Table(name = "complementario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complementario.findAll", query = "SELECT c FROM Complementario c"),
    @NamedQuery(name = "Complementario.findByCompId", query = "SELECT c FROM Complementario c WHERE c.compId = :compId"),
    @NamedQuery(name = "Complementario.findBySaludo", query = "SELECT c FROM Complementario c WHERE c.saludo = :saludo"),
    @NamedQuery(name = "Complementario.findByDatoId", query = "SELECT c FROM Complementario c WHERE c.datosId.datosId = :datosId")})
public class Complementario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_id")
    private Integer compId;
    @Size(max = 255)
    @Column(name = "saludo")
    private String saludo;
    @JoinColumn(name = "datos_id", referencedColumnName = "datos_id")
    @ManyToOne(optional = false)
    private Datos datosId;

    public Complementario() {
    }

    public Complementario(Integer compId) {
        this.compId = compId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public Datos getDatosId() {
        return datosId;
    }

    public void setDatosId(Datos datosId) {
        this.datosId = datosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compId != null ? compId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complementario)) {
            return false;
        }
        Complementario other = (Complementario) object;
        if ((this.compId == null && other.compId != null) || (this.compId != null && !this.compId.equals(other.compId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mercadolibretest.Complementario[ compId=" + compId + " ]";
    }
    
}
