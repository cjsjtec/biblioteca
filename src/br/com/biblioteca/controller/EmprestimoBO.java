package br.com.biblioteca.controller;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Emprestimo;

public class EmprestimoBO {
	private static EmprestimoBO instance;
 
    public static EmprestimoBO getInstance() {
        if (instance == null) {
            instance = new EmprestimoBO();
        }
        return instance;
    }

	public String analisar(String documento, String emprestimos) {
		Gson gson = new Gson();
		
		ArrayList<Emprestimo> listaEmprestimo = gson.fromJson(emprestimos, new TypeToken<ArrayList<Emprestimo>>() {}.getType());

		for (Emprestimo emprestimo : listaEmprestimo) {
			EmprestimoDAO dao = EmprestimoDAO.getInstance();
			Integer idCliente = Integer.parseInt(documento);
			emprestimo.setIdCliente(idCliente);		
			dao.setImprestimo(emprestimo);			
		}
		
		return null;
	}
}
