package com.ocjeetest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocjeetest.beans.User;
import com.ocjeetest.dao.DaoFactory;
import com.ocjeetest.dao.UserDao;

/**
 * Servlet implementation class DB_Servlet
 */
@WebServlet("/DB_Servlet")
public class DB_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		request.setAttribute("users", userDao.getUsers());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/name.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setLastname(request.getParameter("nom"));
		user.setFirstname(request.getParameter("prenom"));
		
		userDao.addUser(user);
		
		request.setAttribute("users", userDao.getUsers());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/name.jsp").forward(request, response);
	}

}
