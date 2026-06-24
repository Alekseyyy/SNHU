package com.gamingroom.gameauth.controller;
 
import io.dropwizard.auth.Auth;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gamingroom.gameauth.auth.GameUser;
import com.gamingroom.gameauth.dao.GameUserDB;
import com.gamingroom.gameauth.representations.GameUserInfo;



@Path("/gameusers") // Student code: Add path annotation for gameusers 
    // Note that I consulted [1] and [2] when adding the @Path annotation
@Produces(MediaType.APPLICATION_JSON)
public class GameUserRESTController {
 
    private final Validator validator;
 
    public GameUserRESTController(Validator validator) {
        this.validator = validator;
    }
 
    @PermitAll
    @GET
    public Response getGameUsers(@Auth GameUser user) {
        return Response.ok(GameUserDB.getGameUsers()).build();
    }
 
    // FIXME: Add RolesAllowed annotation for USER based on BasicAuth Security Example 

    @GET
    @Path("/{id}")
    @RolesAllowed({"USER"})
    public Response getGameUserById(@PathParam("id") Integer id,@Auth GameUser user) {
    	//You can validate here if user is watching his record
    	/*if(id != user.getId()){
    			//Not allowed
    	}*/
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
        if (gameUserInfo != null)
            return Response.ok(gameUserInfo).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }


    // FIXME: Add RolesAllowed annotation for ADMIN based on BasicAuth Security Example 

    @POST
    @RolesAllowed({"ADMIN"})
    public Response createGameUser(GameUserInfo gameUserInfo, @Auth GameUser user) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo e = GameUserDB.getGameUser(gameUserInfo.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            GameUserDB.updateGameUser(gameUserInfo.getId(), gameUserInfo);
            return Response.created(new URI("/gameusers/" + gameUserInfo.getId()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
 
    @PUT
    @Path("/{id}")
    public Response updateGameUserById(@PathParam("id") Integer id, GameUserInfo gameUserInfo) {
        // validation
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo e = GameUserDB.getGameUser(gameUserInfo.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            gameUserInfo.setId(id);
            GameUserDB.updateGameUser(id, gameUserInfo);
            return Response.ok(gameUserInfo).build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
 
    @DELETE
    @Path("/{id}")
    public Response removeGameUserById(@PathParam("id") Integer id) {
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
        if (gameUserInfo != null) {
            GameUserDB.removeGameUser(id);
            return Response.ok().build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
}

/*
 * References
 * 1. Oracle (n.d.). Annotations Basics. Java Documentation. Retrieved on May 30, 2024 from:
 *     https://docs.oracle.com/javase/tutorial/java/annotations/basics.html
 * 2. Magnolia (n.d.). How to create a custom Java-based REST endpoint. Retrieved on May 30, 2024 from:
 *     https://docs.magnolia-cms.com/product-docs/6.3/developing/development-how-tos/how-to-create-a-custom-java-based-rest-endpoint/
 */