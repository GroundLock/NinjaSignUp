package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {this.missionService = missionService;}

    // C Post -- Send req to create missions
    @PostMapping("/create")
    public String createMission(){
        return "create mission";
    }

    // R Get -- Send req to show missions
    @GetMapping("/readall")
    public List<MissionModel> listMissions(){
        return missionService.listMission();
    }

    @GetMapping("/readID/{id}")
    public MissionModel listMissionByID(@PathVariable Long id){return missionService.listMissionByID(id);}

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
