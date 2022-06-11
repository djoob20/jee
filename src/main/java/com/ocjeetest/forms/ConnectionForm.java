package com.ocjeetest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	
	private String result;
	
	public void verifyLogin(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		if(pass != null && pass.equals(login + "123")) {
			result = "connexion réussie!";
		}else {
			result = "connexion échouée!";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

}
