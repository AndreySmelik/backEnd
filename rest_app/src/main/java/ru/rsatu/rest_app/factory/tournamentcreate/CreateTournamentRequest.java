/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.tournamentcreate;

import ru.rsatu.rest_app.pojo.Tournament;

/**
 *
 * @author andrey
 */
public class CreateTournamentRequest {
    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
    
    
}
