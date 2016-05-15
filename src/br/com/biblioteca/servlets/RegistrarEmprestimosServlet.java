package br.com.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.biblioteca.controller.ItemBO;
import br.com.biblioteca.model.Item;

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
		
//	    response.getWriter().write(request.getParameter("acao"));
//	    
		try {
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    	
			String json = null;
			String acao = request.getParameter("acao");
			String descricao = request.getParameter("busca");
			

			switch (acao) {
				case "PESQUISA":					
					ItemBO itemBo = ItemBO.getInstance();
					List<Item> itens = itemBo.listar(descricao);
					System.out.println("teste");
					json = new Gson().toJson(itens);
					break;
			}	

			PrintWriter out = response.getWriter();
	        out.print(json);

		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}

	}

}
