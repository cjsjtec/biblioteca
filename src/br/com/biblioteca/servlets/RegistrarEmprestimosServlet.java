package br.com.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.ItemBO;

@WebServlet("/RegistrarEmprestimosServlet")
public class RegistrarEmprestimosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public RegistrarEmprestimosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		try {		    	
			String retorno = null;
			String acao = request.getParameter("acao");
			String descricao = request.getParameter("busca");
			
			switch (acao) {
				case "PESQUISA":					
					retorno  = ItemBO.getInstance().listar(descricao);
					break;
			}	

			PrintWriter out = response.getWriter();
	        out.print(retorno);

		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}

	}

}
