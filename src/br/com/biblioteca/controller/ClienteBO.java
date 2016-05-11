package br.com.biblioteca.controller;

import br.com.biblioteca.dao.ClienteDAO;
import br.com.biblioteca.model.Cliente;

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
    public Cliente salvar(Cliente cliente) {
    	ClienteDAO dao = ClienteDAO.getInstance();
    	dao.setClient(cliente);
    	//setChanged();
    	//notifyObservers();
        return cliente;
    }
}
