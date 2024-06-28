package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
 
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword()))
        	return Optional.of(new GameUser(credentials.getUsername(), 
        		VALID_USERS.get(credentials.getUsername())
        		)
        	); // Student code: Finish the authorize method based 
               // on BasicAuth Security Example for new GameUser
        	
        return Optional.empty();
    }
}
