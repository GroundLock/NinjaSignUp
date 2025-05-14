package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {this.missionService = missionService;}

    // C Post -- Send req to create missions
    @PostMapping("/create")
    public ResponseEntity<String> createMission(@RequestBody MissionDTO missionDTO){
        MissionDTO newMission = missionService.createMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created on id " + newMission.getId());
    }

    // R Get -- Send req to show missions
    @GetMapping("/read/all")
    public List<MissionDTO> listMissions(){
        return missionService.listMission();
    }

    @GetMapping("/read/ID/{id}")
    public ResponseEntity<?> listMissionByID(@PathVariable Long id){

        MissionDTO mission = missionService.listMissionByID(id);
        if (mission != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(mission);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Mission not found on id " + id);

    }

    // U Put -- Send req to update a mission
    @PutMapping("/updateID/{id}")
    public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        if (missionService.listMissionByID(id)!=null){
            MissionDTO mission = missionService.updateMission(missionDTO, id);
            return ResponseEntity.ok(mission);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Mission not found id " + id);
    }

    // D Delete -- Send req to delete a mission
    @DeleteMapping("/deleteID/{id}")
    public ResponseEntity<String> deleteID(@PathVariable Long id){
        if (missionService.listMissionByID(id) != null){
            missionService.deleteID(id);
            return ResponseEntity.ok("Misison deleted in id " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No mission found in the id " + id);
    }

}
