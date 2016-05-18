package br.com.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.controller.ItemBO;
import br.com.biblioteca.model.Item;


/**
 * Servlet implementation class ListarItens
 */
@WebServlet("/ListarItensServlet")
public class ListarItensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarItensServlet() {
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
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		try {		    	
			String retorno = null;
			String acao = request.getParameter("acao");
			
			switch (acao) {
				case "PESQUISA":
					retorno  = ItemBO.getInstance().listar(request.getParameter("busca"));
					break;
				case "INCLUIR":
					String nome = request.getParameter("nome");
					String tipo = request.getParameter("tipo");
					String status = request.getParameter("status");
					String especial = request.getParameter("status");
					
					Item item = new Item();
					item.setNome(nome);
					item.setTipo(tipo);
					item.setStatus(status);
					item.setEspecial(especial);
					
					ItemBO.getInstance().inserir(item);
					RequestDispatcher rd = request.getRequestDispatcher("/itens.jsp");
					rd.forward(request,response);
//					retorno = 'teste';
					break;
				case "ALTERAR":
					int id_alt = Integer.parseInt(request.getParameter("id"));
					String nome_alt = request.getParameter("nome");
					String tipo_alt = request.getParameter("tipo");
					String status_alt = request.getParameter("status");
					String especial_alt = request.getParameter("especial");
					
					Item item_alt = new Item();
					
					item_alt.setId(id_alt);
					item_alt.setNome(nome_alt);
					item_alt.setTipo(tipo_alt);
					item_alt.setStatus(status_alt);
					item_alt.setEspecial(especial_alt);
					
					ItemBO.getInstance().alterar(item_alt);
					break;
				case "REMOVER":

					ItemBO.getInstance().remover(ItemBO.getInstance().pegarItem(Integer.parseInt(request.getParameter("id"))));
					
					break;
			}	

			PrintWriter out = response.getWriter();
	        out.print(retorno);

		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

}
