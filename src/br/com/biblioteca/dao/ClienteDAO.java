package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Cliente;

public class ClienteDAO {
	private static ClienteDAO instance;

	protected EntityManager entityManager;
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca-unit");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		
		return entityManager;
	}
	
	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	private ClienteDAO() {
		entityManager = getEntityManager();
	}
	
	public List<Cliente> getClientes() {
		// cuidado, use o import javax.persistence.Query
		List<Cliente> lista = entityManager.createQuery("select t from Cliente as t ").getResultList();
		return lista;
	}
	
	public void setClient(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
	}

	public void removeCliente(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
	}

}
