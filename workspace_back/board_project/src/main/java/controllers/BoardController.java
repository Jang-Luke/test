package controllers;

import DAO.BoardDAO;
import DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                response.sendRedirect("/select.board");

            } else if (command.equals("/select.board")) { //items
                List<BoardDTO> contentsList = BoardDAO.getInstance().selectAll();
                request.setAttribute("contentsList", contentsList);
                request.setAttribute("length", contentsList.size());
                System.out.println(request.getContextPath());
                request.getRequestDispatcher("/board/board_main.jsp").forward(request, response);

            } else if (command.startsWith("/viewTarget.board")) {
                BoardDTO targetContent = getTarget(request);
                targetContent = BoardDAO.getInstance().viewTargetContent(targetContent);
                request.setAttribute("targetContent", targetContent);
                System.out.println(request.getContextPath());
                request.getRequestDispatcher("/board/content_view.jsp").forward(request,response);

            } else if (command.startsWith("/delete.board")) {
                BoardDTO targetContent = getTarget(request);
                int result = BoardDAO.getInstance().deleteContent(targetContent);
                response.sendRedirect("/select.board");

            } else if (command.startsWith("/modify.board")) {
                long id = Long.parseLong(request.getParameter("id"));
                String title = request.getParameter("modifyTitle");
                String content = request.getParameter("modifyContent");
                int result = BoardDAO.getInstance().updateContent(new BoardDTO(id, null, title, content, 0, null));
                response.sendRedirect("/select.board");

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
    private BoardDTO getTarget(HttpServletRequest request) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        return BoardDAO.getInstance().searchById(id);
    }
}
