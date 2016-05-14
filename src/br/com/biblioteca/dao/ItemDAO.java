package br.com.biblioteca.dao;

import br.com.biblioteca.model.Item;

public class ItemDAO extends GenericDAO {
	private static ItemDAO instance;

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
}