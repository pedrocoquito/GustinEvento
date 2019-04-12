/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.evento.model;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author coqui
 */
@Entity
@Table(catalog = "mydb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ata.findAll", query = "SELECT a FROM Ata a"),
    @NamedQuery(name = "Ata.findById", query = "SELECT a FROM Ata a WHERE a.id = :id"),
    @NamedQuery(name = "Ata.findByEncerrada", query = "SELECT a FROM Ata a WHERE a.encerrada = :encerrada")})
public class Ata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Short encerrada;
    @JoinColumn(name = "reuniao_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Reuniao reuniaoId;
    @JoinColumn(name = "voto_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Voto votoId;

    public Ata() {
    }

    public Ata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getEncerrada() {
        return encerrada;
    }

    public void setEncerrada(Short encerrada) {
        this.encerrada = encerrada;
    }

    public Reuniao getReuniaoId() {
        return reuniaoId;
    }

    public void setReuniaoId(Reuniao reuniaoId) {
        this.reuniaoId = reuniaoId;
    }

    public Voto getVotoId() {
        return votoId;
    }

    public void setVotoId(Voto votoId) {
        this.votoId = votoId;
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
        if (!(object instanceof Ata)) {
            return false;
        }
        Ata other = (Ata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.evento.model.Ata[ id=" + id + " ]";
    }
    
}
