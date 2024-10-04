package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    public Logger log = LoggerFactory.getLogger(MappingController.class);

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello basic request");
        return "ok";
    }


    @RequestMapping(value = "/mapping/get-v1", method = RequestMethod.GET)
    public String getV1() {
        log.info("get v1 request");
        return "ok";
    }


    /**
     * 축약 어노테이션
     *
     * @return
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping("/mapping-get-v2")
    public String getV2() {
        log.info("get v2 request");
        return "ok";
    }


    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String dt) {
        log.info("mapping path userId = {}", dt);
        return "ok";
    }


    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String dt1, @PathVariable("orderId") Long dt2) {
        log.info("mapping path userId = {}, orderId = {}", dt1, dt2);
        return "ok";
    }
}
