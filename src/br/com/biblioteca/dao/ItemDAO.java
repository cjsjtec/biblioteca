package br.com.biblioteca.dao;

import javax.persistence.EntityManager;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Item;

public class ItemDAO {
	private static ItemDAO instance;

	protected EntityManager entityManager;

	public static ItemDAO getInstance() {
		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	private ItemDAO() {
		entityManager = getEntityManager();
	}

	public void setItem(Item item) {
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
	
	}
}