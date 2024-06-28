package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {
    	
    	return user.getRoles() != null && user.getRoles().contains(role); // Student Code: 
    		// finish the authorize method based on BasicAuth Security Example
    	
    }
}
