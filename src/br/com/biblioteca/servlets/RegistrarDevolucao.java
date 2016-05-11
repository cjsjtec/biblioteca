package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.ItemBO;
import br.com.biblioteca.model.Item;

/**
 * Servlet implementation class RegistrarDevolucao
 */
@WebServlet("/RegistrarDevolucao")
public class RegistrarDevolucao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarDevolucao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Emprestimo em =  new Emprestimo();
		
		em.idItem(request.getParameter("id_item"));
		em.idCliente(request.getParameter("id_clin"));
		
		EmprestimoBO.getInstance().remover(em); 

	}

}
