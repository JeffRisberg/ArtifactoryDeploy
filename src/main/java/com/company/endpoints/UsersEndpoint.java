package com.company.endpoints;

import com.company.models.User;
import com.company.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
@Singleton
@Path("users")
public class UsersEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(UsersEndpoint.class);

    protected UserService userService;

    @Inject
    public UsersEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handle() {
        List<User> users = userService.getList(0, 999);

        return Response.status(Response.Status.OK).entity(users).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleMany(@PathParam("id") Long id) {
        User user = userService.getOne(id);

        return Response.status(Response.Status.OK).entity(user).build();
    }

    @POST
    public Response handlePost() {
        Object results = "POST UPDATE";

        return Response.status(Response.Status.OK).entity(results).build();
    }
}
