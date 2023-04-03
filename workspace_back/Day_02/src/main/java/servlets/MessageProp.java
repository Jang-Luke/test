package servlets;

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

@WebServlet("/MessageProp")
public class MessageProp extends HttpServlet {
    public Connection getConnection() {
        BasicDataSource bds = new BasicDataSource();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        bds.setUrl("jdbc:mysql://kh.cvssgzojc9ja.ap-northeast-2.rds.amazonaws.com:3306/syhrje10_db");
        bds.setUsername("syhrje10");
        bds.setPassword("vtrol!Q2w3e");
        bds.setInitialSize(8);
        Connection connection = null;
        try {
            connection = bds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public int insertMessage(String writer, String message) {
        int result = 0;
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO MESSAGES VALUES(0, ?, ?)";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, writer);
            prepareStatement.setString(2, message);
            result = prepareStatement.executeUpdate();
//          con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("Text/html; charset=UTF-8");
        String writer = request.getParameter("writer");
        String message = request.getParameter("message");
        System.out.println("작성자는 : " + writer);
        System.out.println("메세지는 : " + message);
        int result = insertMessage(writer, message);
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
