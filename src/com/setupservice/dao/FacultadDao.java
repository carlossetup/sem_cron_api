package com.setupservice.dao;

import java.util.List;

import com.setupservice.model.Facultad;


public class FacultadDao extends GenericDao {
	public FacultadDao() {
		super(Facultad.class);
	}
	public List<Facultad> obtenerFacuPorFilial(int filId) {
		try{
		String jpql = "FROM Facultad f WHERE filial.id=:filId and estado=true";
		em.getTransaction().begin();
		List<Facultad> f = (List<Facultad>) em.createQuery(jpql,Facultad.class).setParameter("filId",filId).getResultList();
		em.getTransaction().commit();
		return f;
		}catch(Exception e){
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			return null;
		}

	}
	
}
