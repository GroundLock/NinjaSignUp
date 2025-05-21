package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/UI/ninja")

public class NinjaControllerUI {
    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Read all
    @GetMapping("/read/all")
    public String listNinja(Model model) {
        List<NinjaDTO> ninjaList = ninjaService.listNinja();
        model.addAttribute("ninjas", ninjaList);
        return "listNinjas.html";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteID(@PathVariable Long id){
        ninjaService.deleteNinjaId(id);
        return "redirect:/UI/ninja/read/all";
    }

    @GetMapping("/read/ID/{id}")
    public String listNinjaByID(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listNinjaByID(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "ninjaDetails";
        } else {
            model.addAttribute("message", "Ninja Not Found");
            return "redirect:/UI/ninja/read/all";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "addNinja";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes){
        ninjaService.createNinja(ninja);
        redirectAttributes.addFlashAttribute("message", "Ninja created");
        return "redirect:/UI/ninja/read/all";
    }

    }

