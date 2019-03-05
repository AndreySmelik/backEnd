/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.userscreate;

import javax.persistence.EntityManager;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;
import ru.rsatu.rest_app.pojo.Users;

/**
 *
 * @author andrey
 */
public class CreateUsersFactory {
    public CreateUsersResponse createUsers(EntityManager em, CreateUsersRequest request) throws RestAppException{
        CreateUsersResponse result = new CreateUsersResponse();
        try {
            Users users = request.getUsers();
            em.persist(users);
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_OK);
            resultStatus.setErrorText(Constants.ERROR_TEXT_OK);
            result.setResultStatus(resultStatus);
            result.setUsers(users);
            
        } catch (Exception ex) {
            throw new RestAppException("Unable to create users");
        }
        return result;
    }
}
