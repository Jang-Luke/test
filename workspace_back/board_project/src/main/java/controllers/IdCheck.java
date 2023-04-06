package controllers;

import board_DAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("inId");
        MemberDAO memberDAO = MemberDAO.getInstance();
        boolean result = true;
        try{
            result = memberDAO.is_id_duplicated(id);
        }catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("/error.html");
        }
        request.setAttribute("duplicateCheck", result);
        request.getRequestDispatcher("/member/idCheckResult.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
