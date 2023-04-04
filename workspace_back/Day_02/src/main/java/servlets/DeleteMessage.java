package servlets;

import commons.MyDataSource;
import messageDAO.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        MessageDAO messageDAO = new MessageDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/Day_02/src/main/resources/DB_properties.properties"));
        int result = messageDAO.deleteMessageById(id);
        PrintWriter printWriter = response.getWriter();
        printWriter.append("<html>");
        printWriter.append("<head>");
        printWriter.append("</head>");
        printWriter.append("<body>");
        printWriter.append("<p>삭제 완료!</p>");
        printWriter.append("<button id='toIndex'>돌아가기</button>");
        printWriter.append("<script>document.querySelector('#toIndex').addEventListener('click', () => {location.href='index.html'})</script>");
        printWriter.append("</body>");
        printWriter.append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
