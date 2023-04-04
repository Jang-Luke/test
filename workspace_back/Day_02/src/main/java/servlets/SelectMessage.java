package servlets;

import commons.MyDataSource;
import messageDAO.MessageDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectMessage")
public class SelectMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        MessageDAO messageDAO = new MessageDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/Day_02/src/main/resources/DB_properties.properties"));
        PrintWriter printWriter = response.getWriter();
        printWriter.append("<html>");
        printWriter.append("<head>");
        printWriter.append("<style>");
        printWriter.append("p{margin-top:5px;margin-bottom:5px}");
        printWriter.append("</style>");
        printWriter.append("</head>");
        printWriter.append("<body>");
        messageDAO.selectAll().forEach((e)-> printWriter.append("<p>").append(e.toString()).append("</p><br>"));
        printWriter.append("<button id='toIndex'>돌아가기</button>");
        printWriter.append("<script>document.querySelector('#toIndex').addEventListener('click', () => {location.href='index.html'})</script>");
        printWriter.append("</body>");
        printWriter.append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}