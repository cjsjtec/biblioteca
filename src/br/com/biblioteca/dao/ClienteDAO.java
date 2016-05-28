package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.model.Cliente;

public class ClienteDAO extends GenericDAO {
	private static ClienteDAO instance;
	protected EntityManager entityManager;
	
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
	public List<Cliente> getClientes(String parametro, String valor) {

		Query q = entityManager.createQuery("select t from Cliente as t");
		
		switch (parametro) {
			case "CPF":
				q = entityManager.createQuery("select t from Cliente as t where cpf = :paramCpf");
				q.setParameter("paramCpf", valor);
				break;
			case "NOME":
				q = entityManager.createQuery("select t from Cliente as t where nome LIKE :paramNome");
				q.setParameter("paramNome", "%" + valor + "%");
				break;
			case "TIPO":
				q = entityManager.createQuery("select t from Cliente as t where tipo = :paramTpo");
				q.setParameter("paramTipo", valor );
				break;
		}
		return q.getResultList();
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
