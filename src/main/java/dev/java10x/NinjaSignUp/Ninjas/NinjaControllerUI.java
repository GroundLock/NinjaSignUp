package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/UI/ninja")

public class NinjaControllerUI {
    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/read/all")
    public String listNinjaByID(Model model) {
        List<NinjaDTO> ninjaList = ninjaService.listNinja();
        model.addAttribute("ninjas", ninjaList);
        return "listNinjas";
    }


}
