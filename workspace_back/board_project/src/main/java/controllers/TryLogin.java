package controllers;

import DAO.MemberDAO;
import DTO.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TryLogin")
public class TryLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        String id = request.getParameter("mainId");
        String pw = request.getParameter("mainPw");
        MemberDAO memberDAO = MemberDAO.getInstance();
        try {
            MemberDTO result = memberDAO.getAccount(new MemberDTO(id, pw, "가", "010-0000-0000", "email.@email.com", "", "", "", null));
            if (!result.getId().equals("1")) {
                request.setAttribute("matchedAccount", result);
                System.out.println("성공");
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            } else{
                request.setAttribute("loginFailed", true);
                System.out.println("실패");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error.html");
        }
    }
}
