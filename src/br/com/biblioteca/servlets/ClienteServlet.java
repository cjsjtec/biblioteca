package br.com.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.ClienteBO;
import br.com.biblioteca.model.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
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
		System.out.println("teste111");
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		try {		    	
			String retorno = null;
			String acao = request.getParameter("acao");
			
			switch (acao) {
				case "PESQUISA":
					retorno  = ClienteBO.getInstance().listar(request.getParameter("filtro"), request.getParameter("busca"));
					System.out.println(retorno);
					break;
				case "INCLUIR":
					
					String cpf = request.getParameter("cpf");
					System.out.println(request.getParameter("cpf"));
					String nome = request.getParameter("nome");
					String tipo = request.getParameter("tipo");
					
					Cliente item = new Cliente();
					item.setNome(nome);
					item.setTipo(tipo);
					item.setCpf(cpf);
					ClienteBO.getInstance().salvar(item);
					RequestDispatcher rd = request.getRequestDispatcher("/cliente.jsp");
					rd.forward(request,response);
					break;
				case "ALTERAR":
					int id_alt = Integer.parseInt(request.getParameter("id"));
					String cpf_alt = request.getParameter("cpf");
					String nome_alt = request.getParameter("nome");
					String tipo_alt = request.getParameter("tipo");

					Cliente cliente_alt = new Cliente();
					
					cliente_alt.setId(id_alt);
					cliente_alt.setCpf(cpf_alt);
					cliente_alt.setNome(nome_alt);
					cliente_alt.setTipo(tipo_alt);
					ClienteBO.getInstance().alterar(cliente_alt);
					break;
				case "REMOVER":
					ClienteBO.getInstance().remover(ClienteBO.getInstance().pegarCliente(Integer.parseInt(request.getParameter("id"))));
					break;
			}	

			PrintWriter out = response.getWriter();
	        out.print(retorno);

		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

}
