/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.factory.listtornamentcreate;

import ru.rsatu.rest_app.pojo.ListTournament;
import ru.rsatu.rest_app.pojo.ResultStatus;

/**
 *
 * @author andrey
 */
public class CreateListTournamentResponse {
    ListTournament listTournament;
    private ResultStatus resultStatus;

    public ListTournament getListTournament() {
        return listTournament;
    }

    public void setListTournament(ListTournament listTournament) {
        this.listTournament = listTournament;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
