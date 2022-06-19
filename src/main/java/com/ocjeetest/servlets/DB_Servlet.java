package com.ocjeetest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocjeetest.bdd.Names;
import com.ocjeetest.beans.User;

/**
 * Servlet implementation class DB_Servlet
 */
@WebServlet("/DB_Servlet")
public class DB_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_Servlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Names names = new Names();
		
		request.setAttribute("users", names.getUsers());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/name.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setLastname(request.getParameter("nom"));
		user.setFirstname(request.getParameter("prenom"));
		
		Names names = new Names();
		names.addUser(user);
		
		request.setAttribute("users", names.getUsers());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/name.jsp").forward(request, response);
	}

}
