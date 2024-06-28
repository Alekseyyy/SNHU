package com.gamingroom.gameauth;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gamingroom.gameauth.auth.GameAuthenticator;
import com.gamingroom.gameauth.auth.GameAuthorizer;
import com.gamingroom.gameauth.auth.GameUser;

import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.controller.RESTClientController;

import com.gamingroom.gameauth.healthcheck.AppHealthCheck;
import com.gamingroom.gameauth.healthcheck.HealthCheckController;


public class GameAuthApplication extends Application<Configuration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

	@Override
	public void initialize(Bootstrap<Configuration> b) {
	}

	@Override
	public void run(Configuration c, Environment e) throws Exception 
	{
		LOGGER.info("Registering REST resources");
		
		final Client client = new JerseyClientBuilder(e).build("DemoRESTClient"); // Student Code: Create io.dropwizard.client.JerseyClientBuilder instance and give 
		    // it io.dropwizard.setup.Environment reference (based on BasicAuth Security Example)
		    // Note that: I had to reference [1] when correcting for errors in my original implementation.

		// Application health check
		e.healthChecks().register("APIHealthCheck", new AppHealthCheck(client));

		// Run multiple health checks
		e.jersey().register(new HealthCheckController(e.healthChecks()));
		
		//Setup Basic Security
		e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
                .setAuthenticator(new GameAuthenticator())
                .setAuthorizer(new GameAuthorizer())
                .setRealm("App Security")
                .buildAuthFilter()));

		// Register REST Services
        e.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
        e.jersey().register(RolesAllowedDynamicFeature.class);
        e.jersey().register(new GameUserRESTController(
        	e.getValidator()
        )); // Student Code: register GameUserRESTController (based on BasicAuth Security Example)
          // NOTE that I cited [1] to correct errors in my implementation.
	}

	public static void main(String[] args) throws Exception {
		new GameAuthApplication().run(args);
	}
}

/*
 * References
 * 1. "Brandon-Hobbs (n.d.). GameAuthApplication.java. GitHub Repository. Retrieved on May. 30, 2024 from:
 *     https://github.com/Brandon-Hobbs/SNHU-CS230/blob/main/Module%204/gameauth%20Fixed/src/main/java/com/gamingroom/gameauth/GameAuthApplication.java
 */