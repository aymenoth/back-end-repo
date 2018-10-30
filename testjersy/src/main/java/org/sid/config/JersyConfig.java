package org.sid.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.endpoint.UserServicesJersy;
import org.springframework.stereotype.Component;
@Component
public class JersyConfig extends ResourceConfig{
	public JersyConfig() {
		register(UserServicesJersy.class);
	}

}
