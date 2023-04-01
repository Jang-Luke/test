import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlets")
public class LoginServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String msgId = request.getParameter("msgId");
        String msgPw = request.getParameter("msgPw");
        System.out.println(msgId);
        System.out.println(msgPw);

//			response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter resp = response.getWriter();
        resp.append("로긴 성공~");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
