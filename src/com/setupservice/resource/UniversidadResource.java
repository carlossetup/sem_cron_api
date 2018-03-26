package com.setupservice.resource;

import java.util.List;

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

import com.setupservice.controller.UniversidadController;
import com.setupservice.model.Universidad;


@Path("universidad")
public class UniversidadResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Universidad> u = new UniversidadController().listarTodos();

		if (u != null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(u).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(u).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("id") int id) {
		if (new UniversidadController().eliminar(id)) {
			return Response.status(Response.Status.OK.getStatusCode()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("id") int id) {
		Universidad u = new UniversidadController().obtener(id);
		if (u != null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(u).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(u).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(Universidad universidad) {
		new UniversidadController().guardar(universidad);
		if (Response.Status.CREATED.getStatusCode() == 201) {
			return Response.status(Response.Status.CREATED.getStatusCode()).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidad universidad) {
		universidad=new UniversidadController().actualizar(universidad);
		if (universidad!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(universidad).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
		}
	}

}