/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andrey
 */
@Entity(name = "listTournament")
public class ListTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tournamentName")
    private String tournamentName;
    @Column(name = "maxNumberTeam")
    private String maxNumberTeam;
    @Column(name = "prize")
    private Long prize;
    @Column(name = "date")
    private String date;
   // @Temporal(TemporalType.TIMESTAMP)
    //public java.util.Date date;
    @OneToMany(mappedBy = "listTournament",fetch = FetchType.EAGER)
    private List<Tournament> tournaments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getMaxNumberTeam() {
        return maxNumberTeam;
    }

    public void setMaxNumberTeam(String maxNumberTeam) {
        this.maxNumberTeam = maxNumberTeam;
    }

    public Long getPrize() {
        return prize;
    }

    public void setPrize(Long prize) {
        this.prize = prize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
    
    
}
