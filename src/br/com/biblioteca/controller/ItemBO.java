package br.com.biblioteca.controller;

import java.util.List;

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
    public void inserir(Item item) {

    	ItemDAO dao = ItemDAO.getInstance();
    	dao.Inserir(item);

    }
    public void alterar(Item item) {
    	ItemDAO dao = ItemDAO.getInstance();
    	dao.Alterar(item);
    }
    
    public void remover(Item item) {
    	ItemDAO dao = ItemDAO.getInstance();
    	dao.Remover(item);
    }
    
    public Item pegarItem(long id){
    	ItemDAO dao = ItemDAO.getInstance();
    	return dao.getItem(id);
    }
    
    public List<Item> listar(String nome) {
    	//Chama o dao aqui
    	ItemDAO dao = ItemDAO.getInstance();
    	return dao.getItens(nome);
    }
    
}
