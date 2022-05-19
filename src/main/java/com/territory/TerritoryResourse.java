package com.territory;

import java.net.URI;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/territories")
public class TerritoryResourse {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response createEmployee(TerritoryEntity territoryEntity) {
		territoryEntity.persist();
		return Response.created(URI.create("/territory/" + territoryEntity.id)).build();
	}
	
	 @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response listAllTerritories() {
	        return Response.ok(TerritoryEntity.listAll()).build();
	    }
    
}
