package controllers;

import DAO.MemberDAO;
import DTO.MemberDTO;
import commons.EncryptionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/Join")
public class Join extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        String id = request.getParameter("inId");
        String pw = EncryptionUtils.getSHA256(request.getParameter("inPw"));
        String name = request.getParameter("inName");
        String phone = request.getParameter("inPhone")
                .chars()
                .filter(character ->  48 <= character && character <= 57)
                .mapToObj(element -> (char)element)
                .map(Object::toString)
                .collect(Collectors.joining());
        StringBuilder stringBuilder = new StringBuilder(phone.substring(0, 3));
        phone = stringBuilder.append("-")
                .append(phone.substring(3,7))
                .append("-")
                .append(phone.substring(7))
                .toString();
        String email = request.getParameter("inEmail");
        String zipcode = request.getParameter("inZipcode");
        String address1 = request.getParameter("inAddress1");
        String address2 = request.getParameter("inAddress2");
        MemberDAO memberDAO = MemberDAO.getInstance();
        try {
            memberDAO.insertMember(new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error.html");
        }
        response.sendRedirect("../index.jsp");
    }
}
