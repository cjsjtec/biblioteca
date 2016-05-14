package br.com.biblioteca.controller;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

public class UsuarioBO {
	private static UsuarioBO instance;
	
	private UsuarioBO(){
		
	}
	
	public static UsuarioBO getInstance(){
		if(instance == null){
			instance = new UsuarioBO();
		}
		return instance;
	}
	
	public boolean salvar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		dao.setUsuario(usuario);
		// aqui deve ir tratamentos de erros 
		return true ;
	}

}
