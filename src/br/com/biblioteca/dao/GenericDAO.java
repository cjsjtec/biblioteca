package br.com.biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	protected EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca-unit");//Troca no persistence 
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
