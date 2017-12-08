package com.incra.endpoints;

import com.google.inject.Singleton;
import com.incra.models.Incident;
import com.incra.services.IncidentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
@Singleton
@Path("incidents")
public class IncidentsEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(IncidentsEndpoint.class);

    protected IncidentService incidentService;

    @Inject
    public IncidentsEndpoint(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleOne() {
        List<Incident> incidents = incidentService.getList(0, 999);

        return Response.status(Response.Status.OK).entity(incidents).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleMany(@PathParam("id") Long id) {
        Incident incident = incidentService.getOne(id);

        return Response.status(Response.Status.OK).entity(incident).build();
    }
}
