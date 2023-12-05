package org.marshall.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.marshall.entity.GuestEntity;
import org.marshall.service.GuestService;

@Path("/guest")
public class GuestResource {
    @Inject
    private GuestService guestService;

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
public Response createGuest(GuestEntity guestEntity){
        return Response.ok().entity(guestService.create(guestEntity)).build();
    }

}
