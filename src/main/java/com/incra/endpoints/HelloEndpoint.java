package com.incra.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
@Path("hello")
public class HelloEndpoint {

    public HelloEndpoint() {
    }

    @GET
    public Response handle() {
        Object results = "Hello There";
        return Response.status(Response.Status.OK).entity(results).build();
    }
}
