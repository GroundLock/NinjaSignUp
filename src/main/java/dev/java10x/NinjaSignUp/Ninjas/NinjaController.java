package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";

    }

}
