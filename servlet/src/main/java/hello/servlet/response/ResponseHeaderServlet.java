package hello.servlet.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://localhost:8080/response-header
 *
 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //[status-line] 상태 설정.
        response.setStatus(HttpServletResponse.SC_OK); //200 -> 상수로 각각의 상태가 선언되어있음
        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must revalidate"); // 캐시 뮤효화
                response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header","hello"); //내가 만든 임의의 헤더값.
        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);
        //[message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void redirect(HttpServletResponse response) throws IOException {

        //Status Code 302
        //Location: /basic/hello-form.html
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html"); // 서버 상태를 302로 설정하고 hello-form.html로 경로 재설정.
    }

    private void cookie(HttpServletResponse response) {


        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초 동안 유효
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {

        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2   ->  writer.println("ok"); println을 해서 \n가 포함되어 lenth는 3임. print로 할경우 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }
}