package br.com.biblioteca.dao;

import javax.persistence.EntityManager;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO instance;
	
	protected EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca-unit");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public void setUsuario(Usuario usuario){
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}
	

}
