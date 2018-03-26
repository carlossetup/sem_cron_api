package com.setupservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.setupservice.model.AbstractEntity;

public abstract class GenericDao {
	public static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("sem_cron");

	// @Resource
	private javax.transaction.UserTransaction ut;

	// @PersistenceContext
	public EntityManager em;

	private Class<?> entity;

	public GenericDao(Class<?> entity) {
		this.em = EMF.createEntityManager();
		this.entity = entity;
	}

	public AbstractEntity insertar(AbstractEntity a) {
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			return a;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			a = null;
			return a;

		}

	}

	public AbstractEntity actualizar(AbstractEntity a) {
		try {
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			a = null;
			return a;
		}

	}

	public boolean eliminar(AbstractEntity a) {
		em.getTransaction().begin();
		a = (AbstractEntity) em.find(this.entity, a.getId());
		if (a != null) {
			em.remove(a);
			em.getTransaction().commit();
			return true;
		} else {
			em.close();
			return false;
		}
	}

	public AbstractEntity obtener(AbstractEntity a) {
		try {
			em.getTransaction().begin();
			AbstractEntity b = (AbstractEntity) em.find(this.entity, a.getId());
			em.getTransaction().commit();
			return b;
		} catch (Exception e) {
			em.close();
			return null;
		}

	}

	public void close() {
		em.close();
	}

	public List<?> obtenerTodos() {
		List<?> list = null;
		em.getTransaction().begin();
		list = em.createQuery("From " + entity.getSimpleName(), this.entity).getResultList();
		em.getTransaction().commit();
		return list;
	}

}