package dev.java10x.NinjaSignUp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";

    }

}
