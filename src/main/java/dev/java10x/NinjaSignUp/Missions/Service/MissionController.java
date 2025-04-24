package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionController {

    // C Post -- Send req to create missions
    @PostMapping("/create")
    public String createMission(){
        return "create mission";
    }

    // R Get -- Send req to show missions
    @GetMapping("/readall")
    public String showAllMission(){
        return "show all";
    }

    @GetMapping("/readID")
    public String showID(){
        return "showID";
    }

    // U Put -- Send req to update a mission
    @PutMapping("/updateID")
    public String updateID(){
        return "update ID";
    }

    // D Delete -- Send req to delete a mission
    @DeleteMapping("/deleteID")
    public String deleteID(){
        return "delete ID";
    }


}
