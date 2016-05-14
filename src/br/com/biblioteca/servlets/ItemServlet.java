package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.ItemBO;
import br.com.biblioteca.model.Item;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/CadastrarItem")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
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
		Item item =  new Item();
		
		item.setNome(request.getParameter("nome"));
		item.setTipo(request.getParameter("tipo"));
		item.setGenero(request.getParameter("genero"));
		
		ItemBO.getInstance().inserir(item); 
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request,response);
	}

}
