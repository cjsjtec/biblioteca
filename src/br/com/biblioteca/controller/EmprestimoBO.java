package br.com.biblioteca.controller;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Item;

public class EmprestimoBO {
	private static EmprestimoBO instance;
    /**
    * Singletton
    *
    * @return A inst�ncia �nica da classe
    */
    public static EmprestimoBO getInstance() {
        if (instance == null) {
            instance = new EmprestimoBO();
        }
        return instance;
    }

	public void CadastrarEmprestimo(Emprestimo emprestimo) {
		
	}
}
