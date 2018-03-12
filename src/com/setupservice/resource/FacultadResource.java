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

import com.setupservice.controller.FacultadController;
import com.setupservice.model.Facultad;

@Path("facultad")
public class FacultadResource {
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos(){
	List<Facultad>f =new FacultadController().listarTodos();
	
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("id") int id) {
		if(new FacultadController().eliminar(id)){
		   return Response.status(Response.Status.OK.getStatusCode()).build();
		}else{
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).build();
		}
	}
	
	@GET
	@Path("/obtener/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("id") int id) {
		Facultad f = new FacultadController().obtener(id);
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	@POST
	@Path("/guardar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response guardar(Facultad facultad) {
		facultad=new FacultadController().guardar(facultad);
		if (facultad!=null) {
			return Response.status(Response.Status.CREATED.getStatusCode()).entity(facultad).build();
		}else{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(facultad).build();
		}	
	}
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Facultad facultad) {
		facultad = new FacultadController().actualizar(facultad);
		if(facultad!=null){
			   return Response.status(Response.Status.OK.getStatusCode()).entity(facultad).build();
			}else{
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
			}
	}
	@GET
	@Path("/facultad_por_filial/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerFacPorFilial(@PathParam("id") int filId) {
		List<Facultad>f =new FacultadController().obtenerFacuPorFilial(filId);
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
}
