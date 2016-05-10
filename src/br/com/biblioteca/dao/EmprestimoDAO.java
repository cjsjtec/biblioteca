package br.com.biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Emprestimo;

public class EmprestimoDAO {
	private static EmprestimoDAO instance;
	
	protected EntityManager entityManager;
	
	public static EmprestimoDAO getInstance() {
		if (instance == null) {
			instance = new EmprestimoDAO();
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
	
	private EmprestimoDAO() {
		entityManager = getEntityManager();
	}

	public void setImprestimo(Emprestimo emprestimo) {
		entityManager.getTransaction().begin();
		entityManager.persist(emprestimo);
		entityManager.getTransaction().commit();
	
	}

}
