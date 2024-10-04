package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username : {} age : {}", username, age);
        response.getWriter().write("ok");
    }


    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String userName,
            @RequestParam("age") int age
    ) throws IOException {
        log.info("username : {} age : {}", userName, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) throws IOException {
        log.info("username : {} age : {}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username : {} age : {}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // 클라이언트에서 보낼때 username이있어야함 없으면 오류 400오류발생
            @RequestParam(required = false) int age  // 클라이언트에서 보낼때 age를안보내도됨 ,
            // required = false 고정값. , 하지만 age를 안넣으면 500에러 발생 int형이기 떼문에
            // Int형에는 null값을 넣을수 없음, Integer형에는 null값을 넣을수 있기때문에 500에러 발생안날려면 Integer형으로 변경해야함
    ) {
        log.info("username : {} age : {}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            //값이 null이면 default로 설정
            @RequestParam(defaultValue = "kim") String username,
            @RequestParam(defaultValue = "10") int age
    ) {
        log.info("username : {} age : {}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> map) {
        log.info("username={}, age={}",map.get("username"),map.get("age"));
        return "ok";
    }


/*    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username : {} age : {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }*/

    //위와 동일
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData data) {


        log.info("helloData = {}", data.toString());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloData data) {
        log.info("helloData = {}", data.toString());
        return "ok";
    }
}


