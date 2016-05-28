package br.com.biblioteca.controller;

import com.google.gson.Gson;

import br.com.biblioteca.dao.ClienteDAO;
import br.com.biblioteca.dao.ItemDAO;
import br.com.biblioteca.model.Cliente;
import br.com.biblioteca.model.Item;

public class ClienteBO {
	private static ClienteBO instance;

    private ClienteBO() {
    }
    public static ClienteBO getInstance() {
        if (instance == null) {
            instance = new ClienteBO();
        }
        return instance;
    }
    
    public Cliente pegarCliente(int id){
    	return ClienteDAO.getInstance().getCliente(id);
    }
    
    public void salvar(Cliente cliente) {
    	ClienteDAO.getInstance().setClient(cliente);
    }
    
    public String listar(String parametro,String valor) {
    	return new Gson().toJson(ClienteDAO.getInstance().getClientes(parametro, valor));
    }
    
    public void remover(Cliente c) {
    	ClienteDAO.getInstance().removeCliente(c);
    }
    public void alterar(Cliente c) {
    	ClienteDAO.getInstance().alterarCliente(c);
    }
}
