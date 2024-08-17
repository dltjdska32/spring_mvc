package hello.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //Content-Type: application/json
        response.setHeader("content-type", "application/json"); //-> http응답으로 json을 반환 할때는 application/json을
                                                                        // 컨텐트 타입으로 지정해야한다.
                                                                        // 그리고 application/json은 스펙상 자동으로 utf-8적용
      //  response.setCharacterEncoding("utf-8");
        HelloData hd = new HelloData();
        hd.setUsername("kim");
        hd.setAge(20);
        //{"username":"kim","age":20}
        String result = objectMapper.writeValueAsString(hd); // ->  json 형태의 문자열로 변환하는 함수.
        response.getWriter().write(result);
    }
}
