package br.com.biblioteca.controller;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

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
		
		JSONObject retorno = new JSONObject();
		
		ArrayList<Emprestimo> listaEmprestimo = gson.fromJson(emprestimos, new TypeToken<ArrayList<Emprestimo>>() {}.getType());
		
		int totalEmprestimos = countEmprestimos(registro) + listaEmprestimo.size();
		
		if(totalEmprestimos > 3) {
			return retorno.put("intervencao","Há emprestimo na posse do infeliz!").toString();
		}
		
		Cliente cliente = ClienteBO.getInstance().pegarCliente(Integer.parseInt(registro));
		
		EmprestimoDAO dao = EmprestimoDAO.getInstance();
		
		JSONArray recusas = new JSONArray();
		String tipo_cliente = cliente.getTipo();
		
		for (Emprestimo emprestimo : listaEmprestimo) {
			Item item = ItemBO.getInstance().pegarItem(Integer.parseInt(emprestimo.getIdItem()));
			String especial = item.getEspecial();
			
			if(tipo_cliente.equals("A") && especial.equals("S")) {
				recusas.put(emprestimo.getNome());
				continue;
			}
			
			emprestimo.setIdCliente(registro);
			emprestimo.setStatus("A");
			dao.setEmprestimo(emprestimo);
			
			item.setEmprestado("S");
			ItemBO.getInstance().alterarStausEmprestimo(item);
		}
		
		if(recusas.length() > 0) {
			retorno.put("recusados", recusas);
		} else {
			retorno.put("sucesso", "Todos os itens inseridos com sucesso");			
		}
		
		return retorno.toString();
	}
	public int countEmprestimos(String idCliente) {
		return EmprestimoDAO.getInstance().getEmprestimos(idCliente).size();
	}
	
	public String getEmprestimos(String idCliente) {
		return new Gson().toJson(EmprestimoDAO.getInstance().getEmprestimos(idCliente));	
	}

	public String devolver(String devolvidos) {
		Gson gson = new Gson();
		ArrayList<Emprestimo> listaEmprestimo = gson.fromJson(devolvidos, new TypeToken<ArrayList<Emprestimo>>() {}.getType());
		
		for (Emprestimo emprestimo : listaEmprestimo) {
			ItemBO itembo = ItemBO.getInstance();
			
			Item item = itembo.pegarItem(Integer.parseInt(emprestimo.getIdItem()));
			item.setEmprestado("N");
			itembo.alterar(item);

			emprestimo.setStatus("S");
			EmprestimoDAO.getInstance().alterarEmprestimo(emprestimo);			
		}
		
		JSONObject retorno = new JSONObject();
		retorno.put("successo", "Tudo certo broww");
		return retorno.toString();
	}	
}
