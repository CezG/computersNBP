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
    @NamedQuery(name = "Device.findAll", query = "SELECT k FROM Device k"),
    @NamedQuery(name = "Device.findById", query = "SELECT k FROM Device k WHERE k.id = :id"),
    @NamedQuery(name = "Device.findByDate", query = "SELECT k FROM Device k WHERE k.date = :date"),
    @NamedQuery(name = "Device.findByCostUsd", query = "SELECT k FROM Device k WHERE k.costUsd = :costUsd"),
    @NamedQuery(name = "Device.findByCostPln", query = "SELECT k FROM Device k WHERE k.costPln = :costPln")})
public class Device implements Serializable {

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
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_KSIEGOWANIA")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @NotNull
    @Column(name = "KOSZT_USD")
    private double costUsd;

    @Basic(optional = false)
    @NotNull
    @Column(name = "KOSZT_PLN")
    private double costPln;

    public Device() {
    }

    public Device(Integer id) {
        this.id = id;
    }

    public Device(Integer id, String name, Date date, double costUsd) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.costUsd = costUsd;
    }

    public Device(Integer id, String name, Date date, double costUsd, double costPln) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.costUsd = costUsd;
        this.costPln = costPln;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return name;
    }

    public void setNazwa(String name) {
        this.name = name;
    }

    public Date getDataKsiegowania() {
        return date;
    }

    public void setDataKsiegowania(Date date) {
        this.date = date;
    }

    public double getKosztUsd() {
        return costUsd;
    }

    public void setKosztUsd(double costUsd) {
        this.costUsd = Math.round(costUsd * 100.0) / 100.0;
    }

    public double getKosztPln() {
        return costPln;
    }

    public void setKosztPln(double costPln) {
        this.costPln =  Math.round(costPln * 100.0) / 100.0;;
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
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Komputer[ id=" + id + " ]";
    }

}
