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
        printWriter.append(".inputBar{display:flex; flex-flow:column wrap; justify-content:center; background-color:lightgray;}");
        printWriter.append("p{margin-top:5px;margin-bottom:5px;}");
        printWriter.append("label{display: inline-block;width: 60px;}");
        printWriter.append(".formFlex{display: flex; flex-flow: row wrap; justify-content: center; margin:10px;}");
        printWriter.append("input[type='text']{width:200px; padding:2px; margin:3px;}");
        printWriter.append(("form{border-top: 1px solid gray; border-bottom: 1px solid gray; margin-bottom:0px;}"));
        printWriter.append("</style>");
        printWriter.append("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        printWriter.append("</head>");
        printWriter.append("<body>");
        printWriter.append("<table border='1' align='center'>");
        printWriter.append("<tr><th>글번호</th><th>작성자</th><th>메세지</th></tr>");
        messageDAO.selectAll()
                .forEach(
                        (message) -> printWriter.append("<tr>")
                                .append("<td>").append(String.valueOf(message.getId())).append("</td>")
                                .append("<td>").append(message.getWriter()).append("</td>")
                                .append("<td>").append(message.getMessage()).append("</td>")
                                .append("</tr>")
                );
        printWriter.append("</table><br>");
        printWriter.append("<div class='inputBar'>");
        printWriter.append("<form action='MessageProp' method='post' class='formSubmit'>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<label for='writer'>작성자</label>");
        printWriter.append("<input type='text' name='writer' id='writer' placeholder='작성자를 입력하세요.'>");
        printWriter.append("</div>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<label for='insertMessage'>내용</label>");
        printWriter.append("<input type='text' name='message' id='insertMessage' placeholder='메세지를 입력하세요.'>");
        printWriter.append("</div>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<input type='button' value='메세지 입력할래'>");
        printWriter.append("</div>");
        printWriter.append("</form>");
        printWriter.append("<form action='DeleteMessage' method='post' class='formSubmit'>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<label for='deleteId'>글번호</label>");
        printWriter.append("<input type='text' name='id' id='deleteId' placeholder='삭제할 글번호를 입력하세요.'>");
        printWriter.append("</div>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<input type='button' value='메세지 삭제할래'>");
        printWriter.append("</div>");
        printWriter.append("</form>");
        printWriter.append("<form action='UpdateMessage' method='post' class='formSubmit'>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<label for='modifyId'>글번호</label>");
        printWriter.append("<input type='text' name='id' id='modifyId' placeholder='글번호를 입력하세요.'>");
        printWriter.append("</div>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<label for='modifyMessage'>내용</label>");
        printWriter.append("<input type='text' name='message' id='modifyMessage' placeholder='수정할 메세지를 입력하세요.'>");
        printWriter.append("</div>");
        printWriter.append("<div class='formFlex'>");
        printWriter.append("<input type='button' value='메세지 수정할래'>");
        printWriter.append("</div>");
        printWriter.append("</form>");
        printWriter.append("</div>");
        printWriter.append("<button id='toIndex'>돌아가기</button>");
        printWriter.append("<script>");
        printWriter.append("const showAlert = function() {Swal.fire({title: '진짜?', showDenyButton: true, confirmButtonText: '네!', denyButtonText: '아니요..',}).then((result) => {if(result.isConfirmed){this.closest('form').submit();}else if(result.isDenied){return false;}})};");
        printWriter.append("const forms = document.querySelectorAll('input[type=button]');");
        printWriter.append("Array.from(forms).forEach((element) => element.addEventListener('click', showAlert));");
        printWriter.append("const inputs = document.querySelectorAll('input[type=text]');");
        printWriter.append("Array.from(inputs).forEach((element) => element.addEventListener('keyup', function(e) {if(e.key =='Enter'){showAlert();}}));");
        printWriter.append("document.querySelector('#toIndex').addEventListener('click', () => {location.href='index.html'})");
        printWriter.append("</script>");
        printWriter.append("</body>");
        printWriter.append("</html>");
    }
// TODO: 엔터키 이벤트 this 탐색 이슈 해결해야함
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
