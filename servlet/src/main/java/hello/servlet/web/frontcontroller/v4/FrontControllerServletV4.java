package hello.servlet.web.frontcontroller.v4;


import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerMap = new HashMap<String, ControllerV4>();

    // 컨트롤이 생성될때 미리 컨트롤러들을 맵에 담아둔다.
    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("front-controller");

        // 요청받은 url정보를 가져옴
        String reqURL = req.getRequestURI();
        System.out.println(reqURL);

        // 가져온 url와 일치하는  밸류(컨트롤러) 를가져온다.
        ControllerV4 controller = controllerMap.get(reqURL);
        // 컨트롤러를 찾지못하면 404에러
        if(controller == null) {
            System.out.println("여기야");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // req에 담긴. 데이터로 맵을 만든다.
        Map<String, String> paramMap = createParamMap(req);
        Map<String, Object> model = new HashMap<>(); // 추가
        try {

            String viewName = controller.process(paramMap, model);

            MyView view = viewResolver(viewName);




            view.render(model, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
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
