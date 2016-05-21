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
    /**teste denis
     * Singletton
     *
     * @return A inst�ncia �nica da classe
     */
    public static ClienteBO getInstance() {
        if (instance == null) {
            instance = new ClienteBO();
        }
        return instance;
    }
    
    public Cliente pegarCliente(int id){
    	ClienteDAO dao = ClienteDAO.getInstance();
    	return dao.getCliente(id);
    }
    
    public void salvar(Cliente cliente) {
    	ClienteDAO dao = ClienteDAO.getInstance();
    	dao.setClient(cliente);
    }
    
    public String listar(int id) {
    	return new Gson().toJson(ClienteDAO.getInstance().getClientes(id));
    }
    
    public void remover(Cliente c) {
    	ClienteDAO dao = ClienteDAO.getInstance();
    	dao.removeCliente(c);
    }
    public void alterar(Cliente c) {
    	ClienteDAO dao = ClienteDAO.getInstance();
    	dao.alterarCliente(c);
    	System.out.println(c.getId());
    
    }
}
