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

import com.setupservice.controller.AlumnoController;
import com.setupservice.model.Alumno;

@Path("alumno")
public class AlumnoResource {

	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos(){
	List<Alumno>f =new AlumnoController().listarTodos();
	
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
		if(new AlumnoController().eliminar(id)){
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
		Alumno f = new AlumnoController().obtener(id);
		if (f!=null) {
			return Response.status(Response.Status.OK.getStatusCode()).entity(f).build();
		}else{
			return Response.status(Response.Status.NO_CONTENT.getStatusCode()).entity(f).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response guardar(Alumno a) {
		a=new AlumnoController().guardar(a);
		if (a!=null) {
			return Response.status(Response.Status.CREATED.getStatusCode()).entity(a).build();
		}else{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(a).build();
		}	
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(Alumno a) {
		a = new AlumnoController().actualizar(a);
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
