package servlets;

import contactDAO.ContactDAO;
import contactDTO.ContactDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        ContactDAO contactDAO = ContactDAO.getInstance();
        List<ContactDTO> contactList = contactDAO.selectAll();
//        request.setAttribute("contactList", contactList);
//        request.getRequestDispatcher("selectForm.jsp").forward(request,response);
//        response.sendRedirect("selectForm.jsp");
        printWriter.append("<html>");
        printWriter.append("<head>");
        printWriter.append("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        printWriter.append("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'></script>");
        printWriter.append("<script src=\"https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js\"></script>");
        printWriter.append("<style>");
        printWriter.append(".toCenter{text-align:center;border-radius:10px;background-color:lightgray;}");
        printWriter.append(".toCenter:hover{cursor:pointer;}");
        printWriter.append(".disappear{display:none;}");
        printWriter.append(".margin-top-1{margin-top:10px;}");
        printWriter.append("</style>");
        printWriter.append("</head>");
        printWriter.append("<body>");
        printWriter.append("<div class='container'>");
        printWriter.append("<div class='row'>");
        printWriter.append("<div class='col-12 d-flex justify-content-center'>");
        printWriter.append("<table class='table table-striped'>");
        printWriter.append("<tr>");
        printWriter.append("<th scope='col'>#</th>");
        printWriter.append("<th scope='col'>이름</th>");
        printWriter.append("<th scope='col'>연락처</th>");
        printWriter.append("<th scope='col'>생일</th>");
        printWriter.append("</tr>");
        contactList.forEach((contact) -> {
            printWriter.append("<tr>")
                    .append("<th scope='row'>").append(String.valueOf(contact.getId())).append("</th>")
                    .append("<td>").append(contact.getName()).append("</td>")
                    .append("<td>").append(contact.getContact()).append("</td>")
                    .append("<td>").append(contact.getBirthday()).append("</td>")
                    .append("</tr>");
        });
        printWriter.append("</table>");
        printWriter.append("</div>");
        printWriter.append("<div class='col-12'>");
        printWriter.append("<p class='toCenter'>삭제</p>");
        printWriter.append("<form class='disappear' action='DeleteServlet' method='post'>");
        printWriter.append("<label for='deleteId' class='form-label'>번호</label>");
        printWriter.append("<input name='deleteId' type='text' class='form-control' id='deleteId' placeholder='삭제할 연락처의 번호를 입력하세요.'>");
        printWriter.append("<button class='btn btn-outline-success margin-top-1'>삭제할래</button>");
        printWriter.append("</form>");
        printWriter.append("</div>");
        printWriter.append("<div class='col-12'>");
        printWriter.append("<p class='toCenter'>수정</p>");
        printWriter.append("<form class='disappear' action='UpdateServlet' method='post'>");
        printWriter.append("<label for='updateId' class='form-label'>번호</label>");
        printWriter.append("<input name='updateId' type='text' class='form-control' id='updateId' placeholder='수정할 연락처의 번호를 입력하세요.'>");
        printWriter.append("<label for='updateName' class='form-label'>이름</label>");
        printWriter.append("<input name='updateName' type='text' class='form-control' id='updateName' placeholder='이름을 입력하세요.'>");
        printWriter.append("<label for='updateContact' class='form-label'>연락처</label>");
        printWriter.append("<input name='updateContact' type='text' class='form-control' id='updateContact' placeholder='연락처를 입력하세요.'>");
        printWriter.append("<label for='updateBirthday' class='form-label'>생일</label>");
        printWriter.append("<input name='updateBirthday' type='date' class='form-control' id='updateBirthday' placeholder='생일을 입력하세요.'>");
        printWriter.append("<button class='btn btn-outline-success margin-top-1'>수정할래</button>");
        printWriter.append("</form>");
        printWriter.append("</div>");
        printWriter.append("<div class='col-12'>");
        printWriter.append("<button id='returnButton' class='btn btn-outline-primary'>돌아갈래</button>");
        printWriter.append("</div>");
        printWriter.append("</div>");
        printWriter.append("</div>");
        printWriter.append("<script>");
        printWriter.append("document.querySelector('#returnButton').addEventListener('click', () => {location.href='index.html';});");
        printWriter.append("$('.toCenter').on('click', function() {$(this).siblings('form').toggleClass('disappear');})");
        printWriter.append("</script>");
        printWriter.append("</body>");
        printWriter.append("</html>");
    }
    //TODO: 정규식으로 전화번호 조건 걸기
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
