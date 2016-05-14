package br.com.biblioteca.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		Usuario d = new Usuario();
		d.setNome("Denis Alves");
		d.setSenha("123");
		d.setUsername("dlogin");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(d);
		manager.getTransaction().commit();

	}

}
