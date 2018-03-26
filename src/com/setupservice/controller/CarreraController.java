package com.setupservice.controller;

import java.util.List;




import com.setupservice.dao.CarreraDao;
import com.setupservice.model.Carrera;



public class CarreraController {
	
	public List<Carrera> listarTodos() {
		CarreraDao d = new CarreraDao();
		List<Carrera> a = (List<Carrera>) d.obtenerTodos();
		d.close();
		return a;

	}
	

	public boolean eliminar(int id) {
		Carrera a = new Carrera();
		a.setId(id);
		CarreraDao d = new CarreraDao();
		if (d.eliminar(a)) {
			d.close();
			return true;
		} else {
			d.close();
			return false;
		}

	}

	public Carrera obtener(int id) {
		Carrera a = new Carrera();
		a.setId(id);
		CarreraDao d = new CarreraDao();
		a = (Carrera) d.obtener(a);
		d.close();
		return a;

	}

	public Carrera guardar(Carrera a) {
		a.setId(null);
		//ZoneId zone = ZoneId.of("America/Asuncion");
		CarreraDao d = new CarreraDao();
		try {
			a = (Carrera) d.insertar(a);
			d.close();
			return a;
		} catch (Exception e) {
			d.close();
			a = null;
			return a;

		}

	}

	public Carrera actualizar(Carrera a) {
		CarreraDao d = new CarreraDao();
		a=(Carrera)d.actualizar(a);
		d.close();
		return a;
		
	}

}
