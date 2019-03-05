/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.tournamentcreate;

import javax.persistence.EntityManager;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;
import ru.rsatu.rest_app.pojo.Tournament;

/**
 *
 * @author andrey
 */
public class CreateTournamentFactory {
 public CreateTournamentResponse createTournament(EntityManager em,CreateTournamentRequest request)throws RestAppException {
     CreateTournamentResponse result = new CreateTournamentResponse();
     try {
         Tournament tournament = request.getTournament();
         em.persist(tournament);
         ResultStatus resultStatus = new ResultStatus();
         resultStatus.setErrorCode(Constants.ERROR_CODE_OK);
         resultStatus.setErrorText(Constants.ERROR_TEXT_OK);
         result.setResultStatus(resultStatus);
         result.setTournament(tournament);
     } catch (Exception ex) {
            throw new RestAppException("Unable to create tournament");
        }
        return result;
 }   
}
