package servlets;

import commons.MyDataSource;
import contactDAO.ContactDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDAO contactDAO = new ContactDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/contact/src/main/resources/DB_properties.properties"));
        int id = Integer.parseInt(request.getParameter("deleteId"));
        int result = contactDAO.deleteContact(id);
        response.sendRedirect("SelectServlet");
    }
}
