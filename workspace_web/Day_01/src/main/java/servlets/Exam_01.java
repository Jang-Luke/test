package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exam_01")
public class Exam_01 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getQueryString().split("=")[1];
		String msgPara = request.getParameter("msg");
		PrintWriter resp = response.getWriter();
		resp.append(msgPara + " Complete!");
		System.out.println("여기가 Get 입니다. 이 출력이 처리하는 코드라고 가정합니다. "+msg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기가 Post 입니다.");
	}
}
