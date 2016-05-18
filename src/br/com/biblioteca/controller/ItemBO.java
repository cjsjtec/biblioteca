package br.com.biblioteca.controller;

import com.google.gson.Gson;

import br.com.biblioteca.dao.ItemDAO;
import br.com.biblioteca.model.Item;

public class ItemBO {
	private static ItemBO instance;

    private ItemBO() {
    }

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
    	System.out.println(item.getId());
    
    }
    
    public void remover(Item item) {
    	
    	ItemDAO dao = ItemDAO.getInstance();
    	dao.Remover(item);
    }
    
    public Item pegarItem(long id){
    	ItemDAO dao = ItemDAO.getInstance();
    	return dao.getItem(id);
    }
    
    public String listar(String nome) {
    	return new Gson().toJson(ItemDAO.getInstance().getItens(nome));
    }
    
}
