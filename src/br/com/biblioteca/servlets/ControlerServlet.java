package br.com.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class ControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("action");
		
		switch (acao) {
		case "CadastrarUsuario":
			CadastraUsuarioServlet cadUser = new CadastraUsuarioServlet();
			cadUser.doPost(request, response);			
			break;
		
			
		case "ListarItens":
			new ItensServlet().doPost(request, response);
			break;
		default:
			response.getWriter().append("Não foi possível realizar a ação solicitada:" + acao);
			break;
		}	
	}

}
