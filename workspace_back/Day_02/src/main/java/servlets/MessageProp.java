package servlets;

import commons.MyDataSource;
import messageDAO.MessageDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageProp")
public class MessageProp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        String writer = request.getParameter("writer");
        String message = request.getParameter("message");
        System.out.println("작성자는 : " + writer);
        System.out.println("메세지는 : " + message);
        MessageDAO messageDAO = new MessageDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/Day_02/src/main/resources/DB_properties.properties"));
        int result = messageDAO.insertMessage(writer, message);
        System.out.println(result > 0 ? "입력 성공" : "입력 실패");
        if (result>0){
            System.out.println("입력 성공");
            PrintWriter printWriter = response.getWriter();
            printWriter.append("<html>");
            printWriter.append("<head>");
            printWriter.append("</head>");
            printWriter.append("<body>");
            printWriter.append("작성자는 : ").append(writer);
            printWriter.append("<br>");
            printWriter.append("메세지는 : ").append(message);
            printWriter.append("<br>");
            printWriter.append("<button id='toIndex'>돌아가기</button>");
            printWriter.append("<script>document.querySelector('#toIndex').addEventListener('click', () => {alert('입력 완료!'); location.href='index.html'})</script>");
            printWriter.append("</body>");
            printWriter.append("</html>");
//            response.sendRedirect("success.html");
//            다른 페이지로 이동 명령을 내릴 때 쓰는 코드
        } else {
            System.out.println("입력 실패");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
