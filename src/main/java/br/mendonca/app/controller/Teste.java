package br.mendonca.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Teste extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        
		try {
			PrintWriter writer = resp.getWriter();
	        writer.println("<html lang='pt-br'><head><title>hello</title></head><body>");
	        writer.println("<h1>Server OK!</h1>");
	        writer.println("</body></html>");
	        writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
    
    
}