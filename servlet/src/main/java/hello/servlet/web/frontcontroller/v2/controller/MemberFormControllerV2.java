package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {


    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
