package com.ocjeetest.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ocjeetest.beans.Auteur;
import com.ocjeetest.forms.ConnectionForm;

@WebServlet("/Bonjour")
public class Bonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int BUFFER_SIZE = 10240;
	public static final String FILE_PATH = "/Users/dembadiop/Documents/fichier_final/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bonjour() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "bienvenue";
		request.setAttribute("msg", msg);

		String name = request.getParameter("name");
		request.setAttribute("name", name);

		Auteur auteur = new Auteur();
		auteur.setPrenom("Demba");
		auteur.setNom("Diop");
		auteur.setActif(true);

		String[] titres = { "titre1", "titre2", "titre3", "titre4" };

		request.setAttribute("auteur", auteur);
		request.setAttribute("titres", titres);

		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConnectionForm form = new ConnectionForm();
		form.verifyLogin(request);

		request.setAttribute("form", form);

		String desc = request.getParameter("desc");
		request.setAttribute("desc", desc);

		// On vérifie qu'on a bien reçu un fichier
		Part part = request.getPart("file");

		String fileName = getFileName(part);

		if (fileName != null && !fileName.isEmpty()) {
			String fieldName = part.getName();
			// Corrige un bug du fonctionnement d'Internet Explorer
			fileName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf("\\") + 1);
			// On écrit définitivement le fichier sur le disque
			writeFile(part, fileName, FILE_PATH);
			request.setAttribute(fieldName, fileName);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	/**
	 * 
	 * @param part
	 * @param fileName
	 * @param filePath
	 * @throws IOException
	 */
	private void writeFile(Part part, String fileName, String filePath) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(part.getInputStream(), BUFFER_SIZE);
			bos = new BufferedOutputStream(new FileOutputStream(new File(filePath + fileName)), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int length;
			while ((length = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, length);
			}
		} finally {
			try {
				bos.close();
			} catch (IOException ignore) {

			}
			try {
				bis.close();
			} catch (IOException ignore) {

			}
		}

	}

	/**
	 * Pick the file name form the part.
	 * 
	 * @param part the Part with the given name
	 * @return the filename.
	 */
	private static String getFileName(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			System.out.println(part.getHeader("content-disposition").toString());
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
