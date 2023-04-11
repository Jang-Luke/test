package controllers;

import DAO.BoardDAO;
import DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getRequestURI();
        System.out.println(command);
        try {
            if (command.equals("/insert.board")) {
                String writer = request.getParameter("inWriter");
                String title = request.getParameter("inTitle");
                String contents = request.getParameter("inContents");
                BoardDTO newContents = new BoardDTO(0, writer, title, contents, 0, null);
                int result = BoardDAO.getInstance().insertContent(newContents);
                response.sendRedirect("/board/board_main.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
