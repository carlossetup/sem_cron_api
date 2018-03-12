package com.setupservice.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.setupservice.dao.FacultadDao;
import com.setupservice.model.Facultad;

public class FacultadController {

	public List<Facultad> listarTodos() {
		FacultadDao d = new FacultadDao();
		List<Facultad> f = (List<Facultad>) d.obtenerTodos();
		d.close();
		return f;

	}

	public boolean eliminar(int id) {
		Facultad f = new Facultad();
		f.setId(id);
		FacultadDao d = new FacultadDao();
		if (d.eliminar(f)) {
			d.close();
			return true;
		} else {
			d.close();
			return false;
		}

	}

	public Facultad obtener(int id) {
		Facultad f = new Facultad();
		f.setId(id);
		FacultadDao d = new FacultadDao();
		f = (Facultad) d.obtener(f);
		d.close();
		return f;

	}

	public Facultad guardar(Facultad facultad) {
		FacultadDao d = new FacultadDao();
		ZoneId zone = ZoneId.of("America/Asuncion");
		//facultad.setFechaInscripcion(LocalDateTime.now(zone));
		d.insertar(facultad);
		d.close();
		return facultad;

	}

	public Facultad actualizar(Facultad facultad) {
		FacultadDao d = new FacultadDao();
		facultad = (Facultad) d.actualizar(facultad);
		d.close();
		return facultad;

	}

	public List<Facultad> obtenerFacuPorFilial(int filId) {
		FacultadDao d = new FacultadDao();
		List<Facultad> f = d.obtenerFacuPorFilial(filId);
		d.close();
		return f;
	}

}
