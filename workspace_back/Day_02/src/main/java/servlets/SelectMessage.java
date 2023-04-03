package servlets;

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
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.setBasicDataSource();
        PrintWriter printWriter = response.getWriter();
        messageDAO.selectAll().forEach((e)-> printWriter.append(e.toString()).append("<br>"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
