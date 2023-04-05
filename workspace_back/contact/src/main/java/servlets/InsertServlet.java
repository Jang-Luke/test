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
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        ContactDAO contactDAO = ContactDAO.getInstance();
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String birthday = request.getParameter("birthday");
        StringBuilder stringBuilder = new StringBuilder(birthday);
        birthday = stringBuilder.append(" 00:00:00").toString();
        int result = contactDAO.insertContact(new ContactDTO(0, name, contact, Timestamp.valueOf(birthday)));
        printWriter.append("<html><head>");
        printWriter.append("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        printWriter.append("</head><body>");
        printWriter.append("<script>Swal.fire({title: '입력 완료!', icon:'success'}).then((result) => {if(result.isConfirmed){location.href='index.html'}})</script>");
        printWriter.append("</body></html>");
    }
}
