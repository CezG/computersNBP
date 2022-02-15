/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author cezar
 */
@Entity
@Table(name = "KOMPUTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komputer.findAll", query = "SELECT k FROM Komputer k"),
    @NamedQuery(name = "Komputer.findById", query = "SELECT k FROM Komputer k WHERE k.id = :id"),
    @NamedQuery(name = "Komputer.findByDataKsiegowania", query = "SELECT k FROM Komputer k WHERE k.dataKsiegowania = :dataKsiegowania"),
    @NamedQuery(name = "Komputer.findByKosztUsd", query = "SELECT k FROM Komputer k WHERE k.kosztUsd = :kosztUsd"),
    @NamedQuery(name = "Komputer.findByKosztPln", query = "SELECT k FROM Komputer k WHERE k.kosztPln = :kosztPln")})
public class Komputer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_KSIEGOWANIA")
    @Temporal(TemporalType.DATE)
    private Date dataKsiegowania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KOSZT_USD")
    private double kosztUsd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KOSZT_PLN")
    private double kosztPln;

    public Komputer() {
    }

    public Komputer(Integer id) {
        this.id = id;
    }

    public Komputer(Integer id, String nazwa, Date dataKsiegowania, double kosztUsd, double kosztPln) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataKsiegowania = dataKsiegowania;
        this.kosztUsd = kosztUsd;
        this.kosztPln = kosztPln;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataKsiegowania() {
        return dataKsiegowania;
    }

    public void setDataKsiegowania(Date dataKsiegowania) {
        this.dataKsiegowania = dataKsiegowania;
    }

    public double getKosztUsd() {
        return kosztUsd;
    }

    public void setKosztUsd(double kosztUsd) {
        this.kosztUsd = kosztUsd;
    }

    public double getKosztPln() {
        return kosztPln;
    }

    public void setKosztPln(double kosztPln) {
        this.kosztPln = kosztPln;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komputer)) {
            return false;
        }
        Komputer other = (Komputer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "computer.Komputer[ id=" + id + " ]";
    }
    
}
