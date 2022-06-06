package com.ocjeetest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocjeetest.beans.Auteur;


@WebServlet("/Bonjour")
public class Bonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bonjour() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = "bienvenue";
		request.setAttribute("msg", msg);
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		Auteur auteur = new Auteur();
		auteur.setPrenom("Demba");
		auteur.setNom("Diop");
		auteur.setActif(true);
		
		String[]titres = {"titre1", "titre2","titre3", "titre4"};
		
		request.setAttribute("auteur", auteur);
		request.setAttribute("titres", titres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
