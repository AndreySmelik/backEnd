/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.teamcreate;

import javax.persistence.EntityManager;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;
import ru.rsatu.rest_app.pojo.Team;

/**
 *
 * @author npetrov
 */
public class CreateTeamFactory {
    
    public CreateTeamResponse createTeam(EntityManager em, CreateTeamRequest request) throws RestAppException{
        CreateTeamResponse result = new CreateTeamResponse();
        try {
            Team team = request.getTeam();
            em.persist(team);
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_OK);
            resultStatus.setErrorText(Constants.ERROR_TEXT_OK);
            result.setResultStatus(resultStatus);
            result.setTeam(team);
        } catch (Exception ex) {
            throw new RestAppException("Unable to create team");
        }
        return result;
    }
    
}
