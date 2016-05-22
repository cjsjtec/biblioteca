package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.biblioteca.model.Item;

public class ItemDAO extends GenericDAO {
	private static ItemDAO instance;
	EntityManager entityManager = getEntityManager();

	public static ItemDAO getInstance() {
		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}

	public void Inserir(Item item) {
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
	}

	public void Alterar(Item item) {
		entityManager.getTransaction().begin();
		entityManager.merge(item);
		entityManager.getTransaction().commit();

	}
	
	public void Remover(Item item) {
		entityManager.getTransaction().begin();
		entityManager.remove(item);
		entityManager.getTransaction().commit();
	}

	public Item getItem(int id) {  	// cuidado, use o import
		return entityManager.find(Item.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItens(String nome) { 
		return entityManager
				.createQuery("select t from Item as t where t.nome LIKE :paramNome")
				.setParameter("paramNome", "%" + nome + "%")
				.getResultList();

	}
}