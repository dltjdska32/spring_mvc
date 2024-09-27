package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {


    @Override
    public boolean supports(Object handler) {

        // ControllerV3를 구현한 클래스가 오면 true를 반환 아니면 false를 반환.
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {

        //넘어온 핸들러를 MemberFormControllerV3()로 캐스팅
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(req);

        // 각각의 페이지에 정보를 담고 반환
        ModelView mv = controller.process(paramMap);


        return mv;
    }


    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        //req에 담겨잇는 데이터의 이름으로 맵을 만든다.
        req.getParameterNames().asIterator()
                .forEachRemaining(name -> {
                    paramMap.put(name, req.getParameter(name));
                });
        return paramMap;
    }


}
