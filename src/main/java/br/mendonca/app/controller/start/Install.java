package br.mendonca.app.controller.start;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.mendonca.app.model.dao.DataBase;

@WebServlet("/install")
public class Install extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataBase db = new DataBase();
		
		try {
			db.createTableUser();
		} catch (SQLException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stringStackTrace = sw.toString();
			
			try {
				PrintWriter writer = resp.getWriter();
		        writer.println("<html lang='pt-br'><head><title>Error</title></head><body>");
		        writer.println("<h1>Error</h1>");
		        writer.println("<code>" + stringStackTrace + "</code>");
		        writer.println("</body></html>");
		        writer.close();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
        out.println("successful!!!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
