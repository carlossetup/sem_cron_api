package com.setupservice.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.setupservice.dao.UniversidadDao;
import com.setupservice.model.Universidad;

public class UniversidadController {
	

	public List<Universidad> listarTodos() {
		UniversidadDao d =new UniversidadDao();
		List<Universidad> u = (List<Universidad>)d.obtenerTodos();
		d.close();
			return u;	
	}
	public boolean eliminar(int id) {
		Universidad u =new Universidad();
		u.setId(id);
		UniversidadDao d =new UniversidadDao();
		if (d.eliminar(u)) {
			d.close();
			return true;
		}else{
			d.close();
			return false;
		}
	}
	public Universidad obtener(int id) {
		Universidad u =new Universidad();
		u.setId(id);
		UniversidadDao d =new UniversidadDao();
		u=(Universidad) d.obtener(u);
		d.close();
		return u;
		
	}
	public Universidad guardar(Universidad universidad) {
		ZoneId zone = ZoneId.of("America/Asuncion");
		//universidad.setFechaInscripcion(LocalDateTime.now(zone));
		UniversidadDao d =new UniversidadDao();
	    d.insertar(universidad);
		d.close();
		return universidad;
		
	}
	public Universidad actualizar(Universidad universidad) {
		UniversidadDao d =new UniversidadDao();
		universidad = (Universidad)d.actualizar(universidad);
		d.close();
		return universidad;
		
	}

}
