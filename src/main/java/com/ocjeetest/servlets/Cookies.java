package com.ocjeetest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Coockies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie[]cookies = request.getCookies();
		if(cookies != null) {
			
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("prenom")) {
					request.setAttribute("prenom", cookie.getValue());
				}
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		
		Cookie cookieFirsname = new Cookie("prenom", prenom );
		Cookie cookieLastname = new Cookie("nom", nom );
		
		cookieFirsname.setMaxAge(60 * 60 * 24);
		cookieLastname.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cookieFirsname);
		response.addCookie(cookieLastname);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
	}

}
