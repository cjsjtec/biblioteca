package br.com.biblioteca.controller;

import br.com.biblioteca.dao.ItemDAO;
import br.com.biblioteca.model.Item;

public class ItemBO {
	private static ItemBO instance;

    private ItemBO() {
    }

    /**
     * Singletton
     *
     * @return A inst�ncia �nica da classe
     */
    public static ItemBO getInstance() {
        if (instance == null) {
            instance = new ItemBO();
        }
        return instance;
    }
    public Item salvar(Item item) {
    	//Chama o dao aqui
    	ItemDAO dao = ItemDAO.getInstance();

    	dao.setItem(item);
    	
    	// Notifica a tela das altera��es
    	//setChanged();
    	//notifyObservers();
        return item;
    }
}
