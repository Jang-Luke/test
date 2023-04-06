package servlets;

import messageDAO.MessageDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageProp")
public class InsertMessage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        String writer = request.getParameter("writer");
        String message = request.getParameter("message");
        MessageDAO messageDAO = MessageDAO.getInstance();
        PrintWriter printWriter = response.getWriter();
        int result = messageDAO.insertMessage(writer, message);
        response.sendRedirect("index.html");
//        request.getRequestDispatcher("list.jsp").forward(request, response);

        printWriter.append("<html>");
        printWriter.append("<head>");
        printWriter.append("</head>");
        printWriter.append("<body>");
        if (result>0){
            printWriter.append("작성자는 : ").append(writer);
            printWriter.append("<br>");
            printWriter.append("메세지는 : ").append(message);
            printWriter.append("<br>");
            //            response.sendRedirect("success.html");
//            다른 페이지로 이동 명령을 내릴 때 쓰는 코드
        } else {
            printWriter.append("<p>입력 실패</p>");
        }
        printWriter.append("<button id='toIndex'>메인으로</button>");
        printWriter.append("<button id='toSelect'>목록으로</button>");
        printWriter.append("<script>document.querySelector('#toIndex').addEventListener('click', () => {alert('입력 완료!'); location.href='index.html'})</script>");
        printWriter.append("<script>document.querySelector('#toSelect').addEventListener('click', () => {location.href='SelectMessage'})</script>");
        printWriter.append("</body>");
        printWriter.append("</html>");
    }

}
