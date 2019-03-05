/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.listtornamentcreate;

import javax.persistence.EntityManager;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.pojo.ListTournament;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;

/**
 *
 * @author andrey
 */
public class CreateListTournamentFactory {
    public CreateListTournamentResponse createListTournament(EntityManager em,CreateListTournamentRequest request)throws RestAppException {
     CreateListTournamentResponse result = new CreateListTournamentResponse();
     try {
         ListTournament listTournament = request.getListTournament();
         em.persist(listTournament);
         ResultStatus resultStatus = new ResultStatus();
         resultStatus.setErrorCode(Constants.ERROR_CODE_OK);
         resultStatus.setErrorText(Constants.ERROR_TEXT_OK);
         result.setResultStatus(resultStatus);
         result.setListTournament(listTournament);
     } catch (Exception ex) {
            throw new RestAppException("Unable to create listtournament");
        }
        return result;
 }   
}
