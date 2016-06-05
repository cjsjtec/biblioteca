package br.com.biblioteca.filtro;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Filtro implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		if(session.getAttribute("usuario") != null){
			System.out.println(session.getAttribute("usuario"));
			chain.doFilter(request, response);
		}else {
			System.out.println(session.getAttribute("usuario"));
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		} 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
