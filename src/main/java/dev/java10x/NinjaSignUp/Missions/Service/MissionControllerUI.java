package dev.java10x.NinjaSignUp.Missions.Service;

import dev.java10x.NinjaSignUp.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/UI/mission")
public class MissionControllerUI {
    private final MissionService missionService;

    public MissionControllerUI(MissionService missionService) {
        this.missionService = missionService;
    }

    // Read all
    @GetMapping("/read/all")
    public String listMission(Model model){
        List<MissionDTO> missionList = missionService.listMission();
        model.addAttribute("missions", missionList);
        return "listMission";
    }

    @GetMapping("/deleteID/{id}")
    public String deleteMission(@PathVariable Long id){
        missionService.deleteID(id);
        return "redirect:/UI/mission/read/all";
    }

    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("mission", new MissionDTO());
        return "addMission";
    }

    @PostMapping("/create")
    public String createMission(@ModelAttribute MissionDTO mission, RedirectAttributes redirectAttributes){
        missionService.createMission(mission);
        redirectAttributes.addFlashAttribute("message", "Mission created");
        return "redirect:/UI/mission/read/all";
    }
}
