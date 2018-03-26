package com.setupservice.controller;

import java.util.List;




import com.setupservice.dao.AlumnoPresentacionDao;
import com.setupservice.model.AlumnoPresentacion;


public class AlumnoPresentacionController {
	
	public List<AlumnoPresentacion> listarTodos() {
		AlumnoPresentacionDao d = new AlumnoPresentacionDao();
		List<AlumnoPresentacion> a = (List<AlumnoPresentacion>) d.obtenerTodos();
		d.close();
		return a;

	}
	

	public boolean eliminar(int id) {
		AlumnoPresentacion a = new AlumnoPresentacion();
		a.setId(id);
		AlumnoPresentacionDao d = new AlumnoPresentacionDao();
		if (d.eliminar(a)) {
			d.close();
			return true;
		} else {
			d.close();
			return false;
		}

	}

	public AlumnoPresentacion obtener(int id) {
		AlumnoPresentacion a = new AlumnoPresentacion();
		a.setId(id);
		AlumnoPresentacionDao d = new AlumnoPresentacionDao();
		a = (AlumnoPresentacion) d.obtener(a);
		d.close();
		return a;

	}

	public AlumnoPresentacion guardar(AlumnoPresentacion a) {
		a.setId(null);
		//ZoneId zone = ZoneId.of("America/Asuncion");
		AlumnoPresentacionDao d = new AlumnoPresentacionDao();
		try {
			a = (AlumnoPresentacion) d.insertar(a);
			d.close();
			return a;
		} catch (Exception e) {
			d.close();
			a = null;
			return a;

		}

	}

	public AlumnoPresentacion actualizar(AlumnoPresentacion a) {
		AlumnoPresentacionDao d = new AlumnoPresentacionDao();
		a=(AlumnoPresentacion)d.actualizar(a);
		d.close();
		return a;
		
	}

}
