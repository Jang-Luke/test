package servlets;

import commons.MyDataSource;
import contactDAO.ContactDAO;
import contactDTO.ContactDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("updateId"));
        String name = request.getParameter("updateName");
        String contact = request.getParameter("updateContact");
        String birthday = request.getParameter("updateBirthday");
        StringBuilder stringBuilder = new StringBuilder(birthday);
        birthday = stringBuilder.append(" 00:00:00").toString();
        ContactDAO contactDAO = new ContactDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/contact/src/main/resources/DB_properties.properties"));
        contactDAO.updateContact(new ContactDTO(id, name, contact, Timestamp.valueOf(birthday)));
        int result = contactDAO.deleteContact(id);
        response.sendRedirect("SelectServlet");
    }
}
