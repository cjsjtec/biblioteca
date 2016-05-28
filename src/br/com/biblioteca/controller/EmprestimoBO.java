package br.com.biblioteca.controller;

import java.util.ArrayList;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Cliente;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Item;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EmprestimoBO {
	private static EmprestimoBO instance;
 
    public static EmprestimoBO getInstance() {
        if (instance == null) {
            instance = new EmprestimoBO();
        }
        return instance;
    }

	public String analisar(String registro, String emprestimos) {
		Gson gson = new Gson();
		
		ArrayList<Emprestimo> listaEmprestimo = gson.fromJson(emprestimos, new TypeToken<ArrayList<Emprestimo>>() {}.getType());
		
		Cliente cliente = ClienteBO.getInstance().pegarCliente(Integer.parseInt(registro));
		
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		
		ArrayList<String> retorno = new ArrayList<String>();
				
		for (Emprestimo emprestimo : listaEmprestimo) {
			Item item = ItemBO.getInstance().pegarItem(Integer.parseInt(emprestimo.getIdItem()));
			
			if(item.getTipo() == "E" && cliente.getTipo() == "A") {
				retorno.add(emprestimo.getNome());
				continue;
			}
			
			item.setEmprestado("S");
			
			emprestimo.setIdCliente(registro);
			emprestimo.setStatus("A");
			dao.setImprestimo(emprestimo);
			
			ItemBO.getInstance().alterar(item);
		}
		
		return null;
	}
}
