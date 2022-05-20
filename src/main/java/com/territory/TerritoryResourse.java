package com.territory;

import java.net.URI;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/territories")
public class TerritoryResourse {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response createTerritory(TerritoryEntity territoryEntity) {
		territoryEntity.persist();
		return Response.created(URI.create("/territory/" + territoryEntity.id)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllTerritories() {
		return Response.ok(TerritoryEntity.listAll()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TerritoryEntity getTerritoryById(@PathParam("id") Long id) {
		return TerritoryEntity.findById(id);
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public void deleteTerritory(@PathParam("id") Long id) {
		TerritoryEntity.deleteById(id);

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public TerritoryEntity putTerritory(@PathParam("id") Long id, TerritoryEntity territoryEntity) {

		TerritoryEntity territoryEntity1 = TerritoryEntity.findById(id);
		if (territoryEntity1 == null) {
			throw new NotFoundException();
		}
		territoryEntity1.name = territoryEntity.name;
		territoryEntity1.shortName = territoryEntity.shortName;
		territoryEntity1.code = territoryEntity.code;
		territoryEntity1.details = territoryEntity.details;
		territoryEntity1.notes = territoryEntity.notes;
		territoryEntity1.organizationId = territoryEntity.organizationId;
		territoryEntity1.createdAt= territoryEntity.createdAt;
		territoryEntity1.createdBy = territoryEntity.createdBy;
		return territoryEntity1;

	}

}
