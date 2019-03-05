/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.rest_app.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.rsatu.rest_app.constants.Constants;
import ru.rsatu.rest_app.factory.listtornamentcreate.CreateListTournamentFactory;
import ru.rsatu.rest_app.factory.listtornamentcreate.CreateListTournamentRequest;
import ru.rsatu.rest_app.factory.listtornamentcreate.CreateListTournamentResponse;
import ru.rsatu.rest_app.factory.teamcreate.CreateTeamFactory;
import ru.rsatu.rest_app.factory.teamcreate.CreateTeamRequest;
import ru.rsatu.rest_app.factory.teamcreate.CreateTeamResponse;
import ru.rsatu.rest_app.factory.playercreate.CreatePlayerFactory;
import ru.rsatu.rest_app.factory.playercreate.CreatePlayerRequest;
import ru.rsatu.rest_app.factory.playercreate.CreatePlayerResponse;
import ru.rsatu.rest_app.factory.tournamentcreate.CreateTournamentFactory;
import ru.rsatu.rest_app.factory.tournamentcreate.CreateTournamentRequest;
import ru.rsatu.rest_app.factory.tournamentcreate.CreateTournamentResponse;
import ru.rsatu.rest_app.factory.userscreate.CreateUsersFactory;
import ru.rsatu.rest_app.factory.userscreate.CreateUsersRequest;
import ru.rsatu.rest_app.factory.userscreate.CreateUsersResponse;
import ru.rsatu.rest_app.pojo.ListTournament;
import ru.rsatu.rest_app.pojo.Player;
import ru.rsatu.rest_app.pojo.RestAppException;
import ru.rsatu.rest_app.pojo.ResultStatus;
import ru.rsatu.rest_app.pojo.Team;
import ru.rsatu.rest_app.pojo.Tournament;
import ru.rsatu.rest_app.pojo.Users;

/**
 *
 * @author npetrov
 */
@Stateless
@Path("/gate")
public class RestGate {

    @PersistenceContext(unitName = "rest_app")
    private EntityManager entityManager;
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsers")
    public  List<Users> getUsers() {
        String hql = "select t FROM users t ";
        Query query = entityManager.createQuery(hql);
        List<Users> users = query.getResultList();
        return users;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getListTournament")
    public List<ListTournament> getListTournaments() {
        String hql = "select t FROM listTournament t ";
        Query query = entityManager.createQuery(hql);
        List<ListTournament> listTournament = query.getResultList();
        return listTournament;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTournament")
    public List<Tournament> getTournaments() {
        String hql = "select t FROM tournament t   ";
        Query query = entityManager.createQuery(hql);
        List<Tournament> tournament = query.getResultList();
        return tournament;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTeam")
    public List<Team> getTeams() {
        String hql = "select t FROM team t ";
        Query query = entityManager.createQuery(hql);
        List<Team> team = query.getResultList();
        return team;
    }
    //left join t.players p 
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPlayer")
    public List<Player> getPlayers() {
        String hql = "select p from player p";
        Query query = entityManager.createQuery(hql);
        List<Player> team = query.getResultList();
        return team;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateTournament")
    public List<Player> updateTournaments() {
        String hql = "select p from player p";
        Query query = entityManager.createQuery(hql);
        List<Player> team = query.getResultList();
        return team;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("createTeam")
    public CreateTeamResponse createTeam(CreateTeamRequest request) {
        CreateTeamResponse response = null;
        try {
            response = new CreateTeamFactory().createTeam(entityManager, request);
        } catch (RestAppException ex) {
            response = new CreateTeamResponse();
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_ERROR);
            resultStatus.setErrorText(Constants.ERROR_TEXT_ERROR);
            response.setResultStatus(resultStatus);
        }
        return response;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("createPlayer")
    public CreatePlayerResponse createPlayer(CreatePlayerRequest request) {
        CreatePlayerResponse response = null;
        try {
            response = new CreatePlayerFactory().createPlayer(entityManager, request);
        } catch (RestAppException ex) {
            response = new CreatePlayerResponse();
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_ERROR);
            resultStatus.setErrorText(Constants.ERROR_TEXT_ERROR);
            response.setResultStatus(resultStatus);
        }
        return response;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("checkUsers")
    public boolean checkUsers(CreateUsersRequest request) {
        boolean result = false;
        String hql = "select p from users p";
        Query query = entityManager.createQuery(hql);
        List<Users> users = query.getResultList();
        Users usr = request.getUsers();
        for (int i = 0; i < users.size(); i++){
            //result=result+users.get(i).getPassword();
            //result=result+users.get(i).getUsername ();
            if (users.get(i).equals(usr)) {
                result=true;
            }
         }
        return result; 
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("createUsers")
    public CreateUsersResponse createUsers(CreateUsersRequest request) {
        CreateUsersResponse response = null;
        try {
            response = new CreateUsersFactory().createUsers(entityManager, request);
        } catch (RestAppException ex) {
            response = new CreateUsersResponse();
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_ERROR);
            resultStatus.setErrorText(Constants.ERROR_TEXT_ERROR);
            response.setResultStatus(resultStatus);
        }
        return response;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("createTournament")
    public CreateTournamentResponse createTournament(CreateTournamentRequest request) {
        CreateTournamentResponse response = null;
        try {
            response = new CreateTournamentFactory().createTournament(entityManager, request);
        } catch (RestAppException ex) {
            response = new CreateTournamentResponse();
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_ERROR);
            resultStatus.setErrorText(Constants.ERROR_TEXT_ERROR);
            response.setResultStatus(resultStatus);
        }
        return response;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("createListTournament")
    public CreateListTournamentResponse createListTournament(CreateListTournamentRequest request) {
        CreateListTournamentResponse response = null;
        try {
            response = new CreateListTournamentFactory().createListTournament(entityManager, request);
        } catch (RestAppException ex) {
            response = new CreateListTournamentResponse();
            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setErrorCode(Constants.ERROR_CODE_ERROR);
            resultStatus.setErrorText(Constants.ERROR_TEXT_ERROR);
            response.setResultStatus(resultStatus);
        }
        return response;
    }
    
}
