package com.ocjeetest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocjeetest.beans.User;
import com.ocjeetest.dao.DaoException;
import com.ocjeetest.dao.DaoFactory;
import com.ocjeetest.dao.UserDao;

/**
 * Servlet implementation class DB_Servlet
 */
@WebServlet("/DB_Servlet")
public class DB_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VIEW_PATH = "/WEB-INF/name.jsp";
	private final String VIEW_NAME = "name";
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.getUserDao();
	}
	
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			request.setAttribute("users", userDao.getUsers());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
		}
		
		this.getServletContext().getRequestDispatcher(VIEW_PATH).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastname = request.getParameter("nom") != null || !request.getParameter("nom").equals("") ? request.getParameter("nom"): "";
		String firstname = request.getParameter("prenom") != null || !request.getParameter("prenom").equals("") ? request.getParameter("prenom"): "";
		if(!lastname.equals("") && !firstname.equals("")) {
			try {
				User user = new User();
				user.setLastname(lastname);
				user.setFirstname(firstname);
				userDao.addUser(user);
				request.setAttribute("users", userDao.getUsers());
			} catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
			}
			
		}
		
		response.sendRedirect(VIEW_NAME);
		


	}

}
