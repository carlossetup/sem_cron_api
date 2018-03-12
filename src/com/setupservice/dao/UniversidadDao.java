package com.setupservice.dao;

import com.setupservice.model.Universidad;

public class UniversidadDao extends GenericDao {
	public UniversidadDao() {
		super(Universidad.class);
	}
	/*public Universidad obtenerUniversidad(Carrera f) {
		try{
		em.getTransaction().begin();
		Universidad b = em.find(Universidad.class, f.getCarrId());
		em.getTransaction().commit();
		return b;
		}catch(Exception e){
			em.close();
			e.printStackTrace();
			return null;
			
		}

	}*/
}
