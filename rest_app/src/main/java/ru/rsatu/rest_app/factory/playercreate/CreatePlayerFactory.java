/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.playercreate;

import javax.persistence.EntityManager;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;
import ru.rsatu.rest_app.pojo.Player;

/**
 *
 * @author andrey
 */
public class CreatePlayerFactory {
    
    public CreatePlayerResponse createPlayer(EntityManager em, CreatePlayerRequest request) throws RestAppException{
        CreatePlayerResponse result = new CreatePlayerResponse();
        try {
            Player player = request.getPlayer();
            em.persist(player);
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_OK);
            resultStatus.setErrorText(Constants.ERROR_TEXT_OK);
            result.setResultStatus(resultStatus);
            result.setPlayer(player);
            
        } catch (Exception ex) {
            throw new RestAppException("Unable to create teamList");
        }
        return result;
    }
}
