package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";

    }

    // Add Ninja (Create)
    @PostMapping("/create")
    public String createNinja(){
        return "Ninja Created";
    }

    // Show ninjas (Read)
    @GetMapping("/readall")
    public String showAllNinjas(){
        return "Shown all Ninjas";
    }

    // Show ninja by ID (Read)
    @GetMapping("/read")
    public String showNinjaByID(){
        return "Ninja shown by ID";
    }

    // Change data  (Update)
    @PutMapping("/updateID")
    public String updateNinjaByID(){
        return "Ninja change by ID";
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID")
    public String deleteID(){
        return "Ninja deleted";
    }

    // All of this is called CRUD (Create, read, update, delete)

}
