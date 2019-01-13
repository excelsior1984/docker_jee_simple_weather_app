/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test9;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "pogoda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pogoda.findAll", query = "SELECT p FROM Pogoda p")
    , @NamedQuery(name = "Pogoda.findById", query = "SELECT p FROM Pogoda p WHERE p.id = :id")
    , @NamedQuery(name = "Pogoda.findByLat", query = "SELECT p FROM Pogoda p WHERE p.lat = :lat")
    , @NamedQuery(name = "Pogoda.findByLon", query = "SELECT p FROM Pogoda p WHERE p.lon = :lon")
    , @NamedQuery(name = "Pogoda.findByTemp", query = "SELECT p FROM Pogoda p WHERE p.temp = :temp")
    , @NamedQuery(name = "Pogoda.findByHumidity", query = "SELECT p FROM Pogoda p WHERE p.humidity = :humidity")
    , @NamedQuery(name = "Pogoda.findByPressure", query = "SELECT p FROM Pogoda p WHERE p.pressure = :pressure")
    , @NamedQuery(name = "Pogoda.findByTempmin", query = "SELECT p FROM Pogoda p WHERE p.tempmin = :tempmin")
    , @NamedQuery(name = "Pogoda.findByTempmax", query = "SELECT p FROM Pogoda p WHERE p.tempmax = :tempmax")
    , @NamedQuery(name = "Pogoda.findBySpeed", query = "SELECT p FROM Pogoda p WHERE p.speed = :speed")
    , @NamedQuery(name = "Pogoda.findByDeg", query = "SELECT p FROM Pogoda p WHERE p.deg = :deg")
    , @NamedQuery(name = "Pogoda.findByName", query = "SELECT p FROM Pogoda p WHERE p.name = :name")})
public class Pogoda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Column(name = "temp")
    private Double temp;
    @Column(name = "humidity")
    private Double humidity;
    @Column(name = "pressure")
    private Double pressure;
    @Column(name = "tempmin")
    private Double tempmin;
    @Column(name = "tempmax")
    private Double tempmax;
    @Column(name = "speed")
    private Double speed;
    @Column(name = "deg")
    private Double deg;
    @Size(max = 30)
    @Column(name = "name")
    private String name;

    public Pogoda() {
    }

    public Pogoda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTempmin() {
        return tempmin;
    }

    public void setTempmin(Double tempmin) {
        this.tempmin = tempmin;
    }

    public Double getTempmax() {
        return tempmax;
    }

    public void setTempmax(Double tempmax) {
        this.tempmax = tempmax;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Pogoda)) {
            return false;
        }
        Pogoda other = (Pogoda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test9.Pogoda[ id=" + id + " ]";
    }
    
}
