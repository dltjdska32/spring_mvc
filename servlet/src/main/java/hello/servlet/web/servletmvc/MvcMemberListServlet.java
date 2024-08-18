package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = MemberRepository.getInstance().findAll();

        req.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";


        // Redirect vs forward
        // Redirect의 경우 서버에서 결과를 처리한 후, 결과를 클라이언트에 보내고
        // 다시 redirect되어 서버에넘어간후 결과를 처리하고 다시 클라이언트에 반환하는 작업

        // forward의 경우 클라이언트가 서버에 요청을보내면 서버가 결과를 처리하고 곧바로 다른서버에 요청을 보낸다.
        // 그리고 다른 서버에서 요청을 처리하고 클라이언트에 응답.

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);
    }




}
