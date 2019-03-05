/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.teamcreate;

import ru.rsatu.rest_app.pojo.Team;

/**
 *
 * @author npetrov
 */
public class CreateTeamRequest {
    
    private Team team;
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
}
