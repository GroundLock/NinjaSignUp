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
    public MissionDTO createMission(@RequestBody MissionDTO missionDTO){
        return missionService.createMission(missionDTO);
    }

    // R Get -- Send req to show missions
    @GetMapping("/readall")
    public List<MissionDTO> listMissions(){
        return missionService.listMission();
    }

    @GetMapping("/readID/{id}")
    public MissionDTO listMissionByID(@PathVariable Long id){return missionService.listMissionByID(id);}

    // U Put -- Send req to update a mission
    @PutMapping("/updateID/{id}")
    public MissionModel updateMission(@PathVariable Long id, @RequestBody MissionModel missionModel){return missionService.updateMission(missionModel, id);}

    // D Delete -- Send req to delete a mission
    @DeleteMapping("/deleteID/{id}")
    public void deleteID(@PathVariable Long id){missionService.deleteID(id);}

}
