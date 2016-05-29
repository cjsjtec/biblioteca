package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.hibernate.Query;
import javax.persistence.Query;

import br.com.biblioteca.model.Cliente;
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

	public void setEmprestimo(Emprestimo emprestimo) {
		entityManager.getTransaction().begin();
		entityManager.persist(emprestimo);
		entityManager.getTransaction().commit();	
	}
	
	public void alterarEmprestimo(Emprestimo emprestimo) {
		entityManager.getTransaction().begin();
		entityManager.merge(emprestimo);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprestimo> getEmprestimos(String idCliente) {
		//TODO sou fraco nao consegui retornar um result do count ¬¬'
//		return entityManager.createQuery("select count(*) from Emprestimo as t where t.idCliente = :paramIdCliente")
//		.setParameter("paramIdCliente", idCliente)
//		.getMaxResults();
		Query query = entityManager.createQuery("select t from Emprestimo as t where t.idCliente = :paramIdCliente and t.status = :paramStatus")
		.setParameter("paramIdCliente", idCliente)
		.setParameter("paramStatus", "A");
	
		return query.getResultList();
	}
}
