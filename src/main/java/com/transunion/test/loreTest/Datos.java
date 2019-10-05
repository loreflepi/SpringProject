/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transunion.test.loreTest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorena Pinzón
 */
@Entity
@Table(name = "datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d"),
    @NamedQuery(name = "Datos.findByDatosId", query = "SELECT d FROM Datos d WHERE d.datosId = :datosId"),
    @NamedQuery(name = "Datos.findByAsunto", query = "SELECT d FROM Datos d WHERE d.asunto = :asunto"),
    @NamedQuery(name = "Datos.findByDe", query = "SELECT d FROM Datos d WHERE d.de = :de"),
    @NamedQuery(name = "Datos.findByFecha", query = "SELECT d FROM Datos d WHERE d.fecha = :fecha")})
public class Datos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "datos_id")
    private Integer datosId;
    @Size(max = 255)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 255)
    @Column(name = "de")
    private String de;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "datosId")
    private Collection<Complementario> complementarioCollection;

    public Datos() {
    }

    public Datos(Integer datosId) {
        this.datosId = datosId;
    }

    public Integer getDatosId() {
        return datosId;
    }

    public void setDatosId(Integer datosId) {
        this.datosId = datosId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Complementario> getComplementarioCollection() {
        return complementarioCollection;
    }

    public void setComplementarioCollection(Collection<Complementario> complementarioCollection) {
        this.complementarioCollection = complementarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosId != null ? datosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datos)) {
            return false;
        }
        Datos other = (Datos) object;
        if ((this.datosId == null && other.datosId != null) || (this.datosId != null && !this.datosId.equals(other.datosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mercadolibretest.Datos[ datosId=" + datosId + " ]";
    }
    
}
