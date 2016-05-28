package br.com.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.EmprestimoBO;
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

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		try {
			String retorno = null;
			String acao = request.getParameter("acao");

			switch (acao) {
				case "PESQUISA":
					String descricao = request.getParameter("busca");
					retorno = ItemBO.getInstance().getItensAtivos(descricao);
					break;
				case "ANALISAREMPRESTIMO":
					String documento = request.getParameter("documento");				
					String emprestimos = request.getParameter("selecionados");
					retorno = EmprestimoBO.getInstance().analisar(documento, emprestimos);
					System.out.println(retorno);
					break;
			}

			PrintWriter out = response.getWriter();
			out.print(retorno);

		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}

	}

}
