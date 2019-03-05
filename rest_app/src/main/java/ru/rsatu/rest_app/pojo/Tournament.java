/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author andrey
 */
@Entity(name = "tournament")
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "win")
    private Long win;
    @Column(name = "defeats")
    private Long defeats;
    @Column(name = "listtournament_id")
    private Long listtournament_id;
     @Column(name = "team_id")
    private Long team_id;
    @OneToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;
    @ManyToOne
    @JoinColumn(name = "listtournament_id", referencedColumnName = "id",insertable = false, updatable = false)
    private ListTournament listTournament;

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }
    @JsonIgnore
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    public Long getListtournament_id() {
        return listtournament_id;
    }

    public void setListtournament_id(Long listtournament_id) {
        this.listtournament_id = listtournament_id;
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWin() {
        return win;
    }

    public void setWin(Long win) {
        this.win = win;
    }

    public Long getDefeats() {
        return defeats;
    }

    public void setDefeats(Long defeats) {
        this.defeats = defeats;
    }

    @JsonIgnore
    public ListTournament getListTournament() {
        return listTournament;
    }

    public void setListTournament(ListTournament listTournament) {
        this.listTournament = listTournament;
    }
   

    
   
}
