package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String users() {
        return "get users 123";
    }

    @PostMapping
    public String addUsers() {
        return "post users";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") String userId) {
        return "get user " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable("userId") String userId) {
        return "update user " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "delete user " + userId;
    }


}
