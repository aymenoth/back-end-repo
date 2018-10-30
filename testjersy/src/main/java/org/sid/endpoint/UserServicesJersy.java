package org.sid.endpoint;

import java.awt.PageAttributes.MediaType;
import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.sid.entities.User;
import org.sid.services.IuserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.research.ws.wadl.Application;

@Component
@Path("/index")
public class UserServicesJersy {

	public static final org.jboss.logging.Logger logger = LoggerFactory.logger(UserServicesJersy.class);
    @Autowired
	private IuserServices iuserServices;

	@POST
	@Path("/create")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		try {
			iuserServices.addUser(user);
			return Response.created(URI.create("okkk")).build();
		} catch (Exception e) {
			return Response.created(URI.create("KOOOOOO")).build();
		}

	}
	
	// get all users
	@GET
	@Path("/users")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	
	public Response getAllUsers() {
		List<User> users =iuserServices.getAllUsers();
		return Response.ok(users).build();
	}
	
	
	// delete Methode 
	
	@DELETE
	@Path("/userId/{userId}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	
	Response deleteUser(@ PathParam("userId") int id) {
		iuserServices.deleteUser(id);
		return Response.noContent().build();
		
		
	}
	
	
	
	
	@PUT
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Path("/user/update")
	
	public Response updateUser(User user) {
		iuserServices.updateUser(user);
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	
	public Response getUserByID(@PathParam ("id") int id) {
		
		User user=iuserServices.getUserById(id);
	return	Response.ok(user).build();
		
	}
	
	

}
