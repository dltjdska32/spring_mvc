package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpMethod httpmethod,
            Locale locale,
            @RequestHeader MultiValueMap<String, String> headerMap,
            @RequestHeader ("host") String host,
            @CookieValue(value = "myCookies", required = false) String cookies){

        log.info("headers request");
        log.info("request : {} " , request);
        log.info("response : {} " , response);
        log.info("httpmethod : {} " , httpmethod);
        log.info("headerMap : {} " , headerMap);
        log.info("locale : {} " , locale);
        log.info("host : {} " , host);
        log.info("cookies : {} " , cookies);


        return "ok";
    }
}
