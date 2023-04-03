package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String requestedID = request.getParameter("id");
		String requestedPW = request.getParameter("pw");
		System.out.println("ID : " + requestedID);
		System.out.println("PW : " + requestedPW);
		PrintWriter resp = response.getWriter();
		resp.append("<script>");
		resp.append("alert('ID : " + requestedID + " / PW : " + requestedPW + "')");
		resp.append("</script>");
		resp.append("한글이에욤<br>ID : " + requestedID + "<br>PW : " + requestedPW);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String requestedID = request.getParameter("id");
		String requestedPW = request.getParameter("pw");
		System.out.println("ID : " + requestedID);
		System.out.println("PW : " + requestedPW);
		PrintWriter resp = response.getWriter();
		resp.append("<script>");
		resp.append("alert('ID : " + requestedID + " / PW : " + requestedPW + "')");
		resp.append("</script>");
		resp.append("<style>pre{display:inline-block}</style>");
		resp.append("한글이에욤<br><pre>    </pre>ID : " + requestedID + "<br><pre>    </pre>PW : " + requestedPW);
	}

}
