package com.setupservice.controller;

import java.util.List;




import com.setupservice.dao.AlumnoDao;
import com.setupservice.model.Alumno;


public class AlumnoController {
	
	public List<Alumno> listarTodos() {
		AlumnoDao d = new AlumnoDao();
		List<Alumno> a = (List<Alumno>) d.obtenerTodos();
		d.close();
		return a;

	}
	

	public boolean eliminar(int id) {
		Alumno a = new Alumno();
		a.setId(id);
		AlumnoDao d = new AlumnoDao();
		if (d.eliminar(a)) {
			d.close();
			return true;
		} else {
			d.close();
			return false;
		}

	}

	public Alumno obtener(int id) {
		Alumno a = new Alumno();
		a.setId(id);
		AlumnoDao d = new AlumnoDao();
		a = (Alumno) d.obtener(a);
		d.close();
		return a;

	}

	public Alumno guardar(Alumno a) {
		a.setId(null);
		//ZoneId zone = ZoneId.of("America/Asuncion");
		AlumnoDao d = new AlumnoDao();
		try {
			a = (Alumno) d.insertar(a);
			d.close();
			return a;
		} catch (Exception e) {
			d.close();
			a = null;
			return a;

		}

	}

	public Alumno actualizar(Alumno a) {
		AlumnoDao d = new AlumnoDao();
		a=(Alumno)d.actualizar(a);
		d.close();
		return a;
		
	}

}
