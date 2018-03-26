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

import com.setupservice.controller.AlumnoPresentacionController;
import com.setupservice.model.AlumnoPresentacion;

@Path("alumno_presentacion")
public class AlumnoPresentacionResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos(){
	List<AlumnoPresentacion>f =new AlumnoPresentacionController().listarTodos();
	
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("id") int id) {
		if(new AlumnoPresentacionController().eliminar(id)){
		   return Response.status(Response.Status.OK.getStatusCode()).build();
		}else{
			return Response.status(Response.Status.NOT_FOUND.getStatusCode()).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtener(@PathParam("id") int id) {
		AlumnoPresentacion f = new AlumnoPresentacionController().obtener(id);
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response guardar(AlumnoPresentacion a) {
		a=new AlumnoPresentacionController().guardar(a);
		if (a!=null) {
			return Response.status(Response.Status.CREATED.getStatusCode()).entity(a).build();
		}else{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(a).build();
		}	
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(AlumnoPresentacion a) {
		a = new AlumnoPresentacionController().actualizar(a);
		if(a!=null){
			   return Response.status(Response.Status.OK.getStatusCode()).entity(a).build();
			}else{
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).build();
			}
	}
	
	/*
	@GET
	@Path("/facultad_por_uni/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerFacPorFilial(@PathParam("id") int filId) {
		List<Alumno>f =new AlumnoController().obtenerFacuPorFilial(filId);
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	*/
	
}
