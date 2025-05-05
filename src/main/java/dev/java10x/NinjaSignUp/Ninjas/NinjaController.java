package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";

    }


    // Add Ninja (Create)
    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninjaModel){return ninjaService.createNinja(ninjaModel);}

    // Show ninjas (Read)
    @GetMapping("/readall")
    public List<NinjaModel> listAllNinja(){
        return ninjaService.listNinja();
    }

    // Show ninja by ID (Read)
    @GetMapping("/readID/{id}")
    public NinjaModel listNinjaByID(@PathVariable Long id){return ninjaService.listNinjaByID(id);}

    // Change data  (Update)
    @PutMapping("/updateID")
    public String updateNinjaByID(){
        return "Ninja change by ID";
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID/{id}")
    public void deleteID(@PathVariable Long id){ninjaService.deleteNinjaId(id);}

    // All of this is called CRUD (Create, read, update, delete)

}
