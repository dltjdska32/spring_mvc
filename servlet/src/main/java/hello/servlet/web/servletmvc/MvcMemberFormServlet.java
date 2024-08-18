package hello.servlet.web.servletmvc;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


//컨트롤러 역할을 하는 서블릿
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        //컨트롤러에서 뷰로 이동할때 사용.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        //forward() -> 다른 서블릿이나 jsp로 이동할 수 있는 기능.
        // 클라이언트에 반환후 다시호출하는것이아닌, 서버에서 바로 호출


        // Redirect vs forward
        // Redirect의 경우 서버에서 결과를 처리한 후, 결과를 클라이언트에 보내고
        // 다시 redirect되어 서버에넘어간후 결과를 처리하고 다시 클라이언트에 반환하는 작업

        // forward의 경우 클라이언트가 서버에 요청을보내면 서버가 결과를 처리하고 곧바로 다른서버에 요청을 보낸다.
        // 그리고 다른 서버에서 요청을 처리하고 클라이언트에 응답.
        requestDispatcher.forward(req, resp);
    }
}
