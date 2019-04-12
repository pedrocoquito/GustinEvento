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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Reuniao.findAll", query = "SELECT r FROM Reuniao r"),
    @NamedQuery(name = "Reuniao.findById", query = "SELECT r FROM Reuniao r WHERE r.id = :id"),
    @NamedQuery(name = "Reuniao.findByPauta", query = "SELECT r FROM Reuniao r WHERE r.pauta = :pauta"),
    @NamedQuery(name = "Reuniao.findByDia", query = "SELECT r FROM Reuniao r WHERE r.dia = :dia")})
public class Reuniao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String pauta;
    @Basic(optional = false)
    @Column(nullable = false)
    private int dia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reuniaoId")
    private List<Ata> ataList;
    @JoinColumn(name = "sala_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sala salaId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Reuniao() {
    }

    public Reuniao(Integer id) {
        this.id = id;
    }

    public Reuniao(Integer id, String pauta, int dia) {
        this.id = id;
        this.pauta = pauta;
        this.dia = dia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @XmlTransient
    public List<Ata> getAtaList() {
        return ataList;
    }

    public void setAtaList(List<Ata> ataList) {
        this.ataList = ataList;
    }

    public Sala getSalaId() {
        return salaId;
    }

    public void setSalaId(Sala salaId) {
        this.salaId = salaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Reuniao)) {
            return false;
        }
        Reuniao other = (Reuniao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.evento.model.Reuniao[ id=" + id + " ]";
    }
    
}
