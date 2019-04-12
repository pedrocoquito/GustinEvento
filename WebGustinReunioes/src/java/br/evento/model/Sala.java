/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.evento.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author coqui
 */
@Entity
@Table(catalog = "mydb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findById", query = "SELECT s FROM Sala s WHERE s.id = :id"),
    @NamedQuery(name = "Sala.findByConference", query = "SELECT s FROM Sala s WHERE s.conference = :conference"),
    @NamedQuery(name = "Sala.findByProjetor", query = "SELECT s FROM Sala s WHERE s.projetor = :projetor")})
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Short conference;
    private Short projetor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaId")
    private List<Reuniao> reuniaoList;

    public Sala() {
    }

    public Sala(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getConference() {
        return conference;
    }

    public void setConference(Short conference) {
        this.conference = conference;
    }

    public Short getProjetor() {
        return projetor;
    }

    public void setProjetor(Short projetor) {
        this.projetor = projetor;
    }

    @XmlTransient
    public List<Reuniao> getReuniaoList() {
        return reuniaoList;
    }

    public void setReuniaoList(List<Reuniao> reuniaoList) {
        this.reuniaoList = reuniaoList;
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
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.evento.model.Sala[ id=" + id + " ]";
    }
    
}
