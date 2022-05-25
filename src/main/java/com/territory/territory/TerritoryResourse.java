package com.territory.territory;

import java.net.URI;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/territories")
@Tag(name = "Territories")
public class TerritoryResourse {
	@Inject
	TerritoryTransformer territoryTransformer;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response createTerritory(TerritoryEntity territoryEntity) {
		territoryEntity.persist();
//		return Response.created(URI.create("/territory/" + territoryEntity.id)).build();
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllTerritories() {
		return Response.ok(TerritoryEntity.listAll()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTerritoryById(@PathParam("id") Long id) {
		return Response.ok(territoryTransformer.toResource(TerritoryEntity.findById(id))).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public Response deleteTerritory(@PathParam("id") Long id) {
		TerritoryEntity.deleteById(id);
		return Response.noContent().build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response putTerritory(@PathParam("id") Long id, Territory territory) {
		TerritoryEntity territoryEntity = TerritoryEntity.findById(id);
//		if (territoryEntity1 == null) {
//			throw new NotFoundException();
//		}
//		territoryEntity1.name = territoryEntity.name;
//		territoryEntity1.shortName = territoryEntity.shortName;
//		territoryEntity1.code = territoryEntity.code;
//		territoryEntity1.details = territoryEntity.details;
//		territoryEntity1.notes = territoryEntity.notes;
//		territoryEntity1.organizationId = territoryEntity.organizationId;
//		territoryEntity1.createdAt = territoryEntity.createdAt;
//		territoryEntity1.createdBy = territoryEntity.createdBy;
		if (Objects.nonNull(territory.getOrganization())) {
			territoryEntity.organization = territory.getOrganization();
		    }
			if (Objects.nonNull(territory.getCode())) {
				territoryEntity.code = territory.getCode();
			}
			if (Objects.nonNull(territory.getName())) {
				territoryEntity.name = territory.getName();
			}
			if (Objects.nonNull(territory.getShortName())) {
				territoryEntity.shortName = territory.getShortName();
			}
			if (Objects.nonNull(territory.getDesignation())) {
				territoryEntity.designation = territory.getDesignation();
			}
			if (Objects.nonNull(territory.getNotes())) {
				territoryEntity.notes = territory.getNotes();
			}
			if (Objects.nonNull(territory.getStatus())) {
				territoryEntity.status = territory.getStatus();
			}
			if (Objects.nonNull(territory.getCreatedBy())) {
				territoryEntity.createdBy = territory.getCreatedBy();
			}
			if (Objects.nonNull(territory.getUpdatedBy())) {
				territoryEntity.updatedBy = territory.getUpdatedBy();
			}
			if (Objects.nonNull(territory.getCreatedAt())) {
				territoryEntity.createdAt = territory.getCreatedAt();
			}
			if (Objects.nonNull(territory.getUpdatedAt())) {
				territoryEntity.updatedAt = territory.getUpdatedAt();
			}
			return Response.noContent().build();

		
		}

	}

