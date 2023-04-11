package servlets;

import messageDAO.MessageDAO;
import messageDTO.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("*.message")
public class MessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String command = request.getRequestURI();
        try {
            if (command.equals("/select.message")) {
                MessageDAO messageDAO = MessageDAO.getInstance();
                List<Message> messageList = messageDAO.selectAll();
                request.setAttribute("messageList", messageList);
                request.getRequestDispatcher("list.jsp").forward(request, response);

            } else if (command.equals("/insert.message")) {
                String writer = request.getParameter("writer");
                String message = request.getParameter("message");
                MessageDAO messageDAO = MessageDAO.getInstance();
                int result = messageDAO.insertMessage(writer, message);
                response.sendRedirect("index.html");

            } else if (command.equals("/delete.message")) {
                int id = Integer.parseInt(request.getParameter("id"));
                MessageDAO messageDAO = MessageDAO.getInstance();
                int result = messageDAO.deleteMessageById(id);
                response.sendRedirect("/select.message");

            } else if (command.equals("/update.message")) {
                String message = request.getParameter("message");
                int id = Integer.parseInt(request.getParameter("id"));
                PrintWriter printWriter = response.getWriter();
                MessageDAO messageDAO = MessageDAO.getInstance();
                int result = messageDAO.updateMessageById(message, id);
                response.sendRedirect("/select.message");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

