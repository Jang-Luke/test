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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

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
        String contact = request.getParameter("updateContact")
                .chars()
                .filter(character ->  48 <= character && character <= 57)
                .mapToObj(element -> (char)element)
                .map(Object::toString)
                .collect(Collectors.joining());
        StringBuilder stringBuilder = new StringBuilder(contact.substring(0, 3));
        contact = stringBuilder.append("-")
                .append(contact.substring(3,7))
                .append("-")
                .append(contact.substring(7))
                .toString();
        Timestamp birthday = Timestamp.valueOf(LocalDate.parse(request.getParameter("updateBirthday")).atStartOfDay());
        ContactDAO contactDAO = ContactDAO.getInstance();
        contactDAO.updateContact(new ContactDTO(id, name, contact, birthday));
        response.sendRedirect("SelectServlet");
    }
}
