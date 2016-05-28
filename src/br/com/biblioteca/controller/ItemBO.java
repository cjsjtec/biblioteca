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
    	item.setEmprestado("N");
    	ItemDAO.getInstance().Inserir(item);
    }
    
    public void alterar(Item item) {
    	item.setEmprestado("N");
    	ItemDAO.getInstance().Alterar(item);    
    }
    public void alterarStausEmprestimo(Item item) {
    	ItemDAO.getInstance().Alterar(item);    
    }
    public void remover(Item item) {
    	ItemDAO.getInstance().Remover(item);
    }
    
    public Item pegarItem(int id){
    	return ItemDAO.getInstance().getItem(id);
    }
    
    public String listar(String nome) {
    	return new Gson().toJson(ItemDAO.getInstance().getItens(nome));
    }
    
    public String getItensAtivos(String nome) {
    	return new Gson().toJson(ItemDAO.getInstance().getItensAtivos(nome));
    }

    
}
