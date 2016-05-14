package br.com.biblioteca.dao;

import br.com.biblioteca.model.Usuario;

public class UsuarioDAO extends GenericDAO{
	private static UsuarioDAO instance;	
	
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
		
	public void setUsuario(Usuario usuario){
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	
	}
	

}
