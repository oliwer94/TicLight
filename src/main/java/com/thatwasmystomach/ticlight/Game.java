/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thatwasmystomach.ticlight;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johannes
 */
@Entity
@Table(name = "game")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "Game.findByDateStart", query = "SELECT g FROM Game g WHERE g.dateStart = :dateStart"),
    @NamedQuery(name = "Game.findByDateEnd", query = "SELECT g FROM Game g WHERE g.dateEnd = :dateEnd")
})
public class Game implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @JoinColumn(name = "LOSER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User loserId;
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User winnerId;

    public Game()
    {
    }

    public Game(Integer id)
    {
        this.id = id;
    }

    public Game(Integer id, Date dateStart, Date dateEnd)
    {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getDateStart()
    {
        return dateStart;
    }

    public void setDateStart(Date dateStart)
    {
        this.dateStart = dateStart;
    }

    public Date getDateEnd()
    {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd)
    {
        this.dateEnd = dateEnd;
    }

    public User getLoserId()
    {
        return loserId;
    }

    public void setLoserId(User loserId)
    {
        this.loserId = loserId;
    }

    public User getWinnerId()
    {
        return winnerId;
    }

    public void setWinnerId(User winnerId)
    {
        this.winnerId = winnerId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game))
        {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.thatwasmystomach.ticlight.Game[ id=" + id + " ]";
    }
    
}
