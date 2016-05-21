package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Cliente;
import br.com.biblioteca.model.Item;

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
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(int id) {
//		// cuidado, use o import javax.persistence.Query
//		List<Cliente> lista = entityManager.createQuery("select t from Cliente as t ").getResultList();
//		return lista;
		
		return entityManager
//				.createQuery("select t from Cliente as t")
				.createQuery("select t from Cliente as t where id LIKE :paramId")
				.setParameter("paramId", id)
				.getResultList();
	}
	
	public void setClient(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
	}
	
	public void alterarCliente(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
	}
	
	public Cliente getCliente(int id) {  	// cuidado, use o import
		return entityManager.find(Cliente.class, id);
	}
	
	public void removeCliente(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
	}

}
