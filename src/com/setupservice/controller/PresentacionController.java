package com.setupservice.controller;

import java.util.List;
import com.setupservice.dao.PresentacionDao;
import com.setupservice.model.Presentacion;


public class PresentacionController {
	
	public List<Presentacion> listarTodos() {
		PresentacionDao d = new PresentacionDao();
		List<Presentacion> a = (List<Presentacion>) d.obtenerTodos();
		d.close();
		return a;

	}
	

	public boolean eliminar(int id) {
		Presentacion a = new Presentacion();
		a.setId(id);
		PresentacionDao d = new PresentacionDao();
		if (d.eliminar(a)) {
			d.close();
			return true;
		} else {
			d.close();
			return false;
		}

	}

	public Presentacion obtener(int id) {
		Presentacion a = new Presentacion();
		a.setId(id);
		PresentacionDao d = new PresentacionDao();
		a = (Presentacion) d.obtener(a);
		d.close();
		return a;

	}

	public Presentacion guardar(Presentacion a) {
		a.setId(null);
		//ZoneId zone = ZoneId.of("America/Asuncion");
		PresentacionDao d = new PresentacionDao();
		try {
			a = (Presentacion) d.insertar(a);
			d.close();
			return a;
		} catch (Exception e) {
			d.close();
			a = null;
			return a;

		}

	}

	public Presentacion actualizar(Presentacion a) {
		PresentacionDao d = new PresentacionDao();
		a=(Presentacion)d.actualizar(a);
		d.close();
		return a;
		
	}

}
